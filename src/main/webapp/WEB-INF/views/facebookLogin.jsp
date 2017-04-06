<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="//connect.facebook.net/ko_KR/sdk.js"></script>

</head>
<body>

<script>
		// initialize and setup facebook js sdk
		window.fbAsyncInit = function() {
			FB.init({
				appId : '123354464869468',
				xfbml : true,
				version : 'v2.8'
			});
			
			FB.getLoginStatus(function(response) {
						if (response.status === 'connected') {
							document.getElementById('status').innerHTML = 'We are connected.';
							document.getElementById('login').style.visibility = 'hidden';
							console.log("response:::"+JSON.stringify(response));
							
							var accessToken=response.authResponse.accessToken;
							var signedRequest=response.authResponse.signedRequest;
							var expiresIn = response.authResponse.expiresIn;
							 
							console.log("accessToken : "+JSON.stringify(accessToken));
							console.log("signedRequest : "+JSON.stringify(signedRequest));
							console.log("expiresIn : "+JSON.stringify(expiresIn));
							 
							/*  $.ajax({
									type : "POST",
									url : "./user/socialService",
									datatype : "json",
									data : {

										"responseData" : JSON.stringify(response)
										
									},
									success : function(data) {
										location.reload(true);
									}
								}); */
							
						} else if (response.status === 'not_authorized') {
							document.getElementById('status').innerHTML = 'We are not logged in.'
						} else {
							document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
						}
					});
		};

		FB.Event.subscribe('auth.login', function(response) {
			window.location.href = './userManageHome';
		});

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/ko_KR/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		// login with facebook with extra permissions
		function login() {
			FB.login(
							function(response) {
								if (response.status === 'connected') {
									document.getElementById('status').innerHTML = 'We are connected.';
									document.getElementById('login').style.visibility = 'hidden';
								} else if (response.status === 'not_authorized') {
									document.getElementById('status').innerHTML = 'We are not logged in.'
								} else {
									document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
								}
							}, {
								scope : 'email'
							});
		}

		// getting basic user info
		function getInfo() {
			FB.api('/me', 'GET', {
				 fields : 'name,id,email' 
			}, function(response) {
				document.getElementById('status').innerHTML = response.id;
				 console.log("login.response : "+JSON.stringify(response));
				
				/* 1251786131604425
				1251786131604425   -> 항상 일정 */
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
	</script>


<div id="status"></div>
	<button onclick="getInfo()">페이스북으로 회원가입</button>
	<br />
	<button onclick="login()" id="login" class="fb-login-button" data-auto-logout-link="true"></button>
	<br />
	<br />
	
</body>
</html>