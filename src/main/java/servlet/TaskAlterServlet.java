package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ItemCategoryDAO;
import model.entity.ItemCategoryBean;

/**
 * Servlet implementation class ItemAlterServlet
 */
@WebServlet("/ItemAlterServlet")
public class TaskAlterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 使用するクラスのインスタンス化
		ItemCategoryDAO dao = new ItemCategoryDAO();
		ItemCategoryBean alterItem = new ItemCategoryBean();

		int processingNumber = 0; //処理件数

		// 変更情報をbeanにセット
		alterItem.setItemCode(Integer.parseInt(request.getParameter("item_code")));
		alterItem.setItemName(request.getParameter("item_name"));
		alterItem.setCategoryName(request.getParameter("category_name"));
		alterItem.setCategoryCode(Integer.parseInt(request.getParameter("category_code")));
		alterItem.setPrice(Integer.parseInt(request.getParameter("price")));

		try {
			processingNumber = dao.updateItem(alterItem);//変更処理

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 変更情報をリクエストスコープに設定
		request.setAttribute("alterItem", alterItem);
		// 処理件数をリクエストスコープに設定
		request.setAttribute("processingNumber", processingNumber);
		// セッション情報を削除
		session.removeAttribute("itemDetail");
		// 変更結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("item-alter-result.jsp");
		rd.forward(request, response);
	}
}
