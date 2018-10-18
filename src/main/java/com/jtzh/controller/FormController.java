package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.ResultObject;
import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionForm;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.NewsParam;
import com.jtzh.service.FormService;

@RestController
@RequestMapping("form")
public class FormController extends BaseController {
	
	@Resource
	private FormService formService;
	@RequestMapping(value="getFormList",method=RequestMethod.POST)
	public Object getFormList(@RequestBody NewsParam newsParam) {
		
		return formService.getFormList(newsParam);
	}
	
	
	@RequestMapping(value="delectForm/{id}",method=RequestMethod.GET)
	public Object delectForm(@PathVariable("id")String id) {
		formService.delectForm(id);
		return new ResultObject();
		
	}
	
	@RequestMapping(value="addForm",method=RequestMethod.POST)
	public Object addForm(HttpServletRequest request, @RequestBody UnionForm param) {
		UnionUser user = getUserInfo(request);
		return formService.insertForm(user, param);
		// return new ResultObject();
	}
	@RequestMapping(value="updateForm",method=RequestMethod.POST)
	public Object updateForm( @RequestBody UnionForm param) {
		formService.updateForm(param);
		return new ResultObject();
	}


	/**
	 * 下载文件api
	 * 
	 * @param res
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = { "application/json;charset=utf-8" })
	public Object download(HttpServletResponse res, @RequestParam Integer id) {
		formService.downloadService(res, id);
		return null;
	}
}
