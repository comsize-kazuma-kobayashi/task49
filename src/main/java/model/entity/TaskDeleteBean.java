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
	
	//ユーザー名
	private String userName;
	
	//ステータス名
	private String statusName;
	
	//メモ
	private String memo;
	
	
	/**
	 * フィールドtaskIdの値を返す
	 * @return taskId
	 */
	public int getTaskId() {
		return taskId;
	}
	
	/**
	 * フィールドtaskIdに値を設定
	 * @param taskId
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * フィールドtaskNameの値を返す
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * フィールドtaskNameに値を設定
	 * @param taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	/**
	 * フィールドCategoryNameの値を返す
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 *  フィールドcategoryNameに値を設定
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	/**
	 * フィールドlimitDateの値を返す
	 * @return limitDate
	 */
	public Date getLimitDate() {
		return limitDate;
	}
	
	/**
	 * フィールドlimitDateに値を設定
	 * @param limitDate
	 */
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}
	
	
	/**
	 * フィールドuserNameの値を返す
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * フィールドuserNameに値を設定
	 * @param userName
	 */
	public void setUserId(String userName) {
		this.userName = userName;
	}
	
	/**
	 * フィールドstatusNameの値を返す
	 * @return statusName
	 */
	public String getStatusName() {
		return statusName;
	}
	
	/**
	 * フィールドstatusNameに値を設定
	 * @param statusName
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	/**
	 * フィールドmemoの値を返す
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}
	
	/**
	 * フィールドmemoに値を設定
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
