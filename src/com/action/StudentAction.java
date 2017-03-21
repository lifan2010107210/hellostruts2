package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.biz.IStudentBiz;
import com.biz.impl.StudentBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vo.Student;


public class StudentAction extends ActionSupport {

	private IStudentBiz sbiz = new StudentBizImpl();

	private Student stu;
	
	

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	
	@SuppressWarnings("unchecked")
	public String listStudents(){
		
		List<Student> slist = sbiz.listStudents();
		Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
		request.put("slist", slist);
		request.put("mydate", new Date());
		return "success";
	}
	
	public String saveStudent(){
		sbiz.saveStudent(stu);
		return "success";
	}
	public String removeStudent(){
		sbiz.removeStudent(stu);
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String toUpdateStudent(){
		//如果直接压栈的属性值可以使用Struts2标签加上OGNL直接获取，取法：<s:property value="具有getter/setter的属性名"/>
		//如果是存放到四大域中的属性值需要使用Struts2标签加上OGNL另外获取，取法：<s:property value="#域的名字.属性名"/>
		Student student = sbiz.getStudentByStuId(stu);
		Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
		request.put("student", student);
		return "success";
	}
	public String updateStudent(){
		sbiz.updateStudent(stu);
		return "success";
	}
}
