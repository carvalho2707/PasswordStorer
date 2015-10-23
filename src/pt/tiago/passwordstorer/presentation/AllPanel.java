package pt.tiago.passwordstorer.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import pt.tiago.passwordstorer.dao.ResultsDAO;
import pt.tiago.passwordstorer.util.Constants;

public class AllPanel extends JPanel {
	MainScreenFrame frame;
	private static final long serialVersionUID = 1457643519564804289L;

	/**
	 * Create the panel.
	 * @param panel 
	 */
	public AllPanel(MainScreenFrame frame) {
		this.frame = frame;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton backButton = new JButton(Constants.BUTTON_BACK);
		springLayout.putConstraint(SpringLayout.WEST, backButton, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, backButton, 0, SpringLayout.SOUTH, this);
		add(backButton);
		
		String data[][] = ResultsDAO.getAllData();
		String column[] = { Constants.COLUMN1, Constants.COLUMN2, Constants.COLUMN3 };

		JTable jt = new JTable(data, column);
		
		JScrollPane scrollPane = new JScrollPane(jt);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 3, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -23, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 3, SpringLayout.EAST, this);
		add(scrollPane);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllPanel.this.frame.remove(AllPanel.this);
				AllPanel.this.frame.allPanel.setVisible(false);
				AllPanel.this.frame.add(AllPanel.this.frame.mainPanel);
				AllPanel.this.frame.mainPanel.setVisible(true);
				AllPanel.this.frame.repaint();
			}
		});

		frame.add(this);
		frame.setVisible(true);
	}
}
