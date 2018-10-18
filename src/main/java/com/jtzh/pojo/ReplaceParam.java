package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.UnionReplace;
import com.jtzh.entity.UnionResult;

public class ReplaceParam {
	private UnionReplace replace;
	private CandidateParam candidate;
	private List<UnionResult> result;
	public UnionReplace getReplace() {
		return replace;
	}
	public void setReplace(UnionReplace replace) {
		this.replace = replace;
	}
	public CandidateParam getCandidate() {
		return candidate;
	}
	public void setCandidate(CandidateParam candidate) {
		this.candidate = candidate;
	}
	public List<UnionResult> getResult() {
		return result;
	}
	public void setResult(List<UnionResult> result) {
		this.result = result;
	}
	
}
