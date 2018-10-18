package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.UnionBuildTeam;
import com.jtzh.entity.UnionMiddle;
import com.jtzh.entity.UnionResult;

public class MiddleParam {
	private UnionMiddle mid;
	private List<UnionBuildTeam> team;
	private List<UnionResult> result;
	
	public List<UnionResult> getResult() {
		return result;
	}
	public void setResult(List<UnionResult> result) {
		this.result = result;
	}
	public UnionMiddle getMid() {
		return mid;
	}
	public void setMid(UnionMiddle mid) {
		this.mid = mid;
	}
	public List<UnionBuildTeam> getTeam() {
		return team;
	}
	public void setTeam(List<UnionBuildTeam> team) {
		this.team = team;
	}
	
}
