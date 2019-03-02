package UserPosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcconection.SingleConnection;
import model.Userposjava1;

public class UserPosDAO {

	private Connection connection;

	public UserPosDAO() {

		connection = SingleConnection.getConnection();
	}

	public void save(Userposjava1 userposjava1) {
		try {
			String sql = "insert into userposjava1 (id, name, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava1.getId());
			insert.setString(2, userposjava1.getName());
			insert.setString(3, userposjava1.getEmail());
			insert.execute();
			connection.commit(); // save data inside the db.

		} catch (Exception e) {

			try {
				connection.rollback(); // revert operation
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	// List of object return

	public List<Userposjava1> listar() throws Exception {

		List<Userposjava1> listas = new ArrayList<Userposjava1>();

		String sql = "select * from userposjava1";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			Userposjava1 userposjava1 = new Userposjava1();
			userposjava1.setId(result.getLong("id"));
			userposjava1.setName(result.getString("name"));
			userposjava1.setEmail(result.getString("email"));

			listas.add(userposjava1);
		}

		return listas;
	}

	// Search
	public Userposjava1 search(Long id) throws Exception {

		Userposjava1 returns = new  Userposjava1();

		String sql = "select * from userposjava1 where id = " + id;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) { // return one or none
			//Userposjava1 userposjava1 = new Userposjava1();
			returns.setId(result.getLong("id"));
			returns.setName(result.getString("name"));
			returns.setEmail(result.getString("email"));

	
		}

		return returns;
	}

}
