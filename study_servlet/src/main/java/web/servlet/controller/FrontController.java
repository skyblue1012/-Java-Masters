package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.dao.DAOImpl;
import web.servlet.vo.User;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}//doPost
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		Predicate<String> isEqual = (i)-> command.equals(i);
		
		if(isEqual.test("login")) {
			/*
			 * 폼값 받기
			 * dao 반환받아 비즈니스 로직 호출
			 * 반환값 바인딩 (필요시)
			 * 네비게이션 (forward / redirect)
			 */
			String path = "login.jsp";
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			try {
				User user = DAOImpl.getInstance().login(id, password);
				System.out.println(user);
				System.out.println("비즈니스 로직 호출 성공");
				
				if(user!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					path = "main.jsp";
				}else {
					request.setAttribute("msg", "아이디와 비밀번호를 다시 확인해주세요.");
				}
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("비즈니스 로직 호출 실패");
			}finally {
				System.out.println("비즈니스 로직 호출 완료");
			}//try-catch-finally
			request.getRequestDispatcher(path).forward(request, response);
			
		}//if
		
	}//doProcess

}//FrontController
