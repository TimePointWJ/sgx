package com.jtzh.service;

import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.BuildParam;
import com.jtzh.pojo.UnionParam;

public interface UnionService {
	
	public Object getUnion(UnionUser user,UnionParam param);
	public Object getUnionInfo(String id);
	
	public Object insertUnion(UnionUser user,BuildParam param);
	public Object removeUnion(String id);


}
