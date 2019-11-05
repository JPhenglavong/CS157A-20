<?php
include("includes/config.php");//run session_start() firstly

//session_destroy();        //this function will make you every time log out

//afterUserLogin();
?>
<html>
	<head>
		<title>Here's your music</title>
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
							
							<h1 class="pageHeadingBig">Welcome to Team20 Albums</h1>
							<div class="gridViewContainer">
								<?php 
									$albumQuery = mysqli_query($con, "SELECT * FROM albums");
									while($row = mysqli_fetch_array($albumQuery)){
										echo "<div class='gridViewItem'>
												<a href='album.php?id=" . $row['id'] . "'>
													<img src='" . $row['artworkPath'] . "'>
						
													<div class='gridViewInfo'>"
														. $row['title'] .
													"</div>
												</a>
											</div>";
									}
								?>
							</div>
						</div>
					</div>

				</div>
				<?php include("components/nowPlayingBarComponent.php"); ?>

			</div>
	</body>
</html>

?>
