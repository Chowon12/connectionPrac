package emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertEmpForm.do")
public class EmpInsertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpInsertFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "errors/error.jsp";
		
		url = "emp/insertEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
