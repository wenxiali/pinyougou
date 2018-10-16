package com.cssl.util;

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
   
   
}
