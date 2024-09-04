package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.TodoItem;
import web.servlet.model.TodoItemDAOImpl;


@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		
		try {
			ArrayList<TodoItem> todos = TodoItemDAOImpl.getInstance().showAll();
			request.setAttribute("todos", todos);
			path = "mainView.jsp";
			
		}catch (Exception e) {
			System.out.println("login dopost err : " + e);
			path = "errorPage.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}
