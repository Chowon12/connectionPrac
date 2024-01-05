package emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/updateEmpForm.do")
public class UpdateEmpFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		String empno = request.getParameter("empno");
		
		Emp emp = null;
		
		try {
			emp = EmpDAO.getEmpByEmpno(Integer.parseInt(empno));
			
			if(emp != null) {
				request.setAttribute("emp", emp);
				
				url = "emp/updateEmp.jsp";
				request.getRequestDispatcher(url).forward(request, response);
				
			} else {
				request.setAttribute("error", "존재하지 않는 사원");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			request.setAttribute("error", "사원 정보 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}
