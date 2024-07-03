package model.entity;

public class UserBean {
	
	//ユーザID
	private String userId;
	
	//パスワード
	private String password;
	
	//ユーザネーム
	private String userName;

	
	/**
	 * フィールドuserIdの値を返す
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * フィールドuserIdに値を設定
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * フィールドpasswordの値を返す
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * フィールドpasswordに値を設定
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * フィールドuserIdの値を取得
	 * @return ユーザネーム
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
