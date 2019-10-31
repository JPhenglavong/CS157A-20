<?php
include("includes/config.php");//run session_start() firstly
include("includes/manipulateDatabase.php"); //maipulate data from our database

//session_destroy();        //this function will make you every time log out

afterUserLogin();
?>
<html>
	<head>
		<title>Welcome to Team20!</title>
		<link rel="stylesheet" type="text/css" href="assets/css/style.css">
		<link rel="stylesheet" type="text/css" href="assets/css/albums.css">
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

							<h1 class="pageHeadingBig">Weclome to Team20 Albums</h1>
							<div class="gridViewContainer">
                            <?php
                                idToBeSetted();
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
    
    function idToBeSetted(){
		if(isset($_GET['id'])){
            $albumID = $_GET['id'];
            echo "id=" . $albumID;
            //testing if get the id
            echo '<br>';
            echo 'Hello World!<br>';
            echo 'Midterm for me is hard!<br>';
            echo 'The last changce to get a good grade is trying my best to implement my project.<br>';
            echo 'Are you ready?<br>';
            echo 'Begin to listen to the music...<br>';
		}else{
			header("Location: index.php");
		}
	}
?>