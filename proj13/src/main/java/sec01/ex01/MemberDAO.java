package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection conn;
	DataSource ds;
	
	public MemberDAO() {
		System.out.println("MemberDAO 생성");
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMembers(MemberBean mBean) {
		try {
			conn = ds.getConnection();
			PreparedStatement pstmt;
			String query = "INSERT INTO t_members(id, pwd, name, email) VALUES (?, ?, ?, ?)"; // space needed
			String id = mBean.getId();
			String pwd = mBean.getPwd();
			String email = mBean.getEmail();
			String name = mBean.getName();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeQuery(); // return 1: success
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<MemberBean> listMembers() {
		List<MemberBean> resultList = new ArrayList<MemberBean>(); // null로 이니셜라이징 하면 안되나?
		try {
			conn = ds.getConnection();
			String query = "SELECT * FROM t_members"; // space needed
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String joinDate = rs.getString("joinDate");
				
				MemberBean mb = new MemberBean();
				mb.setId(id); 
				mb.setName(name);
				mb.setEmail(email);
				mb.setPwd(pwd);
				mb.setJoinDate(joinDate);
				
				resultList.add(mb);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
}
