<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有的页面</title>
</head>
<body>
	<!-- http://localhost:8080/hellostruts2/updateStudent -->
	<center>
		<form action="updateStudent" method="post">
			<!-- 凡是在值栈下部的内容，都必须使用#方式进行获取<s:property value="#request.student.stuName"/> -->
			<input type="hidden" name="stu.stuId" value="<s:property value="#request.student.stuId"/>"/><br/>
			<input type="text" name="stu.stuName" value="<s:property value="#request.student.stuName"/>"/><br/>
			<input type="text" name="stu.clsName" value="<s:property value="#request.student.clsName"/>"/><br/>
			<input type="submit" value="修改"/><br/>
		</form>
	</center>
</body>
</html>