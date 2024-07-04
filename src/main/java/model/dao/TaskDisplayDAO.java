package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskDisplayBean;

/**
 * 一覧表示機能のDAO
 * @author 古川真己
 */
public class TaskDisplayDAO {
	
	/**
	 * 一覧機能に表示するフィールドの値をリストに格納し返すメソッド
	 * @return 一覧表示機能用のリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<TaskDisplayBean> selectDisplay()
			throws SQLException, ClassNotFoundException {
	
	//一覧機能に表示するフィールドの値を格納するリスト
	List<TaskDisplayBean> taskDisplayList = new ArrayList<TaskDisplayBean>();
	
	//一覧表示画面に表示するフィールドの値を取得するSQL文
	String sql 
	= "SELECT t1.task_id,t1.task_name, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo FROM t_task t1 LEFT OUTER JOIN m_category t2 ON t1.category_id = t2.category_id LEFT OUTER JOIN m_user t3 ON t1.user_id = t3.user_id LEFT OUTER JOIN m_status t4 ON t1.status_code = t4.status_code ORDER BY task_id;";
	
	//データベースに接続し、一覧表示画面に表示するフィールドの値を取得するSQL文を実行
	try (Connection con = ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql)) {

		while (res.next()) {
			//一覧表示画面に表示するフィールドの値を取得
			int taskId = res.getInt("task_id");
			String taskName = res.getString("task_name");
			String categoryName = res.getString("category_name");
			Date limitDate = (Date) res.getDate("limit_date");
			String userName = res.getString("user_name");
			String statusName = res.getString("status_name");
			String memo = res.getString("memo");
			
			//一覧表示画面に表示するフィールドの値をBeanのフィールドに設定
			TaskDisplayBean task = new TaskDisplayBean();
			task.setTaskId(taskId);
			task.setTaskName(taskName);
			task.setCategoryName(categoryName);
			task.setLimitDate(limitDate);
			task.setUserName(userName);
			task.setStatusName(statusName);
			task.setMemo(memo);

			//一覧表示画面に表示するフィールドの値をリストに格納
			taskDisplayList.add(task);
		}
	}
	return taskDisplayList;
	
	}
	
}
