<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/custom.css">
</head>
<body>

<div class="login-container">
		<h2 class="login-title">로그인</h2>
		<div class="form-group">
			<label for="username" class="label">아이디:</label> <input type="text"
				id="username" class="input-field required">
		</div>
		<div class="form-group">
			<label for="password" class="label">비밀번호:</label> <input
				type="password" id="password" class="input-field required">
		</div>

		<div
			class="d-flex align-items-center justify-content-between mt-4 mb-0">
			<button class="login-button">로그인</button>
			
			<a class="small" href="<c:url value='/member/join'/>">회원가입</a> 
			<a class="small" href="findPassword">비밀번호 찾기</a>
		</div>
	</div>

</body>
</html>