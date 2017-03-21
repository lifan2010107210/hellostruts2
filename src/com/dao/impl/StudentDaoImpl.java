package com.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.commons.StrKit;
import com.dao.IStudentDao;
import com.dbutils.TxQueryRunner;
import com.vo.Student;

public class StudentDaoImpl implements IStudentDao {

	private TxQueryRunner qr = new TxQueryRunner();

	@Override
	public List<Student> listStudents() {
		List<Student> slist = null;
		try {
			slist = qr.query("select * from student ", new BeanListHandler<>(Student.class));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return slist;
	}

	@Override
	public void saveStudent(Student stu) {
		try {
			stu.setStuId(StrKit.uuid());
			qr.update("insert into student values(?,?,?)",
					new Object[] { stu.getStuId(), stu.getStuName(), stu.getClsName() });
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void removeStudent(Student stu) {
		try {
			qr.update("delete from student where stuId=? ", new Object[] { stu.getStuId() });
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Student getStudentByStuId(Student stu) {
		try {
			stu = qr.query("select * from student where stuId=? ", new BeanHandler<>(Student.class),
					new Object[] { stu.getStuId() });
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return stu;
	}

	@Override
	public void updateStudent(Student stu) {
		try {
			qr.update("update student set stuName=?,clsName=? where stuId=? ",
					new Object[] { stu.getStuName(), stu.getClsName(), stu.getStuId() });
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean existStuName(String stuName) {
		boolean bl = false;
		try {
			Number num = (Number)qr.query("select count(*) from student where stuName=? ", new ScalarHandler<>(), new Object[]{stuName});
			if(num.intValue()>0){
				bl = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return bl;
	}

}
