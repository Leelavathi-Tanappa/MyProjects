<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<h2>Welcome to Spring Web MVC, Spring ORM and Hibernate....</h2>
	<form action="addEmployee" method="post">
		Enter Employee id : <input type="text" name="eId"></input></br>
		Enter Employee name : <input type="text" name="eName" required></input></br>
		Enter Employee Age : <input type="text" name="eAge" required></input></br>
		Enter Employee Dept : <input type="text" name="eDept" required></input></br>
		<button type="submit">Add Employee</button>
	</form>
	<hr>
	<form action="getEmployee" method="get">
		Enter your Employee ID : <input type="text" name="eId"></input></br>
		<button type="submit">Get Employee by ID</button>
	</form>
</body>
</html>