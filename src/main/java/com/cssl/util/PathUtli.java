package com.cssl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathUtli {
	//获取文件分隔符
   private static String seperator=System.getProperty("file.separator");
  
   /**
    * 返回根路径
    * @return
    */
   public static String getImgBasePath() {
	   //获取系统名
	   String os=System.getProperty("os.name");
	   String basePath="";
	   //判断是否是winds
	   if(os.toLowerCase().startsWith("win")) {
		   basePath="D:/projectdev/image/";//以winds的方式存储
		   
	   }else {
		basePath="/horne/xiangze/image/";
	  }
	  //替换分隔符
	  basePath=basePath.replace("/",seperator); 
	  return basePath;
   }
   
   /**
    * 返回子路径
    */
   public static String getShopImagePath(long shopId) {
	   String imagePath="upload/itern/shop/"+shopId+"/";
	   return imagePath.replace("/",seperator);
   }

   public static boolean booleStr(String url){
    boolean boole=false;
   	String strsun=url.substring(url.length()-5,url.length()-4);
   	if(strsun.equals("1")){
   		boole=true;
	}
   	return boole;
   }

	public static void main(String[] args) {
     booleStr("safafsafa01.sdf");
	}

}
