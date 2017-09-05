<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css"
	href="resources/css/candidateDeleteCSS.css">
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

	<form action="candidateDeleteServlet" method="post">
		<div class="container-all">
			<h1>Elimina Candidato</h1>
			<p>
				<strong>${username} <a href="LogOut">LOGOUT</a></strong>
			</p>
			<div class="container">
				<p>
					<strong>${message}</strong>
				</p>
				<br>
				<h2>
					Sei sicuro di volere eliminare il Candidato <strong>${candidate.surname}</strong>?
				</h2>
				<br> <strong>Cognome: </strong> ${candidate.surname}<br> <strong>Nome:
				</strong> ${candidate.name}<br> <strong>Data di Nascita: </strong>
				${candidate.dateOfBirth}<br> <strong>Qualifica: </strong>
				${candidate.qualification}<br> <strong>Id Candidato: </strong>
				${candidate.idCandidate}<br> <strong>Id Origin: </strong>
				${candidate.idOrigin}
			</div>
			<h1>Scheda valutazione Candidato</h1>
			<div class="container">
				<strong>Nome Intervistatore: </strong>
				${evaluationForm.interviewerName}<br> <strong>Livello
					presenza: </strong> ${evaluationForm.levelPresence}<br> <strong>Livello
					Comunicazione: </strong> ${evaluationForm.levelComunication}<br> <strong>Livello
					Dinamicità: </strong> ${evaluationForm.levelDynamicity}<br> <strong>Esperienze:
				</strong> ${evaluationForm.experience}<br> <strong>Motivazioni:
				</strong> ${evaluationForm.motivazioni}<br> <strong>Disponibile
					a Trasferte: </strong> ${evaluationForm.transfer}<br> <strong>Lingue
					conosciute: </strong>
				<c:forEach items="${spokenLanguages}" var="candidateLang"
					varStatus="lang">
					<c:out
						value="LINGUA ${languagesList[lang.index].languageName} LIVELLO: " />
										${candidateLang.languageLevel}<br>
				</c:forEach>
				<strong>Retribuzione attuale: </strong> ${evaluationForm.currentPay}<br>
				<strong>Retribuzione richiesta: </strong>
				${evaluationForm.renumeration_required}<br> <strong>Disponibile
					dalla data: </strong> ${evaluationForm.availability}<br>
			</div>
			<h1>Skill Matrix Candidato</h1>
			<div class="container">
				<table>
					<c:forEach items="${requestScope.skillsList}" var="skill"
						varStatus="candiSkills">
						<tr>
							<td><c:out
									value="CATEGORIA ${skill.idScope.scopeName} LIVELLO ${skill.parameterName}" /></td>
							<td>${candidateSkills[candiSkills.index].valuationLevel}</td>
					</c:forEach>
				</table>
			</div>
			<h1>Canale di provenienza Candidato</h1>
			<div class="container">
				<strong>ID Canale di Provenienza: </strong> ${origin.idOrigin}<br>
				<strong>Descrizione: </strong> ${origin.description}<br> <strong>Indirizzo:
				</strong> ${origin.address}<br> <strong>Telefono: </strong>
				${origin.phone}<br>
			</div>
			<div class="container2">
				<div style="padding-top: 12px;">
					<a class="back" href="CandidateListServlet"><<&nbsp; TORNA
						INDIETRO</a>
				</div>
				<div style="text-align: right;">
					<input type="submit" class="download" value="ELIMINA CANDIDATO" />
					<input type="hidden" name="surname" value="${candidate.surname}">
					<input type="hidden" name="idCandidate"
						value="${candidate.idCandidate}"> <input type="hidden"
						name="idOrigin" value="${candidate.idOrigin}">
				</div>
			</div>
		</div>
	</form>
</body>
</html>
