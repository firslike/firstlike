package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.SubjectDao;

import enity.Subject;

public class SubjectView {
	SubjectDao subDao=new SubjectDao();
	ArrayList<Subject> list;
	
	
public static void main(String[] args) {
		SubjectView sbv=new SubjectView();
		sbv.init();
	}
	
	public void init(){
	list=subDao.searchall();
	if(list==null)
	{list=new ArrayList<Subject>();}
	JFrame frame=new JFrame();
	frame.setSize(600,400);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel mainpanl=(JPanel) frame.getContentPane();
	BoxLayout boxLayout=new BoxLayout(mainpanl, BoxLayout.Y_AXIS);
	mainpanl.setLayout(boxLayout);
	JPanel panel1=new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel(new FlowLayout(FlowLayout.CENTER,50,20));
	mainpanl.add(panel1);
	mainpanl.add(panel2);
	mainpanl.add(panel3);
    Label IDlab=new  Label();
    Label namelab=new Label();
    IDlab.setPreferredSize(new Dimension(30,30));
    namelab.setPreferredSize(new Dimension(30,30));
    IDlab.setText("id");
    namelab.setText("科目");
    JTextField IDtext=new JTextField();
    JTextField nametext=new JTextField();
    IDtext.setPreferredSize(new Dimension(100,30));
    nametext.setPreferredSize(new Dimension(100,30));
    JButton searchbon=new JButton();
    searchbon.setPreferredSize(new Dimension(80,30));
    searchbon.setText("查询");
    panel1.add(IDlab);
    panel1.add(IDtext);
    panel1.add(namelab);
    panel1.add(nametext);
    panel1.add(searchbon);
    JTable subtab=new JTable();
    SubjectModel model=new SubjectModel(list);
    subtab.setModel(model);
    JScrollPane scroll=new JScrollPane();
    scroll.setPreferredSize(new Dimension(400,300));
    scroll.setViewportView(subtab);
    panel2.add(scroll);
    JButton addbon=new JButton();
    addbon.setPreferredSize(new Dimension(80,30));
    addbon.setText("增加");
    JButton modifybon=new JButton();
    modifybon.setPreferredSize(new Dimension(80,30));
    modifybon.setText("修改");
    JButton deletebon=new JButton();
    deletebon.setPreferredSize(new Dimension(80,30));
    deletebon.setText("删除");
    panel3.add(addbon);
    panel3.add(modifybon);
    panel3.add(deletebon);
    frame.setVisible(true);
}
	
}