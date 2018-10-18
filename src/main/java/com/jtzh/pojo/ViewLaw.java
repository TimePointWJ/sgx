package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.UnionLaw;
import com.jtzh.entity.UnionSource;

public class ViewLaw {

	private UnionLaw Law;
	private List<UnionSource> source;
	public UnionLaw getLaw() {
		return Law;
	}
	public void setLaw(UnionLaw law) {
		Law = law;
	}
	public List<UnionSource> getSource() {
		return source;
	}
	public void setSource(List<UnionSource> source) {
		this.source = source;
	}
	
}
