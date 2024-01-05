package common.controller; 

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		
		String url = "errors/error.jsp";
		if(empno == null || empno == "" || ename == null || ename == "") {
			request.setAttribute("erorr", "사원번호 또는 사원명 재확인 필요");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		Emp emp = null;
		
		try {
			emp = EmpDAO.getEmpByEmpno(Integer.parseInt(empno));
			
			if(emp == null) {
				request.setAttribute("erorr", "존재하지 않는 사원 정보 오류");
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				
				
				HttpSession session = request.getSession();
				session.setAttribute("userId", emp.getEmpno());
				session.setAttribute("userName", emp.getEname());
				
				url = "getDeptList.do";
				response.sendRedirect(url);
				return;
			}
		} catch (NumberFormatException | SQLException e) {
			request.setAttribute("erorr", "로그인 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
