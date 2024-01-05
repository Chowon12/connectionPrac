package dept.controller; 

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

@WebServlet("/deleteDept.do")
public class DeleteDeptController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		System.out.println("DeleteDeptController");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		System.out.println(deptno);
				
		Dept dept = null;
		boolean result = false;
	
		try {
			dept = DeptDAO.getDeptByDeptno(deptno);
			
			if(dept == null) {
				request.setAttribute("error", "존재하지않는부서");
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				result = DeptDAO.deleteDeptByDeptno(deptno);
			}
			
			if(result) {
				url = "getDeptList.do";
				result = DeptDAO.deleteDeptByDeptno(deptno);
			}
			if(result) {
				url= "getDeptList.do";
				response.sendRedirect(url);
				return;
			}else {
				request.setAttribute("error", "부서 삭제 실패");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "부서 삭제 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
