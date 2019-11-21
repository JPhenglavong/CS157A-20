<?php
include("includes/config.php");//run session_start() firstly
include("includes/manipulateDatabase.php"); //maipulate data from our database

include("includes/classes/Artists.php");
include("includes/classes/Album.php");
include("includes/classes/Songs.php");

//session_destroy();        //this function will make you every time log out

afterUserLogin();
?>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Welcome to Team20!</title>
		<link rel="stylesheet" type="text/css" href="assets/css/style.css">
		<link rel="stylesheet" type="text/css" href="assets/css/albums.css">
		<link rel="stylesheet" type="text/css" href="assets/css/song.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
		<script src="assets/js/songAudio.js"></script>
	</head>

	<body>
		<script>
			var audioElement = new songAudio();
			audioElement.setTrack("assets/music/ByeByeBye.mp3");
			audioElement.audio.play();
		</script>

			<div id="background">
				<div id="mainComponent">
					<div id="topComponent">
						<?php include("components/navBarComponent.php"); ?>
					</div>


					<div id="mainViewComponent">
						<div id="mainContent">

							<?php
								if(isset($_GET['id'])){
									$albumId = $_GET['id'];
									// echo "id=" . $albumId. "<br>";		
								}else{
									header("Location: index.php");
								}
								$albumQuery = mysqli_query($con, "SELECT * FROM albums WHERE id='$albumId'");
								$album = mysqli_fetch_array($albumQuery);
                            ?>

							<div class="entityInfo">
								<div class="leftPart">
									<img src="<?php echo getArtworkPath($con, $albumId); ?>">
								</div>

								<div class="rightPart">
									<h2><?php echo getAlbumTitle($con, $albumId); ?></h2>
									<p>Designed By <?php echo getArtistName($con, $albumId); ?></p>
									<p><?php echo getNumbersOfSongs($con, $albumId); ?></p>
								</div>

							</div>

							<div class="tracklistContainer">
								<ul class="tracklist">

									<?php
									$songIdArray = getSongIds($con, $albumId);
									$i = 1;
									foreach($songIdArray as $albumId) {

										$albumSong = new Song($con, $albumId);
										$albumArtist = getArtistName($con, $albumId);

										echo "<li class='tracklistRow'>
												<div class='trackCount'>
													<img class='play-btn' src='assets/images/icons/play-btn.png'>
													<span class='trackNumber'>$i</span>
												</div>
												<div class='trackInfo'>
													<span class='trackName'>" . $albumSong->getTitle() . "</span>
													<span class='artistName'>" . $albumArtist . "</span>
												</div>
												<div class='trackOptions'>
													<img class='optionsButton' src='assets/images/icons/more.png'>
												</div>
												<div class='trackDuration'>
													<span class='duration'>" . $albumSong->getDuration() . "</span>
												</div>
											</li>";
										$i = $i + 1;
									}
									?>
								</ul>
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