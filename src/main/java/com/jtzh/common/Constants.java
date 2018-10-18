package com.jtzh.common;

public interface Constants {
    int SYSTEM_ERROR_CODE = 1001;
    int PARAM_ERROR_CODE = 1003;
    int NO_DATA_CODE = 2001;
    int LOGIC_ERROR_CODE = 3001;

    String KEY = "HX9W8UF35BQDG1OPIE4YCZKS6NTMLV7RAJ20";

    String DATEFORMATE_SIMPLE = "yyyy-MM-dd";
    String DATEFORMATE_SHORT_SIMPLE = "yyyyMMdd";
    String DATEFORMATE_LONG = "yyyy-MM-dd HH:mm:ss";

    String TIME_ZONE = "GMT+8";

    String SMS_VERIFICATION_CODE_MESSAGE = " (微信服务号验证码,十分钟内有效)【联康科技】";

    /**
     * 调拨出库商品验收信息
     */
    interface RecZhangToEditAcceptance {
        String ACCEPTANCE_PACKING = "包装完整、无破损、无污染";
        String ACCEPTANCE_LABEL = "符合要求";
        String ACCEPTANCE_SPECIFICATION = "符合要求";
        String ACCEPTANCE_CHARACTER = "无异常";
        String ACCEPTANCE_CERTIFICATE = "有";
        String ACCEPTANCE_OTHER = "无异常";
        String ACCEPTANCE_CONCLUSION = "合格";
        String PROMOTION_MARK = "正常";
    }

    String STATUS_ORIGIN_B = "已审核";
    interface OutDepotMode {
        String WESTORE_SALE = "微商城";
    }

    String FREIGHT_NAME = "达达快递";
    String ZITI_NAME = "到店自提";
    Integer WIATTING_PAY_TIME_D =3*24*60*60*1000;
    Integer WIATTING_PAY_TIME_H =3*60*60*1000;

    interface OrderType {
        String WAITTING_PAY = "待付款";
        String WAITTING_FREIGHT = "待发货";
        String WAITTING_SELFGET = "待自提";
        String WAITTING_GET = "待收货";
        String ORDER_FINISH = "交易完成";
        String ORDER_CLOSE = "交易关闭";
    }
}
