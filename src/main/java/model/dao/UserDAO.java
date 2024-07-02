package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
	public UserBean login(String userId, String password) throws SQLException, ClassNotFoundException {
		// SQL文
		String sql = "SELECT * FROM m_user WHERE user_id = ? and password = ?;";
		// ユーザの情報を格納するBeanを生成する
		UserBean bean = new UserBean();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				bean.setUserName(res.getString("user_name"));
				return bean;
			}
			return null;
		}
	}

}
