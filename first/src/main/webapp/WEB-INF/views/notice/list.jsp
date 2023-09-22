<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
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

    .buttons {
        display: flex;
        gap: 10px;
    }

    .buttons button {
        margin-left: auto;
    }
    	
        table {
            border-collapse: collapse;
            width: 70%;
            margin: 0 auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
        
        .noList {
	        text-align: center;
	        font-weight: bold;
	        margin-top: 20px;
    	}
    	.tb-container{
    		text-align: center;
        	margin-top: 20px;
		
		}
		
		.buttons > a{
			text-align: right;
			}
    </style>

<body>
   <div class="header">
        <h1>Study CRUD</h1>
        <div>
        <span>${sessionScope.loginInfo.user_name} 님</span>
<!-- 		<span>로그인했습니다.</span> -->
        <div class="buttons">
            <a href="/info"><button type="button">나의 정보</button></a>
            <a href="/logout"><button type="button">로그아웃</button></a>
        </div>
    </div>
    </div>
<table class="tb-container">
    <thead>
        <tr>
            <th style="width: 10%;">글번호</th>
            <th style="width: 40%;">제목</th>
            <th style="width: 10%;">작성자</th>
            <th style="width: 10%;">작성일자</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="4" class="noList">현재 공지글이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${list}" var="vo">
                    <tr>
                        <td>${vo.id}</td>
                        <td><a href="notice_info?id=${vo.id }">${vo.title }</a></td>
                        <td>${vo.writer}</td>
                        <td>${vo.write_date}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>
<div class="buttons" style="display: flex; justify-content: center; align-items: center; margin-top: 20px">
    <a href="new"><button type="button">공지사항 작성</button></a>
</div>
</body>
</html>