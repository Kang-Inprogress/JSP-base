package sec04.ex01;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

// HttpSessionBindingListener를 구현한 LoginImpl 클래스로 세션에 바인딩 시, 이벤트 처리를 함
public class LoginImpl implements HttpSessionBindingListener {
	String user_id;
	String user_pwd;
	static int total_user = 0;
	
	public LoginImpl() { //default constructor
		
	}
	
	public LoginImpl(String user_id, String user_pwd) { // 파라미터를 이용한 생성자
		this.user_id = user_id;
		this.user_pwd = user_pwd;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) { // login
		System.out.println("사용자가 접속 되었음");
		++total_user;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) { // logout
		System.out.println("사용자가 접속 해제 되었음");
		total_user--;
	}

}
