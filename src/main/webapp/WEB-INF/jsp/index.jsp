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

<h1>Welcome to the REST Demo Java Webapp!</h1>

<p>This application is a very simple Tomcat webapp designed to allow you to test the Blackboard REST APIs and share some basic sample code to help you get started.</p>

<p>This code is not guaranteed in anyway, and is not production ready. It will, however, give you a place to start.</p>

<p>Before you begin, be sure to replace the place holders in bbdn.rest.RestConstants.java to reflect your server URL, key, and secret.</p>

<p>To use, simply select the object and operation you'd like to perform and click Submit. Bear in mind that the settings are all done via constants, and so you must create the term, and then the course and user, and then the membership. Getting and Updating can be done in any order, so long as all of the object's dependencies have been created. You should delete in reverse order.</p>

<p>One caveat at play is regarding the datasource. In order to send the datasource in JSON, you must have the pk1 value. Since this code simply accepts the response as a String object rather than serializing to an Object like the Authorizer does to the Token, the application doesn't keep the pk1 value. As a result, the datasourceId in the other object is hard coded to _2_1, or "SYSTEM". This may be fixed in the future either in this code, or by allowing externalIds to exist in JSON for the datasource.</p>

<br />   

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
		
		<br /><br />
		
		<input value="Submit" type="submit" />
		
	</form>	
</body>
</html>