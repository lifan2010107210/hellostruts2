<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有的页面</title>
<script type="text/javascript" src="jquery-1.5.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#mys").change(function(){
			alert($(this).val());
		});
		
		//动态产生的按钮，普通的click不能处理
		//live 
	});
</script>
</head>
<body>
	<%--list中放的OGNL,listKey就是option的value,listValue就是展示给客户看的内容 --%>
	<%-- <s:select list="#request.slist" listKey="stuId" listValue="stuName"></s:select>
	<br/><br/><br/><br/>
	<select>
		<option value="97B9BE60A8A648FEB3E51E2F3C54B924">殷梨亭</option>
	</select>
	<br/>
	<select id="xxx">
		<option value="1">yyyy</option>
		<option value="2">zzzz</option>
	</select>
	===============<s:select list="{'杭州','南靖','咸阳'}"></s:select><br/>
	<s:select id="mys" list="#{'hz':'杭州','nj':'南靖','xy':'咸阳'}"></s:select><br/><br/>
	==============${requestScope.mydate }<br/>
	==============<fmt:formatDate value="${requestScope.mydate }" pattern="yyyy-MM-dd"/> --%>
	<s:debug/>
	<!-- http://localhost:8080/hellostruts2/listStudents -->
	<center>
		<table border="1">
			<tr>
				<td>学生编号</td>
				<td>学生姓名</td>
				<td>所在班级</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${slist }" var="s">
				<tr>
					<td>${s.stuId }</td>
					<td>${s.stuName }</td>
					<td>${s.clsName }</td>
					<td>
						<a href="removeStudent?stu.stuId=${s.stuId }">删除</a>
						<a href="toUpdateStudent?stu.stuId=${s.stuId }">修改</a>
					</td>
				</tr>
			</c:forEach>
			<%-- <!-- value中要放OGNL表达式，同理可得：值栈上面部分(ObjectStack)直接取值，值栈下面部分(ContextMap)要通过#进行取值 -->
			<s:iterator value="#request.slist">
				<tr>
					<td><s:property value="stuId"/> </td>
					<td><s:property value="stuName"/> </td>
					<td><s:property value="clsName"/> </td>
				</tr>
			</s:iterator>
			<!-- struts2遍历标签的第二种写法，推荐使用第一种 -->
			<s:iterator value="#request.slist" id="s">
				<tr>
					<td><s:property value="#s.stuId"/> </td>
					<td><s:property value="#s.stuName"/> </td>
					<td><s:property value="#s.clsName"/> </td>
				</tr>
			</s:iterator> --%>
		</table>
		<a href="add.jsp">新增学生</a>
	</center>
</body>
</html>