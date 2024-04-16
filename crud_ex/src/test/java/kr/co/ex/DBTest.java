package kr.co.ex;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class DBTest {

//	@Autowired
//	private SqlSession sql;

	@Autowired
	private DataSource ds;

//	@Test
//	public void connect() throws Exception {
//		try {
//			sql.getConnection();
//			System.out.println("DB 연결 성공: ");
//		} catch (Exception e) {
//			System.out.println(e.getMessage() + "DB 연결 실패");
//		}
//	}

	@Test
	public void connect() throws Exception {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println("DB 연결 성공: " + conn);
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "DB 연결 실패");
		} finally {
			conn.close();
			System.out.println();
		}
	}
}
