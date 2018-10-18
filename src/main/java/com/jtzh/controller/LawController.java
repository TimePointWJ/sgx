package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.LawParam;
import com.jtzh.pojo.ViewLaw;
import com.jtzh.service.LawService;

@RestController
@RequestMapping("law")
public class LawController extends BaseController {
	
	@Resource
	private LawService lawService;
	
	/**
	 * 查询列表
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/getLawList",method=RequestMethod.POST)
	public Object getLawList(@RequestBody LawParam param) {
		return lawService.getLawList(param);
	}
	
	/**
	 * 查询详情
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/getLaw/{type}/{id}",method=RequestMethod.GET)
	public Object getLaw(@PathVariable("type")String type,@PathVariable("id")String id) {
		return lawService.getLaw(type,id);
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/removeLaw/{id}",method=RequestMethod.GET)
	public Object removeLaw(@PathVariable("id")String id) {
		return lawService.removeLaw(id);
	}
	
	/**
	 * 新增
	 * 
	 * @param view
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addLaw",method=RequestMethod.POST)
	public Object addLaw(@RequestBody ViewLaw view,HttpServletRequest request) {
		UnionUser user = getUserInfo(request);
		return lawService.insertLaw(user, view);
	}
	

	/**
	 * 修改法律api
	 * 
	 * @param view
	 * @return
	 */
	@RequestMapping(value="/modifyLaw",method=RequestMethod.POST)
	public Object modifyLaw(@RequestBody ViewLaw view) {
		return lawService.updateLaw(view);
	}


	/**
	 * 修改阅读次数api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updateReadNum/{id}", method = RequestMethod.GET)
	public Object modifyLaw(@PathVariable("id") String id) {
		return lawService.updateReadNum(id);
	}

}
