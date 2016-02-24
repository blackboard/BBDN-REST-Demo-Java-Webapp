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

	<form action="rest" method="post">
		<input type="hidden" name="access_token" value="${access_token}" />
		<input type="hidden" name="token_type" value="${token_type}" />
		<input type="hidden" name="expires_in" value="${expires_in}" />
		
		Please select the object you'd like to manipulate: 
		<select name="object">
			<option value="datasource">Datasource</option>
			<option value="term">Term</option>
			<option value="course">Course</option>
			<option value="user">User</option>
			<option value="membership">Membership</option>
		</select> 
		
		<br />
		Please select the operation you'd like to perform: 
		<select name="operation">
			<option value="create">Create</option>
			<option value="read">Read</option>
			<option value="update">Update</option>
			<option value="delete">Delete</option>
		</select>		
		
		<br />
		
		<input value="Submit" type="submit" />
		
	</form>	
</body>
</html>