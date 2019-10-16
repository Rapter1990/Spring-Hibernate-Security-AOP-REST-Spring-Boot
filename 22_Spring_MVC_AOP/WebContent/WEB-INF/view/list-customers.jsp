<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			<!--  add a search box -->
			<form:form action="search" method="GET">
				Search customer: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button" />
				
				<input type="button" value="List"
				   onclick="window.location.href='list'; return false;"
				   class="add-button"
			/>
			</form:form>
			
		
			<!--  add our html table here -->
			<form action="showFormForUpdateAndDelete" action="GET" class="form-inline">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Register Date</th>
					<th>Image</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> <fmt:formatDate value="${tempCustomer.registerDate}" pattern="dd/MM/yyyy"/></td>
						<td><img src="data:image/jpg;base64,${tempCustomer.base64Image}" width="100" height="100"/></td>
						<td>
										
						    <input id="customerId" name="customerId" type=hidden  value="${tempCustomer.id}">
						    
							<button type="submit" name="button" class="btn btn-warning" value="Edit">Edit</button>
							
							<!-- onclick="javascript:confirmDelete(${user.id})" -->
							<button type="submit" name="button" class="btn btn-danger" value="Delete" 
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" >Delete</button>
									
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
			</form>
				
		</div>
	
	</div>
	
	

</body>

</html>









