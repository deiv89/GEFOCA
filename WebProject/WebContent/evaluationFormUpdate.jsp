<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidature WebApp</title>
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css"
	href="resources/css/evalFormUpdateCSS.css">
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
	<p>
		<strong>${username} <a href="LogOut">LOGOUT</a></strong>
	</p>
	<div class="line"></div>
	<br>
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
	<div class="container">
		<h2>
			<strong>${message}</strong>
		</h2>
		<br>
		<form action="evaluationUpdateServlet" method="post">

			<p>
				Nome Intervistatore:<br> <input type="text"
					name="interviewerName" value="${eform.interviewerName}" />
			</p>
			<p>
				Livello Presenza:<br>
				<td id="radioPresence"><input type="radio" name="levelPresence"
					value="1" ${eform.levelPresence== '1'?'checked':''} id="1">1
					<input type="radio" class="radio" name="levelPresence" value="2"
					${eform.levelPresence== '2'?'checked':''} id="2">2 <input
					type="radio" class="radio" name="levelPresence" value="3"
					${eform.levelPresence== '3'?'checked':''} id="3">3 <input
					type="radio" class="radio" name="levelPresence" value="4"
					${eform.levelPresence== '4'?'checked':''} id="4">4 <input
					type="radio" class="radio" name="levelPresence" value="5"
					${eform.levelPresence== '5'?'checked':''} id="5">5</td>
			</p>
			<p>
				Livello Comunicazione:<br>
				<td id="radioComunication"><input type="radio"
					name="levelComunication" value="1"
					${eform.levelComunication=='1'?'checked':''}>1 <input
					type="radio" class="radio" name="levelComunication" value="2"
					${eform.levelComunication=='2'?'checked':''}>2 <input
					type="radio" class="radio" name="levelComunication" value="3"
					${eform.levelComunication=='3'?'checked':''}>3 <input
					type="radio" class="radio" name="levelComunication" value="4"
					${eform.levelComunication=='4'?'checked':''}>4 <input
					type="radio" class="radio" name="levelComunication" value="5"
					${eform.levelComunication=='5'?'checked':''}>5</td>
			</p>
			<p>
				Livello Dinamicit&agrave:<br> <input type="radio"
					name="levelDynamicity" value="1"
					${eform.levelDynamicity=='1'?'checked':''}>1 <input
					type="radio" class="radio" name="levelDynamicity" value="2"
					${eform.levelDynamicity=='2'?'checked':''}>2 <input
					type="radio" class="radio" name="levelDynamicity" value="3"
					${eform.levelDynamicity=='3'?'checked':''}>3 <input
					type="radio" class="radio" name="levelDynamicity" value="4"
					${eform.levelDynamicity=='4'?'checked':''}>4 <input
					type="radio" class="radio" name="levelDynamicity" value="5"
					${eform.levelDynamicity=='5'?'checked':''}>5
			</p>
			<p>
				Esperienze:<br> <input type="text" name="experience"
					value="${eform.experience}" />
			</p>
			<p>
				Motivazioni:<br> <input type="text" name="motivation"
					value="${eform.motivazioni}" />
			</p>
			<p>
				Trasferte:<br> <input type="radio" name="transfer" value="SI"
					${eform.transfer== 'SI'?'checked':''} />SI <input type="radio"
					name="transfer" value="NO" ${eform.transfer== 'SI'?'checked':''} />NO
			</p>
			<p>
			Lingue Conosciute:<br>
			<c:forEach items="${requestScope.languagesList}" var="lang"
				varStatus="candidateLang">
				<tr>
					<td><c:out value="${lang.languageName}" /></td>

					<c:set var="languageLevel" value="languageLevel_${lang.idLanguage}" />

					<td><c:set var="idSlot" value="${lang.idLanguage-1}"/><input type="radio"
						name="${languageLevel}" value="0"
						${eform.spokenLanguages[idSlot].languageLevel== '0'?'checked':''} />
						0 <input type="radio" name="${languageLevel}" value="1"
						${eform.spokenLanguages[idSlot].languageLevel== '1'?'checked':''} />
						1 <input type="radio" name="${languageLevel}" value="2"
						${eform.spokenLanguages[idSlot].languageLevel== '2'?'checked':''} />
						2 <input type="radio" name="${languageLevel}" value="3"
						${eform.spokenLanguages[idSlot].languageLevel== '3'?'checked':''} />3
						<input type="radio" name="${languageLevel}" value="4"
						${eform.spokenLanguages[idSlot].languageLevel== '4'?'checked':''} />
						4
					</td>

				</tr>
			</c:forEach>
			<p>
				Retribuzione attuale:<br> <input type="text" name="currentPay"
					value="${eform.currentPay}" />
			</p>
			<p>
				Retribuzione richiesta:<br> <input type="text"
					name="renumerationRequired" value="${eform.renumeration_required}" />
			</p>
			<p>
				Disponibile dalla data:<br> <input type="date"
					name="availability" value="${eform.availability}" />
			</p>
			<input type="hidden" name="idCandidate" value="${idCandidate}">
			<input type="hidden" name="idOrigin" value="${idOrigin}"> <input
				type="hidden" name="surname" value="${surname}"> <br> <input
				type="submit" value="SALVA MODIFICA" />
		</form>
		<a
			href="CandidateDetailServlet?idCandidate=${eform.idCandidate}&surname=${surname}&idOrigin=${idOrigin}"><<
			&nbsp; TORNA INDIETRO</a>
	</div>
</body>
</html>
