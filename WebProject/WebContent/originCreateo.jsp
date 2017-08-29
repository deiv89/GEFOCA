<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/originCreateCSS.css">
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
	<h1>Canale di provenienza</h1>
	<br>
	<br>
	<p>
		<strong>${message}</strong>
	</p>
	<br>
	<form action="originCreateServlet" method="post">
		<table>
			<tr>
				<td>Descrizione:</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Indirizzo:</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><input type="text" name="phone" /></td>
			</tr>

			<br>
			<tr>
				<td colspan="2"><input type="submit" value="SALVA" /> <input
					type="hidden" name="surname" value="${surname}"></td>
				<input type="hidden" name="idCandidate" value="${idCandidate}">
			</tr>
		</table>
	</form>

	<br>
	<a href="CandidateListServlet">ANNULLA E TORNA INDIETRO</a>

</body>
</html>