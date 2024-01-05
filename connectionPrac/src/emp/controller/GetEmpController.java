package emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.dao.DeptDAO;
import dept.dto.Dept;
import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/getEmp.do")
public class GetEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		String empno = request.getParameter("empno");
		
		int convertedEmpno;

		if(empno == null) {
			convertedEmpno = 0;
			System.out.println("사원번호 누락");
//			request.setAttribute("error", "사원 번호 누락");
//			request.getRequestDispatcher(url).forward(request, response); 
//			return;
		}
		
		Emp emp = null;
		
		try {
			emp = EmpDAO.getEmpByEmpno(Integer.parseInt(empno));
			
			if(emp != null) {
				request.setAttribute("emp", emp);
				url = "emp/getEmp.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				request.setAttribute("error", "존재하지 않는 부서");
				request.getRequestDispatcher(url).forward(request, response);
			}
			
		} catch (SQLException e) {
			request.setAttribute("error", "부서 정보 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
