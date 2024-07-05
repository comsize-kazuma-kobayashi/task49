package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskDeleteBean;

/**
 * タスク削除機能のDAOクラス
 * @author 江村
 */
public class TaskDeleteDAO {
	
	/**
	 * 選択したタスク情報を検索し返すメソッド
	 * @param taskId タスクID
	 * @return taskDelete タスク情報
	 * @throws SQLException 
	 * @throws ClassNotFoundException
	 */
	public TaskDeleteBean selectTask(int taskId) throws SQLException, ClassNotFoundException {

		//タスク情報を検索するSQL文
		String sql = "SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,t4.user_name,t3.status_name, t1.memo FROM t_task t1 JOIN m_category t2 ON t1.category_id = t2.category_id JOIN m_status t3 ON t1.status_code = t3.status_code JOIN m_user t4 ON t1.user_id = t4.user_id WHERE t1.task_id = ?";
		
		//タスク情報を格納するクラスをインスタンス化
		TaskDeleteBean taskDelete = new TaskDeleteBean();
		
		//データベースに接続し、タスク情報を検索するSQL文を実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			//結果の操作
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
		//タスク情報を返す
		return taskDelete;
	}
	
	
	/**
	 * 選択したタスク情報を削除し、処理件数を返すメソッド
	 * @param taskId タスクID
	 * @return processingNumber 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteTask(int taskId) throws SQLException, ClassNotFoundException {

		//タスク情報を削除するSQL文
		String sql = "DELETE FROM t_task WHERE task_id = ?";
		
		int processingNumber = 0; //処理件数
		
		//データベースに接続し、タスク情報を削除するSQL文を実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);
			processingNumber = pstmt.executeUpdate();
		}
		//処理件数を返す
		return processingNumber;
	}

}

