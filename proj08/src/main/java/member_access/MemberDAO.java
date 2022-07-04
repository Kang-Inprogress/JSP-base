package member_access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO {
	/*
	// 모두 /Server/context.xml 에서 설정을 완료함: Connection pool을 설정하기 위해서 변경
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@kanggane.ddns.net:1521:XE";
	//	private static final String url = "jdbc:oracle:thin:@//kanggane.ddns.net:1521/XE";
	private static final String user = "c##yeonu";
	private static final String pwd = "sksmsgkftndlTek";
	*/
	
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public MemberDAO() {
		// tomcat 공식에서 붙혀넣기함
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<MemberVO> listMembers() {
		// try 문에서 MemberVO 를 받기 위해서 List 생성
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
//			connDB();
			// 대신 connectionPool을 얻어오도록 한다 : 연결 성능 향상을 위해 사용
			con = dataFactory.getConnection();
			
			String query = "select * from t_members";
//			System.out.println("listMembers() called : PreparedStatement /" + query);
			
			// 미리 컴파일된 SQL문을 준비하는 객체: 재사용이 가능하기 때문에 자원 효율성 up(권장사항)
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// get[type]으로 받아올 컬럼의 데이터 값을 지정한다 
				String id = rs.getString("id"); 
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id); vo.setPwd(pwd); vo.setName(name); vo.setEmail(email); vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
			// 역순 free
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Exception addMember(MemberVO vo) {
		try {
			// DataSource를 이용해 미리 데이터베이스와 연결함
			con = dataFactory.getConnection();
			
			// vo에 데이터 삽입하고 Connection Pool 불러서 DB에 업데이트
			String query = "INSERT INTO t_members(id, pwd, name, email) VALUES (?, ?, ?, ?)"; // ?의 인덱스는 1부터 시작한다!
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
			pstmt.close();
//			System.out.println("addMember(MemverVO vo) called preparedStatement /" + query);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return e;
		}
		
	}

	public Exception delMember(String id) {
		try {
			con = dataFactory.getConnection();
			
			String query = "DELETE FROM t_members WHERE t_members.id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
//			System.out.println("delMember(MemberVO vo) called parparedStatement /" + query);
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e;
		}
	}
	
//	private void connDB() {
//		try {
//			// Load Oracle driver(jdbc)
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("connection 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
