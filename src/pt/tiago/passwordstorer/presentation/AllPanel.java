package pt.tiago.passwordstorer.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import pt.tiago.passwordstorer.dao.ResultsDAO;
import pt.tiago.passwordstorer.util.Constants;
import pt.tiago.passwordstorer.vo.PasswordVO;

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
		

		Vector<Vector<String>> data = ResultsDAO.getAllData();
		Vector<String> columns = new Vector<String>();
		columns.add(Constants.COLUMN1);
		columns.add(Constants.COLUMN2);
		columns.add(Constants.COLUMN3);
		columns.add(Constants.COLUMN4);
		
		DefaultTableModel model = new DefaultTableModel(data, columns);
		
		JTable jt = new JTable(model);
		
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
