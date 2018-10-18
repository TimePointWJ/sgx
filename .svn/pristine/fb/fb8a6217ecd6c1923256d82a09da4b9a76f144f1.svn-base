package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.UnionBallot;
import com.jtzh.pojo.BallotParam;

public interface UnionBallotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnionBallot record);

    int insertSelective(UnionBallot record);

    List<BallotParam> selectBallot(@Param("source")String source,@Param("sourceId")String sourceId);

    int updateByPrimaryKeySelective(UnionBallot record);

    int updateByPrimaryKey(UnionBallot record);
    
    
}