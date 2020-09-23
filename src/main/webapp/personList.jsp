<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Person List</h1>

	<c:if test="${not empty personList}">
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Tech</th>
			</tr>
			<c:forEach items="${personList}" var="person">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td>${person.tech}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>