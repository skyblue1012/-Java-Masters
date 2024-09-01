package web.http.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.http.model.Order;
import web.http.model.ProductDAOImpl;
import web.http.model.User;


@WebServlet("/Show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowServlet() {
        
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
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<Order> list = ProductDAOImpl.getInstance().showOrder(user.getId());
		request.setAttribute("list", list);
		request.getRequestDispatcher("showOrder.jsp").forward(request, response);
		
		
		
		
	}
	

}
