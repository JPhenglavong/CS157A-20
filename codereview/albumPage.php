<?php
include("src/config.php");//run session_start() firstly
include("src/manipulateDatabase.php"); //maipulate data from our database

include("src/classes/Artists.php");
include("src/classes/Album.php");
include("src/classes/Songs.php");

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
		<script src="https://code.jquery.com/jquery-3.4.1.js" 
		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
		<script src="resource/js/songAudio.js"></script>
		<script src="resource/js/playing.js"></script>
		<script src="resource/js/pullProgress.js"></script>

	</head>

	<body>
		<!-- <script>
			var songAudioElement = new songAudio("resource/music/ByeByeBye.mp3");
			songAudioElement.playBGM();
		</script> -->

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
													<img class='play-btn' src='resource/images/icons/play-btn.png' onclick='setTrackFunction(" . $albumSong->getId() . ", tempPlaylist, true)'>
													<span class='trackNumber'>$i</span>
												</div>
												<div class='trackInfo'>
													<div class='trackName'>" . $albumSong->getTitle() . "</div>
													<div class='artistName'>" . $albumArtist . "</div>
												</div>
												<div class='trackOptions'>
													<img class='optionsButton' src='resource/images/icons/more.png'>
												</div>
												<div class='trackDuration'>
													<div class='duration'>" . $albumSong->getDuration() . "</div>
												</div>
											</li>";
										$i = $i + 1;
									}
									?>

									<script>
										var tempSongIds = '<?php echo json_encode($songIdArray); ?>';
										tempPlaylist = JSON.parse(tempSongIds);
										console.log()
									</script>

								</ul>
							</div>
						
						</div>
					</div>

				</div>
				<?php include("components/playingBarComponent.php"); ?>
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