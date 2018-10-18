package com.jtzh.common.util;

import org.springframework.util.CollectionUtils;

import com.jtzh.common.Constants;
import com.jtzh.common.Response;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lisu on 2017/10/11.
 */
public class ResUtil {

    public static Response success(Object data) {
        if (data == null || data.toString().trim().equals("")) {
            return noData();
        }
        if (data instanceof Collection<?> && CollectionUtils.isEmpty((Collection<?>) data)) {
            return noData();
        }
        if (data instanceof Map && CollectionUtils.isEmpty((Map) data)) {
            return noData();
        }
        return new Response(data, 200, "ok", "ok");
    }

    public static Response paramError(String msg) {
        return new Response(null, Constants.PARAM_ERROR_CODE, msg, "param error");
    }

    public static Response logicError(String msg) {
        return new Response(null, Constants.LOGIC_ERROR_CODE, msg, "logic error");
    }

    public static Response systemError(String msg) {
        return new Response(null, Constants.SYSTEM_ERROR_CODE, msg, "system error");
    }

    public static Response noData() {
        return new Response(null, Constants.NO_DATA_CODE, "没有数据", "no data");
    }
}
