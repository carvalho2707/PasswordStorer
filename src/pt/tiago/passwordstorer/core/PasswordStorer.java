package pt.tiago.passwordstorer.core;

import java.awt.EventQueue;

import pt.tiago.passwordstorer.presentation.MainScreenFrame;

public class PasswordStorer {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainScreenFrame mainScreen = new MainScreenFrame();
				mainScreen.init();
			
			}
		});

	}

}
