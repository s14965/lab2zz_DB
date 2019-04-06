package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDbUtil {
	
	public UserDbUtil() {
		
	}
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static List<Users> getUsers() throws Exception {
		
		final String host = "jdbc:hsqldb:hsql://localhost/workdb";
		final String username = "SA";
		final String password = "";
	    
		List<Users> users = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			// get a connection
			myConn = DriverManager.getConnection( host, username, password );
			
			// create sql statement
			String sql = "SELECT * FROM users";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String Username = myRs.getString("username");
				String Password = myRs.getString("password");
				String email = myRs.getString("email");
				String privileges = myRs.getString("privileges");
				
				// create new user object
				Users tempUser = new Users(id, Username, Password, email, privileges);
				
				// add it to the list of users
				users.add(tempUser);				
			}
			
			return users;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}
	
	public static boolean checkDoesUserExist(String username) {
		
		final String dbHost = "jdbc:hsqldb:hsql://localhost/workdb";
		final String dbUsername = "SA";
		final String dbPassword = "";
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			// get a connection
			myConn = DriverManager.getConnection( dbHost, dbUsername, dbPassword );
			
			// create sql statement
			String sql = "SELECT * FROM users where username = '"+ username +"';";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			myRs.next();
				
			// retrieve data from result set row
			String tempUser = myRs.getString("username");
			if(tempUser.equals(username)) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		return false;
	}

	public static Users checkIfValid(String username, String password) {
		final String DBhost = "jdbc:hsqldb:hsql://localhost/workdb";
		final String DBusername = "SA";
		final String DBpassword = "";
	    
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			// get a connection
			myConn = DriverManager.getConnection( DBhost, DBusername, DBpassword );
			
			// create sql statement
			String sql = "SELECT * FROM users where username = '"+ username +"';";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set to get to first row
			myRs.next();
				
			// retrieve data from result set row
			
			String tempUser = myRs.getString("username");
			String tempPass = myRs.getString("password");
			if(tempUser.equals(username) && tempPass.equals(password)) {
				String tempEmail = myRs.getString("email");
				String tempPriv = myRs.getString("privileges");
				Users user = new Users(tempUser, tempPass, tempEmail, tempPriv); 
				return user;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		return null;
	}

	public static void addNewUser(String signUpUsername, String signUpPassword, String signUpEmail) {
		final String DBhost = "jdbc:hsqldb:hsql://localhost/workdb";
		final String DBusername = "SA";
		final String DBpassword = "";
	    
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			// get a connection
			myConn = DriverManager.getConnection( DBhost, DBusername, DBpassword );
			
			// create sql statement
			String sql = "INSERT INTO users (username, password, email, privileges) VALUES ('"+signUpUsername+"', '"+signUpPassword+"', '"+signUpEmail+"' ,'Bsc');";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
	
	}
	public static void UpDatePrivileges(String upDateUsername, String upDatePrivileges) {
		final String DBhost = "jdbc:hsqldb:hsql://localhost/workdb";
		final String DBusername = "SA";
		final String DBpassword = "";
	    
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			// get a connection
			myConn = DriverManager.getConnection( DBhost, DBusername, DBpassword );
			
			// create sql statement
			String sql = "UPDATE users SET privileges = '" + upDatePrivileges + "' WHERE username = '" + upDateUsername + "';";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
	}

}














