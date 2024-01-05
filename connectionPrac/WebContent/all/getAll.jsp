<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Detail</title>
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%-- <%@ include file="../layout/header.jsp" %> --%>

<header>
  <h1>Servlet / JSP</h1>
  <p>Dept + Emp List Practice</p>
  <div align="right">
	  	<c:if test="${empty sessionScope.userId}">
		  	<span style="font-size:12pt;"><input type="button" value="로그인" onclick="location.href='login.jsp'"></span>
	  	</c:if>
  		<c:if test="${not empty sessionScope.userId}">
  			<span> ${sessionScope.userName}님 </span>
	  		<span style="font-size:12pt;"><input type="button" value="로그아웃" onclick="location.href='logout.do'"></span>
		</c:if>
	</div>
</header>

<!-- action, method -->
<form action="updateDeptForm.do" method="get" name="detailForm" id="detailForm">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
	            		<b>리스트 상세 정보</b>
	            	</font>
	            </p>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">사원번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span id="deptno" style="font-size:12pt;">
	        			${requestScope.all.empno}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">사원이름</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${requestScope.all.ename}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">부서번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${requestScope.all.deptno}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	     <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">부 서 명</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${requestScope.all.dname}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">부서위치</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${requestScope.all.loc}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	</table>
</form>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='getAllList.do'"></span>
</div>

<%-- <%@ include file="../layout/footer.jsp" %> --%>

<footer> 
  <p>copyright 2024</p>
  <p>Dept + Emp List Practice</p>
</footer>

</body>
</html>