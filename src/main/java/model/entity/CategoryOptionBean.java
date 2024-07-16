package model.entity;

//登録画面中、カテゴリ情報プルダウンで使用する情報を格納するクラス
public class CategoryOptionBean {

	//カテゴリコード
	private int categoryId;
	//カテゴリ名
	private String categoryName;
	
	//フィールドの変数に対して、値を返し、値を設定する。
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
