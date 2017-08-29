<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/skillsUpdateCSS.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/skillsCreateCSS.css">
</head>
<body>
	<% //allow access only if session exists 
	String user = null; 
	if(session.getAttribute("user") == null) {
	response.sendRedirect("loginSignup.jsp"); } else user = (String)
	session.getAttribute("user"); %>
	
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
		<form action="skillsCreateServlet" method="post">
			<table>
				<c:forEach items="${requestScope.skillsList}" var="skill">
					<tr>
						<td><c:out
								value="CATEGORIA ${skill.idScope.scopeName} LIVELLO ${skill.parameterName}" /></td>
						<c:set var="valuationLevel"
							value="valuationLevel_${skill.idSkill}" />
						<td><input class="radio" id="0" type="radio"
							name="${valuationLevel}" value="0"><label for="0"><span></span>0</label>
							<input class="radio" id="1" type="radio" name="${valuationLevel}"
							value="1"><label for="1"><span></span>1</label> <input
							class="radio" id="2" type="radio" name="${valuationLevel}"
							value="2"><label for="2"><span></span>2</label> <input
							class="radio" id="3" type="radio" name="${valuationLevel}"
							value="3"><label for="3"><span></span>3</label> <input
							class="radio" id="4" type="radio" name="${valuationLevel}"
							value="4"><label for="4"><span></span>4</label></td>
					</tr>
				</c:forEach>
				<input type="hidden" name="idCandidate" value="${idCandidate}">
				<input type="hidden" name="surname" value="${surname}">
			</table>
		</form>
		<br> <input type="submit" value="AVANTI &nbsp; >>" /> <a
			href="/CandidateListServlet"><< &nbsp; TORNA INDIETRO</a>
	</div>
</body>
</html>
