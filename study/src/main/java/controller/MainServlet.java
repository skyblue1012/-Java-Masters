package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserImpl;
import vo.User;


@WebServlet("/controller")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
		//landomRecipe,showMyRecipe,deleteRecipe
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
		//signup,login,addRecipe
	}

	protected void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		String path="main.html";
		if(command.equals("signUp")) {
			path = signUp(request,response);
		}else if(command.equals("login")) {
			path = login(request,response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private String signUp(HttpServletRequest request, HttpServletResponse response){
		String path ="login.html";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		
		try {
			UserImpl.getInstance().signUp(id, pass, name, category);
			path ="login.html";
		
		} catch (SQLException e) {
		System.out.println("유저추가 sql에서 에러남");
		System.out.println(e);
		}
		
		
		return path;
		
		}
	private String login(HttpServletRequest request, HttpServletResponse response){
		String path ="login.html";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		User user = new User();
		HttpSession session = request.getSession();
		try {
			user =UserImpl.getInstance().login(id, pass);
			System.out.println(user);
			if(user !=null) {
				session.setAttribute("user", user);	
				System.out.println("LoginServlet JSESSION:"+session.getId());
			path="main.jsp";
			//path ="front.do?command=landomRecipe";
			}
		} catch (SQLException e) {
		System.out.println("로그인 sql에서 에러남");
		System.out.println(e);
		}
		

		return path;
		
		}
	
	
}
