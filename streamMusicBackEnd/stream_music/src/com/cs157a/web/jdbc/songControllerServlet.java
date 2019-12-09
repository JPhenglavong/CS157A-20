package com.cs157a.web.jdbc;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class songControllerServlet
 */
@WebServlet("/songControllerServlet")
public class songControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private songDdatabaseUtil songDbUtil; 
	
	//Define datasource/connection pool for Resource Injection
	@Resource(name="jdbc/team20")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create our user db util ... and pass in the conn poll / datasource
		try {
			songDbUtil = new songDdatabaseUtil(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing users
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
				case "LIST":
					listSong(request, response);
					break;
					
				case "ADD":
					addSong(request, response);
					break;
					
				case "LOAD":
					loadSong(request, response);
					break;
					
				case "UPDATE":
					updateSong(request, response);
					break;
				
				case "DELETE":
					deleteSong(request, response);
					break;			
				
				case "HEAP_SORT_ALBUMORDER":
					heapSortSongByAlbumOrder(request, response);
					break;
					
				case "BST_INORDER_SORT_GENRE":
					bstInorderSortSongByGenre(request, response);
					break;
					
				case "RBT_INORDER_SORT_ARTIST":
					bstInorderSortSongByArtist(request, response);
					break;
					
				default:
					listSong(request, response);
			}
				
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}



	private void bstInorderSortSongByArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//get songs from db util
		ArrayList<redBlackSongNode> songs = songDbUtil.getRbtInorderSortSongs();
				
		//add users to the request
		request.setAttribute("SONG_LIST", songs);
				
		//send to JSP page(view)
		RequestDispatcher sender = request.getRequestDispatcher("/list-songs.jsp");
		sender.forward(request, response);
		
	}



	private void bstInorderSortSongByGenre(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//get songs from db util
		ArrayList<song> songs = songDbUtil.getBstInorderSortSongs();
				
		//add users to the request
		request.setAttribute("SONG_LIST", songs);
				
		//send to JSP page(view)
		RequestDispatcher sender = request.getRequestDispatcher("/list-songs.jsp");
		sender.forward(request, response);
	}



	private void heapSortSongByAlbumOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//get songs from db util
		ArrayList<song> songs = songDbUtil.getHeapSortSongs();
				
		//add users to the request
		request.setAttribute("SONG_LIST", songs);
				
		//send to JSP page(view)
		RequestDispatcher sender = request.getRequestDispatcher("/list-songs.jsp");
		sender.forward(request, response);
		
	}



	private void deleteSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// read song id from form data
		String theSongId = request.getParameter("songId");
		
		// delete song from database
		songDbUtil.deleteSong(theSongId);
		
		// send them back to "list songs" page
		listSong(request, response);
		
	}



	private void updateSong(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// read song info from form data
		int id = Integer.parseInt(request.getParameter("songId"));
		String title = request.getParameter("title");
		String artistStr = request.getParameter("artist");
		int artist = Integer.parseInt(artistStr);
		String albumStr = request.getParameter("album");
		int album = Integer.parseInt(albumStr);
		String genreStr = request.getParameter("genre");
		int genre = Integer.parseInt(genreStr);
		String albumOrderStr = request.getParameter("albumOrder");
		int albumOrder = Integer.parseInt(albumOrderStr);
		
		// create a new user object
		song theSong = new song(id, title, artist, album, genre, albumOrder);
		
		// perform update on database
		songDbUtil.updateSong(theSong);
		
		// send them back to the "list user" page
		listSong(request, response);
		
	}



	private void loadSong(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read user id from form data
		String theSongId = request.getParameter("songId");
		
		// get user from database (db util)
		song theSong = songDbUtil.getSong(theSongId);
		
		// place user in the request attribute
		request.setAttribute("THE_SONG", theSong);
		
		// send to jsp page: updateUserform.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateSongForm.jsp");
		dispatcher.forward(request, response);	
		
	}



	private void addSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// read song info from form data
		// String idStr = request.getParameter("id");
		// int id = Integer.parseInt(idStr);
		String title = request.getParameter("title");
		String artistStr = request.getParameter("artist");
		int artist = Integer.parseInt(artistStr);
		String albumStr = request.getParameter("album");
		int album = Integer.parseInt(albumStr);
		String genreStr = request.getParameter("genre");
		int genre = Integer.parseInt(genreStr);
		String albumOrderStr = request.getParameter("albumOrder");
		int albumOrder = Integer.parseInt(albumOrderStr);
		
		// create a new user object
		song theSong = new song(title, artist, album, genre, albumOrder);
		
		// add the user to the database
		songDbUtil.addSong(theSong);
				
		// send back to main page (the user list)
		listSong(request, response);
	}



	private void listSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//get songs from db util
		ArrayList<song> songs = songDbUtil.getSongs();
				
		//add users to the request
		request.setAttribute("SONG_LIST", songs);
				
		//send to JSP page(view)
		RequestDispatcher sender = request.getRequestDispatcher("/list-songs.jsp");
		sender.forward(request, response);
		
	}

}
