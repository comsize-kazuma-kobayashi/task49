package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskDeleteDAO;

/**
 * タスク削除を行うコントロールクラス
 * @author 江村
 */
@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		//TaskDeleteDAOをインスタンス化
		TaskDeleteDAO dao = new TaskDeleteDAO();
		
		int processingNumber = 0; //処理件数
		try {
			// 削除処理
			processingNumber = dao.deleteTask(Integer.parseInt(request.getParameter("task_id")));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "";
		if (processingNumber > 0) {
			
			// 削除結果画面に遷移
			url = "task-delete-result.jsp";
		
		//削除失敗画面へ遷移
		}else{
			url = "task-delete-failure.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
