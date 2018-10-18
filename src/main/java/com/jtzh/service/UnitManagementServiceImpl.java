package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionUnion;
import com.jtzh.mapper.UnionUnionMapper;
import com.jtzh.pojo.TParam;
import com.jtzh.pojo.TandidParam;
import com.jtzh.pojo.TreeParam;
import com.jtzh.pojo.UnitParam;

@Service("unitService")
public class UnitManagementServiceImpl implements UnitManagementService {
	@Resource
	private UnionUnionMapper unitMapper;

	@Override
	public Object getUnitList(UnitParam param) {
		Page page = new Page();
		page.setCurrPage(param.getPage());
		page.setPageSize(param.getPageSize());
		page.setParam(param);
		int total = unitMapper.selectTotal(page);
		if (total > 0) {
			List<UnionUnion> list = unitMapper.selectUnitList(page);
			page.setTotal(total);
			page.setData(list);
		}
		return page;
	}

	@Override
	public Object insertUnit(UnionUnion param) {
		param.setDelflag("A");
		param.setCreateTime(new Date());
		UnionUnion unit = unitMapper.getUnitByName(param.getSuperiorUnionName());
		param.setSuperiorUnionId(unit.getId());
		unitMapper.insertSelective(param);
		return new ResultObject();
	}

	@Override
	public Object updateUnit(UnionUnion param) {
		param.setDelflag("A");
		UnionUnion unit = unitMapper.getUnitByName(param.getSuperiorUnionName());
		param.setSuperiorUnionId(unit.getId());
		unitMapper.updateByPrimaryKeySelective(param);
		return new ResultObject();
	}

	@Override
	public Object deleteUnit(String id) {
		unitMapper.updateUnit(id);
		return new ResultObject();
	}

	@Override
	public Object getUnionTrue() {
		TreeParam treeFather = new TreeParam();
		// 1.查superior_union_id为0的
		List<UnionUnion> unit1 = unitMapper.selectBySuperId(0);
		if (unit1 != null && unit1.size() > 0) {
			// 获取list中的一个元素即最高工会
			UnionUnion unitFather = unit1.get(0);
			treeFather.setName(unitFather.getUnionName());
			// 根据第一层工会id查询第二次的list
			// 2.根据最顶级的id查询它的子类
			// list
			// for(TreeParam t : list){
			// }
			List<UnionUnion> unit2 = unitMapper.selectBySuperId(unitFather.getId());
			for (UnionUnion unitSon : unit2) {
				int index = 0;
				List<TreeParam> children = new ArrayList<TreeParam>();
				TreeParam element = new TreeParam();
				element.setName(unitSon.getUnionName());
				children.set(index, element);
				treeFather.setChildren(children);
				index++;
			}
		}
		return treeFather;
	}

	@Override
	public Object getUnionTree() {
		// 第一层
		TreeParam treeFather = new TreeParam();
		List<UnionUnion> unit1 = unitMapper.selectBySuperId(0);
		if (unit1 != null && unit1.size() > 0) {
			UnionUnion unitFather = unit1.get(0);
			treeFather.setName(unitFather.getUnionName());
			List<TreeParam> son = new ArrayList<TreeParam>();
			List<UnionUnion> unit2 = unitMapper.selectBySuperId(unitFather.getId());
			if (unit2 != null && unit2.size() > 0) {
				for (UnionUnion unitSon : unit2) {
					TreeParam treeSon = new TreeParam();
					List<TreeParam> grandson = new ArrayList<TreeParam>();
					List<UnionUnion> unit3 = unitMapper.selectBySuperId(unitSon.getId());
					if (unit3 != null && unit3.size() > 0) {
						for (UnionUnion unitGrandson : unit3) {
							// 遍历第三层将孩子list处理好
							TreeParam treeGrandson = new TreeParam();
							treeGrandson.setName(unitGrandson.getUnionName());
							grandson.add(treeGrandson);
						}
					}
					// 将第三层的结果放到第二层的孩子里面
					treeSon.setName(unitSon.getUnionName());
					treeSon.setChildren(grandson);
					son.add(treeSon);
				}
			}
			// 将第2层的结果放到第1层的孩子里面
			treeFather.setChildren(son);
		}
		return treeFather;
	}

	@Override
	public Object getTree() {
		List<TParam> t111 = unitMapper.selectBySId("0");
		TParam t1 = t111.get(0);
		List<TParam> t2 = unitMapper.selectBySId(t1.getId());
		List<TParam> tree2 = new ArrayList<TParam>();
		for (TParam t : t2) {
			List<TParam> t3 = unitMapper.selectBySId(t.getId());
			List<TParam> tree3 = new ArrayList<TParam>();
			for (TParam tt : t3) {
				List<TParam> t4 = unitMapper.selectBySId(tt.getId());
				tt.setChildren(t4);
				tree3.add(tt);
			}
			t.setChildren(tree3);
			tree2.add(t);
		}
		t1.setChildren(tree2);
		return t1;
	}

	@Override
	public Object getTreeandid() {
		// 第一层
		TandidParam treeFather = new TandidParam();
		List<UnionUnion> unit1 = unitMapper.selectBySuperId(0);
		if (unit1 != null && unit1.size() > 0) {
			UnionUnion unitFather = unit1.get(0);
			treeFather.setName(unitFather.getUnionName());
			treeFather.setId(String.valueOf(unitFather.getId()));
			List<TandidParam> son = new ArrayList<TandidParam>();
			List<UnionUnion> unit2 = unitMapper.selectBySuperId(unitFather.getId());
			if (unit2 != null && unit2.size() > 0) {
				for (UnionUnion unitSon : unit2) {
					TandidParam treeSon = new TandidParam();
					List<TandidParam> grandson = new ArrayList<TandidParam>();
					List<UnionUnion> unit3 = unitMapper.selectBySuperId(unitSon.getId());
					if (unit3 != null && unit3.size() > 0) {
						for (UnionUnion unitGrandson : unit3) {
							// 遍历第三层将孩子list处理好
							TandidParam treeGrandson = new TandidParam();
							treeGrandson.setId(String.valueOf(unitGrandson.getId()));
							treeGrandson.setName(unitGrandson.getUnionName());
							grandson.add(treeGrandson);
						}
					}
					// 将第三层的结果放到第二层的孩子里面
					treeSon.setId(String.valueOf(unitSon.getId()));
					treeSon.setName(unitSon.getUnionName());
					treeSon.setChildren(grandson);
					son.add(treeSon);
				}
			}
			// 将第2层的结果放到第1层的孩子里面
			treeFather.setChildren(son);
		}
		return treeFather;
	}

}
