package com.cs157a.web.jdbc;

public class redBlackSongNode {

	private int id;
	private String title;
	private int artist;
	private int album;
	private int genre;
	private String duration;
	private String path;
	private int albumOrder;
	private int plays;
	
    /* For binary search tree */
    private redBlackSongNode parent;
    private redBlackSongNode left;
    private redBlackSongNode right;
    private String color;
	
    
    
    
	public redBlackSongNode getParent() {
		return parent;
	}
	public void setParent(redBlackSongNode parent) {
		this.parent = parent;
	}
	public redBlackSongNode getLeft() {
		return left;
	}
	public void setLeft(redBlackSongNode left) {
		this.left = left;
	}
	public redBlackSongNode getRight() {
		return right;
	}
	public void setRight(redBlackSongNode right) {
		this.right = right;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public redBlackSongNode(int id, String title, int artist, int album, int genre, String duration, String path,
			int albumOrder, int plays, String color) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.duration = duration;
		this.path = path;
		this.albumOrder = albumOrder;
		this.plays = plays;
		this.color = color;
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
	
	
}
