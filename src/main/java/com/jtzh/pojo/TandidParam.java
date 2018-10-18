package com.jtzh.pojo;

import java.util.List;

public class TandidParam {
	private String name;
	private String id;
	private List<TandidParam> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<TandidParam> getChildren() {
		return children;
	}

	public void setChildren(List<TandidParam> children) {
		this.children = children;
	}

}
