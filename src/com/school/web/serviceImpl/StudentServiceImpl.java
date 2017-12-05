package com.school.web.serviceImpl;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentBean[] students;
	private int count;

	public StudentServiceImpl() {
		this.count = 0;
		students = new StudentBean[2];
	}

	@Override
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void addStudent(StudentBean student) {
		if(count==students.length) {
			StudentBean[] studentss = new StudentBean[count+10];
			System.arraycopy(students, 0, studentss, 0, students.length);
			students = studentss;
		}
		this.students[count++] = student;
	}

	@Override
	public void addScore(StudentBean score) {

	}

	@Override
	public StudentBean login(StudentBean student) {
		return null;
	}

	@Override
	public StudentBean find(String id) {
		return null;
	}

	@Override
	public StudentBean[] list() {
		return students;
	}

	@Override
	public StudentBean findStudentById(String id) {
		StudentBean student = new StudentBean();
		for(int i = 0; i < count; i++) {
			if(id.equals(students[i].getId())) {
				student = students[i];
				break;
			}
		}
		return student;
	}

	@Override
	public StudentBean[] findStudentByName(String name) {
		int res = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(students[i].getName())) {
					res++;
			}
		}
		StudentBean[] tmp = new StudentBean[res];
		int j =0;
		for(int i=0;i<count;i++) {
			if(name.equals(students[i].getName())) {
				tmp[j] = students[i];
				j++;
				if(j == res) {break;}
			}
		}
		return tmp;
	}
}
