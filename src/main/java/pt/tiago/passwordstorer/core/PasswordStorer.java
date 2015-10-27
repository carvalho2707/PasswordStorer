package main.java.pt.tiago.passwordstorer.core;

import java.awt.EventQueue;

import main.java.pt.tiago.passwordstorer.presentation.MainScreenFrame;

public class PasswordStorer {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				@SuppressWarnings("unused")
				MainScreenFrame mainScreen = new MainScreenFrame();
			}
		});

	}

}
