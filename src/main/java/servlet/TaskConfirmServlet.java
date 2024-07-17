package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.TaskAlterBean;

/**
 * 編集確認表示を行うコントロールクラス
 * @author 青木雪絵
 * Servlet implementation class TaskConfirmServlet
 */
@WebServlet("/TaskConfirmServlet")
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
		TaskAlterBean taskAlter = new TaskAlterBean();

		// 選択されたカテゴリとコードを取得し、カンマ区切りで配列に分割
		String[] selectCategory = request.getParameter("select_category").split(",");
		String[] selectStatus = request.getParameter("select_status").split(",");
		String[] selectUser = request.getParameter("select_user").split(",");

		//期限を取得
		String str = request.getParameter("limit_date");
//		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		Date date = null;
		date = java.sql.Date.valueOf(str);

		// 編集情報をbeanにセット
		taskAlter.setCategoryName(selectCategory[1]);
		taskAlter.setStatusName(selectStatus[1]);
		taskAlter.setTaskName(request.getParameter("task_name"));
		taskAlter.setLimitDate(date);
		taskAlter.setUserName(selectUser[1]);
		taskAlter.setMemo(request.getParameter("memo"));
	

		int categoryId = Integer.parseInt(selectCategory[0]);
		String statusCode = selectStatus[0];
		String userId = selectUser[0];

		// リクエストスコープにbeanの情報を設定
		request.setAttribute("taskAlter", taskAlter);
		HttpSession session = request.getSession();
		
		// プルダウン用の情報をセッションに設定
		session.setAttribute("categoryId", categoryId);
		session.setAttribute("statusCode", statusCode);
		session.setAttribute("userId", userId);

		// 編集情報確認画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("task-alter-confirm.jsp");
		rd.forward(request, response);
	}
}
