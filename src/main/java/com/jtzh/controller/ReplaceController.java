package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionResult;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.UnionParam;
import com.jtzh.service.ReplaceService;
@RestController
@RequestMapping("replace")
public class ReplaceController extends BaseController {
	@Resource
	private ReplaceService replaceService;
	
	
	@RequestMapping(value= "/modifyState", method = RequestMethod.POST)
	public Object modifyState(HttpServletRequest request,@RequestBody UnionResult unionResult) {
		return replaceService.modifyState(getUserInfo(request), unionResult);
		
	}
	/**
	 * 换届申请
	 * @param request
	 * @param param
	 * @return
	 */
	@RequestMapping(value= "/getReplaceList", method = RequestMethod.POST)
	public Object getReplace(HttpServletRequest request,@RequestBody UnionParam param) {
		
		UnionUser user = getUserInfo(request);
		return replaceService.getReplace(user, param);
		
	}
	/**
	 * 换届申请详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getReplaceInfo/{id}",method=RequestMethod.GET)
	public Object getReplaceInfo(@PathVariable("id")String id) {
		return replaceService.getReplaceInfo(id);
		
	}
	
	/**
	 * 换届申请新增
	 * @param id
	 * @return
	 */
	
	/**
	 * 换届申请修改
	 * @param id
	 * @return
	 */
	
	/**
	 * 换届申请删除
	 * @param id
	 * @return
	 */
	
	/**
	 * 换届申请删除
	 * @param id
	 * @return
	 */
	
	
	/**
	 * 换届申请结果申报列表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getReplaceResult",method=RequestMethod.POST)
	public Object getReplaceResult(HttpServletRequest request,@RequestBody UnionParam param) {
		return replaceService.getReplaceResult(getUserInfo(request), param);
		
	}
	/**
	 * 换届申请结果申报详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getReplaceResultInfo/{id}",method=RequestMethod.GET)
	public Object getReplaceResultInfo(@PathVariable("id")String id) {
		return replaceService.getReplaceResultInfo(id);
		
	}
	
	
}
