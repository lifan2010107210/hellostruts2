package com.action;

import com.alibaba.fastjson.JSONObject;
import com.biz.IStudentBiz;
import com.biz.impl.StudentBizImpl;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	
	private IStudentBiz sbiz = new StudentBizImpl();

	private String stuName;
	private String clsName;
	
	
	private JSONObject result;
	
	
	//前台校验---后台校验
//	public void validateTest() {
//		if(StrKit.isBlank(stuName)){
//			this.addFieldError("stuName", "用户名不能空");
//		}
//		if(stuName.length() < 6){
//			this.addFieldError("stuName", "用户名不能少于6位");
//		}
//	}
	
	public String ajaxStuName(){
		result = new JSONObject();
		boolean bl = sbiz.existStuName(this.getStuName());
		if(bl){
			//后台数据库中存在该用户
			result.put("status", "exist");
		}else{
			//后台数据库中不存在该用户
			result.put("status", "noexist");
		}
		return "success";
	}

	public String test(){
		return "success";
	}
	
	public String test2(){
		return "success";
	}
	
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	
}
