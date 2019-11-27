<?php
	/**
	 * A song class
	 */
	class Song {

		private $connect;
		private $id;
		private $mysqli;
		private $title;
		private $artistId;
		private $albumId;
		private $genre;
		private $duration;
		private $path;

		/**
		 * A constructor function to create a new object
		 */
		public function __construct($con, $id) {
			$this->connect = $con;
			$this->id = $id;
			$query = mysqli_query($this->connect, "SELECT * FROM songs WHERE id='$this->id'");
			$this->mysqli = mysqli_fetch_array($query);
			$this->title = $this->mysqli['title'];
			$this->artistId = $this->mysqli['artist'];
			$this->albumId = $this->mysqli['album'];
			$this->genre = $this->mysqli['genre'];
			$this->duration = $this->mysqli['duration'];
			$this->path = $this->mysqli['path'];
		}

		/**
		 * Get the song's title
		 */
		public function getTitle() {
			return $this->title;
		}

		/**
		 * get the path of this song
		 */
		public function getPath() {
			return $this->path;
		}

		/**
		 * get the duration of this song
		 */
		public function getDuration() {
			return $this->duration;
		}

		/**
		 * get the mysqli function
		 */
		public function getMysqli() {
			return $this->mysqli;
		}

		/**
		 * get the genre of this song
		 */
		public function getGenre() {
			return $this->genre;
		}

	}
?>