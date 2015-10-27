package main.java.pt.tiago.passwordstorer.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import main.java.pt.tiago.passwordstorer.bo.PresentationBO;
import main.java.pt.tiago.passwordstorer.util.Constants;
import javax.swing.JCheckBox;
import java.awt.Font;

public class AllPanel extends JPanel {
	MainScreenFrame frame;
	private static final long serialVersionUID = 1457643519564804289L;
	JCheckBox ctrlPasswordCheckBox;

	/**
	 * Create the panel.
	 * @param panel 
	 */
	public AllPanel(MainScreenFrame frame) {
		this.frame = frame;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton backButton = new JButton(Constants.BUTTON_BACK);
		springLayout.putConstraint(SpringLayout.NORTH, backButton, -50, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, backButton, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, backButton, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, backButton, 95, SpringLayout.WEST, this);
		add(backButton);
		

		Vector<Vector<String>> data = PresentationBO.getDomain();
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
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -101, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 3, SpringLayout.EAST, this);
		add(scrollPane);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllPanel.this.frame.remove(AllPanel.this);
				AllPanel.this.frame.allPanel.setVisible(false);
				AllPanel.this.frame.getContentPane().add(AllPanel.this.frame.mainPanel);
				AllPanel.this.frame.mainPanel.setVisible(true);
				AllPanel.this.frame.repaint();
			}
		});

		frame.getContentPane().add(this);
		
		ctrlPasswordCheckBox = new JCheckBox(Constants.CONTROL_CHECKBOX_ON);
		ctrlPasswordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AllPanel.this.ctrlPasswordCheckBox.isSelected()){
					ctrlPasswordCheckBox.setText(Constants.CONTROL_CHECKBOX_OFF);
				}else{
					ctrlPasswordCheckBox.setText(Constants.CONTROL_CHECKBOX_ON);
				}
			}
		});
		ctrlPasswordCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, ctrlPasswordCheckBox, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.WEST, ctrlPasswordCheckBox, 39, SpringLayout.EAST, backButton);
		springLayout.putConstraint(SpringLayout.SOUTH, ctrlPasswordCheckBox, 0, SpringLayout.SOUTH, backButton);
		springLayout.putConstraint(SpringLayout.EAST, ctrlPasswordCheckBox, 212, SpringLayout.EAST, backButton);
		add(ctrlPasswordCheckBox);
		frame.setVisible(true);
	}
}
