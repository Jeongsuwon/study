package ex.member;

public interface MemberService {
	// CRUD
	int member_join(MemberVO vo); // 회원가입

	int member_update(MemberVO vo); // 회원정보변경

	int member_delete(String userid);// 회원정보삭제
}
