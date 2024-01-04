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
<<<<<<< HEAD
		String url = "errors/error.jsp";
		
		System.out.println("DeleteDeptController");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		System.out.println(deptno);
				
		Dept dept = null;
		boolean result = false;
		
=======
//		HttpSession session = request.getSession(false);
//		if(session == null) {
//			response.sendRedirect("login.jsp");
//			return;
//		}
		
		// 부서 삭제 클릭 -> deptno DB -> 삭제 O -> getDeptList
		
		// 							삭제 X -> 에러
	
		String url = "errors/error.jsp";
				
		System.out.println("DeleteDeptController");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		System.out.println(deptno);
		
		// step01 : 해당 deptno로 객체확인
		Dept dept = null;
		boolean result = false;
>>>>>>> create
		try {
			dept = DeptDAO.getDeptByDeptno(deptno);
			
			if(dept == null) {
				request.setAttribute("error", "존재하지않는부서");
				request.getRequestDispatcher(url).forward(request, response);
			}else {
<<<<<<< HEAD
				result = DeptDAO.deleteDeptByDeptno(deptno);
			}
			
			if(result) {
				url = "getDeptList.do";
=======
				//2 삭제로직
				result = DeptDAO.deleteDeptByDeptno(deptno);
			}
			
			// step03: 페이지 이동
			if(result) {
				url= "getDeptList.do";
>>>>>>> create
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
<<<<<<< HEAD
		
		
		
		
=======
				
>>>>>>> create
		
	}
}
