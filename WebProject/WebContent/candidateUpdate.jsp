<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css"
	href="resources/css/candidateUpdateCSS.css">
</head>
<body>
	<% //allow access only if session exists 
	String user = null; if
	(session.getAttribute("user") == null) {
	response.sendRedirect("loginSignup.jsp"); } else user = (String)
	session.getAttribute("user"); %>
	<h1>Modifica Candidato</h1>
	<p>
		<strong>${username} <a href="LogOut">LOGOUT</a></strong>
	</p>
	<div class="line"></div>
	<br>
	<br>
	<div class="container">
		<p>
			<strong>${message}</strong>
		</p>
		<form action="candidateUpdateServlet" method="post">
			<p>
				Nome:<br> <input type="text" class="name" name="name"
					value="${candidate.name}" />
			</p>
			<p>
				Cognome:<br> <input type="text" class="name" name="surname"
					value="${candidate.surname}" />
			</p>
			<p>
				Data di Nascita:<br> <input type="date" name="dateOfBirth"
					value="${candidate.dateOfBirth}" />
			</p>
			<p>
				Qualificazione:<br> <input type="text" id="qualification"
					name="qualification" value="${candidate.qualification}" />
			</p>
			<input type="hidden" name="idCandidate"
				value="${candidate.idCandidate}" /> <input type="hidden"
				name="idOrigin" value="${candidate.idOrigin}" />
		</form>
		<br> <a><input type="submit" value="SALVA MODIFICA" /></a> <a
			href="CandidateDetailServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}"><<
			&nbsp; TORNA INDIETRO</a>
	</div>
</body>
</html>
