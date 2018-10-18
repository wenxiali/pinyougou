package com.cssl.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneRandom {

    public static void main(String[] args) {
       String[] ss=convertStrToArray("maotan.jpg,maotan.jpg,maotan.jpg");
        System.out.println(ss[0]);
    }
    /**
     * 4位随机数
     */
    public static String randomsen(){
        String str="0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
      return  sb.toString();
    }

    /**
     * 获取用户名位随机数
     */
    public static String yhmdomsen(){
        String strer="QWERTYUIOPASDFGHJKLZXCVBNM";
        String str="0123456789";
        StringBuilder sb=new StringBuilder(10);
        for(int i=0;i<2;i++) {
            char ch = strer.charAt(new Random().nextInt(strer.length()));
            sb.append(ch);
        }
        for(int i=0;i<8;i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }


        return  sb.toString();
    }

    /**
     * 判断字符是否为邮箱形式
     */
    public static boolean isema(String email){
        boolean sts = email.contains("@");
        boolean st = email.contains(".com");
        if(sts==true||st==true){
            return  true;
        }
        return false;
    }


    /**
     * 验证邮箱格式是否正确
     * @param email
     * @return
     */
    public static boolean isEmail( String email ) {
        Pattern p = Pattern.compile("[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 是否为纯数字
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if(isNum.matches()){
            return true;
        }
        return false;
    }
    /**
     * 验证手机号码是否正确
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches()+"---");
        return m.matches();
    }




    /**
     * 发送短信
     * @param smsMob
     * @param request
     * @return
     */
    public static int Phonedxe(String smsMob, HttpServletRequest request){
        //短信内容
        String smsText = randomsen();
        System.out.println("进入后台。。。。。。。。。。。。。。");
        System.out.println("验证码："+smsText);
        System.out.println("手机号码："+smsMob);
        request.getSession().setAttribute(Constant.VERCATION,smsText);
//       HttpClientUtil client = HttpClientUtil.getInstance();
//
//            //UTF发送
//            int result = client.sendMsgUtf8(Constant.UID, Constant.KEY, smsText, smsMob);
//            if(result>0){
//                System.out.println("UTF8成功发送条数=="+result);
//              return 1;
//            }else{
//                System.out.println(client.getErrorMsg(result));
//                return 0;
//            }
        return 1;

    }

    /**
     *
     */
    public static String[] convertStrToArray(String str){
        if("".equals(str)||null==str){
            return null;
        }
        String[] strArray = null;
        strArray = str.split(","); //拆分字符为"," ,然后把结果交给数组strArray
        return strArray;
    }
}