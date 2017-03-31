<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
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

	<c:url value="j_spring_security_check" var="loginUrl" />
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
	</form>

</body>
</html>
