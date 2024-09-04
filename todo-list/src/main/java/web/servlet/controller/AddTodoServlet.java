package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.TodoItem;
import web.servlet.model.TodoItemDAO;
import web.servlet.model.TodoItemDAOImpl;

@WebServlet("/AddTodo")
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		TodoItem todo = new TodoItem(0, title);
		
		try {
			TodoItemDAOImpl.getInstance().addTodoItem(todo);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		response.sendRedirect("Main");
	}

}
