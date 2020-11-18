<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<body>
<sql:setDataSource var="snapshot" 
driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/test1"
user="root" password="vaishu"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT uname FROM users;
</sql:query>

<c:set var="u_name" scope="application" value="${param.uname}"/>

<c:set var="flag" value="${0}"/>

<c:forEach var="row" items="${result.rows}">
	<c:if test="${fn:startsWith(row.uname,u_name)}">
			<!--c:out value="${row.uname}"/-->
			<c:set var="flag" value="${1}"/>
	</c:if>	
</c:forEach>
<c:if test="${flag==0}"> <c:out value = "Username Not found"/> </c:if>

</body>
</html>
