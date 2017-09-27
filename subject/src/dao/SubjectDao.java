package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enity.Subject;

public class SubjectDao {
public ArrayList<Subject> searchall(){
	ArrayList<Subject> list=new ArrayList<Subject>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school?"
				+ "characterEncoding=utf-8", "root","123456");
		Statement stat=con.createStatement();
		String sql="select *from subject ";
		ResultSet rs=stat.executeQuery(sql);
		while(rs.next()){
			Subject sub=new Subject();
			sub.setId(rs.getInt("id"));
			sub.setName(rs.getString("name"));
			list.add(sub);
		
		}
		rs.close();
		con.close();	
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public void add(Subject sub){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/shcool?"
				+ "characterEnconding=utf-8","root","123456");
		Statement stat=con.createStatement();
		String sql="insert into subject (id,name) vualues("+sub.getId()+","+sub.getName()+")";
		int result=stat.executeUpdate(sql);
		con.close();
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void update(Subject sub){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/school?"
				+ "characterEncoding=utf-8","root","123456");
		Statement stat=con.createStatement();
		String sql="update subject set name='"+sub.getName()+"' where  id="+sub.getId()+"";
		int result=stat.executeUpdate(sql);
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void searchConditon(){}

}
