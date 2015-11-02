package main.java.pt.tiago.passwordstorer.bo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import main.java.pt.tiago.passwordstorer.dao.ResultsDAO;
import main.java.pt.tiago.passwordstorer.util.CipherUtils;
import main.java.pt.tiago.passwordstorer.util.PasswordVOComparator;
import main.java.pt.tiago.passwordstorer.vo.PasswordVO;

public class PresentationBO {

	public static Vector<Vector<String>> getDomain() {
		List<PasswordVO> passwordList = ResultsDAO.getAllData2();
		for (PasswordVO passVo : passwordList) {
			String decrupted;
			try {
				decrupted = CipherUtils.decrypt(passVo.getPassword());
				passVo.setPassword(decrupted);
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(passwordList, new PasswordVOComparator());
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		Vector<String> temp;
		for (PasswordVO pass : passwordList) {
			temp = pass.getAsVector();
			rows.add(temp);
		}
		return rows;
	}

	public static Vector<Vector<String>> searchData(String name,
			String username, String others) {
		List<PasswordVO> passwordList = ResultsDAO.getAllData2();
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		Vector<String> temp;
		for (PasswordVO passVo : passwordList) {
			String decrupted;
			try {
				decrupted = CipherUtils.decrypt(passVo.getPassword());
				passVo.setPassword(decrupted);
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				e.printStackTrace();
			}
		}
		for (PasswordVO data : passwordList) {
			if ((!name.isEmpty() && data.getName().contains(name))
					|| (!username.isEmpty() && data.getUsername().contains(
							username))
					|| (!others.isEmpty() && data.getOther().contains(others))) {
				temp = data.getAsVector();
				rows.add(temp);
			}
		}
		return rows;
	}

	public static void saveFile(Vector<Vector<String>> data) {
		PasswordVO passwordVO;
		List<PasswordVO> domainList = new ArrayList<PasswordVO>();
		for (Vector<String> row : data) {
			passwordVO = new PasswordVO(row.elementAt(0), row.elementAt(1),
					row.elementAt(2), row.elementAt(3));
			String encrypted = null;
			try {
				encrypted = CipherUtils.encrypt(passwordVO.getPassword());
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			passwordVO.setPassword(encrypted);
			domainList.add(passwordVO);
		}
		ResultsDAO.saveFile(domainList);
	}

}
