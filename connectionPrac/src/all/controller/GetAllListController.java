package all.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import all.dao.AllDAO;
import all.dto.All;
import emp.dao.EmpDAO;
import emp.dto.Emp;

@WebServlet("/getAllList.do")
public class GetAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<All> allList = null;
		try {
			allList = AllDAO.getAllList();
			if(allList != null) {
				request.setAttribute("allList", allList);
				request.getRequestDispatcher("all/getAllList.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "모든 리스트 정보 미존재");
				request.getRequestDispatcher("errors/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("error", "모든 리스트 출력 실패");
			request.getRequestDispatcher("errors/error.jsp").forward(request, response);
		}
		
	}
}
