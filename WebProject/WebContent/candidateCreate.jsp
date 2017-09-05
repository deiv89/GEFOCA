<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/candidateCreateCSS.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/inputvalidation.js"></script>
<script type="text/javascript" src="resources/js/inputfile.js"></script>

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
	<h1>CREA NUOVO CANDIDATO</h1>
	<p>
		<strong>${username} <a href="LogOut">LOGOUT</a></strong>
	</p>
	<div class="line"></div>
	<br>
	<p>
		<strong>${message}</strong>
	</p>
	<br>
	<!-- 	<div class="container"> -->
	<form action="candidateCreateServlet" method="post"
		enctype="multipart/form-data">
		<p>
			Nome:<br> <input class="name" type="text" name="name" />
		</p>
		<p>
			Cognome:<br> <input class="name" type="text" name="surname" />
		</p>
		<p>
			Data di Nascita:<br> <input type="date" name="dateOfBirth" />
		</p>
		<p>
			Qualificazione:<br> <input id="qualification" type="text"
				name="qualification" />
		</p>
		<p class="help-block">(PDF o WORD)</p>
		Carica un CV: <input class="input-file" id="my-file" type="file"
			name="pathCv" size="60" accept=".pdf,.docx,.doc"> <label
			tabindex="0" for="my-file" class="input-file-trigger">Scegli
			un file </label>
		<p class="file-return"></p>
		<input type="submit" class="forward" value="AVANTI &nbsp; >>" /><input
			type="hidden" name="surname" value="surname"> <input
			type="hidden" name="username" value="${username}">
	</form>
	<br>
	<a href="CandidateListServlet"><< &nbsp; TORNA INDIETRO</a>
</body>
</html>
