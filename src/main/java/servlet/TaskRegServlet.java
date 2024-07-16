package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

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
 * Servlet implementation class TaskAddServlet
 */
@WebServlet("/TaskRegServlet")
public class TaskRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// DAOの生成
		TaskRegDAO dao = new TaskRegDAO();
		// 登録情報を格納するBean
		int num = 0; // TaskRegDAOでreturnされたnumと同じではないけれど揃える

		// セッションオブジェクトを生成(session空間に接続する。という宣言)
		HttpSession session = request.getSession();
		// 	sessionにあるユーザInfoを取得
		UserBean userInfo = (UserBean) session.getAttribute("userInfo");

		// 登録情報それぞれ、リクエスパラメータを取得
		String taskName = request.getParameter("task_name");
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		Date limitDate = Date.valueOf(request.getParameter("limit_date"));
		String userId = userInfo.getUserId(); //ログイン情報から、これより上でgetSessionして取得（ユーザIDだけはリクエストからではない）
		String statusCode = request.getParameter("status_code");
		String memo = request.getParameter("memo");

		// sql文を実行する
		try {
			num = dao.registration(taskName, categoryId, limitDate, userId, statusCode, memo); //インサート文のあるメソッドに入力された値を引数として渡す
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 登録が完了した場合と失敗した場合で、遷移先と処理を変更する
		String url = "";

		if (num != 0) {

			TaskRegBean bean = new TaskRegBean();
			bean.setTaskName(taskName);
			bean.setCategoryid(categoryId);
			bean.setDate(limitDate);
			bean.setUserId(userId);
			bean.setStatusCode(statusCode);
			bean.setMemo(memo);

			// 登録完了画面へ遷移し、登録情報を表示する。セッションスコープへ登録内容を設定 (左はSessionにあげるときの属性、右はbeanにつける名前)
			session.setAttribute("taskInfo", bean);
			url = "task-register-success.jsp";

			//			// 登録完了情報で、カテゴリIDに対してカテゴリ名を返す
			//			String categoryName = request.getParameter("category_name");
			//			
			//			CategoryOptionBean optionBean = new CategoryOptionBean();
			//			optionBean.setCategoryName(categoryName);

		} else {
			// 登録失敗画面へ遷移
			url = "task-register-failure.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		
//		request.setCharacterEncoding("UTF-8");
//	
//		// DAOの生成
//		TaskRegDAO conversionDao = new TaskRegDAO();
//		
//		// 変換する情報(カテゴリ、ステータス)を格納するBean
//		int conversionInfo = 0;
//		
//		// セッションオブジェクトを生成(session空間に接続する。という宣言)
//		HttpSession session = request.getSession();
//
//		// 変換する情報それぞれ、リクエスパラメータを取得
//		String categoryName = request.getParameter("category_name");
//		String statusName = request.getParameter("status_name");
//		
//		// sql文を実行する
//		try {
//			conversionInfo = conversionDao.conversion(categoryName); //SELECT文のあるメソッドに入力された値を引数として渡す
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//			// 変換する情報をBeanに格納する
//			TaskRegBean bean = new TaskRegBean();
//			bean.setCategoryName(CategoryName);
//			bean.setStatusName(statusName);
//
//			// 登録完了画面へ再度遷移し、カテゴリ名、ステータス名が変換された登録情報を表示する。
//			// セッションスコープへ登録内容を設定 (左はSessionにあげるときの属性、右はbeanにつける名前)
//			
//			session.setAttribute("taskInfoConversion", bean);
//			
//			// 登録完了情報で、カテゴリIDに対してカテゴリ名を返す
//			String categoryName = request.getParameter("category_name");
//			
//			CategoryOptionBean optionBean = new CategoryOptionBean();
//			optionBean.setCategoryName(categoryName);
//			
//		}
//
//		RequestDispatcher rd = request.getRequestDispatcher("task-register-success.jsp");
//		rd.forward(request, response);
//
//	}		
//		
//	}
//	
//
//	
//}
//
////	if (request.getParameter("limit_date") == null) {　//必須ではない項目の話
