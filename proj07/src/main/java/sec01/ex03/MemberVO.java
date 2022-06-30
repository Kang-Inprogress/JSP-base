package sec01.ex03;

import java.sql.Date;

// Value Object: DTO(Date Transfer Object)
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVO() {
		System.out.println("MemberVO()");
	}
	// get, set을 쓰는 이유가 해당 클래스의 값에 대한 접근을 제어할 수 있기 때문이다
	// 그래서 MemberDAO 에서 MemberVO 객체인 vo에서 일반 값에 접근하려고 했을 때 get과 set 외에 아무것도 뜨지않는 이유이다
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
