package model.entity;

import java.sql.Date;

/**
 * タスクを削除するための情報を保持するクラス
 * @author 江村
 */
public class TaskDeleteBean {

	//タスクID
	private int taskId;
	
	//タスク名
	private String taskName;
	
	//カテゴリ名
	private String categoryName;
	
	//期限
	private Date limitDate;
	
	//ユーザーID
	private  String userId;
	
	//ユーザー名
	private String userName;
	
	//ステータス名
	private String statusName;
	
	//メモ
	private String memo;

	/**
	 * @return taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId セットする taskId
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName セットする taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName セットする categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return limitDate
	 */
	public Date getLimitDate() {
		return limitDate;
	}

	/**
	 * @param limitDate セットする limitDate
	 */
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName セットする statusName
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo セットする memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
