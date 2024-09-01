package web.http.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.http.model.ProductDAOImpl;


@WebServlet("/Cancle")
public class CancleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancleServlet() {
        
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
		
		int orderid =  Integer.parseInt(request.getParameter("orderid"));
		ProductDAOImpl.getInstance().cancleOrder(orderid);
		
		
		
	}

}
