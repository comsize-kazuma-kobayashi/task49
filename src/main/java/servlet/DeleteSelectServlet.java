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
 * 削除確認表示を行うコントロールクラス
 * @author 江村
 */
@WebServlet("/DeleteSelectServlet")
public class DeleteSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//タスク削除機能のDAOクラスTaskDeleteDAOをインスタンス化
		TaskDeleteDAO dao = new TaskDeleteDAO();
		
		//タスクを削除するための情報を保持するクラスの宣言
		TaskDeleteBean taskDelete = null;

		// 選択したタスクのタスクコードをリクエストから取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));

		try {
			taskDelete = dao.selectTask(taskId);//タスク情報の取得
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		
		// タスク情報をセッションに設定
		session.setAttribute("taskDelete", taskDelete);
		
		// タスク確認画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("task-delete-confirm.jsp");
		rd.forward(request, response);
	}
}
