package model.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 登録情報を取得する際に必要なカテゴリリストを格納するクラス
 * @author 行實
 */
public class TaskRegBean implements Serializable {
	
	// タスク名
	private String taskName;
	// カテゴリID	
	private int categoryid;
	// 期限
	private Date limitDate;
	// ユーザID
	private String userId;
	// ステータスコード
	private String statusCode;
	// メモ
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
	 * @param  タスク名
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * フィールドcategoryidの値を返す
	 * @return  カテゴリID
	 */
	public int getCategoryid() {
		return categoryid;
	}

	/**
	 * フィールドcategoryidの値を設定
	 * @param  カテゴリID
	 */
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	/**
	 * フィールドdateの値を返す
	 * @return  期限
	 */
	public Date getLimitDate() {
		return limitDate;
	}

	/**
	 * フィールドdateの値を設定
	 * @param  期限
	 */
	public void setDate(Date date) {
		this.limitDate = date;
	}

	/**
	 * フィールドuserIdの値を返す
	 * @return  ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * フィールドユーザIDの値を設定
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * フィールドstatusCodeの値を返す
	 * @return  ステータスコード
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * フィールドユーザIDの値を設定
	 * @param userId
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * フィールドメモの値を返す
	 * @return  メモ
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * フィールドメモの値を設定
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
