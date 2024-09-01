package web.http.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.http.model.UserDAOImpl;


@WebServlet("/CheckId")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckIdServlet() {
        
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
	System.out.println("id:"+id);
	boolean flag= UserDAOImpl.getInstance().checkId(id);
	System.out.println("flag:"+flag);
	response.getWriter().write(String.valueOf(flag));
	
	
		
}

}
