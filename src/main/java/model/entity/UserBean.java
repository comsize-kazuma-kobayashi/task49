package model.entity;

/**
 * ユーザ情報を格納するクラス
 * @author 小林
 */
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
	 * @return ユーザ名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * フィールドpasswordに値を設定
	 * @param userName ユーザ名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
