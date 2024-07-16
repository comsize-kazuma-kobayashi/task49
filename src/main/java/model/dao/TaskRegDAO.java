package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRegDAO {
	//追加した登録情報を返すメソッド
	public int registration(String taskName, int categoryId, Date limitDate, String userId, String statusCode, String memo) 
			throws SQLException, ClassNotFoundException {
		
		//登録情報を追加するINSERT文
		String sql = "INSERT INTO t_task (task_name, category_id, limit_date, user_id, status_code, memo) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) { 
		
			
			//VALUES句で取得する情報をセット			
			pstmt.setString(1, taskName);
			pstmt.setInt(2, categoryId);
			pstmt.setDate(3, limitDate);
			pstmt.setString(4, userId);
			pstmt.setString(5, statusCode);
			pstmt.setString(6, memo);
			
			int num = pstmt.executeUpdate();
				
		return num;
		}
	}
	
	//登録完了した場合、カテゴリIDに対してカテゴリ名を返すメソッド
	public String conversion(int categoryId) 
			throws SQLException, ClassNotFoundException {
		
		//カテゴリIDをKEYにカテゴリ名を取得するSELECT文
		String sql = "SELECT category_name FROM m_category WHERE category_id=?";
		
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) { 
		
			// WHERE句に取得したカテゴリIDをセット
	        pstmt.setInt(1, categoryId);
	     
	        ResultSet resCategory = pstmt.executeQuery();
	            
	        String category = null;
		
	     return category;
		}
	}


	
//	//登録完了情報で、ステータスコードに対しステータス名を返すメソッド
//	public String ConversionStatus() {
//		String status = null;
//		SELECT status_name FROM m_status WHERE status_code=1;
//	return status;
//	}
}
