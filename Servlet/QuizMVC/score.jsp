<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<%
	int score = (int)session.getAttribute("score");
%>

<c:out value="Thank You for taking the quiz."/><br>
<c:out value="Your score is : ${score}"/>
</body>
</html>
