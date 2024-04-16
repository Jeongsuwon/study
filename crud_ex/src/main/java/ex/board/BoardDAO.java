package ex.board;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int newPost(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO info(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

}
