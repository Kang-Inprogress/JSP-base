package servlets;

public class LoginInformation {
	private String user_name;
	int current_login = 0;
	
	public LoginInformation(String name) {
		user_name = name;
		current_login++;
	}
	
	public String getId() {
		return user_name;
	}
	
	public boolean isLimit() {
		if(current_login < 4) { // login limit is 4
			return false;
		} else {
			return true;
		}
	}
}
