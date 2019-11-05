<?php
include("includes/config.php");//run session_start() firstly

//session_destroy();        //this function will make you every time log out

afterUserLogin();
?>


<html>
	<head>
		<title>Welcome to Team20!</title>
		<link rel="stylesheet" type="text/css" href="assets/css/style.css">
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