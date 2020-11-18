<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>

<html>
<body>
<sql:setDataSource var="snapshot" 
driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/test1"
user="root" password="ssn"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM student1;
</sql:query>


<c:forEach var="row" items="${result.rows}">
	<c:out value="${row.id}"/>
	<c:out value="${row.name}"/>
</c:forEach>
</body>
</html>
