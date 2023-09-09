package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import notice.NoticeDAO;

public class UserDAO {

	UserDAO userDao ;
	Scanner sc = new Scanner(System.in);
	private UserVO vo = new UserVO();
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
    NoticeDAO noticeDAO = new NoticeDAO();
	static int login_state = 0;
	
	public void login_state(UserDAO userDao) {
		this.userDao = userDao;
		if(login_state == 0) {
			menu();
		}else {
			loginMenu();
		}
	}
	
	
	//로그인이 되기 전 메뉴
	public void menu() {
		while(true) {			
		System.out.println("0.종료");
		System.out.println("1.로그인");
		System.out.println("2.회원가입");		
		String choice = sc.nextLine();
		if(choice.equals("1")) {
			login();
		}else if(choice.equals("2")) {
			register();
		}else if(choice.equals("0")) {
			break;
		}else {
			System.out.println("잘못된 입력입니다.");
			continue;
		}
		System.out.println("프로그램을 종료합니다.");
		break;
		}
	}
	
	//로그인 된 상태의 메뉴
	public void loginMenu() {
		while(true) {
			
		System.out.println("0.종료");
		System.out.println("1.로그아웃");
		System.out.println("2.회원정보수정");
		System.out.println("3.회원탈퇴");
		System.out.println("4.공지사항보기");
		String choice = sc.nextLine();
		if(choice.equals("0")) {
			break;
		}else if(choice.equals("1")) {
			logout();
		}else if(choice.equals("2")) {
			update();
		}else if(choice.equals("3")) {
			delete();
		}else if(choice.equals("4")) {
			noticeDAO.notice(userDao);
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		}
	}
	
	//회원가입
	public void register() {
		System.out.println("회원가입을 진행합니다.");
		while(true) {
			System.out.print("아이디를 입력: ");
			String user_id = sc.nextLine();
			
			//아이디 중복 체크
			boolean isCheck = isCheckId(user_id); 
			if(isCheck) {
				System.out.println("이미 사용중인 아이디입니다.");
				continue;
			}else {
				vo.setUser_id(user_id);
			}
			System.out.print("비밀번호를 입력: ");
			String user_pw = sc.nextLine();
			vo.setUser_pw(user_pw);
			System.out.print("성을 입력: ");
			String firstname = sc.nextLine();
			vo.setFirstname(firstname);
			System.out.print("이름을 입력: ");
			String lastname = sc.nextLine();
			vo.setLastname(lastname);
			
			//구글링을 통해 현재 날짜 가져오는 클래스 사용
			//LocalDate 클래스를 사용하여 현재 날짜 조회
			LocalDate currentDate = LocalDate.now();
			//날짜형식변환
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        //Date형 데이터를 String형으로 변환
	        String formattedDate = currentDate.format(formatter);
			vo.setCreate_ymd(formattedDate);
			vo.setUpdate_ymd(formattedDate);
			break;
		}
		System.out.println("아이디: " + vo.getUser_id());
		System.out.println("비밀번호: " + vo.getUser_pw());
		System.out.println("성: " + vo.getFirstname());
		System.out.println("이름: " + vo.getLastname());
		System.out.println("회원가입이 완료되었습니다.");
		try {
			conn = getConn();
			ps = conn.prepareStatement("INSERT INTO USER_TBL VALUES(?,?,?,?,?,?)");
			ps.setString(1, vo.getUser_id());
			ps.setString(2, vo.getUser_pw());
			ps.setString(3, vo.getFirstname());
			ps.setString(4, vo.getLastname());
			ps.setString(5, vo.getCreate_ymd());
			ps.setString(6, vo.getUpdate_ymd());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류");
		}finally{
			dbClose();
		}
		login_state(userDao);
	}
	
	
	
	
	//회원정보수정
	public void update() {
		String user_pw;
		
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT * FROM USER_TBL WHERE USER_PW = ? and USER_ID = ?");
			System.out.println("비밀번호를 한 번 더 입력해주세요");
			user_pw = sc.nextLine();
			ps.setString(1, user_pw);
			ps.setString(2, vo.getUser_id());
			rs = ps.executeQuery();
			if(rs.next()) {
				while(true) {
					ps = conn.prepareStatement("SELECT * FROM USER_TBL WHERE USER_ID = ?");
					ps.setString(1, vo.getUser_id());
					rs = ps.executeQuery();
					if(rs.next()){	
					System.out.println("1.비밀번호 :"+rs.getString("USER_PW"));
					System.out.println("2.성:" + rs.getString("FIRSTNAME"));
					System.out.println("3.이름:" + rs.getString("LASTNAME"));
					System.out.println("4.수정완료");
					
					System.out.println("수정하실부분의 번호를 입력해주세요.");
					String update_select = sc.nextLine();
					if(update_select.equals("1")) {
						System.out.println("수정하실 비밀번호를 입력해주세요.");
						String chg_userPw = sc.nextLine();
						ps = conn.prepareStatement("UPDATE USER_TBL SET USER_PW = ? WHERE USER_ID = ?");
						ps.setString(1, chg_userPw);
						ps.setString(2, vo.getUser_id());
						ps.executeUpdate();
						System.out.println("수정이 완료되었습니다.");
					}else if(update_select.equals("2")) {
						System.out.println("수정하실 성을 입력해주세요.");
						String chg_firstName = sc.nextLine();
						ps = conn.prepareStatement("UPDATE USER_TBL SET FIRSTNAME = ? WHERE USER_ID = ?");
						ps.setString(1, chg_firstName);
						ps.setString(2, vo.getUser_id());
						ps.executeUpdate();
						System.out.println("수정이 완료되었습니다.");
					}else if(update_select.equals("3")) {
						System.out.println("수정하실 이름을 입력해주세요.");
						String chg_lastName = sc.nextLine();
						ps = conn.prepareStatement("UPDATE USER_TBL SET LASTNAME = ? WHERE USER_ID = ?");
						ps.setString(1, chg_lastName);
						ps.setString(2, vo.getUser_id());
						ps.executeUpdate();
						System.out.println("수정이 완료되었습니다.");
					}else if(update_select.equals("4")) {
						System.out.println("정보수정을 종료합니다.");
						break;
					}
					
					else {
						System.out.println("잘못된 입력입니다.");
					}
					
					
					}
				}
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("오류");
		} finally {
			dbClose();
		}
	}
	
	//회원탈퇴
	public void delete() {
		String user_id, user_pw, choice;
		System.out.println("회원탈퇴 전 아이디와 비밀번호를 한 번 더 입력해주세요.");
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT USER_ID, USER_PW FROM USER_TBL WHERE USER_ID = ? AND USER_PW = ?");
			System.out.print("아이디:");
			user_id = sc.nextLine();
			ps.setString(1, user_id);
			System.out.print("비밀번호:");
			user_pw = sc.nextLine();
			ps.setString(2, user_pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				while(true) {
					
				System.out.println("1. 회원탈퇴 / 2.취소");
				choice = sc.nextLine();
				if(choice.equals("1")) {
					ps = conn.prepareStatement("DELETE FROM USER_TBL WHERE USER_ID = ? and USER_PW = ?");
					ps.setString(1, vo.getUser_id());
					ps.setString(2, vo.getUser_pw());
					ps.executeUpdate();
					System.out.println("회원탈퇴가 완료되었습니다.");
					login_state = 0;
					login_state(userDao);
					
				}else if(choice.equals("2")) {
					break;
				}else {
					System.out.println("잘못된 선택입니다.");
					continue;
				}
				break;
				}
			}else {
				System.out.println("회원탈퇴에 실패했습니다. 아이디 또는 비밀번호를 확인해주세요. ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//중복아이디 체크
	private boolean isCheckId(String user_id) {
		boolean isResult = false;
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT USER_ID FROM USER_TBL WHERE USER_ID = ?");
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				isResult= true;
			}
		}catch(Exception e) {
			System.out.println("오류 발생");
		}finally {
			dbClose();
		}
		
		return isResult;
	}
	
	//로그인
	public void login() {
		String user_id, user_pw;
		int loginCnt = 0;
		while(loginCnt < 3) {
		System.out.print("아이디를 입력:");
		user_id = sc.nextLine();
		System.out.println("비밀번호를 입력:");
		user_pw = sc.nextLine();
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT USER_ID, USER_PW FROM USER_TBL WHERE USER_ID = ? AND USER_PW = ?");
			ps.setString(1, user_id);
			ps.setString(2, user_pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("로그인에 성공하였습니다.");
				login_state = 1;
				vo.setUser_id(user_id);
				vo.setUser_pw(user_pw);

				login_state(userDao);
				break;
			}else {
				loginCnt++;
				System.out.println("아이디 또는 비밀번호를 확인해주세요. "+ loginCnt +"회(3회 실패시 프로젝트 종료)");
				
				continue;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		}
		if(loginCnt>=3) {
			System.out.println("3번의 로그인 실패로 프로그램이 종료됩니다.");
		}
		
	}
	
	
	//로그아웃
	public void logout() {
		System.out.println("로그아웃이 되었습니다.");
		login_state = 0;
		vo.setUser_id(null);
		vo.setUser_pw(null);
		login_state(userDao);
	}
	
	
	

	
	
	//db연동
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "c##jsw", "0000");
		}catch(Exception e) {
		System.out.println("연결 오류");
		}
		return conn;
		
	}
	
	//스프링에서는 알아서 해주지만 순수 자바에서는 성능저하 방지를 위해 실행
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}if(ps != null) {
				ps.close();
			}if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateYMD() {
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 포맷을 원하는 대로 설정
        String formattedDate = currentDate.format(formatter);
		try {
			conn = getConn();
			ps = conn.prepareStatement("UPDATE USER_TBL SET UPDATE_YMD = SYSDATE WHERE user_id = ?");
			ps.setString(1, vo.getUser_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbClose();
		}
	}
	
	
	
}
