<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/originCreateCSS.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<title>Candidature WebApp</title>
</head>
<body>
	<%
		//allow access only if session exists 
		String user = null;
		if (session.getAttribute("user") == null) {
			response.sendRedirect("loginSignup.jsp");
		} else
			user = (String) session.getAttribute("user");
	%>
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
		<form action="originCreateServlet" method="post">
			<p>
				Descrizione:<br> <input type="text" class="name"
					name="description" />
			</p>
			<p>
				Indirizzo:<br> <input type="text" class="name" name="address" />
			</p>
			<p>
				Telefono:<br> <input type="text" class="name" name="phone" />
			</p>
			<br> <input type="submit" value="SALVA" /> <a
				href="CandidateListServlet"><< &nbsp; TORNA INDIETRO</a> <input
				type="hidden" name="surname" value="${surname}"> <input
				type="hidden" name="idCandidate" value="${idCandidate}"> <input
				type="hidden" name="username" value="${username}">
		</form>
	</div>
</body>
</html>
