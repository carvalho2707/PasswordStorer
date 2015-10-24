package pt.tiago.passwordstorer.model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import pt.tiago.passwordstorer.vo.PasswordVO;

public class SearchTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -6435656131622502477L;
	private Vector<PasswordVO> rows;
	private Vector<String> columns;
	
	public SearchTableModel(Vector<PasswordVO> rows, Vector<String> columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return 0;
	}

}
