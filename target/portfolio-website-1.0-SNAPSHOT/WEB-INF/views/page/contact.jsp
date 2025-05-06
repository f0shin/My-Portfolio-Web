<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Toastr -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/form.js"></script>

<script>
    <c:if test="${not empty sessionScope.alertType}">
        toastr.${sessionScope.alertType}('${sessionScope.alertMessage}');
        <c:remove var="alertType" scope="session"/>
        <c:remove var="alertMessage" scope="session"/>
    </c:if>
</script>
	
<div class="page-content">
	<form id="form" class="contact-form" action="saveContact" method="post">
		<table>
			<tr>
				<td><label for="name">Name:</label></td>
				<td><input type="text" id="name" name="name" required>
				</td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>
				<td><input type="email" id="email" name="email" required>
				</td>
			</tr>
			<tr>
				<td><label for="message">Message:</label></td>
				<td><textarea id="message" name="message" rows="5" required></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="button-container">
						<button type="button" id="init_button">Init</button>
						<button type="submit" id="submit_button">Send</button>
					</div>
				</td>
			</tr>

		</table>
	</form>
</div>



