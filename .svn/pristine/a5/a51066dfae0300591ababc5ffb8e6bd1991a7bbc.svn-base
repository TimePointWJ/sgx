package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.UnionCandidateInfo;

public interface UnionCandidateInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(List<UnionCandidateInfo> record);

    int insertSelective(UnionCandidateInfo record);

    List<UnionCandidateInfo> selectCandidateInfo(@Param("source")String source,@Param("sourceId")String sourceId);
    List<UnionCandidateInfo> selectInfo(@Param("sourceId")String sourceId);
    int updateByPrimaryKeySelective(UnionCandidateInfo record);

    int updateByPrimaryKey(UnionCandidateInfo record);
}