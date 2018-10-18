package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.base.BaseService;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionCandidate;
import com.jtzh.entity.UnionCandidateInfo;
import com.jtzh.entity.UnionReplace;
import com.jtzh.entity.UnionReplaceResult;
import com.jtzh.entity.UnionResult;
import com.jtzh.entity.UnionUser;
import com.jtzh.mapper.UnionBallotInfoMapper;
import com.jtzh.mapper.UnionBallotMapper;
import com.jtzh.mapper.UnionBuildMapper;
import com.jtzh.mapper.UnionCandidateInfoMapper;
import com.jtzh.mapper.UnionCandidateMapper;
import com.jtzh.mapper.UnionMiddleMapper;
import com.jtzh.mapper.UnionReplaceMapper;
import com.jtzh.mapper.UnionReplaceResultMapper;
import com.jtzh.mapper.UnionResultMapper;
import com.jtzh.pojo.BallotParam;
import com.jtzh.pojo.CandidateParam;
import com.jtzh.pojo.ReplaceParam;
import com.jtzh.pojo.ReplaceResultParam;
import com.jtzh.pojo.UnionParam;

@Service("replaceService")
public class ReplaceServiceImpl extends BaseService implements ReplaceService  {

	@Resource
	private UnionReplaceMapper unionReplaceMapper;
	@Resource
	private UnionCandidateMapper unionCandidateMapper;
	@Resource
	private UnionCandidateInfoMapper unionCandidateInfoMapper;
	@Resource
	private UnionResultMapper unionResultMapper;
	@Resource
	private UnionReplaceResultMapper unionReplaceResultMapper;
	@Resource
	private UnionBallotMapper unionBallotMapper;
	@Resource
	private UnionBallotInfoMapper unionBallotInfoMapper;
	@Resource
	private UnionBuildMapper unionBuildMapper;
	@Resource
	private UnionMiddleMapper unionMiddleMapper;
	@Override
	public Object getReplace(UnionUser user, UnionParam param) {
		Page page = setparam(user, param);
		int total = unionReplaceMapper.selectTotal(page);
		
		if(total>0) {
			List<UnionReplace> ubList = unionReplaceMapper.selectReplace(page);
			page.setTotal(total);
			page.setData(ubList);
		}
		return page;
	}
	@Override
	public Object getReplaceInfo(String id) {
		UnionReplace replace = unionReplaceMapper.selectReplaceInfo(id);
		UnionCandidate  candidate = unionCandidateMapper.selectCandidate("02", id);//候选人信息-主体信息
		//候选人信息：01-工会委员会，02-工会经费审查委员会，03-工会女职工委员会，04-工会劳动法律监察委员会
		List<UnionCandidateInfo> unioninfo = new ArrayList<UnionCandidateInfo>();
		List<UnionCandidateInfo> unionpayinfo = new ArrayList<UnionCandidateInfo>();
		if(candidate != null) {
			List<UnionCandidateInfo> l = unionCandidateInfoMapper.selectInfo(candidate.getId());
			if(l != null && l.size()>0) {
				for(UnionCandidateInfo u : l) {
					if("01".equals(u.getSource())) {
						unioninfo.add(u);
					}
					if("02".equals(u.getSource())) {
						unionpayinfo.add(u);
					}
				}
			}
		}
		CandidateParam c = new CandidateParam();
		c.setCandidate(candidate);
		c.setUnioninfo(unioninfo);
		c.setUnionpayinfo(unionpayinfo);
		List<UnionResult> result = unionResultMapper.selectResult("02", id);
		ReplaceParam r = new ReplaceParam();
		r.setCandidate(c);
		r.setReplace(replace);
		r.setResult(result);
		return r;
	}
	@Override
	public Object getReplaceResult(UnionUser user, UnionParam param) {
		Page page = setparam(user, param);
		int total = unionReplaceResultMapper.selectReplaceResultTotal(page);
		
		if(total>0) {
			List<UnionReplaceResult> ubList = unionReplaceResultMapper.selectReplaceResult(page);
			page.setTotal(total);
			page.setData(ubList);
		}
		return page;
	}
	@Override
	public Object getReplaceResultInfo(String id) {
		ReplaceResultParam p = new ReplaceResultParam();
		UnionReplaceResult r = unionReplaceResultMapper.selectInfo(id);
		
		List<UnionCandidateInfo> unioninfo = new ArrayList<UnionCandidateInfo>();
		List<UnionCandidateInfo> unionpayinfo = new ArrayList<UnionCandidateInfo>();
		List<UnionCandidateInfo> unionwemoninfo = new ArrayList<UnionCandidateInfo>();
		List<UnionCandidateInfo> unionlawinfo = new ArrayList<UnionCandidateInfo>();
		UnionCandidate  candidate = unionCandidateMapper.selectCandidate("03", id);//候选人信息-主体信息
		if(candidate != null) {
			List<UnionCandidateInfo> l = unionCandidateInfoMapper.selectInfo(candidate.getId());
			if(l != null && l.size()>0) {
				for(UnionCandidateInfo u : l) {
					if("01".equals(u.getSource())) {
						unioninfo.add(u);
					}
					if("02".equals(u.getSource())) {
						unionpayinfo.add(u);
					}
					if("03".equals(u.getSource())) {
						unionwemoninfo.add(u);
					}
					if("04".equals(u.getSource())) {
						unionlawinfo.add(u);
					}
				}
			}
			
		}
		CandidateParam c = new CandidateParam();
		c.setCandidate(candidate);
		c.setUnioninfo(unioninfo);
		c.setUnionpayinfo(unionpayinfo);
		c.setUnionwenmoninfo(unionwemoninfo);
		c.setUnionlawinfo(unionlawinfo);
		
		List<UnionResult> result = unionResultMapper.selectResult("03", id);
		
		List<BallotParam> ballot  = unionBallotMapper.selectBallot("1", id);
		
		
		p.setReplaceResult(r);
		p.setCandidate(c);
		p.setResult(result);
		p.setBallot(ballot);
		return p;
	}
	@Override
	public Object modifyState(UnionUser user, UnionResult unionResult) {
		String processingState = "0"+(Integer.parseInt(unionResult.getDelflag())+1);
		if("0".equals(unionResult.getResult())) {
			processingState = "07";
		}
		if("01".equals(unionResult.getSource())) {//组织成立申请
			unionBuildMapper.updateState(unionResult.getSourceId(), processingState);
		}
		if("02".equals(unionResult.getSource())) {//换届申请
			unionReplaceMapper.updateState(unionResult.getSourceId(), processingState);
		}
		if("03".equals(unionResult.getSource())) {//所有结果申请
			unionReplaceResultMapper.updateState(unionResult.getSourceId(), processingState);
		}
		if("04".equals(unionResult.getSource())) {//届中申请
			unionMiddleMapper.updateState(unionResult.getSourceId(), processingState);
		}
		unionResult.setCreateName(user.getUserName());
		String department = "";
		if( "2".equals(user.getAccess())) {
			department = "办公室";
		}
		if("3".equals(user.getAccess())) {
			department = "分管领导";
		}
		if("4".equals(user.getAccess())) {
			department = "主要领导";
		}
		if("01".equals(unionResult.getDelflag())) {
			unionResult.setResult("转发");
		}
		if("02".equals(unionResult.getDelflag())) {
			if("0".equals(unionResult.getResult())) {
				unionResult.setDescription("不通过");
			}else {
				unionResult.setDescription("通过");
			}
			unionResult.setResult("审核");
			
		}
		if("03".equals(unionResult.getResult())) {
			unionResult.setResult("转发");
		}
		if("04".equals(unionResult.getResult())) {
			if("0".equals(unionResult.getResult())) {
				unionResult.setDescription("不通过");
			}else {
				unionResult.setDescription("通过");
			}
			unionResult.setResult("审批");
		}
		if("04".equals(unionResult.getResult())) {
			unionResult.setResult("批复");
		}
		if("07".equals(unionResult.getResult())) {
			unionResult.setResult("批复");
		}
		unionResult.setDepartment(department);
		unionResult.setCreateTime(new Date());
		unionResult.setDelflag("A");
		unionResultMapper.insertResult(unionResult);
		return new ResultObject();
	}
	
}
