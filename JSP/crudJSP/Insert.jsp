<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test1" user="root" password="vaishu"/>

<sql:query dataSource="${snapshot}" var="result">
select * from student1;
</sql:query>

<p>Before Insertion</p>
<table border="1" cellspacing="5" cellpadding="5">
<tr><th>ID</th><th>NAME</th></tr>

<c:forEach var="row" items="${result.rows}">
  <tr>
  	<td><c:out value="${row.id}"/></td>
  	<td><c:out value="${row.name}"/></td>
 </tr>
</c:forEach>

</table>

<sql:update dataSource="${snapshot}" var="count">
INSERT INTO student1 (id,name) VALUES (?, ?);
<sql:param value="${param.u_id}" />
<sql:param value="${param.u_name}" />
</sql:update>

<sql:query dataSource="${snapshot}" var="result">
select * from student1;
</sql:query>

<p>After Insertion</p>
<table border="1" cellspacing="5" cellpadding="5">
<tr><th>ID</th><th>NAME</th></tr>

<c:forEach var="row" items="${result.rows}">
  <tr>
  	<td><c:out value="${row.id}"/></td>
  	<td><c:out value="${row.name}"/></td>
 </tr>
</c:forEach>

</table>
</body>
</html>
