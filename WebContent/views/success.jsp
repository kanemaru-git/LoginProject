<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ログイン成功画面</title>
</head>
<body>

<h1 style="text-align:center">ようこそ<span style="color:orange">${username.username}</span>さん</h1>
<h2>ユーザデータ一覧</h2>
<table>
  <tr>
    <th>user_id</th>
    <th>username</th>
    <th>password</th>
    <th>gender</th>
  </tr>
<c:forEach var="users" items="${users}" >
  <tr>
    <td>${users.user_id}</td>
    <td>${users.username }</td>
    <td>${users.password}</td>
    <td>${users.gender}</td>
  </tr>
</c:forEach>

</table>

</body>
</html>