package com.biz;

import java.util.List;

import com.vo.Student;

public interface IStudentBiz {

	List<Student> listStudents();

	void saveStudent(Student stu);

	void removeStudent(Student stu);

	Student getStudentByStuId(Student stu);

	void updateStudent(Student stu);

	boolean existStuName(String stuName);

}
