<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>用户注册</h1>
	<form action="${pageContext.request.contextPath}/UserAction_regist" method="post" >
		昵称:<input type="text" name="user_name" /> 	<br>
		登录名:<input type="text" name="user_code" /> <br>	
		密码<input type="password" name="user_password" /> <br>
		<input type="submit" value="注册" >	<br>
	</form>
	<font color="red" >${exception.message}</font>
	
</body>
</html>