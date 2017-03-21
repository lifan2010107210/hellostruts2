package com.biz.impl;

import java.util.List;

import com.biz.IStudentBiz;
import com.dao.IStudentDao;
import com.dao.impl.StudentDaoImpl;
import com.vo.Student;

public class StudentBizImpl implements IStudentBiz {
	
	private IStudentDao sdao = new StudentDaoImpl();

	@Override
	public List<Student> listStudents() {
		List<Student> slist = null;
		try {
			slist = sdao.listStudents();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return slist;
	}

	@Override
	public void saveStudent(Student stu) {
		try {
			sdao.saveStudent(stu);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void removeStudent(Student stu) {
		try {
			sdao.removeStudent(stu);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Student getStudentByStuId(Student stu) {
		try {
			stu = sdao.getStudentByStuId(stu);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return stu;
	}

	@Override
	public void updateStudent(Student stu) {
		try {
			sdao.updateStudent(stu);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean existStuName(String stuName) {
		boolean bl = false;
		try {
			bl = sdao.existStuName(stuName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return bl;
	}

}
