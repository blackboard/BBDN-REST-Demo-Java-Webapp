<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Collection,java.util.Iterator" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error!</title>
</head>
<body>
	<% 
		String message = "";
	
	    Collection<String[]> parameters = request.getParameterMap().values();
	
	    Iterator<String[]> paramIt = parameters.iterator();
		while(paramIt.hasNext()) {
			String [] param = paramIt.next();
			for (int i = 0; i < param.length; i++) {
				message += param[i] + "<br />";
			}
		}
		
		message += "<br />BODY<br />";
		
		try {
			ServletInputStream bodyStream = request.getInputStream();
			
			byte[] bodyBytes = null;
			int bytesRead = bodyStream.read(bodyBytes);
			
			if(bytesRead > 0) {
				for(int b = 0; b < bodyBytes.length;b++) {
					message += bodyBytes[b];
				}
			}
			else {
				message += "No body!";
			}
		}
		catch(NullPointerException npe) {
			message += "No body!";
		}
		catch(Exception e) {
			message = e.getMessage();
		}
	%>
	
	<h1>ERROR!!</h1>
	
	<p><%=message%></p>
	
	<br /><br />
	
	<form action="index" method="get">
		<input value="Back" type="submit" />
	</form>
	
</body>
</html>