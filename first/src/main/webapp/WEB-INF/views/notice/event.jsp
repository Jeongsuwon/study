<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판>이벤트</title>
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
body {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 10px;
    width: 70%;
    margin: 0 auto;
    background-color: #f2f2f2;
}

.header h1 {
    margin: 0;
}

.buttons {
    display: flex;
    gap: 10px;
    margin-left: auto;
}

.buttons button {
    margin-left: auto;
}

#sidebar-wrapper {
    margin-top: 20px;
}

#sidebar-wrapper .list-group .list-group-item {
    text-align: left;
    border: none;
    border-radius: 0;
    padding: 15px;
    color: #000; /* 텍스트 색상 */
    text-decoration: none; /* 밑줄 없애기 */
}

#sidebar-wrapper .list-group {
    flex-direction: column; /* 세로로 나열되도록 설정 */
}

#sidebar-wrapper .list-group .list-group-item:hover {
    background-color: #f8f9fa; /* 호버 시 배경 색상 */
    text-decoration: none; /* 밑줄 없애기 */
}

#sidebar-wrapper .list-group .active {
    background-color: #007bff; /* 선택된 항목 배경 색상 */
    color: #fff; /* 선택된 항목 텍스트 색상 */
    text-decoration: none; /* 밑줄 없애기 */
}

.tb-container {
    text-align: center;
    margin-top: 20px;
    width: 70%;
}
    </style>

<body>
   <div class="header">
   		<a class="navbar-brand" href="/">SS-Shop</a>
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
<div class="border-end bg-white d-flex" id="sidebar-wrapper">
    <div class="list-group list-group-flush flex-column">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="list">공지사항</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="freedom">자유게시판</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="event">이벤트</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">리뷰</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
    </div>
</div>
<table class="tb-container">
    <tbody>
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="4" class="noList">현재 진행중인 이벤트가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${list}" var="vo">
                    <tr>
                        <!-- 이미지 표시를 위한 td -->
                        <td><img src="${vo.imageUrl}" alt="이미지" style="width: 100px; height: 100px;"></td>
                        <!-- 타이틀 표시를 위한 td -->
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