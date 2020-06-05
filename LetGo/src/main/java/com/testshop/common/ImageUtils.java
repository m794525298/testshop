package com.testshop.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ImageUtils {
	public static boolean saveBase64Image(String Path,String imgStr) {

        if (imgStr == null) //图像数据为空
            return false;
        imgStr = imgStr.replaceFirst("data:(.+?);base64,", "");
        imgStr = imgStr.replaceAll(" ", "+");
        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println("开始保存");
        try
        {
            //Base64解码
            byte[] b = decoder.decode(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            System.out.println("开始父级文件夹");
            File f = new File(Path);
            f.setWritable(true, false);
            if (f.getParentFile()!=null&&!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            System.out.println("创建父级文件夹");

            OutputStream out = new FileOutputStream(f,true);
            out.write(b);
            out.flush();
            out.close();
            System.out.println("已保存图片");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<String> getImagePaths(String goodId, int goodImgCount){
    	String baseSrc = "http://127.0.0.1:8090/image/get/";
//        String baseSrc = "";
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= goodImgCount ; ++i) {
            result.add(baseSrc+goodId+"/"+i+".jpg");
        }
        return result;
    }


    public static boolean saveGoodsImage(String goodId, String[] imgs){
        String baseSrc = "E:/img/" + goodId+"/";
//    	String baseSrc = "/usr/local/img/" + goodId+"/";
        System.out.println("地址:"+baseSrc);
        int count = imgs.length;
        boolean result = false;
        for (int i = 0; i < count; i++) {
        	
            result = saveBase64Image(baseSrc+String.valueOf(i+1)+".jpg",imgs[i]);
            if (!result)
                break;

        }
        return result;
    }



    public static String saveIcon(String md5Id, String image){
        String baseSrc = "E:/img/icon/"+md5Id+".jpg";
//        String baseSrc = "/usr/local/img/icon/"+md5Id+".jpg";

        boolean result = saveBase64Image(baseSrc,image);

        String path = "http://106.53.114.5:8080/image/get/icon/"+md5Id+".jpg";

        return path;
    }
}
