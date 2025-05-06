<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!-- Toastr -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script src="${pageContext.request.contextPath}/resources/static/js/form.js"></script>

<script>
    <c:if test="${not empty sessionScope.alertType}">
        toastr.${sessionScope.alertType}('${sessionScope.alertMessage}');
        
        <c:remove var="alertType" scope="session"/>
        <c:remove var="alertMessage" scope="session"/>
    </c:if>
</script>

<div class="page-content">
	<form id="form" class="login-form" action="loginSubmit" method="post">
		<table>
			<tr>
				<td><label for="id">ID:</label></td>
				<td><input type="text" id="id" name="id" required></td>
			</tr>
			<tr>
				<td><label for="pw">PW:</label></td>
				<td><input type="password" id="pw" name="pw" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="button-container">
						<button type="button" id="init_button">Init</button>
						<button type="submit" id="submit_button">Login</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>