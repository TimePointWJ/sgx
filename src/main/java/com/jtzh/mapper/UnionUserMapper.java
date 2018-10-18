package com.jtzh.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionUser;


public interface UnionUserMapper {
    int insert(UnionUser record);
    UnionUser getUser(@Param("loginId") String loginId);
    boolean updateUser(UnionUser user);

	List<UnionUser> selectUserList(@Param("page") Page page);

	int selectTotal(@Param("page") Page page);

	int deleteUser(@Param("id") String id);

	List<UnionUser> getUserList();

}