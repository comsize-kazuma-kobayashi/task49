package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CreateCategoryOptionDAO;
import model.entity.CategoryOptionBean;
import model.entity.StatusOptionBean;

/**
 * タスク登録に必要なデータを取得し、タスク登録画面に遷移させる
 * @author 小林
 */
@WebServlet("/TaskRegOptionServlet")
public class TaskRegOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAOをインスタンス化
		CreateCategoryOptionDAO optionDao = new CreateCategoryOptionDAO();

		//プルダウン取得用ArrayListを宣言
		List<CategoryOptionBean> categoryOptionList = null;
		List<StatusOptionBean> statusOptionList = null;
		
		try {
			//プルダウン取得
			categoryOptionList = optionDao.categoryOption();
			statusOptionList = optionDao.statusOption();
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//セッション呼び出し
		HttpSession session = request.getSession();  
		
		//セッションにプルダウン情報を格納
		session.setAttribute("categoryOptionList", categoryOptionList);
		session.setAttribute("statusOptionList", statusOptionList);
		
		//タスク登録画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("task-register.jsp");
		rd.forward(request, response);
	}

}
