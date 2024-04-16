<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        /* 간단한 스타일링을 위한 CSS */
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
.form-group input {
    width: 300px; /* 예시로 300px로 설정 */
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
        .btn-submit {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2>회원가입</h2>
    <form action="register" method="POST">
        <table class="tb-row" style="width: 100%;">
            <colgroup>
                <col width="180px">
                <col>
            </colgroup>
            <tr>
                <th><span>*</span>아이디</th>
                <td>
                    <div class="row input-check align-items-center">
                        <div class="col-auto">
                            <input type="text" name="userid" class="check-item form-control">
                        </div>
                        <div class="col-auto">
                            <a class="btn btn-secondary btn-sm" id="btn-userid">
                                <i class="fa-regular fa-circle-check me-2"></i>중복확인
                            </a>
                        </div>
                        <div class="col-auto">아이디는 영문 소문자나 숫자 4자~12자</div>
                        <div class="desc"></div>
                    </div>
                </td>
            </tr>
            <tr>
                <th><span>*</span>비밀번호</th>
                <td>
                    <div class="row input-check align-items-center">
                        <div class="col-auto">
                            <input type="password" name="userpw" class="check-item form-control">
                        </div>
                        <div class="col-auto">비밀번호는 영문 대/소문자, 숫자를 조합 7자~12자</div>
                        <div class="desc"></div>
                    </div>
                </td>
            </tr>
            <tr>
                <th><span>*</span>비밀번호 확인</th>
                <td>
                    <div class="row input-check align-items-center">
                        <div class="col-auto">
                            <input type="password" name="userpw_ck" class="check-item form-control">
                        </div>
                        <div class="col-auto">비밀번호와 일치하게 입력</div>
                        <div class="desc"></div>
                    </div>
                </td>
            </tr>
        </table>
    </form>
    <div class="btn-toolbar gap-2 my-3 justify-content-center">
		<button class="btn btn-outline-success" id="btn-join">회원가입</button>
		<button type="button" class="btn btn-outline-danger px-4" onclick="history.go(-1)">취소</button>
	</div>
    
    	<script>
	//회원가입 버튼 클릭시
	$('#btn-join').on('click',function(){
		if($("[name=name]").val().trim()==""){
			alert("회원명을 입력하세요!");
			$("[name=name]").focus();
			$("[name=name]").val("");
			return;
		}
		</script>
    
</body>
</html>