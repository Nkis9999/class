<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HOME</h1>

<h2>傳統 traditionRequest </h2>
<form action="traditionRequest" method="POST">
	帳號：<input type="text" name="username" />
	<br/>
	密碼：<input type="text"name="password" />
	<br/>
	<button type="submit">送出</button>
</form>

<h2>RequestParam</h2>
<form action="login" method="POST">
	帳號：<input type="text" name="username2" />
	<br/>
	密碼：<input type="text"name="password2" />
	<br/>
	<button type="submit">送出</button>
</form>

<hr/>

<form action="hobby" method="POST">
    暱稱: <input type="text" name="nickname"/> <br>
    手機: <input type="text" name="phone"/> <br>
    興趣：<br>
    <input type="checkbox" name="hobby" value="吃飯"/>吃飯
    <input type="checkbox" name="hobby" value="睡覺"/>睡覺
    <input type="checkbox" name="hobby" value="打東東"/>打東東
    <br>
    <input type="submit" />
</form>

<hr/>

<a href="testModel">TestModel</a>

</body>
</html>