package main.java.pt.tiago.passwordstorer.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import main.java.pt.tiago.passwordstorer.util.Constants;
import main.java.pt.tiago.passwordstorer.vo.PasswordVO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class ResultsDAO {

	public static List<PasswordVO> getAllData2() {
		final Type REVIEW_TYPE = new TypeToken<List<PasswordVO>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = null;
		try {
			reader = new JsonReader(new FileReader(Constants.FILE_PATH_TRUE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<PasswordVO> data = gson.fromJson(reader, REVIEW_TYPE);
		return data;
	}

	public static void saveFile(List<PasswordVO> domainList) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(domainList);

		FileWriter writer;
		try {
			writer = new FileWriter(Constants.FILE_PATH_TRUE);
			writer.write(jsonString);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
