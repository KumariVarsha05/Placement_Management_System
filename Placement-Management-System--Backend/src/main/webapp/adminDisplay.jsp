<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<%@include file="css/style.jsp"%>

	<title>Placement Management Application</title>
</head>
<body>
	<center>
		<h1>Placement Management</h1>
        
	</center>
	<a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
    <div align="center" class="table">
        <table border="1" cellpadding="5" class="table-bodered">
            <h2>List of Admins</h2>
            <tr>
                <th scope="col" >ID</th>
                <th scope="col" >Name</th>
                <th scope="col" >Password</th>
                <th scope="col">Operations</th>
                
            </tr>
            <c:forEach var="findAllAdmin" items="${findAllAdmin}">
                <tr>
                    <td><c:out value="${findAllAdmin.id}" /></td>
                    <td><c:out value="${findAllAdmin.name}" /></td>
                    <td><c:out value="${findAllAdmin.password}" /></td>
                    <td>
                    	<a href="editAdmin?id=${findAllAdmin.id}"><button type="button"
			class="btn btn-warning">Edit</button></a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deleteAdmin?id=${findAllAdmin.id}"><button type="button"
			class="btn btn-danger">Delete</button></a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	<br>
    <h2 align="center">
        	<a href="adminIndex.jsp"><button type="button"
			class="btn btn-info">Add New Admin</button></a>
        	
        	
        </h2>
</body>
</html>
