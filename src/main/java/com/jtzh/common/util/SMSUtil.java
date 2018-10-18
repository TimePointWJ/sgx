package com.jtzh.common.util;

/**
 * Created by lisu on 2017/10/13.
 */
public class SMSUtil {
    public static String sendUrl;

    /**
     * 发送短信
     *
     * @param tel      手机号
     * @param text     发送内容
     * @param SMS_PWD
     * @param SMS_USER
     * @param SMS_URL
     * @return
     */
    public static String sendSms(String tel, String text, String SMS_URL, String SMS_USER, String SMS_PWD, String hexStr) throws Exception {
        try {

            String url_send = SMS_URL + "?un=" + SMS_USER + "&pw="
                    + SMS_PWD + "&da=" + tel + "&sm=" + toHEX(text.getBytes("GBK"), hexStr)
                    + "&dc=15&rd=1";
            sendUrl = url_send;
            return URLUtil.getPageCode(url_send);
        } catch (Exception e) {

        }
        return "发送失败";
    }

    public static String toHEX(byte[] bytes, String hexStr) {

        String result = "";
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            // 字节高4位
            hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
            // 字节低4位
            hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
            result += hex;
        }
        return result;
    }
}
