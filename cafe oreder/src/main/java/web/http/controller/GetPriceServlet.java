package web.http.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.http.model.ProductDAOImpl;


@WebServlet("/GetPrice")
public class GetPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetPriceServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnum = request.getParameter("pnum");
		
		String list = ProductDAOImpl.getInstance().getPrice(pnum);
		
		response.getWriter().write(list);
	}

}
