<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<title>Home</title>
		<s:head />
	</head>
	<body>
		<s:if test="%{#session['loggedin'] != null}">
			Hello <s:property value="%{#session['theUser'].userName}"/> <br/>
			<div style = "float: right"><a href = "logout.action">Logout</a></div>
		</s:if>
		
	</body>
</html>