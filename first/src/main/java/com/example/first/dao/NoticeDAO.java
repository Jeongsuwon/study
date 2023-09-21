package com.example.first.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.first.vo.NoticeVO;

@Repository
public class NoticeDAO {
	@Autowired private SqlSession sql;
	
	//공지사항 목록
	public List<NoticeVO> list(){
		List<NoticeVO> list = sql.selectList("notice.list");
		return list;
	}
	
	//공지사항 추가
	public int insert(NoticeVO vo) {
		int result = sql.insert("notice.insert", vo);
		return result;
	}
	
	//공지사항 정보
	public NoticeVO info(Integer id) {
		
		return sql.selectOne("notice.info", id);
	}
	
	//공지사항 변경
	public int update(NoticeVO vo) {
		int result = sql.update("notice.update", vo);
		return result;
	}
	
	//공지사항 삭제
	public int delete(NoticeVO vo) {
		int result = sql.delete("notice.delete", vo);
		return result;
	}
}
