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
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.UnionParam;
import com.jtzh.service.MiddleService;
@RestController
@RequestMapping("middle")
public class MiddleController extends BaseController {
	@Resource
	private MiddleService middleService;
	
	@RequestMapping(value= "/getMiddleList", method = RequestMethod.POST)
	public Object getMiddleList(HttpServletRequest request,@RequestBody UnionParam param) {
		
		UnionUser user = getUserInfo(request);
		return middleService.getMiddleList(user, param);
		
	}
	
	@RequestMapping(value= "/getMiddleList/{id}", method = RequestMethod.GET)
	public Object getMiddleInfo(HttpServletRequest request,@PathVariable String id) {
		
		return middleService.getMiddle(id);
		
	}
	
	
	
	
	
	
}
