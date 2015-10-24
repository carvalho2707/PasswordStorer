package pt.tiago.passwordstorer.vo;

import java.util.Vector;

public class PasswordVO extends Vector<String> {
	private static final long serialVersionUID = 4211662433294013345L;
	private String name;
	private String username;
	private String password;
	private String other;

	public PasswordVO(String name, String username, String password,
			String other) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.other = other;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
