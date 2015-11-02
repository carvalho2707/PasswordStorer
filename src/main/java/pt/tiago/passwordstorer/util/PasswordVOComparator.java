package main.java.pt.tiago.passwordstorer.util;

import java.util.Comparator;

import main.java.pt.tiago.passwordstorer.vo.PasswordVO;

public class PasswordVOComparator implements Comparator<PasswordVO> {

	@Override
	public int compare(PasswordVO o1, PasswordVO o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
