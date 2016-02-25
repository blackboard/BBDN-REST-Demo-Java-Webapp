<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blackboard Learn REST Demo - Java</title>
</head>
<body>
	<h1>Operation Complete</h1> 
		<ul>
			<li>Object: ${object}</li>
			<li>Operation: ${operation}</li>
			<li>Access Token: ${access_token}</li>
			<li>Token Type: ${token_type}</li>
			<li>Expires In: ${expires_in}</li>
		</ul>
	
	<br />
	
	<h1>Result</h1>
		${return_json}
		
		<br /><br />
		
	<form action="index" method="get">
		<input value="Back" type="submit" />
	</form>
</body>
</html>