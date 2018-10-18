package com.jtzh.service;

import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.UnionParam;

public interface MiddleService {

	public Object getMiddleList(UnionUser user,UnionParam param);
	

	public Object getMiddle(String id);
}
