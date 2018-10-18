package com.jtzh.service;

import javax.servlet.http.HttpServletResponse;

import com.jtzh.entity.UnionForm;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.NewsParam;

public interface FormService {
	
	public Object getFormList(NewsParam newsParam);
	
	public Object delectForm(String id);
	
	public Object insertForm(UnionUser user,UnionForm unionForm);
	
	public Object updateForm(UnionForm unionForm);
	
	public Object updateNum(String id);

	public void downloadService(HttpServletResponse res, Integer id);
}
