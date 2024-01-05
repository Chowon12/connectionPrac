<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<header>
  <h1>Servlet / JSP</h1>
  <p>Dept Practice Header</p>
  <div align="right">
	  	<c:if test="${empty sessionScope.userId}">
		  	<span style="font-size:12pt;"><input type="button" value="로그인" onclick="location.href='login.jsp'"></span>
	  	</c:if>
  		<c:if test="${not empty sessionScope.userId}">
  			<span> ${sessionScope.userName}님 </span>
	  		<span style="font-size:12pt;"><input type="button" value="로그아웃" onclick="location.href='logout.do'"></span>
		</c:if>
	</div>
	<div class="container">
		<div class="row">
			<form method="post" name="search" action="SearchEmp.jsp">
				<table class="pull-right">
					<tr>
						<td><select class="form-control" name="searchField">
								<option value="0">선택</option>
								<option value="ename">사원이름</option>
								<option value="empno">사원번호</option>
								<option value="deptno">부서번호</option>
						</select></td>
						<td><input type="text" class="form-control"
							placeholder="검색어 입력" name="searchText" maxlength="100"></td>
						<td><button type="submit" class="btn btn-success">검색</button></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
</header>
