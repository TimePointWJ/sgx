package com.jtzh.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by lisu on 2017/10/13.
 */
public class URLUtil {
    /**
     * 根据url获取html代码,默认html编码utf8
     *
     * @param pageUrl
     * @return 网页html代码
     * @author lec
     */
    public static String getPageCode(String pageUrl) throws Exception {
        return getPageCode(pageUrl, "utf8");
    }

    /**
     * 根据url获取html代码
     *
     * @param pageUrl
     * @param encoding html编码格式
     * @return 网页html代码
     * @author lec
     */
    public static String getPageCode(String pageUrl, String encoding) throws Exception {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
//			System.err.println(ex);
        }
        return sb.toString();
    }
}
