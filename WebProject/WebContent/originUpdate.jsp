<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css"
	href="resources/css/originUpdateCSS.css">
<title>Candidature WebApp</title>
</head>
<body>
	<% //allow access only if session exists 
	String user = null; 
	if(session.getAttribute("user") == null) {
	response.sendRedirect("loginSignup.jsp"); } else user = (String)
	session.getAttribute("user"); %>
	<h1>Canale di provenienza</h1>
	<p>
		<strong>${username} <a href="LogOut">LOGOUT</a></strong>
	</p>
	<div class="line"></div>
	<br>
	<br>
	<div class="container">
		<h2>
			<strong>${message}</strong>
		</h2>
		<form action="originUpdateServlet" method="post">
			<p>
				Descrizione:<br> <input type="text" class="name"
					name="description" value="${origin.description}" />
				</td>
			</p>
			<p>
				Indirizzo:<br> <input type="text" class="name" name="address"
					value="${origin.address}" />
				</td>
			</p>
			<p>
				Telefono:<br> <input type="text" class="name" name="phone"
					value="${origin.phone}" />
				</td>
			</p>
			<input type="hidden" name="surname" value="${surname}"> <input
				type="hidden" name="idOrigin" value="${idOrigin}">
			</td>
			</td>
		</form>
		<br> <input type="submit" value="SALVA MODIFICHE" /> <a
			href="CandidateDetailServlet?idCandidate=${idCandidate}&surname=${surname}&idOrigin=${idOrigin}"><<
			&nbsp; TORNA INDIETRO</a>
	</div>
</body>
</html>
