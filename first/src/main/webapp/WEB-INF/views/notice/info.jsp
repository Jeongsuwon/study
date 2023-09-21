<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <style>
    table {
      border-collapse: collapse;
      width: 70%;
      margin: 30px auto;
    }
    
   	h1 {
        align-items: center;
        padding: 10px;
        width: 70%;
        text-align: center;
        margin: 0 auto;
        background-color: #f2f2f2;
    }

    th {
      background-color: #f2f2f2;
      text-align: center;
      padding: 10px;
      border: 1px solid #ddd;
    }

    td {
      text-align: left;
      padding: 10px;
      border: 1px solid #ddd;
    }

    .td-center {
      text-align: center;
    }

    .content-line-height {
      line-height: 1.5; /* 원하는 높이로 조절 */
    }

    tr:first-child td {
      font-weight: bold;
    }
    
    .buttons{
    	 text-align: center;
    }
  </style>
</head>
<body>
<h1>Study CRUD</h1>
	 <table>
    <colgroup>
      <col width="90px">
      <col width="380px">
      <col width="380px">
      <col width="130px">
      <col width="160px">
      <col width="100px">
      <col width="150px">
    </colgroup>
    <tr>
      <th>제목</th>
      <td colspan="2" class="td-center">${vo.title}</td>
      <th>작성자</th>
      <td class="td-center">${vo.writer}</td>
      <th>작성일자</th>
      <td class="td-center">${vo.write_date}</td>
    </tr>
    <tr>
      <th>내용</th>
      <td class="td-margin content-line-height" colspan="6"><pre>${vo.content}</pre></td>
    </tr>
  </table>

  
  <div class="buttons">
    <a href="list"><button>목록으로</button></a>
    
	<!-- sessionScope -> HttpSession에 등록된 데이터의 이름과 값을 저장하고 있는 map객체 -->
    <c:if test="${sessionScope.loginInfo.user_id == vo.user_id}">
        <a href="modify?id=${vo.id }"><button>수정</button></a>
    </c:if>
    
    <c:if test="${sessionScope.loginInfo.user_id == vo.user_id}">
        <a href="delete"><button>삭제</button></a>
    </c:if>
</div>
</body>
</html>