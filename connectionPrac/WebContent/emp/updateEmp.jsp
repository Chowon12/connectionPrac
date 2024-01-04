<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp Update</title>
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="../layout/header.jsp" %>

<form action="updateEmp.do" method="POST">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
	            		<b>사원 정보 업데이트</b>
	            	</font>
	            </p>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:9pt;">사원번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:9pt;">
	        			<!-- 부서번호는 수정되지 않도록 지정 -->
	        			<input type="text" name="deptno" size="30" value="${requestScope.emp.empno}" readonly>
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:9pt;">사 원 명</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:9pt;">
	        			<!-- 부서명 출력 -->
	        			<input type=text name="dname" size="30" value="${requestScope.emp.ename}">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:9pt;">부서번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:9pt;">
	        			<!-- 부서위치 출력 -->
	        			<input type=text name="loc" size="30" value="${requestScope.emp.deptno}">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p><b><span style="font-size:9pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:9pt;">
						<input type="submit" value="사원정보수정">
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
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='getEmpList.do'"></span>
	<span style="font-size:12pt;"><input type="button" value="부서생성" onclick="location.href='insertEmpForm.do'"></span>
</div>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>