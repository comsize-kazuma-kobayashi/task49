package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskAlterDAO;
import model.entity.TaskAlterBean;

/**
 * 編集結果表示を行うコントロールクラス
 * @author 青木雪絵
 * Servlet implementation class ItemAlterServlet
 */
@WebServlet("/TaskAlterServlet")
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
		TaskAlterDAO dao = new TaskAlterDAO();
		TaskAlterBean updateTask = new TaskAlterBean();

		int processingNumber = 0; //処理件数

		String url = "";

		String str = request.getParameter("limit_date");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		Date date = null;
		date = java.sql.Date.valueOf(str);

		Object obj = session.getAttribute("userId");

		String strg = obj.toString();

		// 編集情報をbeanにセット
		updateTask.setTaskName(request.getParameter("task_name"));
		updateTask.setCategoryId((Integer) session.getAttribute("categoryId"));
		updateTask.setCategoryName(request.getParameter("category_name"));
		updateTask.setLimitDate(date);
		updateTask.setUserId(strg);
		updateTask.setUserName(request.getParameter("user_name"));
		updateTask.setStatusCode((String) session.getAttribute("status_code"));
		updateTask.setStatusName(request.getParameter("status_name"));
		updateTask.setMemo(request.getParameter("memo"));
		updateTask.setTaskId(Integer.parseInt(request.getParameter("task_id")));

		
		try {
			processingNumber = dao.updateTask(updateTask);//編集処理

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (processingNumber > 0) {

			//編集結果画面に遷移
			url = "task-alter-result.jsp";

			//編集失敗画面へ遷移
		} else {
			url = "update-failure.jsp";
		}

		// 編集情報をリクエストスコープに設定
		request.setAttribute("updateTask", updateTask);

		// 処理件数をリクエストスコープに設定
		request.setAttribute("processingNumber", processingNumber);
		// 編集結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
