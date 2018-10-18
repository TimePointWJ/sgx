package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.UnionResult;

public interface UnionResultMapper {
	int deleteByPrimaryKey(Integer id);
	int insert(UnionResult record);
	int insertSelective(UnionResult record);
	UnionResult selectByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(UnionResult record);
	int updateByPrimaryKey(UnionResult record);
	List<UnionResult> selectResult(@Param("source")String source,@Param("sourceId")String sourceId);
	void insertResult(UnionResult unionResult);
}