package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskRegDAO;
import model.entity.TaskRegBean;
import model.entity.UserBean;

/**
 * タスク登録に必要なデータ(プルダウンのカテゴリ情報、ステータス情報以外)を取得し、
 * タスク登録完了画面に遷移させる
 * @author 行實
 */
@WebServlet("/TaskRegServlet")
public class TaskRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 登録が完了した場合と失敗した場合で、遷移先と処理を変更する
		String url = "";

		// 最大文字数制限を設定して分岐する
		Date limitDate;
		if (!request.getParameter("limit_date").isEmpty()) {
			limitDate = Date.valueOf(request.getParameter("limit_date"));
		} else {
			limitDate = null;
		}
		int maxlength = 100;

		// セッション呼び出し(セッション空間に接続する)
		HttpSession session = request.getSession();

		// セッションにあるuserInfoを取得
		UserBean userInfo = (UserBean) session.getAttribute("userInfo");

		// 登録情報それぞれ、リクエスパラメータを取得
		String taskName = request.getParameter("task_name");
		int categoryId = Integer.parseInt(request.getParameter("category_id"));

		String userId = userInfo.getUserId(); //ログイン情報から、これより上でgetSessionして取得（ユーザIDだけはリクエストからではない）
		String statusCode = request.getParameter("status_code");
		String memo = request.getParameter("memo");

		// 現在の日付を取得
		Date today = Date.valueOf(LocalDate.now());

		if (memo.length() > maxlength || (limitDate!= null&&limitDate.before(today))) {
			// 文字数制限を超えている場合 または、タスク期限が当日より前の場合、
			// 登録失敗画面へ転送
			url = "task-register-failure.jsp";

		} else {
			// 文字数制限内の場合の処理

			// DAOをインスタンス化
			TaskRegDAO dao = new TaskRegDAO();

			// 登録情報を格納するBean
			int num = 0;

			TaskRegBean bean = new TaskRegBean();
			bean.setTaskName(taskName);
			bean.setCategoryid(categoryId);
			bean.setDate(limitDate);
			bean.setUserId(userId);
			bean.setStatusCode(statusCode);
			bean.setMemo(memo);

			// sql文を実行する
			try {
				num = dao.registration(bean); //インサート文のあるメソッドに入力された値を引数として渡す
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			if (num != 0) {

				//			TaskRegBean bean = new TaskRegBean();
				//			bean.setTaskName(taskName);
				//			bean.setCategoryid(categoryId);
				//			bean.setDate(limitDate);
				//			bean.setUserId(userId);
				//			bean.setStatusCode(statusCode);
				//			bean.setMemo(memo);

				// 登録完了画面へ遷移し、登録情報を表示する。セッションスコープへ登録内容を設定 (左はSessionにあげるときの属性、右はbeanにつける名前)
				session.setAttribute("taskInfo", bean);
				url = "task-register-success.jsp";

			} else {
				// 登録失敗画面へ転送
				url = "task-register-failure.jsp";
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}