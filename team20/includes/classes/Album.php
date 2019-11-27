<?php

    /**
     * A function get the title of album
     */
    function getAlbumTitle($connect, $ID){
        $albumQuery = mysqli_query($connect, "SELECT title FROM albums WHERE id='$ID'");
        $album = mysqli_fetch_array($albumQuery);
		return $album['title'];
    }

    function getArtWorkPath($connect, $ID){
        $albumQuery = mysqli_query($connect, "SELECT artworkPath FROM albums WHERE id='$ID'");
        $album = mysqli_fetch_array($albumQuery);
		return $album['artworkPath'];
    }

    function getGenre($connect, $ID){
        $albumQuery = mysqli_query($connect, "SELECT genre FROM albums WHERE id='$ID'");
        $album = mysqli_fetch_array($albumQuery);
		return $album['genre'];
    }

    function getNumbersOfSongs($connect, $ID){
        $query = mysqli_query($connect, "SELECT id FROM songs WHERE album='$ID'");
        return mysqli_num_rows($query);
    }
    

	function getSongIds($connect, $ID) {

        $query = mysqli_query($connect, "SELECT id FROM songs WHERE album='$ID' ORDER BY albumOrder ASC");
        
		$array = array();
		while($row = mysqli_fetch_array($query)) {
			array_push($array, $row['id']);
		}
		return $array;
	}
?>