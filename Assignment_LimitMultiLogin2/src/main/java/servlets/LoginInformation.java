package servlets;

public class LoginInformation {
	String user_name;
	int current_login;
	
	public LoginInformation(String name, int cl) {
		user_name = name;
		current_login = cl;
	}
}
