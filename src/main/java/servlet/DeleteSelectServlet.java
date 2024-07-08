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
import model.entity.UserBean;

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

		//TaskDeleteDAOをインスタンス化
		TaskDeleteDAO dao = new TaskDeleteDAO();
		
		//TaskDeleteBeanの宣言
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
		UserBean userInfo = (UserBean) session.getAttribute("userInfo");
		
		// taskDeleteをセッションに設定
		session.setAttribute("taskDelete", taskDelete);
		
		String url = "";
		
		//ログインしたユーザーIDと選択したタスクのユーザーIDが一致したら確認画面へ遷移
		if(userInfo.getUserId().equals(taskDelete.getUserId())) {
			
			// 確認画面に遷移
			url = "task-delete-confirm.jsp";
		
		//削除失敗画面へ遷移
		}else{
			url = "task-delete-failure.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
