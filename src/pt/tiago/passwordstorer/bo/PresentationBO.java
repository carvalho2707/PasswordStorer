package pt.tiago.passwordstorer.bo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import pt.tiago.passwordstorer.util.Constants;
import pt.tiago.passwordstorer.vo.PasswordVO;

public class PresentationBO {

	public static List<PasswordVO> getDomain() {
		BufferedReader br = null;
		List<PasswordVO> accountList = new ArrayList<PasswordVO>();
		PasswordVO temp;
		String nameTemp;
		String usernameTemp;
		String passwordTemp;
		String othersTemp;
		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(Constants.FILE_PATH)));
			String line;
			while ((line = br.readLine()) != null) {
				String[] lineTemp = line.split("$");
				if(lineTemp.length < 4){
					throw new IOException();
				}
				temp = new PasswordVO(lineTemp[0], lineTemp[1], lineTemp[2], lineTemp[3]);
				accountList.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return accountList;

	}

}
