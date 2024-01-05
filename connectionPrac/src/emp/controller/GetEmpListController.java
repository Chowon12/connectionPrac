package emp.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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

@WebServlet("/getEmpList.do")
public class GetEmpListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Emp> empList = null;
		try {
			empList = EmpDAO.getEmpList();
			if(empList != null) {
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
