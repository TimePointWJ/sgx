package com.jtzh.service;

import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.NewsParam;
import com.jtzh.pojo.ViewNews;


public interface NewsService {
	
	 Object getNews(NewsParam newsParam);
	 Object getNewsInfo(String id);
	 Object removeNews(String id);
	 Object insertNews(ViewNews viewNews,UnionUser user);
	 Object updateNews(ViewNews viewNews);
	
}
