package emp.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dto.Emp;


@WebServlet("/insertEmp.do")
public class EmpInsertController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String hiredate = request.getParameter("hiredate");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		
		String url = "errors/error.jsp";
		
		boolean result = false;
		
		Emp newEmp = new Emp(Integer.parseInt(empno), ename, job, Integer.parseInt(mgr), Date.valueOf(hiredate), Float.parseFloat(sal), Integer.parseInt(comm), Integer.parseInt(deptno));
		
		try {
			result = EmpDAO.insertEmp(newEmp);
			
			if(result) {
				url = "getEmpList.do";
				response.sendRedirect(url);
				return;
			}else {
				request.setAttribute("error", "사원 생성 실패");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("error", "사원 생성 실패");
			request.getRequestDispatcher(url).forward(request, response);
	
		}
}
}

