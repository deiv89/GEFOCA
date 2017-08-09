<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css" href="resources/evalFormCreateCSS.css">
</head>
<body>
	<h1>Scheda Valutazione Candidato</h1>
	<br>
	<br>
	<p><strong>${message}</strong></p>
	<strong>${messageFile}</strong>
	<br>
	<form action="evaluationCreateServlet" method="post">
		<table>
			<tr>
				<td>Nome Intervistatore:</td>
				<td><input type="text" name="interviewerName" /></td>
			</tr>
			<tr>
				<td>Livello presenza:</td>
				<td><input type="radio" name="levelPresence" value="1">1
					<input type="radio" name="levelPresence" value="2">2 <input
					type="radio" name="levelPresence" value="3">3 <input
					type="radio" name="levelPresence" value="4">4 <input
					type="radio" name="levelPresence" value="5">5</td>
			</tr>
			<tr>
				<td>Livello Comunicazione:</td>
				<td><input type="radio" name="levelComunication" value="1">1
					<input type="radio" name="levelComunication" value="2">2 <input
					type="radio" name="levelComunication" value="3">3 <input
					type="radio" name="levelComunication" value="4">4 <input
					type="radio" name="levelComunication" value="5">5</td>
			</tr>
			<tr>
				<td>Livello Dinamicità:</td>
				<td><input type="radio" name="levelDynamicity" value="1">1
					<input type="radio" name="levelDynamicity" value="2">2 <input
					type="radio" name="levelDynamicity" value="3">3 <input
					type="radio" name="levelDynamicity" value="4">4 <input
					type="radio" name="levelDynamicity" value="5">5</td>
			</tr>
			<tr>
				<td>Esperienze:</td>
				<td><input type="text" name="experience" /></td>
			</tr>
			<tr>
				<td>Motivazioni:</td>
				<td><input type="text" name="motivation" /></td>
			</tr>
			<tr>
				<td>Trasferte:</td>
				<td><input type="radio" name="transfer" value="SI" />SI <input
					type="radio" name="transfer" value="NO" />NO</td>
			</tr>

			<c:forEach items="${requestScope.languagesList}" var="lang">
				<tr>
					<td><c:out value="${lang.languageName}" /></td>

					<c:set var="languageLevel" value="languageLevel_${lang.idLanguage}" />

					<td><input type="radio"
						name="${languageLevel}" value="0">
						0 <input type="radio"
						name="${languageLevel}" value="1">
						1 <input type="radio"
						name="${languageLevel}" value="2">
						2 <input type="radio"
						name="${languageLevel}" value="3">3
						<input type="radio"
						name="${languageLevel}" value="4">
						4</td>
				</tr>
			</c:forEach>
			<tr>
				<td>Retribuzione attuale:</td>
				<td><input type="text" name="currentPay" /></td>
			</tr>
			<tr>
				<td>Retribuzione richiesta:</td>
				<td><input type="text" name="renumerationRequired" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Avanti" /> <input
					type="hidden" name="idCandidate" value="${idCandidate}">
					<input
					type="hidden" name="surname" value="${surname}"></td>
			</tr>
		</table>
	</form>

	<br>
	<a href="/CandidateListServlet">ANNULLA E TORNA INDIETRO</a>


</body>
</html>