package com.cssl.controller;

import com.cssl.pojo.TbItemImg;
import com.cssl.service.TbItemService;
import com.cssl.util.FileUtil;
import com.cssl.util.ImgTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
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

    /**
     * 收藏
     */
    @RequestMapping("/home-person-collect")
    public String homepersoncollect(Model model) {
        List<Map<String,Object>> selling=iService.selectSelling();
        model.addAttribute("selling",selling);
        return "home-person-collect";
    }

    /**
     * 足迹
     */
    @RequestMapping("/home-person-footmark")
    public String footmark(Model model,Long id,String image,Double price,String title) {
        Cookie cookie=new Cookie("id","id");
        List<Map<String, Object>> selling = iService.selectSelling();
        model.addAttribute("selling", selling);
        return "home-person-footmark";
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
    public String tpflie(){
        return "inputfile";
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(String itemid, MultipartFile photo, List<MultipartFile> files,HttpServletRequest request) {

        //最多上传文件数量
        int fileSize=6;
        //itmeFile=((MultipartHttpServletRequest) request).getFile("itemFile");
        if (!photo.isEmpty()) {
            String fileType="upload/itern/itemlsst/";
            String imgurl=FileUtil.addimags( photo,fileType,request);
            Map<String,Object> map=new HashMap<>();
            map.put("id",itemid);
            map.put("image",imgurl);
           iService.updateItme(map);
        }
        //= ((MultipartHttpServletRequest) request) .getFiles("file");
        MultipartFile file = null;

        BufferedOutputStream stream = null;
        if(files.size()<=6){
            fileSize=files.size();
        }
        List<TbItemImg> imgList=new ArrayList<>();
        for (int i = 0; i <fileSize; ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                List<String> lit= ImgTest.UploadFile(file,400,400,request);
                for (int j=0;j<lit.size();j++){
                    TbItemImg tbItemImg=new TbItemImg();
                    tbItemImg.setImg_type(lit.get(j));
                    tbItemImg.setItem_id(Integer.parseInt(itemid));
                    imgList.add(tbItemImg);
                }
            }
        }
        System.out.println("图片=====================路径");
        iService.insertItemImg(imgList);

        return "upload successful";
    }


}
