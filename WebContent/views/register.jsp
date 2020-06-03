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
<h1>新規会員登録</h1>
<form action="/LoginProject/RegisterServlet" method="post">
		<table>
        <tr>
          <td class="item">ユーザ名【必須】</td>
          <td><input type="text" name="username" /></td>
        </tr>
        <tr>
          <td class="item">パスワード【必須】</td>
          <td><input type="text" name="password" /></td>
        </tr>
        <tr>
        	<td class="item">性別</td>
        	<td>
        		<input type="radio" name="gender" value="男" />男
        		<input type="radio" name="gender" value="女" />女
        	</td>
        </tr>
      </table>
      <input type="submit" value="登録" />
	</form>
	<p class="emsg">${register.emsg}</p>
</body>
</html>