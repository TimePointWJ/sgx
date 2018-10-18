package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionReplaceResult;

public interface UnionReplaceResultMapper {

    List<UnionReplaceResult> selectReplaceResult(@Param("page")Page page);
    int selectReplaceResultTotal(@Param("page")Page page);
    UnionReplaceResult selectInfo(@Param("id")String id);
    int updateState(@Param("id")String id,@Param("processingState")String processingState);
}