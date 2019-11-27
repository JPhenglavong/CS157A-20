<?php
include("includes/config.php");//run session_start() firstly
include("includes/manipulateDatabase.php"); //maipulate data from our database

//session_destroy();        //this function will make you every time log out

afterUserLogin();

?>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Welcome to Team20!</title>
		<link rel="stylesheet" type="text/css" href="resource/css/style.css">
		<link rel="stylesheet" type="text/css" href="resource/css/albums.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
	</head>

	<body>
			<div id="background">
				<div id="mainComponent">
					<div id="topComponent">
						<?php include("components/navBarComponent.php"); ?>
					</div>


					<div id="mainViewComponent">
						<div id="mainContent">
							
							<h1 class="pageHeadingBig">Welcome to Team20 Albums</h1>
							<div class="gridViewContainer">
								<?php 
									$albumQuery = mysqli_query($con, "SELECT * FROM albums");
									getDataFromAlbums($albumQuery);
								?>
							</div>


						</div>
					</div>

				</div>
				<?php include("components/nowPlayingBarComponent.php"); ?>

			</div>
	</body>

</html>
<?php 
	function afterUserLogin(){
		// if login in successfully, for index.php, user login
		if (isset($_SESSION['userLoggedIn'])) {
			$userLoggedIn = $_SESSION['userLoggedIn'];
		}else{
			header("Location: register.php");
		}
	}
?>
