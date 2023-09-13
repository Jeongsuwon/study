package com.example.first.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.first.vo.UserVO;

@Repository
public class UserDAO {
	@Autowired private SqlSession sql;
	
	public int register(UserVO vo) {
		int result = sql.insert("register", vo);
		return result;
	}
}
