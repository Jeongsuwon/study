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
	<form method="post" action="/update_notice">
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
      <td colspan="2" class="td-center"><input type="text" name="title" value="${vo.title}" /></td>
      <th>작성자</th>
      <td class="td-center">${vo.writer}</td>
      <th>작성일자</th>
      <td class="td-center">${vo.write_date}</td>
    </tr>
    <tr>
      <th>내용</th>
      <td class="td-margin content-line-height" colspan="6">
        <textarea name="content" rows="10" cols="50">${vo.content}</textarea>
      </td>
    </tr>
  </table>
</form>
  
  
  <div class="buttons">
  	<a href="modify"><button>수정</button></a>
  	<a href="notice_info?id=${vo.id }"><button>취소</button></a>
  	</div>
</body>
</html>