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
 * Servlet implementation class TaskRegOptionServlet
 */
@WebServlet("/TaskRegOptionServlet")
public class TaskRegOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DAOを生成
		CreateCategoryOptionDAO optionDao = new CreateCategoryOptionDAO();

		List<CategoryOptionBean> categoryOptionList = null;
		List<StatusOptionBean> statusOptionList = null;
		
		try {
			categoryOptionList = optionDao.categoryOption();
			statusOptionList = optionDao.statusOption();
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//セッション呼び出し
		HttpSession session = request.getSession();  
		
		// リクエストスコープへの属性の設定
		session.setAttribute("categoryOptionList", categoryOptionList);
		session.setAttribute("statusOptionList", statusOptionList);
		
		// 商品登録画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("task-register.jsp");
		rd.forward(request, response);
	}

}
