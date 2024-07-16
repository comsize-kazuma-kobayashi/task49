package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryOptionBean;
import model.entity.StatusOptionBean;

/**
 * タスク登録用データを取得するクラス
 * @author 小林
 */
public class CreateCategoryOptionDAO {

	/**
	 * タスク登録用カテゴリ情報を取得するメソッド
	 * @return CategoryOptionBean型ArrayList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CategoryOptionBean> categoryOption()
			throws SQLException, ClassNotFoundException {

		//取得したカテゴリ情報を格納するクラスをインスタンス化
		List<CategoryOptionBean> categoryOptionList = new ArrayList<CategoryOptionBean>();

		//カテゴリ情報を取得するSELECT文
		String categorySql = "SELECT category_id, category_name FROM m_category";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();) {

			ResultSet categoryRes = stmt.executeQuery(categorySql);

			//nextメソッドで全カテゴリ情報を格納
			while (categoryRes.next()) {
				int categoryId = categoryRes.getInt("category_id");
				String categoryName = categoryRes.getString("category_name");

				CategoryOptionBean categoryOption = new CategoryOptionBean();
				categoryOption.setCategoryId(categoryId);
				categoryOption.setCategoryName(categoryName);

				categoryOptionList.add(categoryOption);
			}

			return categoryOptionList;

		}
	}

	/**
	 * タスク登録用カテゴリ情報を取得するメソッド
	 * @return StatusOptionBean型ArrayList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<StatusOptionBean> statusOption()
			throws SQLException, ClassNotFoundException {

		//取得したステータス情報を格納するクラスをインスタンス化
		List<StatusOptionBean> statusOptionList = new ArrayList<StatusOptionBean>();

		//ステータス情報を取得するSELECT文
		String statusSql = "SELECT status_code, status_name FROM m_status";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();) {

			ResultSet statusRes = stmt.executeQuery(statusSql);

			//nextメソッドで全ステータス情報を格納
			while (statusRes.next()) {
				String statusCode = statusRes.getString("status_code");
				String statusName = statusRes.getString("status_name");

				StatusOptionBean statusOption = new StatusOptionBean();
				statusOption.setStatusCode(statusCode);
				statusOption.setStatusName(statusName);

				statusOptionList.add(statusOption);
			}

			return statusOptionList;

		}
	}

}
