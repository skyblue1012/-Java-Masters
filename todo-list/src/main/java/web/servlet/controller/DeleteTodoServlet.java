package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.TodoItemDAOImpl;

@WebServlet("/DeleteTodo")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		System.out.println("idStr : " + idStr);
		
		try {
			int id = Integer.parseInt(idStr);
			TodoItemDAOImpl.getInstance().deleteTodoItem(id);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		response.sendRedirect("Main");
	}

}
