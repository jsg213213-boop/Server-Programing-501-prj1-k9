<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/todo/register_0206">글쓰기</a>
</div>
<div>
    <h2>서블릿 컨텍스트에 저장된 데이터 불러와서, 화면에 표현해보기.</h2>
    <h3>서블릿 컨텍스트 데이터 확인</h3>
    <%-- 서블릿에서 설정한 데이터 가져오기 --%>
    <p>메시지: <%= application.getAttribute("globalMessage") %></p>
    <p>관리자 이메일: <%= application.getInitParameter("adminEmail") %></p>
    <h3>직접 가져오기. </h3>
    <p>관리자 이메일2 : ${adminEmailDirect}</p>
</div>
 <ul>
     <c:forEach var="dto" items="${dtoList}">
         <li>
             <span>${dto.tno}</span>
             <span><a href="/todo/read_0206?tno=${dto.tno}">${dto.title}</a></span>
             <span>${dto.dueDate}</span>
             <span>${dto.finished ? "완료" : "미완료"}</span>
         </li>
     </c:forEach>
 </ul>

<form action="/logout" method="post">
    <button>로그아웃</button>
</form>


</body>
</html>
