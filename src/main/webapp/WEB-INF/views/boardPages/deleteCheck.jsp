<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오후 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteCheck.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #delete-Check {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="delete-Check">
    <input type="text" id="boardPass" class="form-control" placeholder="비밀번호">
    <button class="btn btn-secondary" onclick="passCheck()">확인</button>
</div>
</body>
<script>
    const passCheck = () => {
        const passInput = document.getElementById("boardPass").value;
        const passDB = '${board.boardPass}';
        const id = '${board.id}';
        if (passInput == passDB) {
            location.href = "/board/delete?id=" + id;
        } else {
            alert("비밀번호가 일치하지 않습니다!!");
        }
    }
</script>
</html>
