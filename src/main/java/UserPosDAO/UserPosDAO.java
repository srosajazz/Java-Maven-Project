package UserPosDAO;

import java.sql.Connection;

import jdbcconection.SingleConnection;

public class UserPosDAO {

	private Connection connection;
	
	public UserPosDAO() {
		
		connection = SingleConnection.getConnection();		
	}
	
}
