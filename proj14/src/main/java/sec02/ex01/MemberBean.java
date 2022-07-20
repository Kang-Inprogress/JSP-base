package sec02.ex01;

import java.sql.Date;

public class MemberBean {
	private String id;
	private String pwd;
	private String email;
	private String name;
	private String joinDate;
	private Address addr;
	
	public MemberBean() {
		System.out.println("memberbean");
	}
	
	public MemberBean(String id, String pwd, String email, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getJoinDate() {
		return joinDate;
	}
	// Address getter & setter

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", addr=" + addr + "]";
	}
	
}
