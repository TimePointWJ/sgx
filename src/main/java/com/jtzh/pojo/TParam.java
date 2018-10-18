package com.jtzh.pojo;

import java.util.List;

public class TParam {
	private String name;
	private String id;

	private List<TParam> children;

	public String getName() {
		return name;
	}

	public List<TParam> getChildren() {
		return children;
	}

	public void setChildren(List<TParam> children) {
		this.children = children;
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

}
