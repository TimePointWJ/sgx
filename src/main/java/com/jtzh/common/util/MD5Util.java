package com.jtzh.common.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lisu on 2017/10/11.
 */
@SuppressWarnings("restriction")
public class MD5Util {
    /**
     * MD5加密算法
     *
     * @param str 需要转化为MD5码的字符串
     * @return 返回一个32位16进制的字符串
     */
    public static String toMd5(String str) {
        StringBuffer md5Code = new StringBuffer();
        try {
            //获取加密方式为md5的算法对象
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] digest = instance.digest(str.getBytes());
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 0xff);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                md5Code = md5Code.append(b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Code.toString();
    }

    public static String EncoderByMd5(String str) {
        //确定计算方法
        MessageDigest md5 = null;
        String md5String = "";
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            md5String = base64en.encode(md5.digest(str.getBytes("utf-8")));
            System.out.println(md5String);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5String;
    }
}
