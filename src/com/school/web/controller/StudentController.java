package com.school.web.controller;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;
import com.school.web.ui.MainPage;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService studentService = new StudentServiceImpl();
		StudentBean[] students = null;
		StudentBean student = null;
		String message = "";
		while(true) {
			switch(JOptionPane.showInputDialog("0.[종료] 1.[학생등록] 2.[성적등록]"
					+ "3.[총 학생수] 4.[학생 리스트]5.[내정보 보기]"
					+ "6.[이름검색] 7.[비번번경] 8.[ID]삭제 9.[화면보기]")) {
			case "0" :
					JOptionPane.showMessageDialog(null,"[시스템 종료]");
			return;
			case "1" :
				student = new StudentBean();//생성자와 동일해짐
				student.setId(JOptionPane.showInputDialog("[ID]입력"));
				student.setPass(JOptionPane.showInputDialog("[PASS]입력"));
				student.setName(JOptionPane.showInputDialog("[이름]입력"));
				studentService.addStudent(student);
				JOptionPane.showMessageDialog(null,"[등록완료]");
				break;
			//case "2" :
				//System.out.println("[국어]점수");
				//student.setKor(scanner.nextInt());
				//System.out.println("[영어]점수");
				//student.setEng(scanner.nextInt());
				//System.out.println("[수학]점수");
				//student.setMath(scanner.nextInt());
				//break;
			case "3" :
				JOptionPane.showMessageDialog(null,"총 학생수 는?"+studentService.getCount());
			case "4" :
				message = "";
				students = studentService.list();
				for(int i=0;i<studentService.getCount();i++) {
					message += students[i].getName() +"\n";
				}
				JOptionPane.showMessageDialog(null, message);
				break;
			case "5" :
				String idyo = JOptionPane.showInputDialog("[ID]입력");
				StudentBean tmp = studentService.findStudentById(scanner.next());
				System.out.println("[이름]" +tmp.getName()
									+"[국어]"+tmp.getKor()
									+"[영어]"+tmp.getEng()
									+"[수학]"+tmp.getMath());
				break;
				
			case "6" : 
				message = "";
				StudentBean[] findStudents = studentService.findStudentByName(JOptionPane.showInputDialog("[이름] 입력 : "));
				if(findStudents == null) {
					String xxx = JOptionPane.showInputDialog("[사용자가 없습니다]");
				}else {
					for(int i = 0; i < findStudents.length; i ++) {
						message =findStudents[i].toString();
					}
				}
				JOptionPane.showMessageDialog(null, "[사용자가 없습니다]");
				break;
			case "7" :
				break;
			case "8" :
				break;
			case "9" :
				MainPage mp = new MainPage();
				break;
			}
		}
	}
}
