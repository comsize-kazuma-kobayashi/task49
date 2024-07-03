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

import model.dao.TaskDeleteDAO;
import model.entity.TaskDeleteBean;

/**
 * Servlet implementation class DeleteSelectServlet
 */
@WebServlet("/DeleteSelectServlet")
public class DeleteSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		TaskDeleteDAO dao = new TaskDeleteDAO();
		TaskDeleteBean taskDelete = null;

		// 選択した商品の商品コード取得
		
		int taskId = Integer.parseInt(request.getParameter("taskId"));

		try {
			taskDelete = dao.selectTask(taskId);//商品詳細取得
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 商品の詳細情報をセッションに設定
		session.setAttribute("taskDelete", taskDelete);
		// 商品確認画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("task-delete-confirm.jsp");
		rd.forward(request, response);
	}
}
