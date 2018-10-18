package com.jtzh.service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionNotice;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.NoticeParam;

public interface NoticeService {

	Page getNoticeList(UnionUser user,NoticeParam param);
	
	ResultObject getNotice(String id);

	ResultObject addNotice(UnionNotice notice);

	ResultObject deleteNotice(String id);

	ResultObject modifyNotice(UnionNotice notice);
}
