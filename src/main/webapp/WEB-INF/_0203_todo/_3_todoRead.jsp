<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 2. 2.
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--// 0202_모델클래스_서비스_컨트롤러를_이용한_로직 처리_순서7--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>TodoRead 임시화면</h1>
<h3>하나의 정보를 불러오기 , dto 라는 객체에서 정보를 하나씩 꺼내보기.</h3>
<p>_3_TodoDTO 모델클래스의 멤버를 getter 로 가져오는 효과</p>
<div>
    ${dto.tno}
</div>
<div>
    ${dto.title}
</div>
<div>
    ${dto.dueDate}
</div>
<div>
    ${dto.finished}
</div>
</body>
</html>
