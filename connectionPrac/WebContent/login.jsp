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

<!-- action, method -->
<form action="login.do" method="POST">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
	            		<b>로그인</b>
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
	        		<span style="font-size:12pt;">
	        			<input id="empno" type="text" name="empno" size="30">
	        		</span>
	        		<span>
	        			<button id="check-emp">check</button>
	        		</span>
        			<div id="show-msg"/>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">사  원  명</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<!-- input 박스 -->
	        			<input type="text" name="ename" size="30">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p><b><span style="font-size:12pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
						<input type="submit" value="로그인">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</span>
				</b>
			</td>
	    </tr>
	</table>
</form>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='getDeptList.do'"></span>
</div>

<script>
const checkBtn = document.getElementById('check-emp');
checkBtn.addEventListener('click', (e) => {
	e.preventDefault();
	const inputEmpno = document.getElementById('empno');
	const showMsg = document.getElementById('show-msg');
    axios.get('http://localhost:8080/step07_ConnectionPool_c/api/getEmp', 
    		{params : {empno : inputEmpno.value}})
            .then(response => response.data)
            .then(result => {
            	if(result.msg === '존재') {
            		showMsg.innerHTML = '해당 사원은 존재합니다';
            	}else {
            		showMsg.innerHTML = '해당 사원은 미존재합니다';
            	}
            })
})
</script>

	<%-- <%@ include file="../layout/footer.jsp" %> --%>
<footer> 
  <p>copyright 2024</p>
  <p>Practice</p>
</footer>

</body>
</html>
