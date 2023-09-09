<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/custom.css">
</head>
<body>
	<div class="signup-container">
  <h2 class="signup-title">회원가입</h2>
  <div class="form-group">
    <label for="username" class="label">아이디:</label>
    <input type="text" id="username" class="input-field">
  </div>
  <div class="form-group">
    <label for="password" class="label">비밀번호:</label>
    <input type="password" id="password" class="input-field">
  </div>
  <div class="form-group">
    <label for="name" class="label">이름:</label>
    <input type="text" id="name" class="input-field">
  </div>
  <div class="form_group">
  	<label for="phone" class="label">핸드폰번호:</label>
  	<input type="text" id="phone" class="input-field">
  </div>
  <div class="form_group">
  	<label for="birth" class="label">생년월일:</label>
  	<input type="text" id="birth" class="input-field">
  </div>
  <button class="signup-button">회원가입</button>
  <p class="error-message">회원가입에 실패했습니다.</p>
  <p><a href="#" class="link">이미 계정이 있으신가요? 로그인</a></p>
</div>

</body>
</html>