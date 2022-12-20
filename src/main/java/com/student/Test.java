package com.student;

public class Test {

	public static void main(String[] args) {
		Student student = new Student();
		student.setBh(1);
		student.setXh("20220101");
		student.setName("朱茵");
		
		System.out.println(student.getBh());
		System.out.println(student.getXh());
		System.out.println(student.getName());
		
		Student student2 = new Student(2, "20220102", "周星驰");
		System.out.println(student2);
		System.out.println(student2.getName());
		
	}

}
