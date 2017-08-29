<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/evalFormUpdateCSS.css">
<title>Candidature WebApp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	var value = $
	{
		eform.levelPresence
	};

	// $('#radioPresence'), function () {
	// $('#' + value).prop("checked", true);
	// }

	// $(function() {
	//     var $radios = $('input:radio[name=levelPresence]');
	//         $radios.filter('[id=${eform.levelPresence}]').prop('checked', true);
	// }

	/* jQuery(function(){
	 RadionButtonPresence('levelPresence', ${eform.levelPresence}));
	 }

	 jQuery(function(){
	 RadionButtonComunication();
	 }) 

	 jQuery(function(){
	 RadionButtonDynamic('levelDynamicity', ${eform.levelDynamicity});
	 }) */
</script>
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
	<h1>Scheda Valutazione Candidato</h1>
	<br>
	<!-- <script type="text/javascript">
			function RadionButtonPresence(name, SelectdValue) {
			    $('input[name="' + name+ '"][value="' + SelectdValue + '"]').prop('checked', true);
			}</script>

	<script type="text/javascript">
			/* function RadionButtonComunication() {
			    $('input[name=levelComunication][value=3]').prop('checked', true);
			}
			 */
			//$('input[name=levelComunication]:checked', '#radioComunication').val(${eform.levelComunication})
			</script>

	<script type="text/javascript">
			function RadionButtonDynamic(name, SelectdValue) {
			    $('input[name="' + name+ '"][value="' + SelectdValue + '"]').prop('checked', true);
			}}
			</script>
 -->
	<p>
		<strong>${message}</strong>
	</p>
	<br>
	<form action="evaluationUpdateServlet" method="post">
		<table>
			<tr>
				<td>Nome Intervistatore:</td>
				<td><input type="text" name="interviewerName"
					value="${eform.interviewerName}" /></td>
			</tr>
			<tr>
				<td>Livello Presenza:</td>
				<td id="radioPresence"><input type="radio" name="levelPresence"
					value="1" ${eform.levelPresence=='1'?'checked':''} id="1">1
					<input type="radio" name="levelPresence" value="2"
					${eform.levelPresence=='2'?'checked':''} id="2">2 <input
					type="radio" name="levelPresence" value="3"
					${eform.levelPresence=='3'?'checked':''} id="3">3 <input
					type="radio" name="levelPresence" value="4"
					${eform.levelPresence=='4'?'checked':''} id="4">4 <input
					type="radio" name="levelPresence" value="5"
					${eform.levelPresence=='5'?'checked':''} id="5">5</td>
			</tr>
			<tr>
				<td>Livello Comunicazione:</td>
				<td id="radioComunication"><input type="radio"
					name="levelComunication" value="1"
					${eform.levelComunication=='1'?'checked':''}>1 <input
					type="radio" name="levelComunication" value="2"
					${eform.levelComunication=='2'?'checked':''}>2 <input
					type="radio" name="levelComunication" value="3"
					${eform.levelComunication=='3'?'checked':''}>3 <input
					type="radio" name="levelComunication" value="4"
					${eform.levelComunication=='4'?'checked':''}>4 <input
					type="radio" name="levelComunication" value="5"
					${eform.levelComunication=='5'?'checked':''}>5</td>
			</tr>
			<tr>
				<td>Livello Dinamicità:</td>
				<td><input type="radio" name="levelDynamicity" value="1"
					${eform.levelDynamicity=='1'?'checked':''}>1 <input
					type="radio" name="levelDynamicity" value="2"
					${eform.levelDynamicity=='2'?'checked':''}>2 <input
					type="radio" name="levelDynamicity" value="3"
					${eform.levelDynamicity=='3'?'checked':''}>3 <input
					type="radio" name="levelDynamicity" value="4"
					${eform.levelDynamicity=='4'?'checked':''}>4 <input
					type="radio" name="levelDynamicity" value="5"
					${eform.levelDynamicity=='5'?'checked':''}>5</td>
			</tr>
			<tr>
				<td>Esperienze:</td>
				<td><input type="text" name="experience"
					value="${eform.experience}" /></td>
			</tr>
			<tr>
				<td>Motivazioni:</td>
				<td><input type="text" name="motivation"
					value="${eform.motivazioni}" /></td>
			</tr>
			<tr>
				<td>Trasferte:</td>
				<td><input type="radio" name="transfer" value="SI"
					${eform.transfer=='SI'?'checked':''} />SI <input type="radio"
					name="transfer" value="NO" ${eform.transfer=='SI'?'checked':''} />NO


					<%-- <c:choose>
					<c:when test="${eform.transfer == 'SI'}">
						<td><input type="radio" name="transfer"
							value="${eform.transfer}" checked />SI <input type="radio"
							name="transfer" value="${eform.transfer}" />NO
					</c:when>
					<c:when test="${eform.transfer == 'NO'}">
						<td><input type="radio" name="transfer"
							value="${eform.transfer}" checked />NO</td>
						<input type="radio" name="transfer" value="${eform.transfer}" />SI
				</c:when>
				</c:choose> --%>
			</tr>

			<%-- 			<c:forEach items="${requestScope.languagesList}" var="lang" --%>
			<%-- 				varStatus="candidateLang"> --%>
			<!-- 				<tr> -->
			<%-- 					<td><c:out value="${lang.languageName}" /></td> --%>

			<%-- 					<c:set var="languageLevel" value="languageLevel_${lang.idLanguage}" /> --%>

			<%-- 					<td><input type="radio" name="${languageLevel}" --%>
			<%-- 						value="${eform.spokenLanguages[candidateLang.index].languageLevel}" /> --%>
			<%-- 						0 <input type="radio" name="${languageLevel}" --%>
			<%-- 						value="${eform.spokenLanguages[candidateLang.index].languageLevel}" /> --%>
			<%-- 						1 <input type="radio" name="${languageLevel}" --%>
			<%-- 						value="${eform.spokenLanguages[candidateLang.index].languageLevel}" /> --%>
			<%-- 						2 <input type="radio" name="${languageLevel}" --%>
			<%-- 						value="${eform.spokenLanguages[candidateLang.index].languageLevel}" />3 --%>
			<%-- 						<input type="radio" name="${languageLevel}" --%>
			<%-- 						value="${eform.spokenLanguages[candidateLang.index].languageLevel}" /> --%>
			<!-- 						4</td> -->
			<!-- 				</tr> -->
			<%-- 			</c:forEach> --%>
			<%-- <c:forEach items="${requestScope.languagesList}" var="lang"
				varStatus="candidateLang">
				<tr>
					<td><c:out value="${lang.languageName}" /></td>

					<c:set var="languageLevel" value="languageLevel_${lang.idLanguage}" />

					<td><input type="radio" name="${languageLevel}"
						value="0" />
						0 <input type="radio" name="${languageLevel}"
						value="1" />
						1 <input type="radio" name="${languageLevel}"
						value="2" />
						2 <input type="radio" name="${languageLevel}"
						value="3" />3
						<input type="radio" name="${languageLevel}"
						value="4" />
						4</td>
				</tr>
			</c:forEach> --%>
			<c:forEach items="${requestScope.languagesList}" var="lang"
				varStatus="candidateLang">
				<tr>
					<td><c:out value="${lang.languageName}" /></td>

					<c:set var="languageLevel" value="languageLevel_${lang.idLanguage}" />

					<td>var idSlot = ${lang.idLanguage-1};<input type="radio"
						name="${languageLevel}" value="0"
						${eform.spokenLanguages[idSlot].languageLevel=='0'?'checked':''} />
						0 <input type="radio" name="${languageLevel}" value="1"
						${eform.spokenLanguages[idSlot].languageLevel=='1'?'checked':''} />
						1 <input type="radio" name="${languageLevel}" value="2"
						${eform.spokenLanguages[idSlot].languageLevel=='2'?'checked':''} />
						2 <input type="radio" name="${languageLevel}" value="3"
						${eform.spokenLanguages[idSlot].languageLevel=='3'?'checked':''} />3
						<input type="radio" name="${languageLevel}" value="4"
						${eform.spokenLanguages[idSlot].languageLevel=='4'?'checked':''} />
						4
					</td>

				</tr>
			</c:forEach>

			<tr>
				<td>Retribuzione attuale:</td>
				<td><input type="text" name="currentPay"
					value="${eform.currentPay}" /></td>
			</tr>
			<tr>
				<td>Retribuzione richiesta:</td>
				<td><input type="text" name="renumerationRequired"
					value="${eform.renumeration_required}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SALVA MODIFICA" />
					<input type="hidden" name="idCandidate" value="${idCandidate}">
					<input type="hidden" name="idOrigin" value="${idOrigin}"> <input
					type="hidden" name="surname" value="${surname}"></td>
			</tr>
		</table>
	</form>

	<br>
	<a
		href="CandidateDetailServlet?idCandidate=${eform.idCandidate}&surname=${surname}&idOrigin=${idOrigin}">ANNULLA
		E TORNA INDIETRO</a>

</body>
</html>