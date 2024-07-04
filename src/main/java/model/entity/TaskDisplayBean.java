package model.entity;

import java.sql.Date;


/**
 * 一覧表示機能に表示するフィールドの値を受け渡すBean
 * @author 古川真己
 */
public class TaskDisplayBean {

	/**
	 * タスクID
	 */
	private int taskId;
	
	/**
	 * タスク名
	 */
	private String taskName;
	
	/**
	 * カテゴリ名
	 */
	private String categoryName;
	
	/**
	 * 期限
	 */
	private Date limitDate;
	
	/**
	 * ユーザ名
	 */
	private String userName;
	
	/**
	 * ステータス名
	 */
	private String statusName;
	
	/**
	 * メモ
	 */
	private String memo;
	
	/**
	 * フィールドtaskNameの値を返す
	 * @return タスク名
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * フィールドtaskNameの値を設定
	 * @param taskName タスク名
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * フィールドcategoryNameの値を返す
	 * @return カテゴリ名
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * フィールドcategoryNameの値を設定
	 * @param categoryName カテゴリ名
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * フィールドuserNameの値を返す
	 * @return ユーザ名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * フィールドuserNameの値を設定
	 * @param userName ユーザ名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * フィールドstatusNameの値を返す
	 * @return ステータス名
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * フィールドstatusNameの値を設定
	 * @param　statusName ステータス名
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * フィールドmemoの値を返す
	 * @return　メモ
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * フィールドmemoの値を設定
	 * @param memo メモ
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * フィールドlimitDateの値を返す
	 * @return 期限　
	 */
	public Date getLimitDate() {
		return limitDate;
	}

	/**
	 * フィールドlimitDateの値を設定
	 * @param limitDate
	 */
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * フィールドtaskIdの値を返す
	 * @return タスクID
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * フィールドtaskIdの値を設定
	 * @param taskId タスク名
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
}
