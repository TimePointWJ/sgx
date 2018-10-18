package com.jtzh.mapper;

import com.jtzh.entity.UnionBallotInfo;

public interface UnionBallotInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnionBallotInfo record);

    int insertSelective(UnionBallotInfo record);

    UnionBallotInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UnionBallotInfo record);

    int updateByPrimaryKey(UnionBallotInfo record);
}