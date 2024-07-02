package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.ItemCategoryBean;

/**
 * Servlet implementation class ItemConfirmServlet
 */
@WebServlet("/ItemConfirmServlet")
public class TaskConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		// Beanをインスタンス化
		ItemCategoryBean alterItem = new ItemCategoryBean();
		// 選択されたカテゴリとコードを取得し、カンマ区切りで配列に分割
		String[] selectCategory = request.getParameter("select_category").split(",");

		// 変更情報をbeanにセット
		alterItem.setCategoryCode(Integer.parseInt(selectCategory[0]));
		alterItem.setCategoryName(selectCategory[1]);
		alterItem.setItemName(request.getParameter("item_name"));
		alterItem.setPrice(Integer.parseInt(request.getParameter("price")));
		
		// リクエストスコープにbeanの情報を設定
		request.setAttribute("alterItem", alterItem);
		// 変更情報確認画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("item-alter-confirm.jsp");
		rd.forward(request, response);
	}
}
