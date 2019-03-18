package com.yk.tree;

import java.util.ArrayList;
import java.util.List;

public class Dept {
	private int id;
	private String text;
	private int pId;
	private List<Dept> children=new ArrayList<Dept>();
	public List<Dept> getChildren() {
		return children;
	}
	public void setChildren(List<Dept> children) {
		this.children = children;
	}
	public Dept(int id, String text, int pId) {
		super();
		this.id = id;
		this.text = text;
		this.pId = pId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
