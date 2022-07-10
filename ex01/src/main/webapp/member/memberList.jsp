<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		margin-top: 10%;
		margin-left: 40%;
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
<script type="text/javascript">
	function search() {
		location.href = "${path}/selectMember.do";
	}
</script>
</head>
<body>
	<div>
	</div>
	<form id="frm" name="frm">
		<input type="button" id="btn" value="조회" class="btn" onclick="search()">
		<label for="gender">성별</label> 
		<select id="gender" name="gender">
			<option value ="" >전체</option>
			<option value ="1">1. 남자</option>
			<option value ="2">2. 여자</option>
		</select> 
		<c:choose>
			<c:when test="${fn:length(list) > 0}">
				<table class="tab">
					<thead>
						<tr>
							<td>아이디</td>
							<td>이름</td>
						</tr>
					</thead>
					<c:forEach var="row" items="${list}">
						<tr>
							<td>${row.id}</td>
							<td>${row.name}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</form>
</body>
</html>