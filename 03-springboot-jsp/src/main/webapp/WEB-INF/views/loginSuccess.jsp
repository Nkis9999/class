<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${user} 登入成功</h1>

<h2>公司名稱: ${companyName}</h2>

<h2>Pet Name: ${petName}</h2>

<h2>Pet Address: ${petAddress}</h2>

<h2>Pet Hobby: ${petHobby}</h2>

<form action="/upload" method="POST" enctype="multipart/form-data">
    暱稱：<input type="text" name="nickname" /> <br/>
    上傳照片：<input type="file" name="photo" /> <br/>
    <button type="submit">送出</button>
</form>

</body>
</html>