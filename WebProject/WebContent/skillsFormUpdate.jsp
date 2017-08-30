<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/skillsUpdateCSS.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
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
	<p>
		<strong>${username} <a href="LogOut">LOGOUT</a></strong>
	</p>
	<div class="line"></div>
	<br>
	<br>
	<div class="container">
		<p>
			<strong>${message}</strong>
		</p>
		<br>
		<form action="skillsUpdateServlet" method="post">
			<table>
				<c:forEach items="${requestScope.skillsList}" var="skill">
					<tr>
						<td><c:out
								value="CATEGORIA ${skill.idScope.scopeName} LIVELLO ${skill.parameterName}" /></td>
						<c:set var="valuationLevel"
							value="valuationLevel_${skill.idSkill}" />
						<td><c:set var="idSlot" value="${skill.idSkill-1}" /> <input
							class="radio" type="radio" name="${valuationLevel}"
							value="0" ${candidateSkills[idSlot].valuationLevel== '0'?'checked':''}><label
							for="0"><span></span>0</label> <input class="radio"
							type="radio" name="${valuationLevel}" value="1"
							${candidateSkills[idSlot].valuationLevel== '1'?'checked':''}><label
							for="1"><span></span>1</label> <input class="radio"
							type="radio" name="${valuationLevel}" value="2"
							${candidateSkills[idSlot].valuationLevel== '2'?'checked':''}><label
							for="2"><span></span>2</label> <input class="radio"
							type="radio" name="${valuationLevel}" value="3"
							${candidateSkills[idSlot].valuationLevel== '3'?'checked':''}><label
							for="3"><span></span>3</label> <input class="radio"
							type="radio" name="${valuationLevel}" value="4"
							${candidateSkills[idSlot].valuationLevel== '4'?'checked':''}><label
							for="4"><span></span>4</label></td>
					</tr>
				</c:forEach>
				<input type="hidden" name="idCandidate" value="${idCandidate}">
				<input type="hidden" name="idOrigin" value="${idOrigin}">
				<input type="hidden" name="surname" value="${surname}">
			</table>
		</form>
		<br> <input type="submit" value="SALVA MODIFICA" /> <a
			href="CandidateDetailServlet?idCandidate=${idCandidate}&surname=${surname}&idOrigin=${idOrigin}"><<
			&nbsp; TORNA INDIETRO</a>
	</div>
</body>
</html>
