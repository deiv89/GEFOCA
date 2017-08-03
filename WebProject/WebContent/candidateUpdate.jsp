<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css" href="resources/candidateUpdateCSS.css">
</head>
<body>
	<h1>Modifica Candidato</h1>
	<br>
	<br>
	<p><strong>${message}</strong></p>
	<br>
	<form action="candidateUpdateServlet" method="post">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="name" value="${candidate.name}"/></td>
			</tr>
			<tr>
				<td>Cognome:</td>
				<td><input type="text" name="surname" value="${candidate.surname}"/></td>
			</tr>
			<tr>
				<td>Data di Nascita:</td>
				<td><input type="date" name="dateOfBirth" value="${candidate.dateOfBirth}"/></td>
			</tr>
			<tr>
				<td>Qualificazione:</td>
				<td><input type="text" name="qualification" value="${candidate.qualification}"/></td>
			</tr>
			<tr>
				<td><input type="hidden" name="idCandidate" value="${candidate.idCandidate}"/></td>
			</tr>
			<tr>
				<td><input type="hidden" name="idOrigin" value="${candidate.idOrigin}"/></td>
			</tr>
			
			<br>
			<tr>
				<td colspan="2"><input type="submit" value="SALVA MODIFICA"/></td>
			</tr>
		</table>
	</form>
	
	
	
	<a href="CandidateDetailServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}">TORNA INDIETRO</a>

</body>
</html>