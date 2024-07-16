package model.entity;

/**
 * プルダウンを生成する際に必要なカテゴリリストを格納するクラス
 * @author 小林
 */
public class CategoryOptionBean {

	//カテゴリID
	private int categoryId;
	//カテゴリ名
	private String categoryName;

	/**
	 * フィールドcategoryIdの値を返す
	 * @return カテゴリーID
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * フィールドcategoryIdに値を設定
	 * @param カテゴリーID
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * フィールドcategoryNameの値を返す
	 * @return カテゴリー名
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * フィールドcategoryNameの値を設定
	 * @param カテゴリー名
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
