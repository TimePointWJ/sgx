package com.jtzh.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.ResultObject;
import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionUnion;
import com.jtzh.pojo.UnitParam;
import com.jtzh.service.UnitManagementService;

@RestController
@RequestMapping("unit")
public class UnitManagementController extends BaseController {
	@Resource
	private UnitManagementService unitService;

	/**
	 * 单位默认加载api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getUnitList", method = RequestMethod.POST)
	public Object getLawList(@RequestBody UnitParam param) {
		return unitService.getUnitList(param);
	}

	/**
	 * 新建单位api
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addUnit", method = RequestMethod.POST)
	public Object addUnit(@RequestBody UnionUnion param) {
		return unitService.insertUnit(param);
	}

	/**
	 * 修改单位api
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUnit", method = RequestMethod.POST)
	public Object updateUnit(@RequestBody UnionUnion param) {
		return unitService.updateUnit(param);
	}

	/**
	 * 删除单位api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteUnit/{id}", method = RequestMethod.GET)
	public Object deleteUnit(@PathVariable("id") String id) {
		unitService.deleteUnit(id);
		return new ResultObject();

	}

	/**
	 * 废弃的错误接口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getUnionTree", method = RequestMethod.POST)
	public Object getUnionTrue() {
		return unitService.getUnionTrue();
	}

	/**
	 * 获取工会json后台api
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getUnionJson", method = RequestMethod.POST)
	public Object getUnionTree() {
		return unitService.getUnionTree();
	}

	@RequestMapping(value = "getTree", method = RequestMethod.POST)
	public Object getTree() {
		return unitService.getTree();
	}

	@RequestMapping(value = "getTreeandid", method = RequestMethod.POST)
	public Object getTreeandid() {
		return unitService.getTreeandid();
	}

}
