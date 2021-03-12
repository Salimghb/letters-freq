<!DOCTYPE HTML>

// Include FusionCharts core file
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script>

// Include FusionCharts Theme file
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.fusion.js"></script>

<html lang="fr">
<head>
    <title>Letters Frequency App</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
Available languages :
<p><a href="${pageContext.request.contextPath}/totOccByLetter?language=fr">TotOcc French</a></p>
<p><a href="${pageContext.request.contextPath}/totOccByLetter?language=en">TotOcc English</a></p>
<p><a href="${pageContext.request.contextPath}/totOccByLetter?language=es">TotOcc Spanish</a></p>

<p><a href="${pageContext.request.contextPath}/posByLetter?language=fr">Pos French</a></p>
<p><a href="${pageContext.request.contextPath}/posByLetter?language=en">Pos English</a></p>
<p><a href="${pageContext.request.contextPath}/posByLetter?language=es">Pos Spanish</a></p>
</body>
</html>