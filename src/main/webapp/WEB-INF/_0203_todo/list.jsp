<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 1. 30.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--  0202_모델클래스_서비스_컨트롤러를_이용한_로직 처리_순서3--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>list 임시 화면입니다.</h1>
<%--  0202_모델클래스_서비스_컨트롤러를_이용한_로직 처리_순서2--%>
<%-- 서버에서 설정을 : req.setAttribute("list", dtoList);--%>
<%-- 현재, 이 화면에서, 위의 키값을 사용하는 것. --%>
${list}

 <%--  0202_모델클래스_서비스_컨트롤러를_이용한_로직 처리_순서4--%>
<%--jstl 이란 도구 이용해서, 자바 문법를 간소화해서, 반복문 이용해서, --%>
<%--html 태그도 같이 이용해서, 하나씩 조회 해보기. --%>
 <ul>
     <c:forEach var="dto" items="${list}">
         <li>
                 ${dto}
         </li>
     </c:forEach>
 </ul>


</body>
</html>
