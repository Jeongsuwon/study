package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import user.UserDAO;


public class NoticeDAO {

	PreparedStatement ps;
	ResultSet rs;
	NoticeVO noticeVO = new NoticeVO();
//	private UserVO userVO;
//
//    public NoticeDAO(UserVO userVO) {
//        this.userVO = userVO;
//    }
	
//	UserDAO dao = new UserDAO(); 초기화 선언하면 스택오버 루프 발생 //
	
	
	Scanner sc = new Scanner(System.in);
	Connection conn;
	UserDAO userDao;
	
	// 공지사항
	public void notice(UserDAO userDao) {
		this.userDao = userDao  ;
		while (true) {
			System.out.println("1.공지사항 목록");
			System.out.println("2.공지사항 작성");
			System.out.println("3.공지사항 수정");
			System.out.println("4.공지사항 삭제");
			System.out.println("5.종료");
			String choice = sc.nextLine();
			if (choice.equals("1")) {
				noticeList();
			} else if (choice.equals("2")) {
				notice_insert();
			} else if (choice.equals("3")) {
				notice_update();
			} else if (choice.equals("4")) {
				notice_delete();
			} else if (choice.equals("5")) {
				System.out.println("공지사항 기능을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}

	}

	// 공지사항 목록
	public void noticeList() {
		try {
			conn = userDao.getConn();
			ps = conn.prepareStatement("SELECT * FROM NOTICE_TBL order by id desc");
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("현재 작성된 공지사항이 없습니다.");
			} else {
				System.out.println("글번호     제목     내용     작성자");
				while (rs.next()) {
					System.out.print(rs.getString("id") + "\t");
					System.out.print(rs.getString("TITLE") + "\t");
					System.out.print(rs.getString("CONTENT") + "\t");
					System.out.print(rs.getString("WRITER"));
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public void notice_insert() {
		try {
			while(true) {
				
			
			conn = userDao.getConn();
			System.out.println("글번호:");
			String id = sc.nextLine();

			ps = conn.prepareStatement("SELECT id FROM NOTICE_TBL WHERE id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("이미 있는 글 번호입니다.");
				noticeList();
				continue;
			} else {
				
				ps = conn.prepareStatement("select firstname, lastname from user_tbl");
				rs = ps.executeQuery();
				if (rs.next()) {

//					System.out.println("글번호:");
//					String id = sc.nextLine();
					noticeVO.setId(id);
					System.out.print("제목:");
					String title = sc.nextLine();
					noticeVO.setTitle(title);
					System.out.println("내용:");
					String content = sc.nextLine();
					noticeVO.setContent(content);
					noticeVO.setWriter(rs.getString("firstname") + rs.getString("lastname"));

					ps = conn.prepareStatement("INSERT INTO NOTICE_TBL VALUES(?,?,?,?)");
					ps.setString(1, noticeVO.getId());
					ps.setString(2, noticeVO.getTitle());
					ps.setString(3, noticeVO.getContent());
					ps.setString(4, noticeVO.getWriter());
					ps.executeUpdate();
					System.out.println("새 공지사항이 등록되었습니다.");
				}
			}
			break;
			}
		} catch (Exception e) {
			System.out.println("오류" + e.getMessage());
		} finally {
			dbClose();
		}

	}

	public void notice_update() {
		try {
			while (true) {
				noticeList();

				System.out.println("수정하실 글의 번호를 입력해주세요");
				System.out.println("0.취소");
				String updateChoice = sc.nextLine();

				if (updateChoice.equals("0")) {
					System.out.println("취소되었습니다.");
					break;
				}

				conn = userDao.getConn();
				ps = conn.prepareStatement("SELECT * FROM NOTICE_TBL WHERE id = ?");
				ps.setString(1, updateChoice);
				rs = ps.executeQuery();

				if (rs.next()) {
					while (true) {
						System.out.println("1.제목수정");
						System.out.println("2.내용수정");
						System.out.println("3.취소");
						String update_menu = sc.nextLine();

						if (update_menu.equals("1")) {
							System.out.println("수정할 제목을 입력하세요.");
							String title = sc.nextLine();
							ps = conn.prepareStatement("UPDATE NOTICE_TBL SET TITLE = ? WHERE id = ?");
							ps.setString(1, title);
							ps.setString(2, updateChoice);
							ps.executeUpdate();
							System.out.println("제목이 수정되었습니다.");
						} else if (update_menu.equals("2")) {
							System.out.println("수정할 내용을 입력하세요.");
							String content = sc.nextLine();
							ps = conn.prepareStatement("UPDATE NOTICE_TBL SET CONTENT = ? WHERE id = ?");
							ps.setString(1, content);
							ps.setString(2, updateChoice);
							ps.executeUpdate();
							System.out.println("내용이 수정되었습니다.");
						} else if (update_menu.equals("3")) {
							System.out.println("취소되었습니다.");
							break;
						} else {
							System.out.println("잘못된 입력입니다.");
							continue;
						}
					}
				}

				// 수정 작업 후 목록을 다시 최신화
				noticeList();
				break;
			}
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	// 공지사항 삭제
	public void notice_delete() {
		try {
			while (true) {
				noticeList();

				System.out.println("삭제하실 글의 번호를 입력해주세요 (0번 취소)");
				String deleteChoice = sc.nextLine();

				if (deleteChoice.equals("0")) {
					System.out.println("취소되었습니다.");
					break;
				}

				conn = userDao.getConn();
				ps = conn.prepareStatement("delete from notice_tbl where id = ?");
				ps.setString(1, deleteChoice);
				int result = ps.executeUpdate();

				if (result > 0) {
					System.out.println("해당 글이 삭제되었습니다.");
				} else {
					System.out.println("일치하는 글 번호가 없습니다.");
				}
			}
		} catch (Exception e) {
			System.out.println("오류" + e.getMessage());
		} finally {
			dbClose();
		}
	}

	// db연동
//	public Connection getConn() {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(url, "c##jsw", "0000");
//		} catch (Exception e) {
//			System.out.println("연결 오류");
//		}
//		return conn;
//
//	}

	public void dbClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
