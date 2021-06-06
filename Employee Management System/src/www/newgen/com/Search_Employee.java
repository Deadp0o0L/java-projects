package www.newgen.com;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class Search_Employee implements ActionListener {
	
	JFrame sf;
	JLabel l1,l2,l3;
	JButton b1,b2;
	JTextField f1;
	
	Search_Employee(){
		
		sf = new JFrame("Search Employee");
		sf.setBackground(Color.white);
		sf.setLayout(null);
		
		l1 = new JLabel("Search Employee");
		l1.setFont(new Font("serif", Font.ITALIC, 30));
		l1.setBounds(90,20,250,50);
		sf.add(l1);
		
		l2 = new JLabel("Enter Emp ID");
		l2.setFont(new Font("serif", Font.PLAIN, 20));
		l2.setBounds(60,100,300,30);
		sf.add(l2);
		
		f1 = new JTextField();
		f1.setBounds(200,100,100,30);
		sf.add(f1);
		
		b1 = new JButton("SEARCH");
		b1.setFont(new Font("serif", Font.BOLD, 17));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(50,175,120,30);
		b1.addActionListener(this);
		sf.add(b1);
		
		b2 = new JButton("CANCEL");
		b2.setFont(new Font("serif", Font.BOLD, 17));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(215,175,120,30);
		b2.addActionListener(this);
		sf.add(b2);
		
		sf.getContentPane().setBackground(Color.WHITE);
		
		sf.setVisible(true);
		sf.setSize(400,300);
		sf.setLocation(400,200);
		
		
	}
	
	public void actionPerformed(ActionEvent a) {
		
		String emp = f1.getText();
		
		if(a.getSource() == b1) {
			
			connection ccc = new connection();
			
			try {
				
				String r = "SELECT * FROM emp_details WHERE emp_id = '" +emp+  "'";
	
				ResultSet res = ccc.stmnt.executeQuery(r);
				
				if(res.next()) {
					JOptionPane.showMessageDialog(null, "EMPLOYEE DETAILS FOUND !");
					sf.setVisible(false);
					new Update_Employee(emp);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(a.getSource() == b2) {
			sf.setVisible(false);
			new details();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Search_Employee se = new Search_Employee();
		
	}
	
}
