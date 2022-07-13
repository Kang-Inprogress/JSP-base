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
	static int user_count = 0;
	
	public HttpSessionListenerImplement() {
		
    }
    public HttpSessionListenerImplement(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
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
