<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css"
	href="resources/css/evalFormCreateCSS.css">
</head>
<body>
	<% //allow access only if session exists 
	String user = null; if
	(session.getAttribute("user") == null) {
	response.sendRedirect("loginSignup.jsp"); } else user = (String)
	session.getAttribute("user"); %>
	<h1>Scheda Valutazione Candidato</h1>
	<p>
		<strong>${username} <a href="LogOut">LOGOUT</a></strong>
	</p>
	<div class="line"></div>
	<br>
	<br>
	<div class="container">
		<strong>${message}</strong> <strong>${messageFile}</strong> <br>
		<form action="evaluationCreateServlet" method="post">
			<p>
				Nome Intervistatore:<br> <input type="text"
					name="interviewerName" />
			</p>
			<p>
				Livello presenza:<br> <input type="radio" name="levelPresence"
					value="1">1 <input type="radio" class="radio"
					name="levelPresence" value="2">2 <input type="radio"
					class="radio" name="levelPresence" value="3">3 <input
					type="radio" class="radio" name="levelPresence" value="4">4
				<input type="radio" class="radio" name="levelPresence" value="5">5
			</p>
			<p>
				Livello Comunicazione:<br> <input type="radio"
					name="levelComunication" value="1">1 <input type="radio"
					class="radio" name="levelComunication" value="2">2 <input
					type="radio" class="radio" name="levelComunication" value="3">3
				<input type="radio" class="radio" name="levelComunication" value="4">4
				<input type="radio" class="radio" name="levelComunication" value="5">5
			</p>
			<hr>
			<p>
				Livello Dinamicità:<br> <input type="radio"
					name="levelDynamicity" value="1">1 <input type="radio"
					class="radio" name="levelDynamicity" value="2">2 <input
					type="radio" class="radio" name="levelDynamicity" value="3">3
				<input type="radio" class="radio" name="levelDynamicity" value="4">4
				<input type="radio" class="radio" name="levelDynamicity" value="5">5
			</p>
			<p>
				Esperienze:<br> <input type="text" name="experience" />
			</p>
			<p>
				Motivazioni:<br> <input type="text" name="motivation" />
			</p>
			<hr>
			<p>
				Trasferte:<br> <input type="radio" name="transfer" value="SI" />SI
				<input type="radio" class="radio" name="transfer" value="NO" />NO
			</p>
			<p>
				<c:forEach items="${requestScope.languagesList}" var="lang">
					<c:out value="${lang.languageName}" />
					<c:set var="languageLevel" value="languageLevel_${lang.idLanguage}" />
					<br>
					<input type="radio" name="${languageLevel}" value="0">0
									<input type="radio" class="radio" name="${languageLevel}"
						value="1">1
									<input type="radio" class="radio" name="${languageLevel}"
						value="2">2
									<input type="radio" class="radio" name="${languageLevel}"
						value="3">3
									<input type="radio" class="radio" name="${languageLevel}"
						value="4">4
						</c:forEach>
			</p>
			<p>
				Retribuzione attuale:<br> <input type="text" name="currentPay" />
			</p>
			<hr>
			<p>
				Retribuzione richiesta:<br> <input type="text"
					name="renumerationRequired" />
			</p>
			<p>
				Disponibile dalla data:<br> <input type="date"
					name="availability" />
			</p>
			<br> <input type="submit" value="AVANTI &nbsp; >>" /> <a
				href="/CandidateListServlet"><< &nbsp; TORNA INDIETRO</a> <input
				type="hidden" name="idCandidate" value="${idCandidate}"> <input
				type="hidden" name="surname" value="${surname}">
		</form>
	</div>
</body>
</html>
