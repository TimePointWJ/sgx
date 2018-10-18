package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionElection;

public interface UnionElectionMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(UnionElection record);

	int insertSelective(UnionElection record);

	UnionElection selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UnionElection record);

	int updateByPrimaryKey(UnionElection record);

	List<UnionElection> selectElectionList(@Param("page") Page page);

	int selectTotal(@Param("page") Page page);

	int deleteElection(@Param("id") String id);

}