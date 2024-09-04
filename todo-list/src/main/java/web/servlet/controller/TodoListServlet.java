package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.TodoItem;
import web.servlet.model.TodoItemDAOImpl;


/* 목록조회 */
@WebServlet("/TodoList")
public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TodoItem> list;
		try {
			list = TodoItemDAOImpl.getInstance().showAll();	
			request.setAttribute("list", list);
			
			System.out.println("list : " + list);
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		request.getRequestDispatcher("mainView.jsp").forward(request, response);
	}

	

}
