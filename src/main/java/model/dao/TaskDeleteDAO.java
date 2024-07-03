package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskDeleteBean;

public class TaskDeleteDAO {

	public int deleteTask(int taskId) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM t_task WHERE task_id = ?";
		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
	
	public TaskDeleteBean selectTask(int taskId) throws SQLException, ClassNotFoundException {

		String sql = "SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,t4.user_name,t3.status_name, t1.memo FROM t_task t1 JOIN m_category t2 ON t1.category_id = t2.category_id JOIN m_status t3 ON t1.status_code = t3.status_code JOIN m_user t4 ON t1.user_id = t4.user_id WHERE t1.task_id = ?";
		
		TaskDeleteBean taskDelete = new TaskDeleteBean();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				taskDelete.setTaskId(res.getInt("task_id"));
				taskDelete.setTaskName(res.getString("task_name"));
				taskDelete.setCategoryName(res.getString("category_name"));
				taskDelete.setLimitDate(res.getDate("limit_date"));
				taskDelete.setUserId(res.getString("user_name"));
				taskDelete.setStatusName(res.getString("status_name"));
				taskDelete.setMemo(res.getString("memo"));
			}
		}
		return taskDelete;
	}
	
	
	
}

