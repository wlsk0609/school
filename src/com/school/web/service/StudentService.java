package com.school.web.service;

import com.school.web.bean.StudentBean;

public interface StudentService {
	public void addStudent(StudentBean student);
	public void addScore(StudentBean student);
	public StudentBean login(StudentBean student);
	public void setCount(int count);
	public int getCount();
	public StudentBean find(String id);
	public StudentBean[] list();
	public StudentBean findStudentById(String id);
	public StudentBean[] findStudentByName(String name);
}
