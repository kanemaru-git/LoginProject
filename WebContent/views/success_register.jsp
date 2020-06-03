<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/LoginProject/views/login.css">
</head>
<body>
<h1>この内容で登録しました。</h1>
<table>
  <tr>
    <td align="center">ユーザ名</td>
    <td align="center">　${register.username }</td>
  </tr>
  <tr>
    <td align="center">パスワード</td>
    <td align="center">　${register.password}</td>
  </tr>
  <tr>
    <td align="center">性別</td>
    <td align="center">　${register.gender}</td>
  </tr>
</table>	
<a href="views/login.jsp">ログイン画面へ</a>
 
</body>
</html>