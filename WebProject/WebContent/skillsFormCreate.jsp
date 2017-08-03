<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css" href="resources/skillsCreateCSS.css">
</head>
<body>
	<h1>Skills Matrix Candidato</h1>
	<br>
	<br>
	<p><strong>${message}</strong></p>
	<br>
	<form action="skillsCreateServlet" method="post">
		<table>
			<c:forEach items="${requestScope.skillsList}" var="skill">
				<tr>
					<td><c:out
							value="CATEGORIA ${skill.categorySkill} LIVELLO ${skill.parameterName}"/></td>
					<c:set var="valuationLevel" value="valuationLevel_${skill.idSkill}" />
					<td><input type="radio" name="${valuationLevel}" value="0">
						0 <input type="radio" name="${valuationLevel}" value="1">
						1 <input type="radio" name="${valuationLevel}" value="2">
						2 <input type="radio" name="${valuationLevel}" value="3">3
						<input type="radio" name="${valuationLevel}" value="4"> 4</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Avanti" /><input
					type="hidden" name="idCandidate" value="${idCandidate}">
					<input
					type="hidden" name="surname" value="${surname}"></td>
			</tr>
		</table>
	</form>

	<br>
	<a href="/CandidateListServlet">ANNULLA E TORNA ALLA HOMEPAGE</a>


</body>
</html>