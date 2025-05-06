<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Toastr -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">

<script>
	<c:if test="${not empty sessionScope.alertType}">
		toastr.${sessionScope.alertType}('${sessionScope.alertMessage}');
		<c:remove var="alertType" scope="session"/>
		<c:remove var="alertMessage" scope="session"/>
	</c:if>
</script>

<div class="contactList-container">
	<div class="contactList-header">
		<c:set var="count" value="0"/>

		<c:forEach var="contact" items="${contacts}">
		    <c:set var="count" value="${count + 1}"/>
		</c:forEach>
		
		<h3>📧Contact List (${count})</h3>
		
		<a href="/admin/getContactList" id="update_button">Update</a>
	</div>

	<table class="contactList-table">
		<thead>
			<tr>
				<th>No</th>
				<th>Date</th>
				<th>Name</th>
				<th>E-Mail</th>
				<th>Message</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="count" value="0"/> <!-- 초기값 설정 -->
			<c:forEach var="contact" items="${contacts}">
			<c:set var="count" value="${count + 1}"/>
				<tr>
					<td>${count}</td>
					<td><fmt:formatDate value="${contact.createdAt}" pattern="yyyy-MM-dd HH:mm"/></td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.message}</td>
					<td>
						<c:choose>
						    <c:when test="${contact.completed == 1}">
						        처리 완료 ✅
						    </c:when>
						    <c:otherwise>
        						미완료 ❌
						        <a href="/admin/modifyContact?id=${contact.id}" id="completed_button">Complete!</a>
						    </c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>








