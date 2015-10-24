package pt.tiago.passwordstorer.dao;

import java.util.Vector;

import pt.tiago.passwordstorer.vo.PasswordVO;

public class ResultsDAO {

	/**
	 * This function goes to the database
	 * 
	 * @return
	 */
	public static Vector<Vector<String>> getAllData() {
		// TODO access db
		PasswordVO data;
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		Vector<String> temp;
		for (int i = 0; i < 30; i++) {
			data = new PasswordVO("Site" + i, "Username" + i, "Pass" + i,
					"Other" + i);
			temp = data.getAsVector();
			rows.add(temp);
		}
		return rows;
	}

	public static Vector<Vector<String>> searchData(String name,
			String username, String others) {
		PasswordVO data;
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		Vector<String> temp;
		for (int i = 0; i < 30; i++) {
			data = new PasswordVO("Site" + i, "Username" + i, "Pass" + i,
					"Other" + i);
			if (!name.isEmpty() && data.getName().contains(name)) {
				temp = data.getAsVector();
				rows.add(temp);
			}
			if (!username.isEmpty() && data.getUsername().contains(name)) {
				temp = data.getAsVector();
				rows.add(temp);
			}
			if (!others.isEmpty() && data.getOther().contains(others)) {
				temp = data.getAsVector();
				rows.add(temp);
			}
		}
		return rows;
	}

}
