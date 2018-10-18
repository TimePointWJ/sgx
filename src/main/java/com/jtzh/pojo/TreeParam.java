package com.jtzh.pojo;

import java.util.List;

public class TreeParam {
	private String name;

	private List<TreeParam> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TreeParam> getChildren() {
		return children;
	}

	public void setChildren(List<TreeParam> children) {
		this.children = children;
	}

}
