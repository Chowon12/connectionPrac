package api.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/empSort")
public class ApiEmpSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Emp> empList = EmpDAO.empOrderByDeptno();
			if(empList != null) {
				System.out.println(empList);
				request.setAttribute("empList", empList);
				request.getRequestDispatcher("emp/getEmpList.jsp").forward(request, response);
			}else {

				request.setAttribute("error", "모든 부서 정보 미존재");
				request.getRequestDispatcher("errors/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("error", "모든 부서 출력 실패");
			request.getRequestDispatcher("errors/error.jsp").forward(request, response);
		}
		
	}
}
