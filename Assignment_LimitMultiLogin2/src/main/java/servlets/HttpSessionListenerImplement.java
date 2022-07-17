package servlets;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSessionListenerImplement
 *
 */
public class HttpSessionListenerImplement implements HttpSessionListener {
	HttpSessionListenerImplement hsli;
	private String id;
	private String pwd;
	static int user_count = 0; // 이 클래스 간의 공통의 접근 가능 변수
	private final int login_limit = 4;
	private int current_login;
	
	public HttpSessionListenerImplement() {
		// no
    }
    public HttpSessionListenerImplement(String id, String pwd) {
    	this.id = id;
    	this.pwd = pwd;
    	current_login = 1;
    }
    
    public String getId() {
    	return id;
    }
    public int getCL() {
    	return current_login;
    }
    public void setCL(int cl) {
    	current_login = cl;
    }
    
    public boolean isLimit() {
    	if(current_login < login_limit) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
	@Override
	public void sessionCreated(HttpSessionEvent se) { // 세션에 연결됨을 감지
		user_count++;
		current_login++;
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) { // 세션 소멸
		user_count--;
		current_login--;
	}
	
}
