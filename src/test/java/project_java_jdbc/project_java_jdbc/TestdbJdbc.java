package project_java_jdbc.project_java_jdbc;



import org.junit.Test;

import jdbcconection.SingleConnection;

public class TestdbJdbc {

	@Test
	public void initdb() {

		SingleConnection.getConnection();
	}
}
