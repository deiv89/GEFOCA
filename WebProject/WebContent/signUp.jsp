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
	<h2>SIGN-UP</h2>
	<form action="SignUpServlet" method="post">
		<table>
			<tr>
				<strong>${messageUsername}</strong>
				<td>UserName:</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<strong>${messagePassword}</strong>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Ripeti Password:</td>
				<td><input type="password" name="passwordCheck" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="REGISTRA"></td>
			</tr>
		</table>
	</form>
	<br>
	<p>
		<a href="WelcomePage">Annulla e torna indietro</a>
	</p>
</body>
</html>