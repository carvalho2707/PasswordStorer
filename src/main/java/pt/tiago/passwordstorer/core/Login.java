package main.java.pt.tiago.passwordstorer.core;

import main.java.pt.tiago.passwordstorer.util.Constants;

public class Login {

	public static boolean authenticate(String username, String password) {
		return username.equals(Constants.USERNAMEE)
				&& password.equals(Constants.PASSWORD);
	}

}
