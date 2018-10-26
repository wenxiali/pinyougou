package com.cssl.controller;

import com.cssl.pojo.TbItemImg;
import com.cssl.service.TbCollectionService;
import com.cssl.service.TbItemService;
import com.cssl.util.FileUtil;
import com.cssl.util.ImgTest;
import com.cssl.util.PathUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShowController {

    @Autowired
    private TbItemService iService;


    @Autowired
    private TbCollectionService cService;

    /**
     * 收藏
     */
    @RequestMapping("/home-person-collect.action")
    public String homepersoncollect(Model model, Map map, HttpServletRequest request) {
        Integer uid = (Integer) request.getSession().getAttribute("id");

        map.put("uid", uid);
        List<Map<String, Object>> collect = cService.selectCollection(map);
        List<Map<String, Object>> selling = iService.selectSelling();
        model.addAttribute("conllect", collect);
        model.addAttribute("selling", selling);
        return "home-person-collect";
    }


    /**
     * 手机列表页面
     */
    @RequestMapping("/search")
    public String search() {
        return "search.html";
    }

    /**
     * 欢迎界面
     */
    @RequestMapping("/home")
    public String home(String username, HttpSession session) {
        username = (String) session.getAttribute("username");
        if (username == null) {
            return "login";
        }
        return "forward:home-index";
    }

    /**
     * 合作招商
     *
     * @return
     */
    @RequestMapping("cooperation")
    public String cooperation() {
        return "cooperation";
    }

    /**
     * 商家入驻
     *
     * @return
     */
    @RequestMapping("sampling")
    public String sampling() {
        return "sampling";
    }

    @RequestMapping("/tpflie")
    public String tpflie() {
        return "inputfile";
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(String itemid, HttpServletRequest request) {

        //最多上传文件数量
        int fileSize = 6;
        MultipartFile itmeFile = ((MultipartHttpServletRequest) request).getFile("itemfile");
        if (!itmeFile.isEmpty()) {
            String fileType = "upload/itern/itemlsst/";
            String imgurl = FileUtil.addimags(itmeFile, fileType, request);
            Map<String, Object> map = new HashMap<>();
            map.put("id", itemid);
            map.put("image", imgurl);
            iService.updateItme(map);
        }
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;

        BufferedOutputStream stream = null;
        if (files.size() <= 6) {
            fileSize = files.size();
        }
        List<TbItemImg> imgList = new ArrayList<>();
        List<String> imgtype = new ArrayList();
        List<String> imgfdw = new ArrayList();
        for (int i = 0; i < fileSize; ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                List<String> lit = ImgTest.UploadFile(file, 400, 400, request);

                for (int j = 0; j < lit.size(); j++) {
                    if (PathUtli.booleStr(lit.get(j))) {
                        imgtype.add(lit.get(j));
                    } else {
                        imgfdw.add(lit.get(j));
                    }

                }

            }
        }
        System.out.println("图片=====================路径");
        for (int d = 0; d < imgtype.size(); d++) {
            TbItemImg tbItemImg = new TbItemImg();
            tbItemImg.setItem_id(Integer.parseInt(itemid));
            tbItemImg.setImg_type(imgtype.get(d));
            tbItemImg.setImg_fdw(imgfdw.get(d));
            imgList.add(tbItemImg);
        }

        iService.insertItemImg(imgList);

        return "upload successful";
    }

    @RequestMapping("/getorderinfo")
    public String getOrderInfo() {
        return "/getOrderInfo";
    }
}
