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

@WebServlet("/updateDeptForm.do")
public class UpdateDeptFormController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ?
		String url = "errors/error.jsp";
		
		String deptno = request.getParameter("deptno");
		int convertedDeptno;
		if(deptno == null) {
			convertedDeptno = 0;
			request.setAttribute("error", "부서 번호 누락");
			request.getRequestDispatcher(url).forward(request, response); //시스템적으로 문제가 있을 때 에러코드 노출시키지 않도록 함. 
			return;
		}
		
		Dept dept = null;
		try {
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept != null) {
				request.setAttribute("dept", dept);
				
				url = "dept/updateDept.jsp";
				request.getRequestDispatcher(url).forward(request, response);
				
			} else {
				request.setAttribute("error", "존재하지 않는 부서");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			request.setAttribute("error", "부서 정보 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}

