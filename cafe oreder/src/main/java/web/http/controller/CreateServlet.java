package web.http.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.http.model.User;
import web.http.model.UserDAOImpl;


@WebServlet("/Create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CreateServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		
		User user = new User(id, pass, name, mobile);
		UserDAOImpl.getInstance().createAccount(user);
		response.sendRedirect("index.html");
		
		//response.getWriter().write("ok");
		
		
		
	}

}
