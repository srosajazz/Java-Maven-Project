package UserPosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbcconection.SingleConnection;
import model.Userposjava1;

public class UserPosDAO {

	private Connection connection;
	
	public UserPosDAO() {
		
		connection = SingleConnection.getConnection();		
	}
	
	public void save (Userposjava1 userposjava1) {
		try {
			String sql = "insert into userposjava1 (id, name, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1,  userposjava1.getId());
			insert.setString(2, userposjava1.getName());
			insert.setString(3, userposjava1.getEmail());
			insert.execute();
			connection.commit(); //save data inside the db.
			
		} catch (Exception e) {
			
			try {
				connection.rollback(); //revert operation
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
