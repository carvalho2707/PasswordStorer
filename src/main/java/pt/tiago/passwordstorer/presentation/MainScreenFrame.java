package main.java.pt.tiago.passwordstorer.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.java.pt.tiago.passwordstorer.util.Constants;
import main.java.pt.tiago.passwordstorer.util.SearchType;

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
		loginDlg.setVisible(true);
		

		// create grid layout with 3 rows , 2 columns with horizontal
		// and vertical gap set to 10
		mainPanel = new JPanel();

		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Password Storer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(210, 59, 440, 96);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setForeground(Color.ORANGE);
		mainPanel.add(lblNewLabel);

		JButton btnAdd = new JButton(Constants.BUTTON_ADD_RECORD);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.addPanel = new AddPanel(MainScreenFrame.this);
			}
		});
		btnAdd.setBounds(210, 333, 101, 34);
		// add buttons to the panel
		mainPanel.add(btnAdd);
		JButton btnSearch = new JButton(Constants.BUTTON_SEARCH);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.searchPanel = new SearchPanel(MainScreenFrame.this);
			}
		});
		btnSearch.setBounds(321, 333, 83, 34);
		mainPanel.add(btnSearch);
		JButton btnDelete = new JButton(Constants.BUTTON_DELETE);
		btnDelete.setBounds(414, 333, 128, 34);
		mainPanel.add(btnDelete);
		JButton btnAll = new JButton(Constants.BUTTON_ALL);
		btnAll.setBounds(552, 333, 83, 34);
		mainPanel.add(btnAll);
		
		JButton sigmaButton = new JButton(Constants.BUTTON_SIGMA);
		sigmaButton.setBounds(210, 378, 101, 34);
		mainPanel.add(sigmaButton);
		
		JButton innowaveButton = new JButton(Constants.BUTTON_INNOWAVE);
		innowaveButton.setBounds(414, 378, 127, 34);
		mainPanel.add(innowaveButton);
		
		JButton tdcButton = new JButton(Constants.BUTTON_TDC);
		tdcButton.setBounds(321, 378, 82, 34);
		mainPanel.add(tdcButton);

		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.allPanel = new AllPanel(
						MainScreenFrame.this, SearchType.ALL);
			}
		});
		
		sigmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.allPanel = new AllPanel(
						MainScreenFrame.this, SearchType.SIGMA);
			}
		});
		
		innowaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.allPanel = new AllPanel(
						MainScreenFrame.this, SearchType.INW);
			}
		});
		
		tdcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreenFrame.this.remove(MainScreenFrame.this.mainPanel);
				MainScreenFrame.this.allPanel = new AllPanel(
						MainScreenFrame.this, SearchType.TDC);
			}
		});
		
		mainPanel.setVisible(true);

		setVisible(true);

	}
}
