<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css" href="resources/candidateDetailCSS.css">
</head>
<body>
	<br>
	<p><strong>${message}</strong></p>
	<br>
	<h1>Dettaglio Candidato</h1>
	<br>
	<br>
	<div>
	Scarica CV candidato
	<a href="DownloadServlet?pathCv=${candidate.pathCv}">Download</a> 
	</div>
	<div>
		<strong>Cognome: </strong> ${candidate.surname}
	</div>
	<div>
		<strong>Nome: </strong> ${candidate.name}
	</div>
	<div>
		<strong>Data di Nascita: </strong> ${candidate.dateOfBirth}
	</div>
	<div>
		<strong>Qualifica: </strong> ${candidate.qualification}
	</div>
	<div>
		<strong>Id Candidato: </strong> ${candidate.idCandidate}
	</div>
	<div>
		<strong>Id Origin: </strong> ${candidate.idOrigin}
	</div>
	<br>
	<a
		href="CandidateUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}">MODIFICA
		CANDIDATO</a>
	<br>
	<h1>Scheda valutazione Candidato</h1>
	<br>
	<div>
		<strong>Nome Intervistatore:</strong>
		${evaluationForm.interviewerName}
	</div>
	<div>
		<strong>Livello presenza: </strong> ${evaluationForm.levelPresence}
	</div>
	<div>
		<strong>Livello Comunicazione: </strong>
		${evaluationForm.levelComunication}
	</div>
	<div>
		<strong>Livello Dinamicità: </strong>
		${evaluationForm.levelDynamicity}
	</div>
	<div>
		<strong>Esperienze: </strong> ${evaluationForm.experience}
	</div>
	<div>
		<strong>Motivazioni: </strong> ${evaluationForm.motivazioni}
	</div>
	<div>
		<strong>Disponibile a Trasferte: </strong> ${evaluationForm.transfer}
	</div>

	<div>
		<strong>Lingue conosciute: </strong> <br>
		<table>
			<c:forEach items="${spokenLanguages}" var="candidateLang"
				varStatus="lang">
				<tr>
					<td><c:out
							value="LINGUA
						${languagesList[lang.index].languageName} LIVELLO: " /></td>
					<td>
						${candidateLang.languageLevel}
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div>
		<strong>Retribuzione attuale: </strong> ${evaluationForm.currentPay}
	</div>
	<div>
		<strong>Retribuzione richiesta: </strong>
		${evaluationForm.renumeration_required}
	</div>
	<br>
	<a href="EvaluationUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}">MODIFICA SCHEDA DI VALUTAZIONE</a>
	<br>
	<h1>Skill Matrix Candidato</h1>
	<br>
	<table>
		<c:forEach items="${requestScope.skillsList}" var="skill"
			varStatus="candiSkills">
			<tr>
				<td><c:out
						value="CATEGORIA ${skill.categorySkill} LIVELLO ${skill.parameterName}" /></td>
				<td>
					<div>${candidateSkills[candiSkills.index].valuationLevel}</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="SkillsUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}">MODIFICA SKILL MATRIX</a>
	<br>
	<h1>Canale di provenienza Candidato</h1>
	<br>
	<div>
		<strong>ID Canale di Provenienza: </strong> ${origin.idOrigin}
	</div>
	<div>
		<strong>Descrizione: </strong> ${origin.description}
	</div>
	<div>
		<strong>Indirizzo: </strong> ${origin.address}
	</div>
	<div>
		<strong>Telefono: </strong> ${origin.phone}
	</div>
	<br>
	<a href="OriginUpdateServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}">MODIFICA CANALE PROVENIENZA</a>
	<br>

	<br>
	<a href="CandidateListServlet">TORNA INDIETRO</a>
</body>
</html>