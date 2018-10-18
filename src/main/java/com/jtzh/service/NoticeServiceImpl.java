package com.jtzh.service;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionNotice;
import com.jtzh.entity.UnionSource;
import com.jtzh.entity.UnionUser;
import com.jtzh.mapper.UnionNoticeMapper;
import com.jtzh.mapper.UnionSourceMapper;
import com.jtzh.mapper.UnionUserMapper;
import com.jtzh.pojo.NoticeParam;
import com.jtzh.pojo.ViewNotice;
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private UnionNoticeMapper unionNoticeMapper;
	
	@Resource
	private UnionSourceMapper unionSourceMapper;

	@Resource
	private UnionUserMapper unionUserMapper;
	@Override
	public Page getNoticeList(UnionUser user, NoticeParam param) {
		Page page = new Page();
		page.setCurrPage(param.getPage());
		page.setPageSize(param.getPageSize());
		page.setParam(param);
		int total = unionNoticeMapper.selectNoticeTotal(page);
		if(total > 0) {
			List<UnionNotice> list = unionNoticeMapper.selectNoticeList(page);
			page.setData(list);
			page.setTotal(total);
		}
		return page;
	}
	
	@Override
	public ResultObject getNotice(String id) {
		UnionNotice notice = unionNoticeMapper.selectNotice(id);
		List<UnionSource> list = unionSourceMapper.selectSource("02", id);
		ViewNotice view = new ViewNotice();
		view.setNotice(notice);
		view.setSource(list);
		ResultObject obj = new ResultObject();
		obj.setObj(view);
		return obj;
	}

	@Override
	public ResultObject addNotice(UnionNotice notice) {
		UnionUser exUser = unionUserMapper.getUser(notice.getLoginId());
		notice.setDelflag("A");
		notice.setCreateTime(new Date());
		notice.setCreateName(exUser.getUserName());
		unionNoticeMapper.insert(notice);
		if (notice.getFj() != null && notice.getFj().length() != 0) {
			UnionSource source = new UnionSource();
			source.setCreatTime(new Date());
			source.setDelflag("A");
			source.setAttachmentSource("03");
			source.setSourceId(notice.getId());
			source.setFileName(notice.getFj());
			source.setFileUrl("D:\\ynw\\" + notice.getFj());
			unionSourceMapper.insertSource(source);
		}
		return new ResultObject();
	}

	@Override
	public ResultObject deleteNotice(String id) {
		unionNoticeMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}

	@Override
	public ResultObject modifyNotice(UnionNotice notice) {
		unionNoticeMapper.updateByPrimaryKey(notice);
		if (notice.getFj() != null && notice.getFj().length() != 0) {
			UnionSource source = new UnionSource();
			source.setCreatTime(new Date());
			source.setDelflag("A");
			source.setAttachmentSource("02");
			source.setSourceId(notice.getId());
			source.setFileName(notice.getFj());
			source.setFileUrl("D:\\ynw\\" + notice.getFj());
			unionSourceMapper.insertSource(source);
		}
		return new ResultObject();
	}
}
