<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ina's Portfolio : ${pageTitle}</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/style.css">
	
	<!-- Toastr 라이브러리 추가 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
	
</head>
<body class="layout-body">
	
	<header>
		<jsp:include page="common/header.jsp" />
	</header>

	<main>
		<div class="page-name">${pageTitle}</div>
		<jsp:include page="${pagePath}" />
	</main>

	<footer>
		<jsp:include page="common/footer.jsp" />
	</footer>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/static/js/common.js"></script>
	<script src="${pageContext.request.contextPath}/resources/static/js/effect.js"></script>
	
	<div class="snow-container"></div>

</body>
</html>
