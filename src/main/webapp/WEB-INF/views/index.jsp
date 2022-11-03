<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오후 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<a href="/board/">글목록</a>
<a href="/board/save">글작성</a>
<a href="/board/paging">페이징목록</a>
<a href="/board/paging?page=10">10페이지</a>
<a href="/board/paging?page=3">3페이지</a>
</body>
</html>
<%-- 글작성, 회원가입
    /boardSave    /memberSave
    /board/save   /member/save --%>