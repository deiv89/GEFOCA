<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css" href="resources/css/signUpCSS.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
</head>
<body>
	<p>
		<strong>${message}</strong>
	</p>
	<h1>CANDIDATURE MANAGEMENT</h1>
	<div class="line"></div>
	<h2>SIGN-UP</h2>
	<div class="container">
		<form action="SignUpServlet" method="post">
			<p class="reg"><strong>${messageUsername}</strong>
				<strong>${messagePassword}</strong>
			</p>
			<div class="container2">
				<table>
					<tr>
						<td id="pad">UserName:<br>
						<input type="text" name="userName" /></td>
					</tr>
					<tr>
						<td>Password:<br>
						<input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>Ripeti Password:<br>
						<input type="password" name="passwordCheck" /></td>
					</tr>
				</table>
				<p class="reg"><input type="submit" value="REGISTRA"></p>
				<p id="reg">
					<a id="link" href="WelcomePage">Annulla e torna indietro</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>
