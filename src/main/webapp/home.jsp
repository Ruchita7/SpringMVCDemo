<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h3>Add person</h3>
	<form action="addPerson">
		Id:<input type="text" name="id"><br /> Name:<input
			type="text" name="name"><br /> <input type="submit">
	</form>

	<br />
	<h3>Get person</h3>
	<form action="getPerson">
		Id:<input type="text" name="id"><br /> <input type="submit">
	</form>

	<br />
	<h3>Update person</h3>
	<form action="updatePerson">
		Id: <input type="text" name="id"><br /> Name: <input
			type="text" name="name"><br /> <input type="submit">
	</form>

	<br />
	<h3>Delete person</h3>
	<form action="deletePerson">
		Id: <input type="text" name="id"><br /> <input type="submit">
	</form>

	<br />
	<h3>Find person by tech</h3>
	<form action="findPersonByTech">
		Tech: <input type="text" name="tech"><br /> <input
			type="submit">
	</form>
</body>
</html>