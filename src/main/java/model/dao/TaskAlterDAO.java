package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskAlterBean;

/**
 * タスク編集機能のDAOクラス
 * @author 青木雪絵
 */
public class TaskAlterDAO {

	/**
	 * 選択されたタスク情報を検索し返すメソッド
	 * @param taskId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TaskAlterBean selectTask(int taskId) throws SQLException, ClassNotFoundException {

		String sql = "SELECT t1.task_name, t1.task_id, t1.category_id, t3.category_name, t1.limit_date, t1.user_id, t2.user_name, t1.status_code, t4.status_name, t1.memo FROM t_task t1 JOIN m_user t2 ON t1.user_id = t2.user_id JOIN m_category t3 ON t1.category_id = t3.category_id JOIN m_status t4 ON t1.status_code = t4.status_code WHERE task_id = ?";

		TaskAlterBean taskDetail = new TaskAlterBean();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			// 
			while (res.next()) {
				taskDetail.setTaskName(res.getString("task_name"));
				taskDetail.setLimitDate(res.getDate("limit_date"));
				taskDetail.setUserName(res.getString("user_name"));
				taskDetail.setMemo(res.getString("memo"));
				taskDetail.setUserId(res.getString("user_id"));
				taskDetail.setCategoryId(res.getInt("category_id"));
				taskDetail.setCategoryName(res.getString("category_name"));
				taskDetail.setStatusName(res.getString("status_name"));
				taskDetail.setStatusCode(res.getString("status_code"));

			}
		}
		return taskDetail;
	}

	/**
	 * プルダウン用のカテゴリー情報を返すメソッド
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<TaskAlterBean> selectCategory() throws SQLException, ClassNotFoundException {

		List<TaskAlterBean> categoryList = new ArrayList<TaskAlterBean>();
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_category")) {
			// 結果の操作
			while (res.next()) {
				int categoryId = res.getInt("category_id");
				String categoryName = res.getString("category_name");

				TaskAlterBean categoryAlter = new TaskAlterBean();
				categoryAlter.setCategoryId(categoryId);
				categoryAlter.setCategoryName(categoryName);
				categoryList.add(categoryAlter);
			}
		}
		return categoryList;
	}

	/**
	 * プルダウン用のステータス情報を返すメソッド
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<TaskAlterBean> selectStatus() throws SQLException, ClassNotFoundException {

		List<TaskAlterBean> statusList = new ArrayList<TaskAlterBean>();
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_status")) {
			// 結果の操作
			while (res.next()) {
				String statusCode = res.getString("status_code");
				String statusName = res.getString("status_name");

				TaskAlterBean statusAlter = new TaskAlterBean();
				statusAlter.setStatusCode(statusCode);
				statusAlter.setStatusName(statusName);
				statusList.add(statusAlter);
			}
		}
		return statusList;
	}

	/**
	 * プルダウン用の担当者情報を返すメソッド
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<TaskAlterBean> selectUser() throws SQLException, ClassNotFoundException {

		List<TaskAlterBean> userList = new ArrayList<TaskAlterBean>();
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_user")) {
			// 結果の操作
			while (res.next()) {
				String userId = res.getString("user_id");
				String userName = res.getString("user_name");
				TaskAlterBean userAlter = new TaskAlterBean();
				userAlter.setUserId(userId);
				userAlter.setUserName(userName);
				userList.add(userAlter);
			}
		}
		return userList;
	}

	/**
	 * 打ち込まれた・選択されたタスク情報を、編集するメソッド
	 * @param taskResult
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateTask(TaskAlterBean taskResult)
			throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, user_id = ?, status_code = ?, memo = ? WHERE task_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setString(1, taskResult.getTaskName());
			pstmt.setInt(2, taskResult.getCategoryId());
			pstmt.setDate(3, taskResult.getLimitDate());
			pstmt.setString(4, taskResult.getUserId());
			pstmt.setString(5, taskResult.getStatusCode());
			pstmt.setString(6, taskResult.getMemo());
			pstmt.setInt(7, taskResult.getTaskId());
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}
