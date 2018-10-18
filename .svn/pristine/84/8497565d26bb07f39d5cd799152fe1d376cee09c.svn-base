package com.jtzh.common.util;

import tk.mybatis.mapper.entity.Example;

/**
 * creator: duyu
 * date: 2017/12/26 0026
 */
public class ExampleUtil {

    public static Example findByProperty(Class className,String property,Object value){
        Example e = new Example(className);
        Example.Criteria criteria = e.createCriteria();
        criteria.andEqualTo(property,value);
        return e;
    }
}
