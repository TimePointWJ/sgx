package com.jtzh.common.base;

import java.util.ArrayList;
import java.util.List;

import com.jtzh.common.CodeConstants;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.UnionParam;

public class BaseService {

	/**
	 * 设置参数
	 * @param user
	 * @param param
	 * @return
	 */
	public Page setparam(UnionUser user, UnionParam param) {
		Page page = new Page();
		page.setCurrPage(param.getPage());
		page.setPageSize(param.getPageSize());
		List<String> list = new ArrayList<String>();
		if(CodeConstants.accsss_1.equals(user.getAccess())) {//工会成员
			//可以看到自己申请成立的工会
			param.setUnionId(user.getLoginId());
			page.setParam(param);
			return page;
		}
		//上级工会id
		param.setSuperUnionId(user.getUnionId());
		if(CodeConstants.accsss_2.equals(user.getAccess())) {//办公室
			//可以看到CodeConstants.review_process =01,03,05的
			list.add("01");
			list.add("02");
			list.add("03");
			list.add("04");
			list.add("05");
			list.add("06");
			list.add("07");
			list.add("08");
			
		}
		if(CodeConstants.accsss_3.equals(user.getAccess())) {//分管领导
			//可以看到CodeConstants.review_process =02的
			list.add("02");
			list.add("03");
			list.add("04");
			list.add("05");
			list.add("06");
			list.add("07");
			list.add("08");
		}
		if(CodeConstants.accsss_4.equals(user.getAccess())) {//主要领导
			//可以看到CodeConstants.review_process =04的
			list.add("04");
			list.add("05");
			list.add("06");
			list.add("07");
			list.add("08");
		}
		param.setList(list);
		page.setParam(param);
		return page;
	}
}
