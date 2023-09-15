<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 공지사항 작성</title>
</head>
<body>

	<form method="post" action="notice_insert">
		<div>

			<h2>새 공지사항 작성</h2>

			<table>

				<tbody>

					<tr>
						<td>
							<div style="width: 100%;">
								<input type="text" placeholder="글 제목" maxlength="40"
									style="width: 100%;">
							</div>
						</td>
					</tr>

					<tr>

						<td><textarea class="form-control" placeholder="글 내용을 작성하세요"
								maxlength="1024" style="height: 400px;"></textarea></td>

					</tr>

				</tbody>

			</table>


		</div>
	<div>
		<button id="btn-save">저장</button>
		<button type="button" onclick="history.go(-1)">취소</button>
	</div>
	</form>

	
	
	
	<script>
	$('#btn-save').on('click', function() {
		$('form').submit()
})
	</script>
</body>
</html>