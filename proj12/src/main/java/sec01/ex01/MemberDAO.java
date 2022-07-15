package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	PreparedStatement pstmt;
	DataSource ds;
	Connection conn;
	
	public MemberDAO() {
		try {
			// From Tomcat 10.0.0 document
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/oracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembersByid(MemberVO memvo) {
		String name = memvo.getId();
		List<MemberVO> uList = new ArrayList<>();
		ResultSet rs;
		try {
			String query = "SELECT * FROM t_members ";
			pstmt = conn.prepareStatement(query);
			if (name != null && name.length() != 0) {
				query += "WHERE name=?";
				pstmt.setString(1, name);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				rs.next();
				MemberVO resultMember = new MemberVO();
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String mName = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				resultMember.setId(id); resultMember.setPwd(pwd); resultMember.setName(mName);resultMember.setEmail(email);resultMember.setJoinDate(joinDate);
				uList.add(resultMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uList;
	}
}
