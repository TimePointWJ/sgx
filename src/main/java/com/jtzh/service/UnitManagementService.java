package com.jtzh.service;

import com.jtzh.entity.UnionUnion;
import com.jtzh.pojo.UnitParam;

public interface UnitManagementService {
	public Object getUnitList(UnitParam param);

	public Object insertUnit(UnionUnion param);

	public Object updateUnit(UnionUnion param);

	public Object deleteUnit(String id);

	public Object getUnionTrue();

	public Object getUnionTree();

	public Object getTree();

	public Object getTreeandid();
}
