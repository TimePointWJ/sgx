package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionForm;

public interface UnionFormMapper {
    

    List<UnionForm> selectFormList(@Param("page")Page page);
    int selectTotal(@Param("page")Page page);
    
    boolean updateForm(@Param("id")String id);
    
    boolean insertForm(UnionForm unionForm);
    
    boolean udateFormInfo(UnionForm unionForm);
    
	boolean updateNum(@Param("id") String id);
    
	UnionForm selectFormByPrimaryKey(Integer id);

}