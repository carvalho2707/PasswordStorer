package main.java.pt.tiago.passwordstorer.presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.java.pt.tiago.passwordstorer.util.Constants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPanel extends JPanel {
	private static final long serialVersionUID = 3486544837941562990L;
	MainScreenFrame frame;
	private JTextField nameField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField othersField;

	/**
	 * Create the panel.
	 */
	public AddPanel(MainScreenFrame frame) {
		this.frame = frame;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel nameLabel = new JLabel(Constants.ADD_LABEL_NAME);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(nameLabel);
		
		JLabel usernameLabel = new JLabel(Constants.ADD_LABEEL_USERNAME);
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, usernameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -6, SpringLayout.NORTH, usernameLabel);
		springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 136, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 66, SpringLayout.WEST, this);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel(Constants.ADD_LABEL_PASSWORD);
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 164, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 66, SpringLayout.WEST, this);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(passwordLabel);
		
		JLabel titleLabel = new JLabel(Constants.ADD_LABEL_TITLE);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		springLayout.putConstraint(SpringLayout.NORTH, titleLabel, 33, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, titleLabel, 149, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, titleLabel, 98, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, titleLabel, -142, SpringLayout.EAST, this);
		add(titleLabel);
		
		JLabel otherLabel = new JLabel(Constants.ADD_LABEL_OTHERS);
		springLayout.putConstraint(SpringLayout.EAST, nameLabel, 6, SpringLayout.EAST, otherLabel);
		springLayout.putConstraint(SpringLayout.NORTH, otherLabel, 6, SpringLayout.SOUTH, passwordLabel);
		springLayout.putConstraint(SpringLayout.WEST, otherLabel, 66, SpringLayout.WEST, this);
		otherLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(otherLabel);
		
		nameField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, nameField, 69, SpringLayout.EAST, nameLabel);
		springLayout.putConstraint(SpringLayout.EAST, nameField, -75, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, -7, SpringLayout.NORTH, nameField);
		springLayout.putConstraint(SpringLayout.NORTH, nameField, 10, SpringLayout.SOUTH, titleLabel);
		add(nameField);
		nameField.setColumns(10);
		
		usernameField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, usernameField, 4, SpringLayout.NORTH, usernameLabel);
		springLayout.putConstraint(SpringLayout.WEST, usernameField, 49, SpringLayout.EAST, usernameLabel);
		springLayout.putConstraint(SpringLayout.EAST, usernameField, -75, SpringLayout.EAST, this);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 53, SpringLayout.EAST, passwordLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, 0, SpringLayout.SOUTH, passwordLabel);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -75, SpringLayout.EAST, this);
		add(passwordField);
		passwordField.setColumns(10);
		
		othersField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, othersField, 8, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.WEST, othersField, 75, SpringLayout.EAST, otherLabel);
		springLayout.putConstraint(SpringLayout.EAST, othersField, -75, SpringLayout.EAST, this);
		add(othersField);
		othersField.setColumns(10);
		
		JButton backButton = new JButton(Constants.BUTTON_BACK);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPanel.this.frame.remove(AddPanel.this);
				AddPanel.this.frame.allPanel.setVisible(false);
				AddPanel.this.frame.getContentPane().add(AddPanel.this.frame.mainPanel);
				AddPanel.this.frame.mainPanel.setVisible(true);
				AddPanel.this.frame.repaint();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, backButton, 26, SpringLayout.SOUTH, otherLabel);
		springLayout.putConstraint(SpringLayout.WEST, backButton, 66, SpringLayout.WEST, this);
		add(backButton);
		
		JButton addButton = new JButton(Constants.BUTTON_ADD);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AddPanel.this.frame.m
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, addButton, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.WEST, addButton, 6, SpringLayout.EAST, backButton);
		add(addButton);
		
		JButton clearButton = new JButton(Constants.BUTTON_CLEAR);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				othersField.setText("");
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.WEST, clearButton, 6, SpringLayout.EAST, addButton);
		add(clearButton);
		
		frame.getContentPane().add(this);
		frame.setVisible(true);

	}
}
