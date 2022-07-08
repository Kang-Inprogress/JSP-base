package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource ds;
	
	public MemberDAO() {
		try {
		// DB 연동 코드
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExist(MemberVO vo) {
		boolean result = false;
		String id = vo.getId();
		String pwd = vo.getPwd();
		String query = "SELECT decode(count(id), 1, 'true', 'false') AS RESULT FROM t_members WHERE id=? AND pwd=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			rs.next(); // 헤더가 데이터가 들어있는 부분을 가르키지 않기 때문에 메소드를 사용
			// 조회된 값의 result 컬럼의 값을 가져온 후 Boolean으로 변환함
			result = Boolean.parseBoolean(rs.getString("result"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<MemberVO> listMember() {
		return null;
	}
	public void addMember(MemberVO vo) {
		
	}
	public void delMember(MemberVO vo) {
		
	}
		
}
