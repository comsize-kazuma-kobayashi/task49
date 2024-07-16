package model.entity;

//登録画面中、ステータス情報のプルダウンで使用する情報を格納するクラス
public class StatusOptionBean {
	
	//ステータスコード
	private String statusCode;
	//ステータス名
	private String statusName;
	

	//フィールドの変数に対して、値を返し、値を設定する。
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	

}
