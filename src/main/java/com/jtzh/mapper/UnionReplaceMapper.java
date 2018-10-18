package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionReplace;

public interface UnionReplaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnionReplace record);

    int insertSelective(UnionReplace record);

    List<UnionReplace> selectReplace(@Param("page")Page page);
    int selectTotal(@Param("page")Page page);
    UnionReplace selectReplaceInfo(@Param("id")String id);

    int updateByPrimaryKeySelective(UnionReplace record);

    int updateByPrimaryKey(UnionReplace record);
    
    int updateState(@Param("id")String id,@Param("processingState")String processingState);
    
}