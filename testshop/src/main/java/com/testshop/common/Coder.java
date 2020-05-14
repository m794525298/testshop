package com.testshop.common;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import java.util.Base64;

public class Coder {
    /**
	 * @describe 把字符串编码為指定字符编码的字符串
	 * @param str 需要编码的字符串
	 * @param charsetName 指定的字符編碼
	 * @return	指定字符編碼的字符串
	 * @throws UnsupportedEncodingException
	 */
    public static String textToBase64(String str, String charsetName)
            throws UnsupportedEncodingException{
        if (charsetName == null) throw new NullPointerException();
        if(str == null)
            return null;
        String res = "";
        try{
            res = Base64.getEncoder().encodeToString(str.getBytes(charsetName));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return res;
    }
    /**
	 * @describe 缺省字符串編碼,默認字符編碼為UTF-8
	 * @param str 需要编码的字符串
	 * @return	UTF-8編碼的字符串
	 * @throws UnsupportedEncodingException
	 */
    public static String textToBase64(String str) throws UnsupportedEncodingException {
        return Coder.textToBase64(str, "UTF-8");
    }
    /**
	 * @describe 把字符串解码為指定字符编码的字符串
	 * @param base64String 需要解碼的字符串
	 * @return	解碼后的字符串
	 * @throws Exception
	 */
    public static String base64ToText(String base64String, String charsetName) {
        if (base64String == null)
            return null;
        try {
            byte[] bytes = Base64.getDecoder().decode(base64String);
            return new String(bytes, charsetName);
        } catch (Exception e) {
            return "該字符串无法解碼為該字符編碼";
        }
    }

    /**
     * @describe    把字符串解码為指定字符编码的字节缓存
     * @param base64String  需要解码的base64字符串
     * @param charsetName   指定的字符編碼
     * @return      解码后的字节缓存
     */
    private static ByteBuffer base64ToBuffer(String base64String, String charsetName) {
        if (base64String == null)
            return null;
        try {
            byte[] bytes = Base64.getDecoder().decode(base64String);
            return ByteBuffer.wrap(bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
	 * @describe 从本地获取附件base64编码，并生成目标文件
	 * @author  周梓浩
	 * @param sourcePath    保存base64的文档路径
     * @param targetPath    目标档案的存储路径
	 * @return  生成目标文件
	 * @throws Exception
	 */
    public static void base64ToFile(String sourcePath, String attachmentName, String targetPath) {

        File source = new File(sourcePath);
        File target = new File(targetPath);
        RandomAccessFile in = null;
        RandomAccessFile out = null;

        if (!source.exists() || !source.isFile()) {
            throw new IllegalArgumentException("file not exsits!");
        }

        if (target.exists()) {
            target.delete();
        }

        try {
            target.createNewFile();
            in = new RandomAccessFile (source, "r");
            out = new RandomAccessFile(target, "rw");

            String buffer;
            ByteBuffer plain = null;

            String charsetName = null;
            do {
                do {
                    buffer = new String(in.readLine().getBytes("ISO-8859-1"), "UTF-8");
                } while (!buffer.equals("Attachment"));

                charsetName = in.readLine();
                buffer = new String(in.readLine().getBytes("ISO-8859-1"), "UTF-8");
            } while(!buffer.equals(attachmentName));

            do {
                buffer = in.readLine();
                if(buffer.equals("--"))
                    break;
                plain = Coder.base64ToBuffer(buffer, charsetName);
                out.write(plain.array());
            } while (true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @desc    将文件转成base64 字符串
     * @param   path    文件路径
     * @author  周梓浩
     * @return  编码成的base64字符串
     * @throws Exception
     */
    public static String fileToBase64(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return Base64.getEncoder().encodeToString(buffer);
    }
}

