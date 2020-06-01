<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<link rel="stylesheet" href="/LoginProject/views/login.css">
</head>
<body>
<h1>ログイン画面</h1>
	<form action="/LoginProject/LoginServlet" method="post">
		<table>
        <tr>
          <td class="item">ユーザ名</td>
          <td><input type="text" name="username" /></td>
        </tr>
        <tr>
          <td class="item">パスワード</td>
          <td><input type="text" name="password" /></td>
        </tr>
      </table>
      <input type="submit" value="ログイン" />
	</form>
	<p class="emsg">${loginBean.emsg}</p>
	
</body>
</html>