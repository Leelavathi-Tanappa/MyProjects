<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<h2>Welcome Spring boot MVC....</h2>
	<h3 style="background-clip: DodgerBlue">Enter details here if you want save an Employee to database</h3>
	<form action="addEmployee" method="post">
		Enter your Id : <input type="text" name="eId"></input></br>
		Enter Name : <input type="text" name="eName"></input></br>
		Enter Age : <input type="text" name="eAge"></input></br>
		Enter Dept : <input type="text" name="eDept"></input></br>
		<button type="submit">Add Employee</button>
	</form>
	
	<hr>
	<h3 style="background-clip: DodgerBlue">Enter Employee Id to get the Employee to DB</h3>
	<form action="getEmployee">
		Enter Employee ID : <input type="text" name="eId" /> </br>
		<button type="submit">Get Employee by your ID</button>
	</form>
	
	<hr>
	<h3 style="background-clip: DodgerBlue">Enter Employee name to get the Employee to DB</h3>
	<form action="getEmployeeByName">
		Enter Employee ID : <input type="text" name="eName" /> </br>
		<button type="submit">Get Employee/(s) by Name</button>
	</form>
	
	<hr>
	<h3 style="background-clip: DodgerBlue">Enter Employee Id to delete the Employee to DB</h3>
	<form action="deleteEmployee">
		Enter Employee ID : <input type="text" name="eId" /> </br>
		<button type="submit">Delete Employee by ID</button>
	</form>
</body>
</html>