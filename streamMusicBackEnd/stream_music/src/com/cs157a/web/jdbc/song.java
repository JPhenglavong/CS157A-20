package com.cs157a.web.jdbc;

public class song {
	private song parent;
	private song left;
	private song right;
	
	
	public song getParent() {
		return parent;
	}

	public void setParent(song parent) {
		this.parent = parent;
	}

	public song getLeft() {
		return left;
	}

	public void setLeft(song left) {
		this.left = left;
	}

	public song getRight() {
		return right;
	}

	public void setRight(song right) {
		this.right = right;
	}
	

	private int id;
	private String title;
	private int artist;
	private int album;
	private int genre;
	private String duration;
	private String path;
	private int albumOrder;
	private int plays;
	
	public song(String title, int artist, int album, int genre, int albumOrder) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.duration = "2:08";
		this.path = "resource/music/Intro.mp3";
		this.albumOrder = albumOrder;
		this.plays = 0;
	}
	
	public song(int id, String title, int artist, int album, int genre, int albumOrder) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.duration = "2:08";
		this.path = "resource/music/Intro.mp3";
		this.albumOrder = albumOrder;
		this.plays = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getArtist() {
		return artist;
	}

	public void setArtist(int artist) {
		this.artist = artist;
	}

	public int getAlbum() {
		return album;
	}

	public void setAlbum(int album) {
		this.album = album;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getAlbumOrder() {
		return albumOrder;
	}

	public void setAlbumOrder(int albumOrder) {
		this.albumOrder = albumOrder;
	}

	public int getPlays() {
		return plays;
	}

	public void setPlays(int plays) {
		this.plays = plays;
	}

	@Override
	public String toString() {
		return "song [id=" + id + ", title=" + title + ", artist=" + artist + ", album=" + album + ", genre=" + genre
				+ ", duration=" + duration + ", path=" + path + ", albumOrder=" + albumOrder + ", plays=" + plays + "]";
	}
	
	
	
}
