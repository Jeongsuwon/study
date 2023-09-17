package com.example.first.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.first.vo.NoticeVO;

@Repository
public class NoticeDAO {
	@Autowired private SqlSession sql;
	
	public List<NoticeVO> list(){
		List<NoticeVO> list = sql.selectList("notice.list");
		return list;
	}
	
	public int insert(NoticeVO vo) {
		int result = sql.insert("notice.insert", vo);
		return result;
	}
	
	public NoticeVO info(Integer id) {
		
		return sql.selectOne("notice.info", id);
	}
}
