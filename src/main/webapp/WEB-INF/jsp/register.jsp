<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Register</title>
	<s:head />
</head>
<body>

	<!--Paypal should be added-->
	<s:form action="register/complete" namespace="/">
		<s:textfield key="register.login" name="login" />
		<s:textfield key="register.password" name="pass" />

		
		<s:submit />
	</s:form>

</body>
</html>
