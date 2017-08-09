<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link rel="stylesheet" type="text/css"
	href="resources/candidateCreateCSS.css">
</head>
<body>
	<h1>Crea nuovo Candidato</h1>
	<br>
	<br>
	<p>
		<strong>${message}</strong>
		<strong>${messageFile}</strong>
	</p>
	<br>
	<form action="candidateCreateServlet" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Cognome:</td>
				<td><input type="text" name="surname" /></td>
			</tr>
			<tr>
				<td>Data di Nascita:</td>
				<td><input type="date" name="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>Qualificazione:</td>
				<td><input type="text" name="qualification" /></td>
			</tr>
			<tr>
				<input type="file" name="pathCv" size="60" accept=".pdf,.docx,.doc"/>
				<p class="help-block">Tipi di file supportati: PDF E WORD</p>
			</tr>
			<br>
			<tr>
				<td colspan="2"><input type="submit" class="forward"
					value="Avanti &nbsp; >>" /> <input type="hidden" name="surname"
					value="surname"></td>
			</tr>
		</table>
	</form>

	<br>
	<a href="CandidateListServlet">ANNULLA E TORNA INDIETRO</a>

</body>
</html>