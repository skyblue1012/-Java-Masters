package web.http.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.http.model.User;
import web.http.model.UserDAOImpl;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
       
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
		String path="login_fail.jsp";
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		User user = UserDAOImpl.getInstance().login(id, pass);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			path="login_success.jsp";
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
