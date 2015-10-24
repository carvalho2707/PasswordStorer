package pt.tiago.passwordstorer.dao;

import java.util.Vector;

import pt.tiago.passwordstorer.vo.PasswordVO;

public class ResultsDAO {

	/**
	 * This function goes to the database
	 * @return
	 */
	public static Vector<PasswordVO> getAllData() {
		// TODO access db
		PasswordVO data;
		String[][] finalLista = null;
		Vector<PasswordVO> lista = new Vector<PasswordVO>();
		for(int i = 0 ;  i < 10; i++){
			data = new PasswordVO("Site" + i, "Username" + i, "Pass" + i , "Other"  + i);
			lista.add(data);
		}
		return lista;
	}

}
