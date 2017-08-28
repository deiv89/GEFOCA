<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css"
	href="resources/candidateCSSTest.css">
</head>
<body>
	<h1>GESTIONE CANDIDATURE</h1>
	<p>
		<strong>${messageUsername}</strong>
		<strong>Benvenuto ${username} nel portale Candidature</strong>
	</p>
	<div class="line"></div>
	<br>
	<div class="container">
		<fieldset>
			<legend>
				<h2>CERCA CONTATTO</h2>
			</legend>
			<div>
				<form action="CandidateSearchServlet" method="post">
					<input type="text" name="name" placeholder="Nome" /> <input
						id="surname" type="text" name="surname" placeholder="Cognome" />
					<button type="submit" class="btn">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>
		</fieldset>
		<br>
		<div class="new">
			<a href="CandidateCreateServlet"><span class="fa fa-pencil"></span>&nbsp;
				CREA NUOVO CANDIDATO</a>
		</div>
		<br>
		<h2>LISTA CANDIDATI</h2>
		<p>
			<strong>${message}</strong>
		</p>
		<table>
			<tr>
				<th>COGNOME</th>
				<th>NOME</th>
				<th>DATA DI NASCITA</th>
				<th>ID CANDIDATO</th>
			</tr>
			<c:forEach items="${requestScope.candidateList}" var="candidate">
				<tr>
					<td><c:out value="${candidate.surname}" /></td>
					<td><c:out value="${candidate.name}" /></td>
					<td><c:out value="${candidate.dateOfBirth}" /></td>
					<td><c:out value="${candidate.idCandidate}" /></td>
					<td><a class="tab"
						href="CandidateDetailServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}"><span
							class="fa fa-address-card-o"></span>&nbsp; DETTAGLI</a></td>
					<td><a class="tab"
						href="CandidateDeleteServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}"><span
							class="fa fa-trash-o"></span>&nbsp; ELIMINA</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
