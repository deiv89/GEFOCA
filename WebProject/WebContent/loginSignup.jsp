<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
</head>
<body>
	<p>
		<strong>${message}</strong>
	</p>
	<h1>CANDIDATURE MANAGEMENT</h1>
	<h2>LOG-IN OR SIGN-UP</h2>
	<form action="welcomePage" method="post">
		<table>
			<tr>
				<strong>${messageUsername}</strong>
				<td>Username:</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<strong>${messagePsw}</strong>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="ACCEDI"></td>
			</tr>
		</table>
	</form>
	<br>
	<p>
		Non ti sei ancora registrato? Registrati <a href="SignUpServlet">QUI</a>
	</p>

</body>
</html>