package pt.tiago.passwordstorer.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pt.tiago.passwordstorer.util.Constants;

public class MainScreenFrame extends JFrame {
	private static final long serialVersionUID = 1897728166830013009L;
	public JPanel mainPanel;
	public JPanel allPanel;
	public JPanel searchPanel;
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

		// create grid layout with 3 rows , 2 columns with horizontal
		// and vertical gap set to 10
		mainPanel = new JPanel();

		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Password Storer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 40, 440, 96);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setForeground(Color.ORANGE);
		mainPanel.add(lblNewLabel);

		JButton btnAdd = new JButton(Constants.BUTTON_ADD);
		btnAdd.setBounds(31, 334, 101, 34);
		// add buttons to the panel
		mainPanel.add(btnAdd);
		JButton btnSearch = new JButton(Constants.BUTTON_SEARCH);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.searchPanel = new SearchPanel(MainScreenFrame.this);
			}
		});
		btnSearch.setBounds(142, 334, 83, 34);
		mainPanel.add(btnSearch);
		JButton btnDelete = new JButton(Constants.BUTTON_DELETE);
		btnDelete.setBounds(235, 334, 128, 34);
		mainPanel.add(btnDelete);
		JButton btnAll = new JButton(Constants.BUTTON_ALL);
		btnAll.setBounds(373, 334, 83, 34);
		mainPanel.add(btnAll);

		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.allPanel = new AllPanel(
						MainScreenFrame.this);
			}
		});
		mainPanel.setVisible(true);

		setVisible(true);

	}

}
