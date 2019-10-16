<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		  
	<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
	<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 

	<!--Font Awesome (added because you use icons in your prepend/append)-->
	<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

	<!-- Inline CSS based on choices in "Settings" tab -->
	<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}</style>  
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST" enctype="multipart/form-data">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" />
						<font color="red"><form:errors path="firstName" /></font></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" />
						<font color="red"><form:errors path="firstName" /></font></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" />
						<font color="red"><form:errors path="email" /></font></td>
					</tr>
					
					<tr>
						<td><label>Image:</label></td>
						<td><input type="file" name="file" required="required"/>
						</td>
					</tr>
					
					<tr>
						<td><label>Register Date:</label></td>
						<td><div class="col-sm-10">
						       <div class="input-group">
						        <div class="input-group-addon">
						         <i class="fa fa-calendar">
						         </i>
						        </div>
						        <input class="form-control" id="date" name="date" placeholder="dd/MM/yyyy" type="text"/>
						       </div>
						    </div>
						<font color="red"><form:errors path="registerDate" /></font>
						</td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
			
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>
	
	
	

</body>

<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
	$(document).ready(function(){
		var date_input=$('input[name="date"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'dd/mm/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
		})
	})
</script>

</html>










