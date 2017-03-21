package com.dao;

import java.util.List;

import com.vo.Student;

public interface IStudentDao {

	List<Student> listStudents();

	void saveStudent(Student stu);

	void removeStudent(Student stu);

	Student getStudentByStuId(Student stu);

	void updateStudent(Student stu);

	boolean existStuName(String stuName);

}
