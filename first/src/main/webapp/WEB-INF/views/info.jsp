<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	    	.header {
        display: flex;
        align-items: center;
        padding: 10px;
        width: 70%;
        margin: 0 auto;
        background-color: #f2f2f2;
    }

    .header h1 {
    	margin: 0 auto;
    }
    
    .info{
    	margin: 0 auto;
    	text-align: center;
    }
</style>
</head>
<body>
<div class="header">
	<h1>Study CRUD 회원정보</h1>	
</div>
<div class="info">
	<div >
        <p>아이디: ${user.user_id}</p>
        <p>성명: ${user.user_name}</p>
        <p>가입일: ${user.create_ymd}</p>
        <p>수정일: ${user.update_ymd}</p>
    </div>
    <div>
    	<a href="modify_check"><button type="button">회원수정</button></a>
    	<a href="modify"><button type="button">회원탈퇴</button></a>
    </div>
    </div>
</body>
</html>