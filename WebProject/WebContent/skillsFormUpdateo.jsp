<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/skillsUpdateCSS.css">
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
	<h1>Skills Matrix Candidato</h1>
	<br>
	<br>
	<p>
		<strong>${message}</strong>
	</p>
	<br>
	<form action="skillsUpdateServlet" method="post">
		<table>
			<c:forEach items="${requestScope.skillsList}" var="skill">
				<tr>
					<td><c:out
							value="CATEGORIA ${skill.categorySkill} LIVELLO ${skill.parameterName}" /></td>
					<c:set var="valuationLevel" value="valuationLevel_${skill.idSkill}" />
					<td><input type="radio" name="${valuationLevel}" value="0">
						0 <input type="radio" name="${valuationLevel}" value="1">
						1 <input type="radio" name="${valuationLevel}" value="2">
						2 <input type="radio" name="${valuationLevel}" value="3">3
						<input type="radio" name="${valuationLevel}" value="4"> 4</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="SALVA MODIFICA" /><input
					type="hidden" name="idCandidate" value="${idCandidate}"> <input
					type="hidden" name="idOrigin" value="${idOrigin}"> <input
					type="hidden" name="surname" value="${surname}"></td>
			</tr>
		</table>
	</form>

	<br>
	<a
		href="CandidateDetailServlet?idCandidate=${idCandidate}&surname=${surname}&idOrigin=${idOrigin}">ANNULLA
		E TORNA ALLA HOMEPAGE</a>


</body>
</html>