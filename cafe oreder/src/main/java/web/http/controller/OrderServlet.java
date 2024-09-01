package web.http.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.http.model.ProductDAOImpl;
import web.http.model.User;


@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderServlet() {
        
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
		
		//linkedhashmap<String,Integer>로 인자값
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String id = user.getId();
		int tp = Integer.parseInt(request.getParameter("tp"));
		LinkedHashMap<String, Integer> list = new LinkedHashMap<String, Integer>();
		list.put(request.getParameter("pnum1"), Integer.parseInt(request.getParameter("quantity1")) );
		list.put(request.getParameter("pnum2"), Integer.parseInt(request.getParameter("quantity2")) );
		list.put(request.getParameter("pnum3"), Integer.parseInt(request.getParameter("quantity3")) );
		System.out.println(list);
		ProductDAOImpl.getInstance().order(id, tp, list);
		request.getRequestDispatcher("Show").forward(request, response);
		
	}

}
