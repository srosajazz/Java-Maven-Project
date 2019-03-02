package project_java_jdbc.project_java_jdbc;



import org.junit.Test;

import UserPosDAO.UserPosDAO;
import model.Userposjava1;

public class TestdbJdbc {

	@Test
	public void initdb() {

		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava1 userposjava1 = new Userposjava1();
		
		userposjava1.setId(6L);
		userposjava1.setName("Joe test");
		userposjava1.setEmail("test.outlook.com");
		
		userPosDAO.save(userposjava1);
	}
}
