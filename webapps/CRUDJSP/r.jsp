<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="ssn"/>
<sql:query dataSource="${snapshot}" var="result">select * from student;</sql:query>
<table border="1" cellspacing="5" cellpadding="5">
<c:forEach var="row" items="${result.rows}">
  <tr><td><c:out value="${row.id}"/></td>
  <td><c:out value="${row.name}"/></td></tr>
</c:forEach>
</table>
</body>
</html>
