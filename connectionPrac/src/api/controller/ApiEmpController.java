package api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/api/getEmp")
public class ApiEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno = request.getParameter("empno");
		
		Emp emp = null;
		PrintWriter out = null;
		try {
			emp = EmpDAO.getEmpByEmpno(Integer.parseInt(empno));
			
			response.setContentType("application/json; charset=UTF-8");
			out = response.getWriter();
			
			if(emp != null) {
				// "{\"msg\" : \"존재\"}"
				out.print("{\"msg\" : \"존재\"}");
			}else {
				out.print("{\"msg\" : \"미존재\"}");
			}
		} catch (NumberFormatException | SQLException e) {
//			e.printStackTrace();
			out.print("{\"msg\" : \"" + e.getMessage() + "\"}");
		}
		
		
	}

}