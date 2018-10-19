package com.cssl.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ImgTest {
    public static void main(String[] args) {
        HttpServletRequest request = null;


    }
    /***
     * 上传图片到服务器 并压缩
     *
     * @param myFile  文件
     * @param request
     * @return
     */
   public static List<String> UploadFile(MultipartFile myFile, int width, int height,HttpServletRequest request) {
       List<String> imgList=new ArrayList<>();
       Boolean sta = false;
        InputStream is = null;
        FileOutputStream fs = null;
        /** 临时文件夹*/
        String imgPath = "E:/pinyougou/pinyougou_A/src/main/webapp/"+"upload/itern/item/";
       System.out.println(imgPath);
        System.out.println("old-path-" +imgPath);
        //图片名
        String name = myFile.getOriginalFilename();

        File oldFile = new File(imgPath);
        if (!oldFile.exists()) {
            oldFile.mkdirs();
        }
        String newImgNmae="upload/itern/updeteitem/";
        /** 处理后文件夹*/
        String newImaPath =  "E:/pinyougou/pinyougou_A/src/main/webapp/"+newImgNmae;
       System.out.println(newImaPath);

        String newPath = ""+ newImaPath;
        System.out.println("new-path-" + newPath);
        File newFile = new File(newPath);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            /** 先存取源文件*/
            is = myFile.getInputStream();
            fs = new FileOutputStream(imgPath + myFile.getOriginalFilename());
            //...
            if (myFile.getSize() > 0) {
                byte[] buffer = new byte[1024 * 1024];
                int bytesum = 0;
                int byteread = 0;
                while ((byteread = is.read(buffer)) != -1) {
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                    fs.flush();
                }
                fs.close();
                is.close();
            }
            /** 处理源文件 ，进行压缩再放置到新的文件夹*/
            String oldPath = imgPath + myFile.getOriginalFilename();
            String copyPath=null;
            String filetilename=null;
            for (int i=0;i<2;i++){
                filetilename=FileUtil.getRandomName(myFile.getOriginalFilename(),i+1);
                if(i==0){

                    copyPath = newPath +filetilename;
                    imgList.add(newImgNmae+filetilename);
                }else {
                    width=width*2;
                    height=height*2;
                    copyPath = newPath +filetilename;
                    imgList.add(newImgNmae+filetilename);
                }
                System.out.println("==========="+copyPath);
                zipWidthHeightImageFile(oldPath, copyPath, width,height, 1f);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return imgList;
    }


    /***
     * 压缩制定大小图片
     *
     * @param oldPath  临时图片路径
     * @param copyPath 压缩图片保存路径
     * @param width    宽度
     * @param height   高度
     * @param quality  高清度
     * @return
     * @throws Exception
     */
    private static Boolean zipWidthHeightImageFile(String oldPath, String copyPath, int width, int height,
                                            float quality) {
        Boolean sta = false;
        File oldFile = new File(oldPath);
        File newFile = new File(copyPath);
        if (oldFile == null) {
            return null;
        }
        String newImage = null;
        try {
            /** 对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(oldFile);
            int w = srcFile.getWidth(null);
            System.out.println(w);
            int h = srcFile.getHeight(null);
            System.out.println(h);

            /** 宽,高设定 */
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
            //String filePrex = oldFile.substring(0, oldFile.indexOf('.'));
            /** 压缩后的文件名 */
            //newImage = filePrex + smallIcon+ oldFile.substring(filePrex.length());

            /** 压缩之后临时存放位置 */
            FileOutputStream out = new FileOutputStream(newFile);

            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
            /** 压缩质量 */
            jep.setQuality(quality, true);
            encoder.encode(tag, jep);
            out.close();
            sta = true;
        } catch (Exception e) {
            e.printStackTrace();
            sta = false;
        }
        return sta;
    }
}
