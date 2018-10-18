package com.jtzh.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.base.BaseService;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionElection;
import com.jtzh.entity.UnionSource;
import com.jtzh.mapper.UnionElectionMapper;
import com.jtzh.mapper.UnionSourceMapper;
import com.jtzh.pojo.ElectionParam;

@Service("electionService")
public class UnionElectionServiceImpl extends BaseService implements UnionElectionService {
	protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(UnionElectionService.class);
	@Resource
	private UnionElectionMapper electionMapper;

	@Resource
	private UnionSourceMapper unionSourceMapper;

	@Override
	public Object getElectionList(ElectionParam param) {
		Page page = new Page();
		page.setCurrPage(param.getPage());
		page.setPageSize(param.getPageSize());
		page.setParam(param);
		int total = electionMapper.selectTotal(page);
		if (total > 0) {
			List<UnionElection> list = electionMapper.selectElectionList(page);
			page.setTotal(total);
			page.setData(list);
		}
		return page;
	}

	@Override
	public Object insertElection(UnionElection unionElection) {
		unionElection.setDelflag("A");
		unionElection.setCreateTime(new Date());
		electionMapper.insert(unionElection);
		if (unionElection.getAttachment() != null && unionElection.getAttachment().length() != 0) {
			UnionSource source = new UnionSource();
			source.setCreatTime(new Date());
			source.setDelflag("A");
			source.setAttachmentSource("11");
			source.setSourceId(unionElection.getId());
			source.setFileName(unionElection.getAttachment());
			source.setFileUrl("D\\ynw\\" + unionElection.getAttachment());
			unionSourceMapper.insertSource(source);
		}
		return new ResultObject();
	}

	@Override
	public Object updateElection(UnionElection unionElection) {
		UnionElection ele = electionMapper.selectByPrimaryKey(Integer.parseInt(unionElection.getId()));
		if (unionElection.getAttachment() != null && unionElection.getAttachment().length() != 0) {
			ele.setAttachment(unionElection.getAttachment());
		}
		ele.setElectionTitle(unionElection.getElectionTitle());
		ele.setElectionState(unionElection.getElectionState());
		electionMapper.updateByPrimaryKey(ele);
		if (unionElection.getAttachment() != null && unionElection.getAttachment().length() != 0) {
			UnionSource source = new UnionSource();
			source.setCreatTime(new Date());
			source.setDelflag("A");
			source.setAttachmentSource("11");
			source.setSourceId(unionElection.getId());
			source.setFileName(unionElection.getAttachment());
			source.setFileUrl("D\\ynw\\" + unionElection.getAttachment());
			unionSourceMapper.insertSource(source);
		}
		return new ResultObject();
	}

	@Override
	public Object deleteElection(String id) {
		electionMapper.deleteElection(id);
		return new ResultObject();
	}

}
