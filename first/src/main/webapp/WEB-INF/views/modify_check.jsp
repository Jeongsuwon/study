<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.buttons{
		margin-top: 20px; 
	}
	.buttons button{
		gap: 20px;
	}
</style>
</head>
<body>
<form action="/pw_modify_check" method="post">
	<div>
		<h2>정보수정을 위해 비밀번호를 입력해주세요.</h2>
	</div>
	<div>
		<label for="user_pw">비밀번호</label>
		<input type="password" id="user_pw" name="user_pw">
	</div>
	
	<div class="buttons">
		<button type="submit">확인</button>
		<button type="button" onclick="history.go(-1)">취소</button>
		
	</div>
	
	    <div>
        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>
    </div>
	
</form>

</body>
</html>