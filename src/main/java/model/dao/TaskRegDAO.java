package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.TaskRegBean;

/**
 * タスク登録するクラス
 * @author 行實
 */
public class TaskRegDAO {
	
	
	/**
	 * 追加したタスク登録情報を返すメソッド
	 */
	public int registration(TaskRegBean bean) 
			throws SQLException, ClassNotFoundException {
		
		//登録情報を追加するINSERT文
		String sql = "INSERT INTO t_task (task_name, category_id, limit_date, user_id, status_code, memo) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) { 
		
			
			//VALUES句で取得する情報をセット			
			pstmt.setString(1, bean.getTaskName());
			pstmt.setInt(2, bean.getCategoryid());
			pstmt.setDate(3, bean.getLimitDate());
			pstmt.setString(4, bean.getUserId());
			pstmt.setString(5, bean.getStatusCode());
			pstmt.setString(6, bean.getMemo());
			
			int num = pstmt.executeUpdate();
				
		return num;
		}
	}
}
