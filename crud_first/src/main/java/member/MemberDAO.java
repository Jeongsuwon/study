package member;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired private SqlSession sql;
	
	
	public int register(MemberVO vo) {
		int list = sql.insert("pr.register", vo);
		return list;
	}
	}
