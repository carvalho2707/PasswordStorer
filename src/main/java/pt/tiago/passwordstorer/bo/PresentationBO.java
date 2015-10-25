package main.java.pt.tiago.passwordstorer.bo;

import java.util.List;
import java.util.Vector;

import main.java.pt.tiago.passwordstorer.dao.ResultsDAO;
import main.java.pt.tiago.passwordstorer.vo.PasswordVO;

public class PresentationBO {

	public static Vector<Vector<String>> getDomain() {
		List<PasswordVO> passwordList = ResultsDAO.getAllData2();
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		Vector<String> temp;
		for (PasswordVO pass : passwordList) {
			temp = pass.getAsVector();
			rows.add(temp);
		}
		return rows;
	}

}
