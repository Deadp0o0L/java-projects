package www.newgen.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Print_Data implements ActionListener {

	JFrame pf;
	JButton b1,b2;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, h1,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;
	String name,emp_id,designation,email,phone,blood_type,location,salary,dob,education;
	
	
	Print_Data(String e_id){
		
		
		try {
			
			connection print_con = new connection();
			
			String query = "SELECT * FROM emp_details WHERE emp_id = '"+e_id+"'";
			ResultSet print_res = print_con.stmnt.executeQuery(query);
			
			while(print_res.next()) {
				
				name = print_res.getString("name");
				emp_id= print_res.getString("emp_id");
				designation = print_res.getString("designation");
				email = print_res.getString("email");
				phone= print_res.getString("phone");
				salary = print_res.getString("salary");
				dob= print_res.getString("dob");
				education = print_res.getString("education");
				blood_type= print_res.getString("blood_group");
				location= print_res.getString("location");
				
			}
			
		}catch(Exception pdex) {
			pdex.printStackTrace();
		}
		
		
		pf = new JFrame("Print Employee Data");
		pf.setBackground(Color.white);
		pf.setLayout(null);
		
		h1 = new JLabel("Employee Details");
		h1.setFont(new Font("serif", Font.ITALIC, 35));
		h1.setBounds(170, 20, 500, 50);
		pf.add(h1);
		
		l1 = new JLabel("Name");
		l1.setBounds(30, 100, 100, 30);
		l1.setFont(new Font("serif", Font.PLAIN, 20));
		pf.add(l1);

		d1 = new JLabel(name);
		d1.setBounds(140, 100, 150, 30);
		d1.setFont(new Font("serif", Font.PLAIN, 20));
		d1.setForeground(Color.BLUE);
		pf.add(d1);
		
		l2 = new JLabel("Emp ID");
		l2.setFont(new Font("serif", Font.PLAIN, 20));
		l2.setBounds(30, 175, 100, 30);
		pf.add(l2);

		d2 = new JLabel(emp_id);
		d2.setBounds(140, 175, 150, 30);
		d2.setFont(new Font("serif", Font.PLAIN, 20));
		d2.setForeground(Color.BLUE);
		pf.add(d2);
		
		l3 = new JLabel("Designation");
		l3.setFont(new Font("serif", Font.PLAIN, 20));
		l3.setBounds(30, 250, 100, 30);
		pf.add(l3);

		d3 = new JLabel(designation);
		d3.setBounds(140, 250, 150, 30);
		d3.setFont(new Font("serif", Font.PLAIN, 20));
		d3.setForeground(Color.BLUE);
		pf.add(d3);
		
		
		l4 = new JLabel("Email");
		l4.setFont(new Font("serif", Font.PLAIN, 20));
		l4.setBounds(30, 325, 100, 30);
		pf.add(l4);

		d4 = new JLabel(email);
		d4.setBounds(140, 325, 150, 30);
		d4.setFont(new Font("serif", Font.PLAIN, 14));
		d4.setForeground(Color.BLUE);
		pf.add(d4);
		
		
		l5 = new JLabel("Phone");
		l5.setFont(new Font("serif", Font.PLAIN, 20));
		l5.setBounds(30, 400, 100, 30);
		pf.add(l5);

		d5 = new JLabel(phone);
		d5.setBounds(140, 400, 150, 30);
		d5.setFont(new Font("serif", Font.PLAIN, 20));
		d5.setForeground(Color.BLUE);
		pf.add(d5);
		
		
		l6 = new JLabel("DOB");
		l6.setFont(new Font("serif", Font.PLAIN, 20));
		l6.setBounds(370, 100, 100, 30);
		pf.add(l6);

		d6 = new JLabel(dob);
		d6.setBounds(500, 100, 150, 30);
		d6.setFont(new Font("serif", Font.PLAIN, 20));
		d6.setForeground(Color.BLUE);
		pf.add(d6);
		
		
		l7 = new JLabel("Salary");
		l7.setFont(new Font("serif", Font.PLAIN, 20));
		l7.setBounds(370, 175, 100, 30);
		pf.add(l7);

		d7 = new JLabel(salary);
		d7.setBounds(500, 175, 150, 30);
		d7.setFont(new Font("serif", Font.PLAIN, 20));
		d7.setForeground(Color.BLUE);
		pf.add(d7);
		
		
		l8 = new JLabel("Education");
		l8.setFont(new Font("serif", Font.PLAIN, 20));
		l8.setBounds(370, 250, 100, 30);
		pf.add(l8);

		d8 = new JLabel(education);
		d8.setBounds(500, 250, 150, 30);
		d8.setFont(new Font("serif", Font.PLAIN, 20));
		d8.setForeground(Color.BLUE);
		pf.add(d8);
		
		
		l9 = new JLabel("Blood Type");
		l9.setFont(new Font("serif", Font.PLAIN, 20));
		l9.setBounds(370, 325, 100, 30);
		pf.add(l9);

		d9 = new JLabel(blood_type);
		d9.setBounds(500, 325, 150, 30);
		d9.setFont(new Font("serif", Font.PLAIN, 20));
		d9.setForeground(Color.BLUE);
		pf.add(d9);
		
		
		l10 = new JLabel("Location");
		l10.setFont(new Font("serif", Font.PLAIN, 20));
		l10.setBounds(370, 400, 100, 30);
		pf.add(l10);
		
		d10 = new JLabel(location);
		d10.setBounds(500, 400, 150, 30);
		d10.setFont(new Font("serif", Font.PLAIN, 20));
		d10.setForeground(Color.BLUE);
		pf.add(d10);
		
		b1 = new JButton("PRINT");
		b1.setFont(new Font("serif", Font.BOLD, 20));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(150, 470, 150, 40);
		b1.addActionListener(this);
		pf.add(b1);

		b2 = new JButton("BACK");
		b2.setFont(new Font("serif", Font.BOLD, 20));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(400, 470, 150, 40);
		b2.addActionListener(this);
		pf.add(b2);
		
		pf.getContentPane().setBackground(Color.white);
		
		pf.setVisible(true);
		pf.setSize(700,600);
		pf.setLocation(350,100);
		
	}
	
	public void actionPerformed(ActionEvent pde) {
		if(pde.getSource() == b1) {
			
			JOptionPane.showMessageDialog(null, "Printed Successfully !");
			pf.setVisible(false);
			new details();
			
		}
		
		if(pde.getSource() == b2) {
			pf.setVisible(false);
			new View_Employee();
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Print_Data pd = new Print_Data("Print Data");
	}
	
}
