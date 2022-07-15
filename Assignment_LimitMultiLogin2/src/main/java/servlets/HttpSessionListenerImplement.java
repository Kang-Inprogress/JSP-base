package servlets;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSessionListenerImplement
 *
 */
public class HttpSessionListenerImplement implements HttpSessionListener {
	private String id;
	private String pwd;
	static int user_count = 0; // 이 클래스 간의 공통의 접근 가능 변수
	private final int login_limit = 4;
	private int current_login = 0;
	
	public HttpSessionListenerImplement() {
		// no
    }
    public HttpSessionListenerImplement(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }
    public boolean isLimit() { // 현재 로그인한 이력이 있을 때 몇 군데에서 로그인이 되었는가 확인
    	if(current_login < login_limit) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    public String getId() {
    	return id;
    }
    
	@Override
	public void sessionCreated(HttpSessionEvent se) { // 세션에 연결됨을 감지
		user_count++;
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) { // 세션 소멸
		user_count--;
	}
	
}
