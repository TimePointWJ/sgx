package com.jtzh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.base.BaseService;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionBuildTeam;
import com.jtzh.entity.UnionMiddle;
import com.jtzh.entity.UnionResult;
import com.jtzh.entity.UnionUser;
import com.jtzh.mapper.UnionBuildTeamMapper;
import com.jtzh.mapper.UnionMiddleMapper;
import com.jtzh.mapper.UnionResultMapper;
import com.jtzh.pojo.MiddleParam;
import com.jtzh.pojo.UnionParam;

@Service("middleService")
public class MiddleServiceImpl extends BaseService implements MiddleService {
	@Resource
	private UnionMiddleMapper unionMiddleMapper;
	@Resource
	private UnionBuildTeamMapper unionBuildTeamMapper;
	@Resource
	private UnionResultMapper unionResultMapper;
	@Override
	public Object getMiddleList(UnionUser user, UnionParam param) {
		Page page = setparam(user, param);
		int total = unionMiddleMapper.selectTotal(page);
		if(total>0) {
			List<UnionMiddle> ubList = unionMiddleMapper.selectMiddle(page);
			page.setTotal(total);
			page.setData(ubList);
		}
		return page;
	}

	@Override
	public Object getMiddle(String id) {
		UnionMiddle mid = unionMiddleMapper.selectMiddleInfo(id);
		List<UnionBuildTeam> l = unionBuildTeamMapper.selectBuildTeam("2", id);
		List<UnionResult> result = unionResultMapper.selectResult("04", id);
		MiddleParam p = new MiddleParam();
		p.setMid(mid);
		p.setTeam(l);
		p.setResult(result);
		return p;
	}

}
