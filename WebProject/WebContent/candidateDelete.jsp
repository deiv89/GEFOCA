<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/candidateDeleteCSS.css">
<title>Candidature WebApp</title>
</head>
<body>
	<h1>Elimina Candidato</h1>
	<br>
	<br>
	<p><strong>${message}</strong></p>/p>
	<br>
	<h2>
		Sei sicuro di volere eliminare il Candidato <strong>${candidate.surname}</strong>
		?
	</h2>
	<br>
	<form action="candidateDeleteServlet" method="post">
		<table>
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

			<h1>Scheda valutazione Candidato</h1>
			<br>
			<div>
				<strong>Nome Intervistatore:: </strong>
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
				<strong>Disponibile a Trasferte: </strong>
				${evaluationForm.transfer}
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
							<td>${candidateLang.languageLevel}</td>
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
			<tr>
				<td colspan="2"><input type="submit" value="ELIMINA CANDIDATO" />
					<input type="hidden" name="surname" value="${candidate.surname}">
					<input type="hidden" name="idCandidate" value="${candidate.idCandidate}">
					<input type="hidden" name="idOrigin" value="${candidate.idOrigin}">
					</td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<a href="CandidateListServlet">ANNULLA E TORNA INDIETRO</a>

</body>
</html>