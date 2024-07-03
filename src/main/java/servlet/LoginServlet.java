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

/**
 * ユーザIDとパスワードでログインを承認し、ユーザ名を返す
 *@author 小林 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//DAOをインスタンス化
		UserDAO dao = new UserDAO();

		//ユーザ情報を格納するクラスを宣言
		UserBean bean = null;

		//IDとパスワードをリクエストから取得
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");

		try {
			//ログイン承認をするメソッドにIDとパスワードを渡す
			bean = dao.login(userId, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "";

		//ログインに成功すればメニュー画面へ
		if (bean != null) {

			//セッションにユーザ情報を格納
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", bean);
			url = "menu.jsp";

			//ログインに失敗したら失敗画面へ
		} else {
			url = "login-failure.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
