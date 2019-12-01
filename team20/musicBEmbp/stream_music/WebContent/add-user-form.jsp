<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<title>Save Music Customer</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/mainView.css">
</head>

<body>
	<div id="background">
		<div class="container">
		
			<h3>Customer Directory</h3>
			<hr>
			
			<p class="h4 mb-4">Save User</p>
		
			<form action="userControllerServlet" method="GET">
			
				<!-- Add hidden form field to handle update, Note: we must use value="ADD" -->
				<input type="hidden" name="command" value="ADD" />
				
				<input type="text" name="username"
						class="form-control mb-4 col-4" placeholder="User name">
						
				<input type="text" name="firstName"
						class="form-control mb-4 col-4" placeholder="First name">
	
				<input type="text" name="lastName"
						class="form-control mb-4 col-4" placeholder="Last name">
	
				<input type="text" name="email"
						class="form-control mb-4 col-4" placeholder="Email">
					
				<button type="submit" class="btn btn-info col-2">Save</button>
							
			</form>
		
			<hr>
			<a href="userControllerServlet">Back to Users List</a>
			
		</div>
	</div>
</body>

</html>