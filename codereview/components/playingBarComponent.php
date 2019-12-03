<?php
include("./src/classes/randomTenSongs.php");
$jsonArray =  getJSONformatArray($con);
// export an Array with JSON format
?>

<script>

$(document).ready(function() {
    currentPlaylist = <?php echo $jsonArray; ?>;
    // console.log(currentPlaylist);
	audioElement = new songAudio();
	setTrackFunction(currentPlaylist[0], currentPlaylist, false);


	$(".playbackBar .progressBar").mousedown(function() {
		mouseDown = true;
	});

	$(".playbackBar .progressBar").mousemove(function(e) {
		if(mouseDown == true) {
			//Set time of song, depending on position of mouse
			timeFromOFFset(e, this);
		}
	});

	$(".playbackBar .progressBar").mouseup(function(e) {
		timeFromOFFset(e, this);
	});

	$(document).mouseup(function() {
		mouseDown = false;
	});

});

function timeFromOFFset(mouse, progressBar) {
	var percentage = mouse.offsetX / $(progressBar).width() * 100;
	var seconds = audioElement.audio.duration * (percentage / 100);
	audioElement.setTime(seconds);
}




function setTrackFunction(trackId, newPlaylist, playFlag){
    $.post("./src/AJAX/getSongConvertToJson.php", {songId: trackId}, function(data){

        var track = JSON.parse(data);
        console.log(track);
        /**
         * A common use of JSON is to exchange data to/from a web server. 
         * When receiving data from a web server, the data is always a string.
         * Parse the data with JSON.parse(), and the data becomes a JavaScript object.
         */
        $(".trackName span").text(track.title);

        $.post("./src/AJAX/getArtistConvertToJson.php", {artistId: track.artist}, function(data){
            currentIndex = currentPlaylist.indexOf(trackId);
            var artist = JSON.parse(data);
            console.log(artist.name);
            $(".artistName span").text(artist.name);
        });

        $.post("./src/AJAX/getAlbumConvertToJson.php", {albumId: track.album}, function(data){
            var album = JSON.parse(data);
            $(".albumLink img").attr("src", album.artworkPath);
        });

        audioElement.setTrack(track);
        audioElement.playOneSong('./src/AJAX/updatePlayCounts.php','.playingBarButton.play','.playingBarButton.pause');
    });

    if(playFlag == true){
        audioElement.play();
    }
}

</script>


<div id="playingBarComponentContainer">

    <div id="playingBar">

        <div id="playingBarLeft">
                <div class="content">
                    <span class="albumLink">
                        <img src="resource/images/icons/react.png" class="albumArtwork">
                    </span>

                    <div class="trackInfo">
                        <span class="trackName">
                            <span>Team 20</span>
                        </span>

                        <span class="artistName">
                            <span>Team 20</span>
                        </span>
                    </div>

                </div>
        </div>

        <div id="playingBarCenter">

                <div class="content playerControls">

                    <div class="buttons">
                        <button class="playingBarButton shuffle" title="Shuffle button">
                            <img src="resource/images/icons/shuffle.png" alt="Shuffle">
                        </button>
                        <button class="playingBarButton previous" title="Previous button">
                            <img src="resource/images/icons/previous.png" alt="Previous">
                        </button>
                        <button class="playingBarButton play" title="Play button" 
                        onclick="audioElement.playOneSong('./src/AJAX/updatePlayCounts.php','.playingBarButton.play','.playingBarButton.pause')">
                            <img src="resource/images/icons/play.png" alt="Play">
                        </button>
                        <button class="playingBarButton pause" itle="Pause button" style="display: none;" 
                        onclick="audioElement.pauseOneSong('.playingBarButton.play','.playingBarButton.pause')">
                            <img src="resource/images/icons/pause.png" alt="Pause">
                        </button>
                        <button class="playingBarButton next" title="Next button">
                            <img src="resource/images/icons/next.png" alt="Next">
                        </button>
                        <button class="playingBarButton repeat" title="Repeat button">
                            <img src="resource/images/icons/repeat.png" alt="Repeat">
                        </button>
                    </div>


                    <div class="playbackBar">
                        <span class="progressTime current">0.00</span>
                        <div class="progressBar">
                            <div class="progressBarBg">
                                <div class="progress" id="progressID"></div>
                            </div>
                        </div>
                        <span class="progressTime remaining">0.00</span>
                    </div>

            </div>


        </div>

        <div id="playingBarRight">
                <div class="volumeBar">
                    <button class="playingBarButton volume" title="Volume button">
                        <img src="resource/images/icons/volume.png" alt="Volume">
                    </button>
                    <div class="progressBar">
                        <div class="progressBarBg">
                            <div class="progress"></div>
                        </div>
                    </div>
                </div>
        </div>

    </div>

</div>