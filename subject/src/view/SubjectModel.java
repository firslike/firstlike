package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import enity.Subject;

public class SubjectModel extends AbstractTableModel{
	String [] ColumnCount={"id","¿ÆÄ¿"};
	ArrayList<Subject> list=null;
	public SubjectModel(ArrayList<Subject> list){
		this.list=list;
	}
	@Override
	public int getRowCount() {
	
		return list.size();
	}
	@Override
	public int getColumnCount() {
	
		return ColumnCount.length;
	}
	public String getColumnName(int columnIndex){
		return ColumnCount[columnIndex];
		
	}	
	public void setDate(ArrayList<Subject> list){
		this.list=list;
		fireTableDataChanged();
		
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==0)
		return list.get(rowIndex).getId() ;
		if(columnIndex==1)
			return list.get(rowIndex).getName();
		else 
			return "";
	}

}
