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
<script type="text/javascript" src="//connect.facebook.net/ko_KR/sdk.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#regBtn').click(function() {

			$.ajax({
				type : "POST",
				url : "./user/insertUser",
				datatype : "json",
				data : {
					"userId" : $('#userId').val(),
			/* 	"snsId" : $('#snsId').val(),
					"snsType" : $('#snsType').val(), */
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
						alert("로그인 성공");
						location.reload(true);
					} else {
						alert("로그인 실패");
						location.reload(true);
					}

				}
			});
		});

	});
</script>

</head>
<body>

<script>
			
		// initialize and setup facebook js sdk
		window.fbAsyncInit = function() {
			FB.init({
				appId : '123354464869468',
				oauth   : true,
		        status  : true, // check login status
		        cookie  : true, // enable cookies to allow the server to access the session
		        xfbml   : true ,// parse XFBML
				version : 'v2.5'
			});
			
		}
			(function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0];
				if (d.getElementById(id)) {
					return;
				}
				js = d.createElement(s);
				js.id = id;
				js.src = "//connect.facebook.net/en_US/sdk.js";
				fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
		
			
		FB.getLoginStatus(function(response) {

			if (response.status === 'connected') {//페이스북 로그인 상태라면 로그인 페이지 안나오고 바로 웹에 접근
						/* document.getElementById('status').innerHTML = 'We are connected.';
						document.getElementById('login').style.visibility = 'hidden'; */
						
						
						var accessToken=response.authResponse.accessToken;
						var signedRequest=response.authResponse.signedRequest;
						var expiresIn = response.authResponse.expiresIn;
						 
						/* console.log("accessToken : "+JSON.stringify(accessToken));
						console.log("signedRequest : "+JSON.stringify(signedRequest));
						console.log("expiresIn : "+JSON.stringify(expiresIn)); */
						
					} else if (response.status === 'not_authorized') {
						document.getElementById('status').innerHTML = 'We are not logged in.';
						login();
					} else {
						document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
						login();
					}
				});
		
		


		 FB.Event.subscribe('auth.login', function(response) {
			//window.location.href = './userManageHome';
			if(response.status === 'connected' ){
// 				console.log("response->accessToken:::"+JSON.stringify(response.authResponse.accessToken));
				getInfo();
				
			}
			
		}); 
		
		// login with facebook with extra permissions
		function login() {
			FB.login(
							function(response) {
								if (response.status === 'connected') {
									/* document.getElementById('status').innerHTML = 'We are connected.';
									document.getElementById('login').style.visibility = 'hidden'; */
					
								
								} else if (response.status === 'not_authorized') {
									/* document.getElementById('status').innerHTML = 'We are not logged in.' */
								} else {
// 									document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
								}
							}
							
						);
		}

		// getting basic user info
		function getInfo() {
			
			FB.api('/me', 'GET', {
				 fields : 'name,id,email' 
			}, function(response) {
// 				document.getElementById('status').innerHTML = response.id;
// 				console.log("login.response : "+JSON.stringify(response));
				
				 $.ajax({
						type : "POST",
						url : "./user/socialInsertUser",
						datatype : "json",
						data : {

							"snsId" : response.id,
							"snsType" : "Facebook",
							"userName" : response.name,
							"email" : response.email
							
						},
						success : function(data) {
							location.reload(true);
						}
					});
			});
			
		}
		
		function getInfoToMerge() {
			
			FB.api('/me', 'GET', {
				 fields : 'name,id,email' 
			}, function(response) {
						 $.ajax({
								type : "POST",
								url : "./user/mergeAccount",
								datatype : "json",
								data : {
									"snsId" : response.id,
									"userId":$('#userId_merge').val(),
									"password":$('#password_merge').val(),
									"phoneNum" : $('#phoneNum_merge').val()
									
								},
								success : function(data) {
									location.reload(true);
								}
							});
			});
		}
	</script>

<div id="status">
	</div> 
	<!-- <button onclick="getInfo()">페이스북으로 회원가입</button> -->
	
	<br />
	<button onclick="login()" id="login" class="fb-login-button" data-auto-logout-link="true"> 페이스 북으로 로그인</button>
	<br />
	<br />
	<h3> 계정 통합을 위한 추가 사용자 정보 등록</h3>
	<input type="text" id="userId_merge" name="userId" placeholder="아이디" />
	<br />
	<input type="password" id="password_merge" name="password"
		placeholder="Password" />
	<br />
	<input type="text" id="phoneNum_merge" name="phoneNum"
		placeholder="Phone Number" />
	<br />
	<button  onclick="getInfoToMerge()">계정 통합</button>

	<h3>일반 회원가입</h3>
	<input type="text" id="userId" name="userId" placeholder="아이디" />
	<br />
	<!-- <input type="text" id="snsId" name="snsId" placeholder="SNS아이디"  />
	<br />
	<input type="text" id="snsType" name="snsType" placeholder="SNS종류" />
	<br /> -->
	<input type="text" id="userName" name="userName" placeholder="이름" />
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

	<h3>사용자 로그인</h3>
	<input type="text" id="loginUserId" name="userId" placeholder="아이디" />
	<br />
	<input type="password" id="loginPassword" name="password"
		placeholder="Password" />
	<br />
	<button type="button" id="loginBtn">로그인</button>
	<br />
	<br />
	<h3>사용자 조회</h3>

	<c:forEach items="${selectUserList}" var="userList">
	${userList.userNo}
	${userList.userId}
	${userList.snsId} 
	${userList.snsType} 
	${userList.userName}
	${userList.password} 
	${userList.phoneNum} 
	${userList.email} 
	${userList.reqDt} 
	<br />
	</c:forEach> 

	<h3>사용자 검색</h3>
	<input type="text" id="searchWord" />
	<button type="button" id="searchBtn">검색</button>
	
	<h3>SNS 등록 사용자 조회 </h3>
	
	<c:forEach items="${selectSnsUserList}" var="snsUserList">
		${snsUserList.userNo}
		 ${snsUserList.snsId }
		${snsUserList.snsType }
		${snsUserList.userName}
		${snsUserList.email }
		${snsUserList.reqDt} 
	<br/>
	</c:forEach> 


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