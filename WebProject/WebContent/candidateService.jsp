<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css" href="resources/candidateCSS.css">
</head>
<body>
	<h1>GESTIONE CANDIDATURE</h1>
	<br>
	<h2>CERCA CONTATTO</h2>
	
	<table>
		<div>
			<tr>
				
				<td id="tdName"><input type="text" name="name" placeholder="Nome"/></td>
			</tr>
			<tr>
				
				<td><input type="text" name="surname" placeholder="Cognome"/></td>
			</tr>

			<td colspan="3"><i class="fa fa-search" style="font-size:30px"><input type="submit" value="CERCA CANDIDATO" ></i></td>
		</tr>
	</table>
	<br>
	<a href="CandidateCreateServlet" style="font-size:24px"><i class="fa fa-pencil"></i>CREA NUOVO CANDIDATO</a>
	<br>
	<h2>LISTA CANDIDATI</h2>
	<p><strong>${message}</strong></p>

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

				<td><a href="CandidateDetailServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}" style="font-size:24px"><i class="fa fa-address-card-o"></i>DETTAGLIO COMPLETO</a></td>
				<td><a href="CandidateDeleteServlet?surname=${candidate.surname}&idCandidate=${candidate.idCandidate}&idOrigin=${candidate.idOrigin}" style="font-size:24px"><i class="fa fa-trash-o" aria-hidden="true"></i>ELIMINA</a></td>
			</tr>
			
		</c:forEach>

	</table>
	<br>

</body>
</html>