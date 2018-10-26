package com.cssl.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileUtil {
    // 时间格式
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    // 随机数
    private static final Random r = new Random();

    public static String addimags(MultipartFile file,String fileType, HttpServletRequest request){
        String contentType = file.getContentType();
        String fileName =FileUtil.getRandomFileName(file.getOriginalFilename());
        String filePath = request.getSession().getServletContext().getRealPath(fileType);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return fileType+fileName;
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 生成随机文件名 年月日时分秒+五为随机数
     *
     * @return
     */
    public static String getRandomFileName(String fileName) {
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum+getFileExtension(fileName);
    }

    public static String getRandomName(String fileName,int i){
        int begin=fileName.indexOf(".");

        String imgname=fileName.substring(0,begin);
       return imgname+"0"+i+getFileExtension(fileName);
    }

    /**
     * 获取输入文件流的扩展名
     * @param
     * @return
     */
    private static String getFileExtension(String fileName) {

        return fileName.substring(fileName.lastIndexOf("."));
    }

    private static String URL="C:\\Users\\acer\\Desktop\\pinyougou_A\\src\\main\\webapp\\imgupload\\123\\tx";//URL为文件夹目录

    public static void main(String[] args) {

    }















    public static void deleteFileOrpath(String url){
        File file=new File(url);
        if (file.isDirectory()){//判断file是否是文件目录 若是返回TRUE
            String name[]=file.list();//name存储file文件夹中的文件名
            for (int i=0; i<name.length; i++){
                File f=new File(URL, name[i]);//此时就可得到文件夹中的文件

                f.delete();//删除文件
            }
        }
    }
}


