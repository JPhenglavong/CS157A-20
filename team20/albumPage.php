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
		<link rel="stylesheet" type="text/css" href="resource/css/style.css">
		<link rel="stylesheet" type="text/css" href="resource/css/albums.css">
		<link rel="stylesheet" type="text/css" href="resource/css/song.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
		<script src="resource/js/songAudio.js"></script>
	</head>

	<body>
		<script>
			var audioElement = new songAudio();
			audioElement.setTrack("resource/music/Number Ones/Dont Stop Til You Get Enough.mp3");
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
									<h1><?php echo getAlbumTitle($con, $albumId); ?></h1>
									<h2>Music By <?php echo getArtistName($con, $albumId); ?></h2>
									<p>Number of Songs: <?php echo getNumbersOfSongs($con, $albumId); ?></p>
								</div>

							</div>

							<div class="tracklistContainer">
								<ul class="tracklist">

									<?php
									$songIdArray = getSongIds($con, $albumId);
									$albumArtist = getArtistName($con, $albumId);
									$albumIdSongIncrementer = $albumArtist;
									$trackNumber = 1;
									foreach($songIdArray as $albumIdSongIncrementer) {

										$albumSong = new Song($con, $albumIdSongIncrementer);

										echo "<li class='tracklistRow'>
												<div class='trackCount'>
													<img class='play-btn' src='resource/images/icons/play-btn.png'>
													<span class='trackNumber'>$trackNumber</span>
												</div>
												<div class='trackInfo'>
													<span class='trackName'>" . $albumSong->getTitle() . "</span>
													<span class='artistName'>" . $albumArtist . "</span>
												</div>
												<div class='trackOptions'>
													<img class='optionsButton' src='resource/images/icons/more.png'>
												</div>
												<div class='trackDuration'>
													<span class='duration'>" . $albumSong->getDuration() . "</span>
												</div>
											</li>";
										$trackNumber++;
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