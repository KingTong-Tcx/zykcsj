package com.student;

public class Student {
	
	private int bh;
	private String xh;
	private String name;
	
	public Student() {
		super();
	}
	public Student(int bh, String xh, String name) {
		super();
		this.bh = bh;
		this.xh = xh;
		this.name = name;
	}

	public int getBh() {
		return bh;
	}
	public void setBh(int bh) {
		this.bh = bh;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [bh=" + bh + ", xh=" + xh + ", name=" + name + "]";
	}
}
