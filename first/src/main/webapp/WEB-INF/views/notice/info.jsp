<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <table class="table table-bordered" id="info_table"  style="border-radius: 10px;">
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
      <td class="td-center">${vo.user_name}</td>
      <th>작성일자</th>
      <td class="td-center">${vo.write_date}</td>
    </tr>
    <tr>
      <th>내용</th>
      <td class="td-margin content-line-height" colspan="6"><pre>${vo.content}</pre></td>
    </tr>
  </table>
</body>
</html>