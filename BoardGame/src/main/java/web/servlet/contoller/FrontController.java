package web.servlet.contoller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.BoardGame;
import web.servlet.model.BoardGameDAOImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doProcess(request, response); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doProcess(request, response); }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "boardgame_list.jsp";
		
		if(command.equals("register")) {
			path = register(request, response);
		} else if(command.equals("showAllBoardGame")) {
			path = showAllBoardGame(request, response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}//doProcess
	
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		float level = Float.parseFloat(request.getParameter("level"));
		int price = Integer.parseInt(request.getParameter("price"));
		String designer = request.getParameter("designer");
		String publisher = request.getParameter("publisher");
		
		String path = "boardgame_list.jsp";
		BoardGame vo = null;
		
		vo = new BoardGame(0, name, level, price, designer, publisher);
		try {
			BoardGameDAOImpl.getInstance().registerBoardGame(vo);
			request.setAttribute("vo", vo);
			path = "register_result.jsp";
			
		} catch (Exception e) {
		
		}
		return path;
	}
	
	private String showAllBoardGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		try {
			ArrayList<BoardGame> list = BoardGameDAOImpl.getInstance().showAllBoardGame();
			request.setAttribute("list", list);
			path = "boardgame_list.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		return path;
	}
}
