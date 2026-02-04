<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="f/todo/register_0204">글쓰기</a>
</div>
 <ul>
     <c:forEach var="dto" items="${dtoList}">
         <li>
                 ${dto}
         </li>
     </c:forEach>
 </ul>


</body>
</html>
