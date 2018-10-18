package com.jtzh.mapper;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.UnionCandidate;

public interface UnionCandidateMapper {

    int insert(UnionCandidate record);

    int insertSelective(UnionCandidate record);

    UnionCandidate selectCandidate(@Param("source")String source,@Param("sourceId")String sourceId);

    int updateByPrimaryKeySelective(UnionCandidate record);

    int updateByPrimaryKey(UnionCandidate record);
}