package ex.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {

	@Autowired
	private SqlSession sql;

	@Override
	public List<BoardVO> list() {
		return sql.selectList("list");
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
