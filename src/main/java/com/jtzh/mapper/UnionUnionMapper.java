package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionUnion;
import com.jtzh.pojo.TParam;

public interface UnionUnionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnionUnion record);

    int insertSelective(UnionUnion record);

    UnionUnion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UnionUnion record);

    int updateByPrimaryKey(UnionUnion record);

	List<UnionUnion> selectUnitList(@Param("page") Page page);

	int selectTotal(@Param("page") Page page);

	int updateUnit(@Param("id") String id);

	UnionUnion getUnitByName(String name);

	List<UnionUnion> selectBySuperId(Integer id);

	List<TParam> selectBySId(String id);

}