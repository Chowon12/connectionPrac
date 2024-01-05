<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*"%>
 <%@ page import="emp.dao.EmpDAO" %>
 <%@ page import="emp.dto.Emp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpList</title>
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="../layout/header.jsp" %>
		<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">

					<%
						EmpDAO empDAO = new EmpDAO();
						ArrayList<Emp> list = empDAO.getSearch(request.getParameter("searchField"),
								request.getParameter("searchText"));
						if (list.size() == 0) {
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("alert('검색결과가 없습니다.')");
							script.println("history.back()");
							script.println("</script>");
						}
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						
						<td><%=list.get(i).getEmpno()%></td>
						<td><%=list.get(i).getEname()%></td>
						<td><%=list.get(i).getDeptno()%></td>
					</tr>
					<%}%>
					</table>
	<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='getEmpList.do'"></span>
</div>
				
</body>
</html>