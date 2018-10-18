package com.jtzh.controller;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionElection;
import com.jtzh.pojo.ElectionParam;
import com.jtzh.service.UnionElectionService;

@RestController
@RequestMapping("election")
public class ElectionController extends BaseController {
	protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(ElectionController.class);
	@Resource
	private UnionElectionService electionService;

	/**
	 * 默认获取选举api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getElectionList", method = RequestMethod.POST)
	public Object getLawList(@RequestBody ElectionParam param) {
		return electionService.getElectionList(param);
	}

	/**
	 * 新建选举api
	 * 
	 * @param unionElection
	 * @return
	 */
	@RequestMapping(value = "/addElection", method = RequestMethod.POST)
	public Object addElection(@RequestBody UnionElection unionElection) {
		return electionService.insertElection(unionElection);
	}

	/**
	 * 修改选举api
	 * 
	 * @param unionElection
	 * @return
	 */
	@RequestMapping(value = "/updateElection", method = RequestMethod.POST)
	public Object updateElection(@RequestBody UnionElection unionElection) {
		return electionService.updateElection(unionElection);
	}

	/**
	 * 删除选举api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteElection/{id}", method = RequestMethod.GET)
	public Object deleteElection(@PathVariable("id") String id) {
		return electionService.deleteElection(id);
	}
}
