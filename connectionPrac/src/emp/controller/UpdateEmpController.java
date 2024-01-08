package emp.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dto.Emp;


@WebServlet("/updateEmp.do")
public class UpdateEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String deptno = request.getParameter("deptno");
		
		String url = "errors/error.jsp";
		
		Emp emp = null;
		
		boolean result = false;
		
		try {
			emp = EmpDAO.getEmpByEmpno(Integer.parseInt(empno));
			
			if(emp != null) {
				emp.setEname(ename);
				emp.setDeptno(Integer.parseInt(deptno));
				
				if(EmpDAO.updateEmp(emp)) {
					url = "getEmp.do?empno=" + empno;
					response.sendRedirect(url);
					return ;
				} else {
					request.setAttribute("error", "사원 정보 수정 실패");
					request.getRequestDispatcher(url).forward(request, response);
				}
				
			}
		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("error", "사원 정보 수정 오류");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}
