package main;

import user.UserDAO;

public class main {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");	
		UserDAO userDao = new UserDAO();
		userDao.login_state(userDao);
	}
	
}
