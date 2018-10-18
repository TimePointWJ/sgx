package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionNotice;
import com.jtzh.pojo.NoticeParam;
import com.jtzh.service.NoticeService;

@RestController
@RequestMapping("notice")
public class NoticeController extends BaseController {
	
	@Resource
	private NoticeService noticeService;
	
	/**
	 * 查询通知列表
	 * 
	 * @param request
	 * @param adviceParam
	 * @return
	 */
	@RequestMapping(value="getNoticeList",method=RequestMethod.POST)
	public Object getAdviceList(HttpServletRequest request,@RequestBody NoticeParam adviceParam) {
		
		return noticeService.getNoticeList(getUserInfo(request), adviceParam);
	}
	
	/**
	 * 获取通知详情
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="getNotice/{id}",method=RequestMethod.GET)
	public Object getNotice(HttpServletRequest request,@PathVariable("id")String id) {
		return noticeService.getNotice(id);
	}
	
	@RequestMapping(value = "addNotice", method = RequestMethod.POST)
	public Object addNotice(HttpServletRequest request, @RequestBody UnionNotice notice) {
		return noticeService.addNotice(notice);
	}

	@RequestMapping(value = "deleteNotice/{id}", method = RequestMethod.GET)
	public Object deleteNotice(HttpServletRequest request, @PathVariable("id") String id) {
		return noticeService.deleteNotice(id);
	}
	
	@RequestMapping(value = "modifyNotice", method = RequestMethod.POST)
	public Object modifyNotice(HttpServletRequest request, @RequestBody UnionNotice notice) {
		return noticeService.modifyNotice(notice);
	}
}
