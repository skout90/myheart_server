<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="//connect.facebook.net/ko_KR/sdk.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						Kakao.init("b6f81403dd202808db42e2088c526b6f");
						function getKakaotalkUserProfile() {
							Kakao.API
									.request({
										url : '/v1/user/me',
										success : function(res) {

											/* $("#kakao-profile").append(res.properties.nickname); */
											/* $("#kakao-profile").append(res); */
											
											console.log("res : "+ JSON.stringify(res));
											console.log("res.id : "+ JSON.stringify(res.id));
											
											/* 395287127
											395287127 ->항상 일정 */
											//console.log("res.properties"+JSON.stringify(res.properties));
											$("#kakao-profile").append(
													res.properties);

											/* $("#kakao-profile").append($("<img/>",{"src":res.properties.profile_image,"alt":res.properties.nickname+"porfile picture"})); */
											/*  window.location.href='./userManageHome';  */
										},
										fail : function(error) {
											console.log(error);
										}
									});
						}
						function createKakaotalkLogin() {
							$(
									"#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn")
									.remove();
							var loginBtn = $("<button>", {
								"class" : "kakao-login-btn",
								"text" : "Log-in with kakao"
							}, "</button>");
							loginBtn.click(function() {
								Kakao.Auth.login({
									persistAccessToken : true,
									persistRefreshToken : true,
									success : function(authObj) {
										alert("authObj_info : "
												+ JSON.stringify(authObj));
										console.log("authObj_info : "
												+ JSON.stringify(authObj));

										getKakaotalkUserProfile();
										createKakaotalkLogout();

									},
									fail : function(err) {
										console.log(err);
									}
								});
							});
							$("#kakao-logged-group").prepend(loginBtn)
						}
						function createKakaotalkLogout() {
							$(
									"#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn")
									.remove();
							var logoutBtn = $("<button>", {
								"class" : "kakao-logout-btn",
								"text" : "Log-out with kakao"
							}, "</button>");
							logoutBtn.click(function() {
								Kakao.Auth.logout();
								createKakaotalkLogin();
								$("#kakao-profile").text("");
							});
							$("#kakao-logged-group").prepend(logoutBtn);
						}

						if (Kakao.Auth.getRefreshToken() != undefined
								&& Kakao.Auth.getRefreshToken().replace(/ /gi,
										"") != "") {
							createKakaotalkLogout();
							getKakaotalkUserProfile();
						} else {
							createKakaotalkLogin();
						}

					});
</script>

</head>


<body>
	<h1>
		<c:forEach items="${resultList}" var="item">
			<%-- 		${item.drugCd}<br/> --%>
			<%-- 		${item.drugNm}<br/> --%>
			<%-- 		${item.mainIngredientCd}<br/> --%>
			<%-- 		${item.description}<br/> --%>
		${item.pushTime}<br />
		${item.timeDivision}<br />
		</c:forEach>

	</h1>

	<%-- <c:url value="j_spring_security_check" var="loginUrl" />
	<form action="${loginUrl }" method="post">
		<c:if test="${param.ng != null}">
			<p>
				Login NG! <br />
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL }">
				message:<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message }" />
				</c:if>
			</p>
		</c:if>
		ID : <input type="text" name="j_username" ><br />
		PW : <input type="text" name="j_password" ><br />
		<input type="submit" value="전송"><br />
	</form> --%>


	

	

	<div id="kakao-logged-group"></div>
	<div id="kakao-profile"></div>
	<br />


	<button type="button" onclick="location.href='./userManageHome'">Login
		Test page</button>

</body>
</html>
