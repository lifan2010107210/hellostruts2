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
	<center>
		<form action="test" method="post">
			<input id="stuName" type="text" name="stuName"/><br/>
			<input type="text" name="clsName"/><br/>
			<input type="submit" value="提交"/><br/>
		</form>
	</center>
	<script type="text/javascript" src="jquery-1.5.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#stuName").blur(function(){
				$.post(
					"ajaxStuName",
					{"stuName":$("#stuName").val()},
					function(data){
						alert(data.status);
					},
					"json"
				);
			});
		});
	</script>
</body>
</html>