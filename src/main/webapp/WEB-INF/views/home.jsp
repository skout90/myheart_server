<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
		${item.pushTime}<br/>
		${item.timeDivision}<br/>
	</c:forEach> 
	
</h1>

</body>
</html>
