package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionBuild;

public interface UnionBuildMapper {
	List<UnionBuild> getUnion(@Param("page")Page page);
	int  getUnionTotal(@Param("page")Page page);
	UnionBuild getUnionByid(@Param("id")String id);
	int insertUnion(UnionBuild unionBuild);
	int updateState(@Param("id")String id,@Param("processingState")String processingState);
	int updateDeflag(@Param("id")String id);
	
}