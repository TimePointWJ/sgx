package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionNotice;

public interface UnionNoticeMapper {

	int selectNoticeTotal(@Param("page")Page page);
    List<UnionNotice> selectNoticeList(@Param("page")Page page);
    UnionNotice selectNotice(@Param("id")String id);

	int insert(UnionNotice notice);

	int deleteByPrimaryKey(String id);

	int updateByPrimaryKey(UnionNotice notice);
}