package com.jtzh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.UserParam;
import com.jtzh.pojo.UserPassword;

public interface UnionUserService {

	Object getUser(HttpServletRequest request, UnionUser user);

	Object updateUser(UnionUser user);

	Object changePassword(UserPassword userPassword);

	public Object getUserList(UserParam param);

	public Object insertUser(UnionUser param);

	public Object deleteUser(String id);

	public Object exportExcel(HttpServletResponse response);


}
