<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="bbdn.rest.Authorizer"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blackboard Learn REST Demo - Java</title>
</head>
<body>
	<form action="/auth" method="post">
		Key: <input name="key" type="text" />
		Password: <input name="secret" type="password" />
		<input name="Submit" type="submit" />
	
	</form>
</body>
</html>