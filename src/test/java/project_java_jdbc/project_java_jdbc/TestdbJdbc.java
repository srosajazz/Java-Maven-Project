package project_java_jdbc.project_java_jdbc;



import java.util.List;

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
	
	@Test
	public void initList() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava1> list = dao.listar();
			
			for (Userposjava1 userposjava1 : list) {
				System.out.println(userposjava1);
				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	@Test
	public void initSearch() {
		
		UserPosDAO dao  = new UserPosDAO();
		
		try {
			Userposjava1 userposjava1 = dao.search(6L);
			
			System.out.println(userposjava1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
