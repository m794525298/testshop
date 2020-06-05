package com.testshop.common;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;

import java.util.Base64;
import java.util.Base64.Decoder;

public class Coder {
	public static final String KEY_MD5 = "LetGo";
	public static String encrypted(String s){
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");	//获取MD5实例
            md.update(s.getBytes());								//此处传入要加密的byte类型值
            byte[] digest = md.digest();							//此处得到的是md5加密后的byte类型值

            int i;
            StringBuilder sb = new StringBuilder();
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    sb.append(0);
                sb.append(Integer.toHexString(i));					//通过Integer.toHexString方法把值变为16进制
            }
            return sb.toString().substring(0, 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

	}
	
	public static boolean saveBase64Image(String Path,String imgStr) {
			
			if (imgStr == null) //图像数据为空  
	            return false;
			Decoder decoder = Base64.getDecoder();
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
	            File f = new File(Path);
	            if (!f.exists()) {
	            	f.createNewFile();
	            }
	            
	            OutputStream out = new FileOutputStream(f);
	            out.write(b);  
	            out.flush();  
	            out.close();  
	            return true;  
	        } catch (Exception e) {
	        	System.out.println(e);
	            return false;  
	        }
		}
	
	public static String textToBase64(String str, String charsetName)
	        throws UnsupportedEncodingException{
	    if (charsetName == null) throw new NullPointerException();
	    if(str == null)
	        return null;
	    String res = "";
	    try{
	        res =  Base64.getEncoder().encodeToString(str.getBytes(charsetName));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	
	    return res;
	}
	
	public static String textToBase64(String str) throws UnsupportedEncodingException {
	    return Coder.textToBase64(str, "UTF-8");
	}
}

