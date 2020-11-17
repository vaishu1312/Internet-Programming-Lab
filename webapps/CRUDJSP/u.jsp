<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="ssn"/>

<sql:update dataSource="${snapshot}" var="count">
Update student set name='${param.name2}' where id='${param.id2}';
</sql:update>

<sql:query dataSource="${snapshot}" var="result">select * from student;</sql:query>
<table border="1" cellspacing="5" cellpadding="5">
<c:forEach var="row" items="${result.rows}">
  <tr><td><c:out value="${row.id}"/></td>
  <td><c:out value="${row.name}"/></td></tr>
</c:forEach>
</table>
</body>
</html>
