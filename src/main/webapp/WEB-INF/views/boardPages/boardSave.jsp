<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오후 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardSave.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #write-form {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="write-form">
    <form action="/board/save" method="post">
        <input type="text" name="boardWriter" class="form-control" placeholder="작성자">
        <input type="text" name="boardPass" class="form-control" placeholder="비밀번호">
        <input type="text" name="boardTitle" class="form-control" placeholder="제목">
        <textarea name="boardContents" cols="30" rows="10" class="form-control" placeholder="내용을 입력하세요"></textarea>
        <input type="submit" value="작성" class="btn btn-primary">
    </form>
</div>
</body>
</html>
