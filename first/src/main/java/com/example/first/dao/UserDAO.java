package com.example.first.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.first.vo.UserVO;

@Repository
public class UserDAO {
	@Autowired private SqlSession sql;
	
	public int register(UserVO vo) {
		int result = sql.insert("user.register", vo);
		return result;
	}

	public UserVO login(HashMap<String, Object> params) {
		UserVO vo = sql.selectOne("user.login", params);
		return vo;
	}
	
	public int update(UserVO vo) {
		int result = sql.update("user.user_update", vo);
		return result;
	}
	
	public UserVO info(String user_id) {
		return sql.selectOne("user.info", user_id);
	}
	
}
