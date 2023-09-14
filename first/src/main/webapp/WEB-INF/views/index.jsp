<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="/css/styles.css"> -->
<style>
		div {
    background-color: #f2f2f2;
    padding: 20px;
    width: 300px;
    margin: 0 auto;
    border: 1px solid #ddd;
    border-radius: 5px;
    text-align: center;
}

h1 {
    color: #333;
}

h2 {
    color: #007bff;
}

label {
    font-weight: bold;
    display: block;
    margin-bottom: 5px;
}

input[type="text"],
input[type="password"] {
    width: 90%;
    padding: 10px;
    margin: 5px auto;
    border: 1px solid #ccc;
    border-radius: 3px;
    display: block;
}

button {
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    margin-top: 10px;
}

button:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
<div>	
<h1>Study CRUD</h1>
		<form action="/login" method="post">
				<label for="user_id">아이디</label> <input type="text" id="user_id"
					name="user_id">
				<label for="user_pw">비밀번호</label> <input type="password"
					id="user_pw" name="user_pw">
			<button type="submit">로그인</button>
			
		</form>
		<a href="join">회원가입</a>
		
	</div>
</body>
</html>