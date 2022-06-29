package sec01.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// DB 연결에 필요한 정보
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "c##yeonu";
	private static final String pwd = "sksmsgkftndlTek";

	private Statement stmt;
	private Connection con;

	// 커스텀 메서드
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>(); // abstract list: parent of ArrayList, Vector, etc.

		try {
			// try to connect DB
			connDB();

			// SQL 변수에 저장
			String query = "select * from t_members"; // SQL문을 저장할 때 세미콜론은 제외해도됨
			System.out.println("query");

			// SQL 결과를 변수에 저장
			ResultSet rs = stmt.executeQuery(query);

			// 결과 출력
			while (rs.next()) {
				String id = rs.getString("id"); // "id"라는 컬럼의 값을 id 변수에 삽입
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String joindate = rs.getString("joinDate");

				// 정보 저장을 위한 객체생성(여기서는 MemberVO)
				MemberVO vo = new MemberVO();

				// 생성자를 호출 할 때 한번에 넣는 방법도 있지만..null인 경우는 에러처리가 힘들기 때문에 set 노가다를 시작한다
				vo.setId(id);
				vo.setEmail(email);
				vo.setJoinDate(joindate);
				vo.setName(name);
				vo.setPwd(pwd);

				list.add(vo); // ArrayList 조회 결과 저장된 회원(한 개의 vo)을 추가하게 됨
			}
			rs.close();
			stmt.close();
			con.close();// 리소스를 위해 역순으로 객체들을 반납
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list; // 여러 회원의 정보가 저장된 리스트 반환
	}

	// DB 연결
	private void connDB() {
		try {
			// Load Oracle driver(jdbc)
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("connection 성공");

			// SQL문을 저장하고 삽입
			stmt = con.createStatement();
			System.out.println("Statement 객체 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
