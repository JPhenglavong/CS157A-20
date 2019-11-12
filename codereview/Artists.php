<?php
    function getArtistName($connect, $ID){
        $artistQuery = mysqli_query($connect, "SELECT name FROM artists WHERE id='$ID'");
        $artist = mysqli_fetch_array($artistQuery);
		return $artist['name'];
    }
?>