<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>새 공지사항 작성</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            width: 50%; /* 테이블 폭을 조절할 수 있습니다. */
        }

        h2 {
            text-align: center;
        }

        table {
            width: 100%;
        }

        td div {
            display: flex;
        }

        td input {
            flex: 1;
        }
    </style>
</head>
<body>

    <form method="post" action="notice_insert">
        <div>

            <h2>새 게시글 작성</h2>

            <table>

                <tbody>

                    <tr>
                        <td>
                            <!-- 카테고리 선택 드롭다운 메뉴 -->
                            <select name="category">
                                <option value="공지사항">공지사항</option>
                                <option value="자유게시판">자유게시판</option>
                                <option value="이벤트">이벤트</option>
                            </select>
                        </td>
                        <td>
                            <div>
                                <input type="text" name="title" placeholder="글 제목" maxlength="40">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div>
                                <textarea class="form-control" name="content" placeholder="글 내용을 작성하세요" maxlength="1024" style="height: 400px;"></textarea>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <!-- 첨부파일 삽입 칸 -->
                            <input type="file" name="file">
                        </td>
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
            $('form').submit();
        });
    </script>
</body>
</html>