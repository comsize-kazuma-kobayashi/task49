package servlet;

import java.io.IOException;
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

import model.dao.TaskDisplayDAO;
import model.entity.TaskDisplayBean;


/**
 *　一覧表示画面に表示するフィールドの値をリストで渡し、一覧表示画面に遷移
 *　@author 古川真己 
 */
@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//一覧表示画面に表示するフィールドの値を渡すためのリストを生成
		List<TaskDisplayBean> taskDisplayList = new ArrayList<TaskDisplayBean>();
		
		//一覧表示機能用のDAOをインスタンス化
		TaskDisplayDAO dao = new TaskDisplayDAO();

		try {
			//一覧表示画面に表示するフィールドの値をリストに格納
			taskDisplayList = dao.selectDisplay();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		//セッションに取得したリストを格納
		HttpSession session = request.getSession();
		session.setAttribute("taskDisplayList", taskDisplayList);

		//一覧表示画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("task-list.jsp");
		rd.forward(request, response);
		
	}

}
