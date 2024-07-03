package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

/**
 * ユーザIDとパスワードを照合するクラス
 * @author 小林
 */
public class UserDAO {
	
	/**
	 * ユーザIDとパスワードを元にログイン認証しユーザ情報を返すメソッド
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return bean UserBean型のユーザ情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public UserBean login(String userId, String password) throws SQLException, ClassNotFoundException {

		//ユーザIDとパスワードを検索するSELECT文
		String sql = "SELECT * FROM m_user WHERE user_id = ? and password = ?;";

		//ユーザ情報を格納するクラスをインスタンス化
		UserBean bean = new UserBean();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			//WHERE句に取得したユーザIDとパスワードをセット
			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();
			
			//ログインに成功した場合、ユーザ情報を返す
			if (res.next()) {
				bean.setUserId(res.getString("user_id"));
				bean.setUserName(res.getString("user_name"));
				return bean;
			}
			//ログインに失敗した場合、nullを返す
			return null;
		}
	}

}
