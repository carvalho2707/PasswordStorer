package main.java.pt.tiago.passwordstorer.presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.java.pt.tiago.passwordstorer.bo.PresentationBO;
import main.java.pt.tiago.passwordstorer.util.Constants;
import main.java.pt.tiago.passwordstorer.vo.PasswordVO;

public class AddPanel extends JPanel {
	private static final long serialVersionUID = 3486544837941562990L;
	MainScreenFrame frame;
	private JTextField nameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField othersField;

	/**
	 * Create the panel.
	 */
	public AddPanel(MainScreenFrame frame) {
		this.frame = frame;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel nameLabel = new JLabel(Constants.ADD_LABEL_NAME);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(nameLabel);
		
		JLabel usernameLabel = new JLabel(Constants.ADD_LABEEL_USERNAME);
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, usernameLabel);
		springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 66, SpringLayout.WEST, this);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel(Constants.ADD_LABEL_PASSWORD);
		springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 66, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, usernameLabel, -50, SpringLayout.NORTH, passwordLabel);
		springLayout.putConstraint(SpringLayout.EAST, usernameLabel, 0, SpringLayout.EAST, passwordLabel);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(passwordLabel);
		
		JLabel titleLabel = new JLabel(Constants.ADD_LABEL_TITLE);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		springLayout.putConstraint(SpringLayout.NORTH, titleLabel, 33, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, titleLabel, 149, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, titleLabel, 98, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, titleLabel, -142, SpringLayout.EAST, this);
		add(titleLabel);
		
		JLabel otherLabel = new JLabel(Constants.ADD_LABEL_OTHERS);
		springLayout.putConstraint(SpringLayout.WEST, otherLabel, 0, SpringLayout.WEST, nameLabel);
		otherLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(otherLabel);
		
		nameField = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, 0, SpringLayout.SOUTH, nameField);
		springLayout.putConstraint(SpringLayout.EAST, nameLabel, -21, SpringLayout.WEST, nameField);
		springLayout.putConstraint(SpringLayout.NORTH, nameField, 10, SpringLayout.SOUTH, titleLabel);
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, -3, SpringLayout.NORTH, nameField);
		springLayout.putConstraint(SpringLayout.WEST, nameField, 193, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, nameField, -75, SpringLayout.EAST, this);
		add(nameField);
		nameField.setColumns(10);
		
		usernameField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, usernameField, 201, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nameField, -49, SpringLayout.NORTH, usernameField);
		springLayout.putConstraint(SpringLayout.WEST, usernameField, 6, SpringLayout.EAST, usernameLabel);
		springLayout.putConstraint(SpringLayout.EAST, usernameField, -75, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, -7, SpringLayout.NORTH, usernameField);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 193, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, passwordLabel, -6, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.SOUTH, usernameField, -30, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -75, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 17, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 271, SpringLayout.NORTH, this);
		add(passwordField);
		passwordField.setColumns(10);
		
		othersField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, otherLabel, 0, SpringLayout.NORTH, othersField);
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -23, SpringLayout.NORTH, othersField);
		springLayout.putConstraint(SpringLayout.WEST, othersField, 0, SpringLayout.WEST, nameField);
		springLayout.putConstraint(SpringLayout.NORTH, othersField, 338, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, othersField, -75, SpringLayout.EAST, this);
		add(othersField);
		othersField.setColumns(10);
		
		JButton backButton = new JButton(Constants.BUTTON_BACK);
		springLayout.putConstraint(SpringLayout.NORTH, backButton, 413, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, backButton, -37, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, othersField, -31, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.WEST, backButton, 233, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, backButton, -576, SpringLayout.EAST, this);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPanel.this.frame.remove(AddPanel.this);
				AddPanel.this.frame.addPanel.setVisible(false);
				AddPanel.this.frame.getContentPane().add(AddPanel.this.frame.mainPanel);
				AddPanel.this.frame.mainPanel.setVisible(true);
				AddPanel.this.frame.repaint();
			}
		});
		add(backButton);
		
		JButton addButton = new JButton(Constants.BUTTON_ADD);
		springLayout.putConstraint(SpringLayout.NORTH, addButton, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.WEST, addButton, 39, SpringLayout.EAST, backButton);
		springLayout.putConstraint(SpringLayout.SOUTH, addButton, 0, SpringLayout.SOUTH, backButton);
		springLayout.putConstraint(SpringLayout.EAST, addButton, -446, SpringLayout.EAST, this);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Vector<String>> passwordList = PresentationBO.getDomain();
				PasswordVO newAccount = new PasswordVO(nameField.getText(), usernameField.getText(), new String(passwordField.getPassword()), othersField.getText());
				passwordList.add(newAccount.getAsVector());
				PresentationBO.saveFile(passwordList);
				AddPanel.this.frame.remove(AddPanel.this);
				AddPanel.this.frame.addPanel.setVisible(false);
				AddPanel.this.frame.getContentPane().add(AddPanel.this.frame.mainPanel);
				AddPanel.this.frame.mainPanel.setVisible(true);
				AddPanel.this.frame.repaint();
			}
		});
		add(addButton);
		
		JButton clearButton = new JButton(Constants.BUTTON_CLEAR);
		springLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.WEST, clearButton, 18, SpringLayout.EAST, addButton);
		springLayout.putConstraint(SpringLayout.SOUTH, clearButton, 0, SpringLayout.SOUTH, backButton);
		springLayout.putConstraint(SpringLayout.EAST, clearButton, -322, SpringLayout.EAST, this);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				othersField.setText("");
			}
		});
		add(clearButton);
		
		frame.getContentPane().add(this);
		frame.setVisible(true);

	}
}
