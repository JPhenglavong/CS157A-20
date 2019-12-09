package com.cs157a.web.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class songDdatabaseUtil {
	private DataSource dataSource;

	public songDdatabaseUtil(DataSource ds) {
		dataSource = ds;
	}

	public ArrayList<song> getSongs() throws SQLException {
		ArrayList<song> songs = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM Songs";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);

			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int artist = rs.getInt("artist");
				int album = rs.getInt("album");
				int genre = rs.getInt("genre");
				String duration = rs.getString("duration");
				String path = rs.getString("path");
				int albumOrder = rs.getInt("albumOrder");
				int plays = rs.getInt("plays");

				//create new user object
				song tempSong = new song(id, title, artist, album, genre, albumOrder);
				tempSong.setDuration(duration);
				tempSong.setPath(path);
				tempSong.setPlays(plays);
				//add it to the list of users
				songs.add(tempSong);
			}
			// heap Heap = new heap(songs);
			// Heap.buildMaxHeap(songs);
			// Heap.HeapSort(songs);
			return songs;

		}finally {
			//close JDBC objects
			close(conn, stmt, rs);
		}
	}

	public ArrayList<song> getHeapSortSongs() throws SQLException {
		ArrayList<song> songs = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM Songs";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);

			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int artist = rs.getInt("artist");
				int album = rs.getInt("album");
				int genre = rs.getInt("genre");
				String duration = rs.getString("duration");
				String path = rs.getString("path");
				int albumOrder = rs.getInt("albumOrder");
				int plays = rs.getInt("plays");

				//create new user object
				song tempSong = new song(id, title, artist, album, genre, albumOrder);
				tempSong.setDuration(duration);
				tempSong.setPath(path);
				tempSong.setPlays(plays);
				//add it to the list of users
				songs.add(tempSong);
			}
			 heap Heap = new heap(songs);
			 Heap.buildMaxHeap(songs);
			 Heap.HeapSort(songs);
			return songs;

		}finally {
			//close JDBC objects
			close(conn, stmt, rs);
		}
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addSong(song theSong) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "INSERT INTO Songs "
					   + "(id, title, artist, album, genre, duration, path, albumOrder, plays)"
					   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setString(1, null);
			myStmt.setString(2, theSong.getTitle());
			myStmt.setInt(3, theSong.getArtist());
			myStmt.setInt(4, theSong.getAlbum());
			myStmt.setInt(5, theSong.getGenre());
			myStmt.setString(6, theSong.getDuration());
			myStmt.setString(7, theSong.getPath());
			myStmt.setInt(8, theSong.getAlbumOrder());
			myStmt.setInt(9, theSong.getPlays());

			// execute sql insert
			myStmt.execute();

		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public song getSong(String theSongId) throws Exception {
		song theSong = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int songId;

		try {
			// convert student id to int
			songId = Integer.parseInt(theSongId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected user
			String sql = "SELECT * FROM Songs WHERE id=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, songId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {

				int id = myRs.getInt("id");
				String title = myRs.getString("title");
				int artist = myRs.getInt("artist");
				int album = myRs.getInt("album");
				int genre = myRs.getInt("genre");
				String duration = myRs.getString("duration");
				String path = myRs.getString("path");
				int albumOrder = myRs.getInt("albumOrder");
				int plays = myRs.getInt("plays");

				// use the studentId during construction
				theSong = new song(id, title, artist, album, genre, albumOrder);
				theSong.setDuration(duration);
				theSong.setPath(path);
			}
			else {
				throw new Exception("Could not find user id: " + songId);
			}
			return theSong;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateSong(song theSong) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create SQL update statement
			String sql = "UPDATE Songs "
						+ "set title=?, artist=?, album=?, genre=?, albumOrder=? "
						+ "WHERE id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theSong.getTitle());
			myStmt.setInt(2, theSong.getArtist());
			myStmt.setInt(3, theSong.getAlbum());
			myStmt.setInt(4, theSong.getGenre());
			myStmt.setInt(5, theSong.getAlbumOrder());
			myStmt.setInt(6, theSong.getId());

			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public void deleteSong(String theSongId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// convert song id to int
			int songId = Integer.parseInt(theSongId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to delete student
			String sql = "DELETE FROM Songs where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, songId);

			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}

	}

	public ArrayList<song> getBstInorderSortSongs() throws SQLException {
		binarySearchTree bst = new binarySearchTree();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM Songs";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);

			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int artist = rs.getInt("artist");
				int album = rs.getInt("album");
				int genre = rs.getInt("genre");
				String duration = rs.getString("duration");
				String path = rs.getString("path");
				int albumOrder = rs.getInt("albumOrder");
				int plays = rs.getInt("plays");

				//create new user object
				song tempSong = new song(id, title, artist, album, genre, albumOrder);
				tempSong.setDuration(duration);
				tempSong.setPath(path);
				tempSong.setPlays(plays);
				//add it to the list of users
				bst.Tree_Insert(tempSong);
			}
			bst.Inorder_BST_Walk(bst.getRoot());

			return bst.songlist;

		}finally {
			//close JDBC objects
			close(conn, stmt, rs);
		}
	}

	public ArrayList<redBlackSongNode> getRbtInorderSortSongs() throws SQLException {
		redBlackTree RBTree = new redBlackTree();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM Songs";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);

			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int artist = rs.getInt("artist");
				int album = rs.getInt("album");
				int genre = rs.getInt("genre");
				String duration = rs.getString("duration");
				String path = rs.getString("path");
				int albumOrder = rs.getInt("albumOrder");
				int plays = rs.getInt("plays");
				
				//add it to the list of users
				redBlackSongNode insertNode = new redBlackSongNode(id, title, artist, album, genre, duration,
						path, albumOrder, plays, "");
				RBTree.RB_Insert(insertNode);
			}
			// RBTree.Inorder_RBT_Walk(RBTree.getRoot());

			return RBTree.redBlackNodeslist;

		}finally {
			//close JDBC objects
			close(conn, stmt, rs);
		}
	}

}
