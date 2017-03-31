<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#regBtn').click(function() {

			$.ajax({
				type : "POST",
				url : "./user/insertUser",
				datatype : "json",
				data : {
					"userId" : $('#userId').val(),
					"snsId" : $('#snsId').val(),
					"snsType" : $('#snsType').val(),
					"userName" : $('#userName').val(),
					"password" : $('#password').val(),
					"phoneNum" : $('#phoneNum').val(),
					"email" : $('#email').val()
				},
				success : function(data) {
					location.reload(true);
				}
			});
		});

		$('#searchBtn').click(function() {

			$.ajax({

				type : "POST",
				url : "./user/searchUserListById",
				datatype : "json",
				data : {

					"userId" : $('#searchWord').val()

				},
				success : function(data) {
					alert(JSON.stringify(data));
					location.reload(true);
				}
			});
		});

		$('#loginBtn').click(function() {

			$.ajax({

				type : "POST",
				url : "./user/loginService",
				datatype : "json",
				data : {

					"loginUserId" : $('#loginUserId').val(),
					"loginPassword" : $('#loginPassword').val()

				},
				success : function(data) {
					if (JSON.stringify(data) == "true") {
						alert("�α��� ����");
						location.reload(true);
					} else {
						alert("�α��� ����");
						location.reload(true);
					}

				}
			});
		});

	});
</script>

</head>
<body>



	<h3>����� ���</h3>
	<input type="text" id="userId" name="userId" placeholder="���̵�" />
	<br />
	<input type="text" id="snsId" name="snsId" placeholder="SNS���̵�" />
	<br />
	<input type="text" id="snsType" name="snsType" placeholder="SNS����" />
	<br />
	<input type="text" id="userName" name="userName" placeholder="�̸�" />
	<br />
	<input type="password" id="password" name="password"
		placeholder="Password" />
	<br />
	<input type="text" id="phoneNum" name="phoneNum"
		placeholder="Phone Number" />
	<br />
	<input type="email" id="email" name="email" placeholder="Email Address" />
	<br />
	<button type="button" id="regBtn">Register</button>

	<h3>����� �α���</h3>
	<input type="text" id="loginUserId" name="userId" placeholder="���̵�" />
	<br />
	<input type="password" id="loginPassword" name="password"
		placeholder="Password" />
	<br />
	<button type="button" id="loginBtn">�α���</button>
	<br />
	<br />
	<h3>����� ��ȸ</h3>

	<c:forEach items="${selectUserList}" var="userList">
	${userList.userNo}
	${userList.userId}
	${userList.snsId} 
	${userList.snsType} 
	${userList.userName}
	${userList.password} 
	${userList.phoneNum} 
	${userList.email} 
	<br />
	</c:forEach>

	<h3>����� �˻�</h3>
	<input type="text" id="searchWord" />
	<button type="button" id="searchBtn">�˻�</button>


	<c:if test="${not empty pageContext.request.userPrincipal }">
		<p>is Log-In</p>
	</c:if>

	<c:if test="${empty pageContext.request.userPrincipal }">
		<p>is Log-Out</p>
	</c:if>

	USER ID:${pageContext.request.userPrincipal.name}
	<br />
	<a href="${pageContext.request.contextPath }/j_spring_security_logout">Log
		Out</a>
	<br />

</body>
</html>