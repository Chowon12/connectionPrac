<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp Insertion</title>
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> 
</head>
<body>
 
<%@ include file="../layout/header.jsp" %>

<!-- action, method -->
<form action="insertEmp.do" method="POST" id="insertForm" onsubmit="checkData()">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
	            		<b>새로운 사원 생성</b>
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
	        		<button id="check-emp">check</button>
	        		<div id="empCheckMessage"></div>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">사 원 명</span></b></p>
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
	            <p align="center"><b><span style="font-size:12pt;">부서번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<!-- input 박스 -->
	        			<input type="text" name="deptno" size="30">
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
						<input type="submit" value="사원생성">
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
</div>

<%@ include file="../layout/footer.jsp" %>

<script type="text/javascript">
function checkData() {
	let insertForm = document.getElementById('');	
	
	if(insertForm.empno.value == "") {
		
		return;
	}
	if(insertForm.ename.value == "") {
		
		return;
	}
	if(insertForm.deptno.value == "") {
		
		return;
	}
}	

</script>


<script>
const checkBtn = document.getElementById('check-emp');
checkBtn.addEventListener('click', (e) => {
	e.preventDefault();.
	const inputEmpno = document.getElementById('empno');
	const showMsg = document.getElementById('empCheckMessage');
    axios.get('http://localhost:8080/step07_ConnectionPool_c/api/getEmp', 
    		{params: {empno : inputEmpno.value}})
            .then(response => response.data)
            .then(result => {
            	if(result.msg === '존재') {
            		empCheckMessage.innerHTML = "<p style='color: red;'>해당사원은 존재합니다.</p>";
            	}else {
            		empCheckMessage.innerHTML = "<p style='color: green;'>해당사원은 미존재합니다.</p>";
            	}
            })
})
</script>

</body>
</html>