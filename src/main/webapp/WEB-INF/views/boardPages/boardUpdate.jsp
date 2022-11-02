<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardUpdate.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #update-form {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="update-form">
    <form action="/board/update" method="post" name="updateForm">
        <input type="hidden" name="id" value="${board.id}" class="form-control" readonly>
        <input type="text" name="boardWriter" value="${board.boardWriter}" class="form-control" readonly>
        <input type="text" name="boardPass" id="boardPass" class="form-control" placeholder="비밀번호">
        <input type="text" name="boardTitle" value="${board.boardTitle}" class="form-control">
        <textarea name="boardContents" cols="30" rows="10" class="form-control">${board.boardContents}</textarea>
        <input type="button" value="수정" onclick="updateReqFn()" class="btn btn-primary">
    </form>
</div>
</body>
<script>
    const updateReqFn = () => {
        const passInput = document.getElementById("boardPass").value;
        const passDB = '${board.boardPass}';
        if (passInput == passDB) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!!");
        }
    }
</script>
</html>
