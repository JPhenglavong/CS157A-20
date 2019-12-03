<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<title>Save Stream Music Songs</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/mainView.css">
</head>

<body>
	<div id="background">
		<div class="container">
		
			<h3>Songs Directory</h3>
			<hr>
			
			<p class="h4 mb-4">Save Song</p>
		
			<form action="songControllerServlet" method="GET">
			
				<!-- Add hidden form field to handle update, Note: we must use value="ADD" -->
                <input type="hidden" name="command" value="ADD" />

                <input type="text" name="title"
                        class="form-control mb-4 col-4" placeholder="title">
				
				<input type="text" name="artist"
						class="form-control mb-4 col-4" placeholder="artist">
						
				<input type="text" name="album"
						class="form-control mb-4 col-4" placeholder="album">
	
				<input type="text" name="genre"
						class="form-control mb-4 col-4" placeholder="genre">
	
				<input type="text" name="albumOrder"
						class="form-control mb-4 col-4" placeholder="album Order">
					
				<button type="submit" class="btn btn-info col-2">Save</button>
							
			</form>
		
			<hr>
			<a href="songControllerServlet">Back to Songs List</a>
			
		</div>
	</div>
</body>

</html>