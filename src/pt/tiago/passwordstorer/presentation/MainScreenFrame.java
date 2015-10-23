package pt.tiago.passwordstorer.presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pt.tiago.passwordstorer.util.Constants;

public class MainScreenFrame extends JFrame {
	private static final long serialVersionUID = 1897728166830013009L;
	public JPanel mainPanel;
	public JPanel allPanel;
	public JPanel searchJPanel;
	public JPanel deletePanel;
	public JPanel addPanel;

	public MainScreenFrame() {
		setTitle(Constants.APP_NAME);
		setSize(Constants.WINDOW_WDTH, Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		LoginDialog loginDlg = new LoginDialog(MainScreenFrame.this);
		// false - test
		loginDlg.setVisible(false);

		JButton btnAdd = new JButton(Constants.BUTTON_ADD);
		JButton btnSearch = new JButton(Constants.BUTTON_SEARCH);
		JButton btnDelete = new JButton(Constants.BUTTON_DELETE);
		JButton btnAll = new JButton(Constants.BUTTON_ALL);

		// create grid layout with 3 rows , 2 columns with horizontal
		// and vertical gap set to 10
		mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		// add buttons to the panel
		mainPanel.add(btnAdd);
		mainPanel.add(btnSearch);
		mainPanel.add(btnDelete);
		mainPanel.add(btnAll);

		getContentPane().add(mainPanel);
		mainPanel.setVisible(true);

		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.allPanel = new AllPanel(
						MainScreenFrame.this);
			}
		});

		setVisible(true);

	}

	public void init() {
		setTitle(Constants.APP_NAME);
		setSize(Constants.WINDOW_WDTH, Constants.WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		LoginDialog loginDlg = new LoginDialog(MainScreenFrame.this);
		// false - test
		loginDlg.setVisible(false);

		JButton btnAdd = new JButton(Constants.BUTTON_ADD);
		JButton btnSearch = new JButton(Constants.BUTTON_SEARCH);
		JButton btnDelete = new JButton(Constants.BUTTON_DELETE);
		JButton btnAll = new JButton(Constants.BUTTON_ALL);

		// create grid layout with 3 rows , 2 columns with horizontal
		// and vertical gap set to 10
		mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		// add buttons to the panel
		mainPanel.add(btnAdd);
		mainPanel.add(btnSearch);
		mainPanel.add(btnDelete);
		mainPanel.add(btnAll);

		getContentPane().add(mainPanel);
		mainPanel.setVisible(true);

		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.allPanel = new AllPanel(
						MainScreenFrame.this);
			}
		});

		setVisible(true);
	}

}
