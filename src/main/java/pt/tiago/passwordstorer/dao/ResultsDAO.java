package main.java.pt.tiago.passwordstorer.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Vector;

import main.java.pt.tiago.passwordstorer.util.Constants;
import main.java.pt.tiago.passwordstorer.vo.PasswordVO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

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

	public static List<PasswordVO> getAllData2() {
		final Type REVIEW_TYPE = new TypeToken<List<PasswordVO>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = null;
		try {
			reader = new JsonReader(new FileReader(Constants.FILE_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<PasswordVO> data = gson.fromJson(reader, REVIEW_TYPE);
		return data;
	}
}
