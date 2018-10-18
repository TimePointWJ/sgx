package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.ResultObject;
import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionPhoneBook;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.PhoneBookParam;
import com.jtzh.service.PhoneBookService;

@RestController
@RequestMapping("phoneBook")
public class PhoneBookController extends BaseController {
	
	@Resource
	private PhoneBookService phoneBookService;
	
	/**
	 * 查询列表
	 * @param request
	 * @param param
	 * @return
	 */
	@RequestMapping(value="getBook",method=RequestMethod.POST)
	public Object getBook(HttpServletRequest request,@RequestBody PhoneBookParam param) {
		UnionUser user = getUserInfo(request);
		return phoneBookService.getBook(user, param);
		
	}
	
	/**
	 * 新增联系人
	 * @param request
	 * @param book
	 * @return
	 */
	@RequestMapping(value="addBook",method=RequestMethod.POST)
	public Object insertBook(HttpServletRequest request,@RequestBody UnionPhoneBook book) {
		UnionUser user = getUserInfo(request);
		return phoneBookService.insertBook(user, book);
	}
	
	/**
	 * 删除联系人
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="removeBook/{id}",method=RequestMethod.GET)
	public Object removeBook(HttpServletRequest request, @PathVariable String id) {
		phoneBookService.removeBook(id);
		return new ResultObject();
		
	}
	/**
	 * 修改联系人
	 * @param request
	 * @param book
	 * @return
	 */
	@RequestMapping(value="modifyBook",method=RequestMethod.POST)
	public Object modifyBook(HttpServletRequest request,@RequestBody UnionPhoneBook book) {
		return phoneBookService.updateBook(book);
		
	}
}
