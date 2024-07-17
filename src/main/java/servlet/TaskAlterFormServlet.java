package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskAlterDAO;
import model.entity.TaskAlterBean;
import model.entity.UserBean;

/**
 * 編集画面に表示する値をリストで渡し、編集画面に遷移するクラス
 * @author 青木雪絵
 */
@WebServlet("/TaskAlterFormServlet")
public class TaskAlterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		TaskAlterDAO dao = new TaskAlterDAO();
		List<TaskAlterBean> categoryList = new ArrayList<TaskAlterBean>();
		List<TaskAlterBean> statusList = new ArrayList<TaskAlterBean>();
		List<TaskAlterBean> userList = new ArrayList<TaskAlterBean>();

		// 選択されたタスク情報の取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		TaskAlterBean taskDetail = null;

		try {
			statusList = dao.selectStatus();//プルダウン用のステータス情報取得
			categoryList = dao.selectCategory();//プルダウン用のカテゴリー情報取得
			userList = dao.selectUser();//プルダウン用のユーザー情報取得
			taskDetail = dao.selectTask(taskId);//選択されたタスク情報を取得
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		TaskAlterBean updateTask = new TaskAlterBean();
		TaskAlterBean taskAlter = new TaskAlterBean();
		UserBean userInfo = (UserBean) session.getAttribute("userInfo");

		// 選択されたタスク情報をセッションに設定
		session.setAttribute("taskId", taskId);

		// タスク情報をセッションに設定
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("statusList", statusList);
		request.setAttribute("userList", userList);
		request.setAttribute("taskDetail", taskDetail);

		String url = "";

		Date str = taskDetail.getLimitDate();

		//ログインしたユーザーIDと選択したタスクのユーザーIDが一致したら確認画面へ遷移
		if (userInfo.getUserId().equals(taskDetail.getUserId())) {

			// 編集画面に遷移
			url = "task-alter-form.jsp";

			//編集失敗画面へ遷移
		} else {
			url = "update-failure.jsp";

			updateTask.setTaskName(taskDetail.getTaskName());
			updateTask.setCategoryId(taskDetail.getCategoryId());
			updateTask.setCategoryName(taskDetail.getCategoryName());
			updateTask.setLimitDate(str);
			updateTask.setUserId(taskDetail.getUserId());
			updateTask.setUserName(taskDetail.getUserName());
			updateTask.setStatusCode(taskDetail.getStatusCode());
			updateTask.setStatusName(taskDetail.getStatusName());
			updateTask.setMemo(taskDetail.getMemo());
			updateTask.setTaskId(taskId);
			
			request.setAttribute("updateTask", updateTask);
		}

		// タスク編集画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
