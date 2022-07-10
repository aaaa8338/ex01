<%-- <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:forward page="/egovSampleList.do"/> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file ="/api/api.jsp" %>

<script type="text/javascript">
	function loginCheck() {
		if (document.frm.id.value.trim() == "") {
			alert('아이디를 입력하세요');
			frm.userid.focus();
			return;
			
		} else if (document.frm.password.value.trim() == ""){
			alert('비밀번호를 입력하세요');
			frm.userpwd.focus();
			return;
		}
		
		
		var param = {};
		param.id = document.frm.id.value;
		param.password = document.frm.password.value;
		/* location.href */
		$.ajax({
		    type: "post",
		    url: "${path}/loginCheck.do",
		    data: param,
		    success: function (res) {
		    	if (res) {
		    		alert("로그인 성공");
		    		location.href = "${path}/list.do";
		    		
		    	} else {
		    		alert("로그인 실패");
		    		
		    	}
		    	
	       	}, error : function () {
	       		alert("로그인 실패");
			}
		});	
		
	}
	
</script>
</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" style="text-align: center;">로그인</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
					<form id="loginform" class="form-horizontal" role="form" method="post" name="frm">
						<div style="margin-bottom: 25px; width: 100%;" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<input id="login-username" type="text" class="form-control" name="id" placeholder="id">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<input id="login-password" type="password" class="form-control" name="password" placeholder="password">
						</div>

						<div style="margin-top: 10px; text-align: center;"
							class="form-group">
							<div class="col-dm-12 controls">
								<a id="btn-login" href="" class="btn btn-primary" onclick="loginCheck()">확인</a> 
								<a id="btn-join"  href="${path}/join.do" class="btn btn-primary">회원가입</a>
								<a id="btn-join"  href="${path}/memberList.do" class="btn btn-primary">리스트</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>