package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.UnionBuildTeam;

public interface UnionBuildTeamMapper {

    int insert(List<UnionBuildTeam> record);


    List<UnionBuildTeam> selectBuildTeam(@Param("source")String source,@Param("sourceId")String buildId);


    int updateByPrimaryKey(UnionBuildTeam record);
}