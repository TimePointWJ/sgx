package com.jtzh.common.util;

/**
 * creator: duyu
 * date: 2017/12/7 0007
 */
public class MathUtil {

    public static double getDistance(double long1, double lat1, double long2,
                                  double lat2) {
        double a, b, R,lat3,lat4,sa2, sb2;
        R = 6378137; // 地球半径
        lat3 = lat1 * Math.PI / 180.0;
        lat4 = lat2 * Math.PI / 180.0;
        a = lat3 - lat4;
        b = (long1 - long2) * Math.PI / 180.0;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        return 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat3) * Math.cos(lat4) * sb2 * sb2));
    }
}
