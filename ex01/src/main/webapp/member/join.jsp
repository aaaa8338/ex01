<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file ="/api/api.jsp" %>


<style type="text/css">
	.tab {
		width: 20%;
		height: 30%;
	}
	
	.btn {
		border : 1px solid;
	}
	
	table {
		border-collapse: collapse;
	} 
	
	th,td {
		border: 1px solid;
		padding: 5px;	
	}
</style>
<script>
	function check() {
		var param = {};
		param.name = frm.name.value.trim(); 
		param.id = frm.id.value.trim(); 
		param.password = frm.password.value.trim(); 
		param.confirmPassword = frm.confirmPassword.value.trim(); 
		
		if (param.name == "") {
			alert("이름을 입력하세요");
			frm.name.focus();
			return;
			
		}  
		
		if (param.id == "") {
			alert("아이디를 입력하세요")
			frm.id.focus();
			return;
			
		}  
		
		if (param.password == "") {
			alert("비밀번호를 입력하세요")
			frm.password.focus();
			return;
			
		}  
		
		if (param.confirmPassword == "") {
			alert("비밀번호확인을 입력하세요")
			frm.confirmPassword.focus();
			return;
		}
		
		if (param.password != param.confirmPassword) {
			frm.confirmPassword.focus();
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return;
		}
		
		var msg = confirm("저장 하시겠습니까?");
		
		if (msg) {
			$.ajax({
				 type : "post"
			   , url : "${path}/insertMember.do"
			   , data : param  // $("#frm").serialize()
			   , success : function(res) {
				 	console.log(JSON.stringify(res));
				 	
					if (res != "") {
			    		alert("성공");
			    		location.href = "${path}/";
			    		
			    	} else {
			    		alert("아이디 중복");
			    	}
			    	
		       	}
			});	 
		}
		
		//document.frm.action = "${path}/insertMember.do";
        //document.frm.submit();
	}
	
</script>

</head>
<body>
	<form id="frm" name="frm">
		<table class="tab">
			<tr>
				<th>이름</th>
				<td><input type="text" id="name" name="name"></input></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id"></input></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" id="password" name="password"></input></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="text" id="confirmPassword" name="confirmPassword"></input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="btn" value="확인" class="btn" onclick="check()"></input></td>
			</tr>	
		</table>
	</form>
</body>
</html>