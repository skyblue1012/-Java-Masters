package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.TodoItem;
import web.servlet.model.TodoItemDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

/* 로그인 */

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "";
		
		try {
			User rvo = UserDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			
			if(rvo != null) {
				session.setAttribute("user", rvo);
				ArrayList<TodoItem> todos = TodoItemDAOImpl.getInstance().showAll();
				request.setAttribute("todos", todos);
				path = "mainView.jsp";
			}
			
		}catch (Exception e) {
			System.out.println("login dopost err : " + e);
			path = "errorPage.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}
}
