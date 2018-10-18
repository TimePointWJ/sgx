package com.jtzh.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lisu on 2017/10/11.
 */
public class StringUtil {

    /**
     * 对json进行加密
     *
     * @param json json对象
     * @param key  秘钥
     * @return 加密后的字符串
     */
    public static String encode(JSONObject json, String key) {
        StringBuilder sb = new StringBuilder();
        sb.append(json.toJSONString());
        sb.append(key);
        return MD5Util.EncoderByMd5(sb.toString());
    }

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code 数字
     * @param num  保留位数
     * @return
     */
    public static String autoGenericCode(Integer code, int num) {
        return String.format("%0" + num + "d", code + 1);
    }

    /**
     * 排序方法
     *
     * @param strArray 字符串数组
     * @return
     */
    public static String sort(Object... strArray) {
        return JSON.toJSONString(strArray);
//        Arrays.sort(strArray);
//        StringBuilder sb = new StringBuilder();
//        for (String str : (String[]) strArray) {
//            sb.append(str);
//        }
//        return sb.toString();
    }

    /**
     * 将字符串进行sha1加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的内容
     */
    public static String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // 创建 16进制字符串
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

//    /**
//     * 根据给定的字段对list逆序排序
//     *
//     * @param list
//     * @param sortField
//     */
//    public static void comparator(List list, String sortField) {
//        Comparator comparator = ComparableComparator.getInstance();
//        comparator = ComparatorUtils.reversedComparator(comparator);
//        List sortFields = new ArrayList<>();
//        sortFields.add(new BeanComparator(sortField, comparator));
//        ComparatorChain comparatorChain = new ComparatorChain(sortFields);
//        Collections.sort(list, comparatorChain);
//    }
//
//    /**
//     * 根据给定的字段对list正序排序
//     *
//     * @param list
//     * @param sortField
//     */
//    public static void comparatorASC(List list, String sortField) {
//        Comparator comparator = ComparableComparator.getInstance();
//        List sortFields = new ArrayList<>();
//        sortFields.add(new BeanComparator(sortField, comparator));
//        ComparatorChain comparatorChain = new ComparatorChain(sortFields);
//        Collections.sort(list, comparatorChain);
//    }

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0)
            return true;
        return false;
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 保留两位有效数字浮点数.
     *
     * @param d
     * @return
     */
    public static String accurateTwoBit(double d) {
        return String.format("%.2f", d);
    }

}
