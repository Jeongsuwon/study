package ex.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> list(); // 게시글 목록 조회

	int newPost(BoardVO vo); // 새로운 게시글 저장

	int update(BoardVO vo); // 게시글 수정

	int delete(int bno); // 게시글 삭제

	BoardVO info(int bno); // 게시글 정보
}
