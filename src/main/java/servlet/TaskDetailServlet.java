package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ItemCategoryDAO;
import model.entity.CategoryBean;
import model.entity.ItemCategoryBean;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/ItemDetailServlet")
public class TaskDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		ItemCategoryDAO dao = new ItemCategoryDAO();
		ItemCategoryBean itemDetail = null;
		List<CategoryBean> categoryList = null;

		// 選択した商品の商品コード取得
		int itemCode = Integer.parseInt(request.getParameter("item_code"));

		try {
			itemDetail = dao.selectItem(itemCode);//商品詳細取得
			categoryList = dao.selectCategory();//プルダウン用の商品カテゴリ取得
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 商品の詳細情報をセッションに設定
		session.setAttribute("itemDetail", itemDetail);
		// プルダウン用の商品カテゴリをセッションに設定
		session.setAttribute("categoryList", categoryList);
		// 商品詳細画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("item-detail.jsp");
		rd.forward(request, response);
	}
}
