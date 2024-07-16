package model.entity;

import java.sql.Date;

/**
 * タスクを編集するための情報を保持するクラス
 * @author 青木雪絵
 */
public class TaskAlterBean {

	private String categoryName;
	private int categoryId;
	private Date LimitDate;
	private int taskId;
	private String taskName;
	private String statusCode;
	private String userId;
	private String userName;
	private String statusName;
	private String memo;

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
	 * @return categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId セットする categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return limitDate
	 */
	public Date getLimitDate() {
		return LimitDate;
	}

	/**
	 * @param limitDate セットする limitDate
	 */
	public void setLimitDate(Date limitDate) {
		LimitDate = limitDate;
	}

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
	 * @return statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode セットする statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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