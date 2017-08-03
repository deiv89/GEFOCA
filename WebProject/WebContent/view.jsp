<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
</head>
<body>
	<p>
		<strong>${message}</strong>
	</p>
	<h1>Test Stage Web</h1>
	<form action="controller" method="post">
		<input type="submit" value="ciao">
	</form>

	<a href="CandidateListServlet">ACCEDI A GESTIONE CANDIDATI</a>

</body>
</html>