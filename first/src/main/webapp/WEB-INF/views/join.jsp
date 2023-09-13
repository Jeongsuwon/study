<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* form 요소를 flex 컨테이너로 설정 */
    form {
        display: flex;
        flex-direction: column; /* 요소들을 세로로 나열 */
        max-width: 300px; /* 원하는 최대 폭 설정 */
        margin: 0 auto; /* 가운데 정렬을 위한 마진 설정 */
    }

    /* 라벨 스타일 설정 */
    label {
        width: 100%; /* 라벨을 100% 폭으로 설정하여 동일한 너비로 정렬 */
        text-align: left; /* 라벨 텍스트를 왼쪽 정렬 */
        margin-bottom: 5px; /* 라벨 아래 여백을 줍니다. */
    }

    /* 입력 필드 스타일 설정 */
    input[type="text"],
    input[type="password"] {
        width: 100%; /* 입력 필드를 100% 폭으로 설정하여 동일한 너비로 정렬 */
        padding: 5px; /* 입력 필드 주위에 여백을 줍니다. */
        margin-bottom: 10px; /* 입력 필드 아래 여백을 줍니다. */
    }

    /* 가입 버튼 스타일 설정 */
    input[type="submit"] {
        width: auto; /* 가입 버튼의 너비를 내용에 맞게 설정 */
    }
</style>
</head>
<body>
	 <h2>회원가입</h2>
    <form action="/register" method="post">
        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id" required><br><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="firstname">성:</label>
        <input type="text" id="firstname" name="firstname" required><br><br>
        
        <label for="lastname">이름:</label>
        <input type="text" id="lastname" name="lastname" required><br><br>

        <input type="submit" value="가입">
    </form>
</body>
</html>