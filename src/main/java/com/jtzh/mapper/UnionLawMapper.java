package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionLaw;

public interface UnionLawMapper {

	List<UnionLaw> selectLawList(@Param("page")Page page);
    int selectTotal(@Param("page")Page page);
    UnionLaw selectLaw(@Param("type")String type,@Param("id")String id);
    
    int updateLaw(@Param("id")String id);
    
    int insertLaw(UnionLaw law);
    
    int updateLaws(UnionLaw law);

	boolean updateReadNum(@Param("id") String id);
}