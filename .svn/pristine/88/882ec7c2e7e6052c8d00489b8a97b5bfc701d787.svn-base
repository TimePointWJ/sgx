package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.NewsParam;
import com.jtzh.pojo.ViewNews;
import com.jtzh.service.NewsService;


@RestController
@RequestMapping("news")
public class NewsController extends BaseController {
	protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(NewsController.class);
	@Resource
	private NewsService newsService;

	/**
	 * 获取新闻列表
	 * 
	 * @param newsParam
	 * @param req
	 * @return
	 */
	@RequestMapping("getNews")
	@ResponseBody
	public Object getNews(@RequestBody NewsParam newsParam, HttpServletRequest req) {
		return newsService.getNews(newsParam);
	}

	/**
	 * 获取新闻信息
	 * 
	 * @param id
	 * @return
	 */
    @RequestMapping(value= "/getNewsInfo/{id}", method = RequestMethod.GET)
	public Object getNewsInfo(@PathVariable(value ="id") String id, HttpServletRequest request) {
		logger.info(String.valueOf(request.getSession().getMaxInactiveInterval()));
		return newsService.getNewsInfo(id);
		
	} 


	/**
	 * 新增新闻
	 * 
	 * @param viewNews
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/addNews", method = RequestMethod.POST)
	@Transactional
	public Object addNews(@RequestBody ViewNews viewNews, HttpServletRequest request) {
		UnionUser user = getUserInfo(request);
		return newsService.insertNews(viewNews, user);
		
	}

	/**
	 * 修改新闻
	 */
	@RequestMapping(value = "/modifyNews", method = RequestMethod.POST)
	@Transactional
	public Object modifyNews(@RequestBody ViewNews viewNews, HttpServletRequest req) {

		return newsService.updateNews(viewNews);

	}
	
	/**
	 * 删除新闻
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeNews/{id}",method = RequestMethod.GET)
	@Transactional
	public Object removeNews(@PathVariable("id")String id) {
		
		return newsService.removeNews(id);
		
	}
	
	
}
