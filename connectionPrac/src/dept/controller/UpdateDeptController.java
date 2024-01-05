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

@WebServlet("/updateDept.do")
public class UpdateDeptController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		String url = "errors/error.jsp";
		
		Dept dept = null;
		
		boolean result = false;
		
		try {
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept != null) {
				dept.setDname(dname);
				dept.setLoc(loc);
				
				if(DeptDAO.updateDept(dept)) {
					url = "getDept.do?deptno=" + deptno;
					response.sendRedirect(url);
					return ;
				} else {
					request.setAttribute("error", "부서 정보 수정 실패");
					request.getRequestDispatcher(url).forward(request, response);
				}
				
			}
		} catch (Exception e) {
			request.setAttribute("error", "부서 정보 수정 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}

	}
}
