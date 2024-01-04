package emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/deleteEmp.do")
public class EmpDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		System.out.println("DeleteEmpControlloer");
		int empno = Integer.parseInt(request.getParameter("empno"));
		System.out.println(empno);
		
		Emp emp = null;
		boolean result = false;
		
		try {
			emp = EmpDAO.getEmpbyEmpno(empno);
			
			if(emp == null) {
				request.setAttribute("error", "존재하지않는사원");
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				result = EmpDAO.deleteEmpbyEmpno(empno);
			}
			if(result) {
				url = "getEmpList.do";
				response.sendRedirect(url);
				return;
			}else {
				request.setAttribute("error", "사원삭제실패");
				request.getRequestDispatcher(url).forward(request, response);
			}
	
		} catch (Exception e) {
			request.setAttribute("error", "사원삭제실패");
			request.getRequestDispatcher(url).forward(request, response);
			
		} 
		
		}
	
	
}


