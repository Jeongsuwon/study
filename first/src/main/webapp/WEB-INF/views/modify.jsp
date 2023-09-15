<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#user_id {
        background-color: lightgray;
        color: black;
    }
    #btn-update,
button[type="button"] {
    width: 100px;
     display: inline-block;
}


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

    form {
        display: flex;
        flex-direction: column; 
        max-width: 300px;
        margin: 0 auto; 
    }
    
    .form-group {
        display: flex;
        flex-direction: row;
        align-items: center;
        margin-bottom: 10px;
    }

    .form-group label {
        width: 100px;
        text-align: left;
        margin-right: 10px;
    }

   
    label {
        width: 100%;
        text-align: left;
        margin-bottom: 5px;
    }

    
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 5px;
    }

   
</style>
</head>
<body>
<div class="header">
	<h1>Study CRUD 정보수정</h1>	
</div>
	
    <form action="/user_update" method="post">
        <div class="form-group">
        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id" value="${user.user_id}" readonly><br><br>
		</div>
		<div class="form-group">
        <label for="user_pw">비밀번호:</label>
        <input type="password" id="user_pw" name="user_pw" value="${user.user_pw}"required><br><br>
		</div>
		<div class="form-group">
        <label for="user_name">성명:</label>
        <input type="text" id="user_name" name="user_name" value="${user.user_name}"><br><br>
		</div>
		<div class="btn-container">
        <button id="btn-update">수정하기</button>
		<button type="button"
			onclick="history.go(-1)">취소</button>

		</div>
    </form>
    
    <script>

		$('#btn-update').on('click', function() {
				$('form').submit()
		})
	</script>

</body>
</html>