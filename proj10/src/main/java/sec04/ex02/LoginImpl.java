package sec04.ex02;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pwd;
	static int total_user = 0;
	
    @Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("세션 생성");
		++total_user;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("세션 소멸");
		--total_user;
	}

    public LoginImpl() {
    	this.user_id = "";
        this.user_id = "";
    }
    
    public LoginImpl(String user_id, String user_pwd) {
    	System.out.println("매개변수 생성자 호출");
        this.user_id = user_id;
        this.user_pwd = user_pwd;
    }
}
