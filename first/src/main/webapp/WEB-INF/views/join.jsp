<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    form {
        display: flex;
        flex-direction: column;
        max-width: 300px;
        margin: 0 auto;
    }

    
    label {
        width: 100%;
        text-align: left;
        margin-bottom: 5px;
    }

    /* 입력 필드 스타일 설정 */
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 5px;
        margin-bottom: 10px;
    }

    /* 가입 버튼 스타일 설정 */
    input[type="submit"] {
        width: auto;
    }
</style>
</head>
<body>
	 <h2>회원가입</h2>
    <form action="/register" method="post">
        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id" required><br><br>

        <label for="user_pw">비밀번호:</label>
        <input type="password" id="user_pw" name="user_pw" required><br><br>

        <label for="user_name">성명:</label>
        <input type="text" id="user_name" name="user_name" required><br><br>
		
        <input type="submit" value="가입">
    </form>
</body>
</html>