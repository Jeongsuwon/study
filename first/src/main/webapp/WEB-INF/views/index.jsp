<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<h2>로그인</h2>
		<form action="/login" method="post">
			<div>
				<label for="user_id">아이디</label> <input type="text" id="user_id"
					name="user_id">
			</div>
			<div>
				<label for="user_pw">비밀번호</label> <input type="password"
					id="user_pw" name="user_pw">
			</div>
			<button type="submit">로그인</button>
			
		</form>
		<a href="join">회원가입</a>
		
	</div>
</body>
</html>