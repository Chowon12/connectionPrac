<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp List</title>
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> 
</head>
<body>

<%@ include file="../layout/header2.jsp" %>

<c:if test="${not empty sessionScope.userId}">
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#336699">
            <p align="center">
            <font color="white"><b><span style="font-size:12pt;">사원번호</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">사원이름</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">부서번호</span></b></font></p>
            <button id="sortByDeptno" onclick="location.href='empSort'">부서번호로 정렬</button>
        </td>
    </tr>

	<!-- 부서 객체 유무 검증 -->
	<c:if test="${empty requestScope.empList}">    
		<tr>
	        <td colspan="5">
	            <p align="center"><b><span style="font-size:12pt;">등록된 사원의 정보가 존재하지 않습니다.</span></b></p>
	        </td>
	    </tr>
	</c:if>
	<!-- 반복 출력 -->
	<c:forEach items="${requestScope.empList}" var="emp">
		    <tr>
		        <td bgcolor="">
		            <p align="center">
			            <span style="font-size:12pt;">
			            	<!-- 사원번호 클릭 시, 사원번호로 해당 사원 상세정보 출력 -->
			            	<b id="empno">
			            		<a href="getEmp.do?empno=${emp.empno}">${emp.empno}</a>
			            	</b>
			            </span>
		            </p>
		        </td>
		        <td bgcolor="">
					<p align="center">
						<span style="font-size:12pt;">
							<!--
								사원 이름
							 -->
							<b id="ename">
								${emp.ename}
							</b>
						</span>
					</p>
		        </td>
		        <td bgcolor="">
		            <p align="center">
		            	<span style="font-size:12pt;">
		            		<!-- 사원 부서번호 -->
		             		<b id="deptno">${emp.deptno}</b>
		             	</span>
		             </p>
		        </td>
		    </tr>
    </c:forEach>
</table>
<hr>
<div align=center>
	<!-- 메인으로 클릭 시, 모든 부서 정보 출력 -->
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='showBtn.jsp'"></span>
	<!-- 부서생성 클릭 시, 새로운 부서 정보 입력 페이지로 이동 -->
	<span style="font-size:12pt;"><input type="button" value="사원등록" onclick="location.href='insertEmpForm.do'"></span>
</div>
</c:if>
<c:if test="${empty sessionScope.userId}">
	<div align="center">
  		<span style="font-size:12pt;">로그인이 필요한 서비스입니다.</span>
	</div>
</c:if>
<script type="text/javascript">
/* const sortByDeptnoBtn = document.getElementById('sortByDeptno');
sortByDeptnoBtn.addEventListener('click', (e) => {
	e.preventDefault();
    axios.get('http://localhost:8080/step07_ConnectionPool_c/empSort')
            .then(response => response.data)
            .then(result => {
            	console.log(response.data);
            	
            	const enameElement = document.getElementById("ename");
            	const empnoElement = document.getElementById("empno");
            	const deptnoElement = document.getElementById("deptno");
            	response.data.forEach(emp => {
            		enameElement.textContent = emp.ename;
            		empnoElement.textContent = emp.empno;
            		deptnoElement.textContent = emp.deptno;
            	});
            })
}) */
</script>
<%@ include file="../layout/footer2.jsp" %>

</body>
</html>