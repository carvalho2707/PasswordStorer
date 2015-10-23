package pt.tiago.passwordstorer.presentation;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pt.tiago.passwordstorer.util.Constants;

public class MainScreenFrame extends JFrame {

	private static final long serialVersionUID = -277290881388427529L;

	public void init() {
		setTitle(Constants.APP_NAME);
		setSize(Constants.WINDOW_WDTH, Constants.WINDOW_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		LoginDialog loginDlg = new LoginDialog(MainScreenFrame.this);
		loginDlg.setVisible(true);


		setLayout(new FlowLayout());

		String data[][] = { { "101", "Amit", "670000" },
				{ "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };

		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 300);

		JScrollPane sp = new JScrollPane(jt);
		add(sp);
		setVisible(true);
	}

}
