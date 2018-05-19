package com.atyang.selectionSort;

public class Student implements Comparable<Student> {

	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student() {
		super();
	}

	/**
	 * 按照年龄排序，年龄大的靠前
	 * 年龄相等则按照姓名首字母排序
	 */
	@Override
	public int compareTo(Student o) {
		if(this.age > o.getAge()){
			return 1;
		}else if(this.age < o.getAge()){
			return -1;
		}else{
			this.name.compareTo(this.getName());
		}
		return 0;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
