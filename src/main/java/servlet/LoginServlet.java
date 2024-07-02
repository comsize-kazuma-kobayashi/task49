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

import model.dao.UserDAO;
import model.entity.UserBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAOの生成
		UserDAO dao = new UserDAO();

		// ユーザの情報を格納するBean
		UserBean bean = null;

		// 入力されたユーザIDとパスワードを取得する
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");
		try {
			// 入力されたユーザIDとパスワードでユーザの情報を取得する
			bean = dao.login(userId, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "";// 転送先

		// ログイン認証
		if (bean != null) {

			// セッションオブジェクトを生成
			HttpSession session = request.getSession();
			// セッションスコープへユーザ名を設定
			session.setAttribute("userName", bean.getUserName());
			url = "menu.jsp";
		} else {
			url = "login-failure.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
