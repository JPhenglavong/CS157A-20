package com.cs157a.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import javax.sql.DataSource;

public class UserDdatabaseUtil {
	
	private DataSource dataSource;

	public UserDdatabaseUtil(DataSource ds) {
		dataSource = ds;
	}
	
	public ArrayList<user> getUsers() throws Exception{
		ArrayList<user> users = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM users";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				
				//create new user object
				user tempUser = new user(id, username, firstName, lastName, email);
				//add it to the list of users
				users.add(tempUser);
			}
			
			return users;
			
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

	public void addUser(user theUser) throws Exception {
//		java.util.Date dt = new java.util.Date();
//		java.text.SimpleDateFormat sdf = 
//		new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String currentTime = sdf.format(dt);
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into users "
					   + "(id, username,firstName,lastName, email, password, signUpDate,profilePic)"
					   + "values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, null);
			myStmt.setString(2, theUser.getUsername());
			myStmt.setString(3, theUser.getFirstName());
			myStmt.setString(4, theUser.getLastName());
			myStmt.setString(5, theUser.getEmail());
			myStmt.setString(6, theUser.getPassword());
			myStmt.setString(7, theUser.getTime());
			myStmt.setString(8, theUser.getProfilePic());
			
			// execute sql insert
			myStmt.execute();
			
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public user getUser(String theUserId) throws Exception {
		user theUser = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int userId;
		
		try {
			// convert student id to int
			userId = Integer.parseInt(theUserId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected user
			String sql = "SELECT * FROM users WHERE id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, userId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String username = myRs.getString("username");
				String firstName = myRs.getString("firstName");
				String lastName = myRs.getString("lastName");
				String email = myRs.getString("email");
				
				// use the studentId during construction
				theUser = new user(userId, username, firstName, lastName, email);
			}
			else {
				throw new Exception("Could not find user id: " + userId);
			}		
			return theUser;
			
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateUser(user theUser) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "UPDATE users "
						+ "set username=?, firstName=?, lastName=?, email=? "
						+ "WHERE id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theUser.getUsername());
			myStmt.setString(2, theUser.getFirstName());
			myStmt.setString(3, theUser.getLastName());
			myStmt.setString(4, theUser.getEmail());
			myStmt.setInt(5, theUser.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public void deleteUser(String theUserId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int userId = Integer.parseInt(theUserId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "DELETE FROM users where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, userId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
		
	}

	public ArrayList<user> getλLambdaSortUsersList() throws SQLException {
		ArrayList<user> users = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM users";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				
				//create new user object
				user tempUser = new user(id, username, firstName, lastName, email);
				//add it to the list of users
				users.add(tempUser);
			}
			Collections.sort(users, user.comparatorByUserName(true));

			return users;
			
		}finally {
			//close JDBC objects
			close(conn, stmt, rs);
		}
		

	}

	public ArrayList<user> getλLambdaSortByEmailUsersList() throws SQLException{
		ArrayList<user> users = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM users";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				
				//create new user object
				user tempUser = new user(id, username, firstName, lastName, email);
				//add it to the list of users
				users.add(tempUser);
			}
			Collections.sort(users, user.comparatorByEmail(true));

			return users;
			
		}finally {
			//close JDBC objects
			close(conn, stmt, rs);
		}
		

	}

	public ArrayList<user> getUsersBySortID() throws SQLException {
		ArrayList<user> users = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			//get a connection
			conn = dataSource.getConnection();
			//create sql statemnt
			String sql = "SELECT * FROM users";
			stmt = conn.createStatement();
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				
				//create new user object
				user tempUser = new user(id, username, firstName, lastName, email);
				//add it to the list of users
				users.add(tempUser);
			}
			 uHeap Heap = new uHeap(users);
			 Heap.buildMaxHeap(users);
			 Heap.HeapSort(users);
			return users;
			
		}finally {
			//close JDBC objects
			close(conn, stmt, rs);
		}
	}
	
	
}
