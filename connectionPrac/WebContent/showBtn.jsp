<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/layout2.css" rel="stylesheet" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> 
</head>
<body>

<%-- <%@ include file="../layout/header.jsp" %> --%>

<header>
  <h1>Servlet / JSP</h1>
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


  	<div class="container">
	    <p><a href="getDeptList.do" title="Button" class="button btnPush show">Dept Practice</a><br><br>
	    <a href="getEmpList.do" title="Button" class="button btnPush show">Emp Practice</a><br><br><br>
	    <a href="getAllList.do" title="Button" class="button btnPush show">Dept + Emp List Practice</a><br><br><br>
	    <a href="showBtn.jsp" title="Button" class="button btnPush show">메인으로</a><br><br><br>
	    <div class="clear"></div></p>
  	</div>
  
<%-- <%@ include file="../layout/footer.jsp" %> --%>

<footer> 
  <p>copyright 2024</p>
  <p>Practice</p>
</footer>

</body>
</html>