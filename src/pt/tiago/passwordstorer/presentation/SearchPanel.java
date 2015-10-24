package pt.tiago.passwordstorer.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import pt.tiago.passwordstorer.dao.ResultsDAO;
import pt.tiago.passwordstorer.util.Constants;
import pt.tiago.passwordstorer.vo.PasswordVO;

public class SearchPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8978455682457031765L;
	MainScreenFrame frame;
	private JTextField nameTextField;
	private JTextField usernameTextField;
	private JTextField othersTextField;
	JTable jt;

	/**
	 * Create the panel.
	 */
	public SearchPanel(MainScreenFrame frame) {

		this.frame = frame;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JButton clearButton = new JButton(Constants.BUTTON_CLEAR);
		springLayout.putConstraint(SpringLayout.EAST, clearButton, -118, SpringLayout.EAST, this);
		add(clearButton);

		Vector<PasswordVO> data = ResultsDAO.getAllData();
		Vector<String> columns = new Vector<String>();
		columns.add(Constants.COLUMN1);
		columns.add(Constants.COLUMN2);
		columns.add(Constants.COLUMN3);
		columns.add(Constants.COLUMN4);
		
		jt = new JTable(data, columns);

		JScrollPane scrollPane = new JScrollPane(jt);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 5,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -146,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("");
				usernameTextField.setText("");
				othersTextField.setText("");
			}
		});

		frame.getContentPane().add(this);
		
		JLabel nameLabel = new JLabel(Constants.SEARCH_LABEL_NAME);
		add(nameLabel);
		
		nameTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, nameTextField);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -6, SpringLayout.NORTH, nameTextField);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel usernameLabel = new JLabel(Constants.SEARCH_LABEL_USERNAME);
		springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 28, SpringLayout.SOUTH, scrollPane);
		add(usernameLabel);
		
		usernameTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 0, SpringLayout.WEST, usernameTextField);
		springLayout.putConstraint(SpringLayout.NORTH, usernameTextField, 50, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, usernameTextField, -199, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, clearButton, 25, SpringLayout.SOUTH, usernameTextField);
		springLayout.putConstraint(SpringLayout.NORTH, nameTextField, 0, SpringLayout.NORTH, usernameTextField);
		springLayout.putConstraint(SpringLayout.EAST, nameTextField, -6, SpringLayout.WEST, usernameTextField);
		usernameTextField.setColumns(10);
		add(usernameTextField);
		
		JLabel othersLabel = new JLabel(Constants.SEARCH_LABEL_OTHER);
		springLayout.putConstraint(SpringLayout.NORTH, othersLabel, 28, SpringLayout.SOUTH, scrollPane);
		add(othersLabel);
		
		othersTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, othersLabel, 0, SpringLayout.WEST, othersTextField);
		springLayout.putConstraint(SpringLayout.NORTH, othersTextField, 0, SpringLayout.NORTH, nameTextField);
		springLayout.putConstraint(SpringLayout.WEST, othersTextField, 6, SpringLayout.EAST, usernameTextField);
		othersTextField.setColumns(10);
		add(othersTextField);
		
		JButton searchButton = new JButton(Constants.BUTTON_SEARCH);
		springLayout.putConstraint(SpringLayout.EAST, searchButton, -210, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, clearButton, 6, SpringLayout.EAST, searchButton);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//TODO
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, clearButton);
		add(searchButton);
		
		JButton backButton = new JButton(Constants.BUTTON_BACK);
		springLayout.putConstraint(SpringLayout.EAST, backButton, -306, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, searchButton, 7, SpringLayout.EAST, backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchPanel.this.frame.remove(SearchPanel.this);
				SearchPanel.this.frame.searchPanel.setVisible(false);
				SearchPanel.this.frame.getContentPane().add(SearchPanel.this.frame.mainPanel);
				SearchPanel.this.frame.mainPanel.setVisible(true);
				SearchPanel.this.frame.repaint();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, backButton, 0, SpringLayout.NORTH, clearButton);
		add(backButton);
		frame.setVisible(true);
	}
}