<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/candidateDetailCSS.css">
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
	<br>
	<p>
		<strong>${message}</strong>
	</p>
	<br>
	<div class="container-all">
		<h1>Dettaglio Candidato</h1>
		<p>
			<strong>${username} <a href="LogOut">LOGOUT</a></strong>
		</p>
		<div class="line"></div>
		<div class="container">
			<strong>Cognome: </strong> ${candidate.surname}<br> <strong>Nome:
			</strong> ${candidate.name}<br> <strong>Data di Nascita: </strong>
			${candidate.dateOfBirth}<br> <strong>Qualifica: </strong>
			${candidate.qualification}<br> <strong>Id Candidato: </strong>
			${candidate.idCandidate}<br> <strong>Id Origin: </strong>
			${candidate.idOrigin}
			<div class="new">
				<a
					href="CandidateUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}"><span
					class="fa fa-pencil"></span>&nbsp; MODIFICA CANDIDATO</a>
			</div>
		</div>
		<h1>Scheda valutazione Candidato</h1>
		<div class="line"></div>
		<div class="container">
			<strong>Nome Intervistatore:</strong>
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
				dalla data: </strong>${evaluationForm.availability}<br>
		</div>
		<div class="new">
			<a
				href="EvaluationUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}"><span
				class="fa fa-pencil"></span>&nbsp; MODIFICA SCHEDA DI VALUTAZIONE</a>
		</div>
		<h1>Skill Matrix Candidato</h1>
		<div class="line"></div>
		<div class="container">
			<table>
				<c:forEach items="${requestScope.skillsList}" var="skill"
					varStatus="candiSkills">
					<tr>
						<td><c:out
								value="CATEGORIA ${skill.idScope.scopeName} LIVELLO ${skill.parameterName}" /></td>
						<td>
							<div>${candidateSkills[candiSkills.index].valuationLevel}</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="new">
			<a
				href="SkillsUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}"><span
				class="fa fa-pencil"></span>&nbsp; MODIFICA SKILL MATRIX</a>
		</div>
		<h1>Canale di provenienza Candidato</h1>
		<div class="line"></div>
		<div class="container">
			<strong>ID Canale di Provenienza: </strong> ${origin.idOrigin}<br>
			<strong>Descrizione: </strong> ${origin.description}<br> <strong>Indirizzo:
			</strong> ${origin.address}<br> <strong>Telefono: </strong>
			${origin.phone}<br>
			<div class="new">
				<a
					href="OriginUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}"><span
					class="fa fa-pencil"></span>&nbsp; MODIFICA CANALE PROVENIENZA</a>
			</div>
			<div class="container2">
				<div>
					<a class="back" href="CandidateListServlet"><<&nbsp; TORNA
						INDIETRO</a>
				</div>
				<div style="text-align: right;">
					<a class="download"
						href="DownloadServlet?pathCv=${candidate.pathCv}">SCARICA CV</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
