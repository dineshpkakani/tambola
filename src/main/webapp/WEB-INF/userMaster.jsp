 <%@ include file="nav.html" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">

	<title>Create an account</title>

</head>

<body>
<div class="container">
	<form:form method="POST" modelAttribute="userForm" class="form-signin">
		<h2 class="form-signin-heading">Registration Form </h2>
		<spring:bind path="username">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="username" class="form-control" placeholder="Username"
							autofocus="true"></form:input>
				<form:errors path="username"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="firstname">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="firstname" class="form-control" placeholder="first name"
							autofocus="true"></form:input>
				<form:errors path="firstname"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="lastname">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="lastname" class="form-control" placeholder="last name"
							autofocus="true"></form:input>
				<form:errors path="lastname"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="empcode">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="empcode" class="form-control" placeholder="employee code"
							autofocus="true"></form:input>
				<form:errors path="empcode"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
				<form:errors path="password"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="passwordConfirm">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="password" path="passwordConfirm" class="form-control"
							placeholder="Confirm your password"></form:input>
				<form:errors path="passwordConfirm"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="roles">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:select path="roles" items="${roleList}" itemValue="id" itemLabel="name" class="form-control" multiple="false" >
				</form:select>
				<form:errors path="roles"></form:errors>
			</div>
		</spring:bind>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	</form:form>

</div>

</body>
</html>
