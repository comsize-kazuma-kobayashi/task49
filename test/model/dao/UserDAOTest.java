package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.UserBean;

class UserDAOTest {

	UserDAO userDao = new UserDAO();
	UserBean userBean = null;

	@Test
	void test1_login() {
		try {
			userBean = userDao.login("kobayashi", "kazuma");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
		assertEquals("小林一馬", userBean.getUserName());

	}

	@Test
	void test2_login() {

		try {
			userBean = userDao.login("", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertNull(userBean);
	}
}
