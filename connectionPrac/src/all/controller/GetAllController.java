package all.controller; 

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import all.dao.AllDAO;
import all.dto.All;
import dept.dao.DeptDAO;
import dept.dto.Dept;
import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/getAll.do")
public class GetAllController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if(session == null) {
//			response.sendRedirect("login.jsp");
//			return;
//		}
		/*
		 * 시나리오
		 * DB로부터 특정 부서 검색 후 반환
		 * 	-> dept 존재 O -> getDept.jsp에 출력
		 * 	-> dept 존재 X -> error.jsp에 error메세지 출력
		 * 							"존재하지 않는 부서" / "부서 정보 검색 실패"
		 */
		String url = "errors/error.jsp";
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		All all = null;
		
		try {
			all = AllDAO.getAllByEmpno(empno);
			
			if(all != null) {
				request.setAttribute("all", all);
				url = "all/getAll.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				request.setAttribute("error", "존재하지 않는  리스트 정보");
				request.getRequestDispatcher(url).forward(request, response);
			}
			
		} catch (SQLException e) {
			request.setAttribute("error", "리스트 정보 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
