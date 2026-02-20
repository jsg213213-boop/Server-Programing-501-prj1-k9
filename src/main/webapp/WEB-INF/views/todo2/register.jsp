<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 2. 13.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>임시 register</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!--        <h1>Header</h1>-->
        <!--        네비게이션 추가 작업-->
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <!--        네비게이션 추가 작업-->
        <!--        추가1-->
        <div class="row content">
            <!--            추가2-->
            <div class="col">
                <!--                추가3 -->
                <div class="card">
                    <div class="card-header">
                        Featured
                    </div>
                    <div class="card-body">
                        <form action="/todo2/register" method="post">
<%--                            부트스트랩 이용중이고, 폼 컨트롤 하나씩 적용해보기.--%>
                            <div class="input-group mb-3">
                                <span class="input-group-text">Title:</span>
                                <input class="form-control" type="text" name="title" placeholder="todo 제목을 입력해주세요">
                            </div>
                            <div>
                                DueDate: <input type="date" name="dueDate">
                            </div>
                            <div>
                                Writer: <input type="text" name="writer">
                            </div>
                            <div>
                                Finished: <input type="checkbox" name="finished">
                            </div>
                            <div>
                                <button type="reset">초기화</button>
                                <button type="submit">등록하기</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <h1>Content</h1>
    </div>
    <div class="row footer">
        <!--        <h1>Footer</h1>-->
        <!--        추가1-->
        <div class="row fixed-bottom" style="z-index: -100">
            <!--            추가2-->
            <footer class="py-1 my-1">
                <!--                추가3-->
                <p class="text-center text-muted">
                    Footer
                </p>
            </footer>
        </div>
    </div>
</div>
<h1>부트스트랩 적용, register 화면</h1>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
