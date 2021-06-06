package www.newgen.com;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;

public class Update_Employee implements ActionListener{

	JFrame uf;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,h1;
	JTextField f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;
	String name,emp_id,designation,email,phone,blood_type,location,salary,dob,education;
	
	Update_Employee(String e_id){
		
		try {
			
			connection up_con = new connection();
			
			String get_data = "SELECT * FROM emp_details WHERE emp_id = '"+e_id+"'";
			ResultSet update_res = up_con.stmnt.executeQuery(get_data);
			
			while(update_res.next()) {
				
				name = update_res.getString("name");
				emp_id= update_res.getString("emp_id");
				designation = update_res.getString("designation");
				email = update_res.getString("email");
				phone= update_res.getString("phone");
				salary = update_res.getString("salary");
				dob= update_res.getString("dob");
				education = update_res.getString("education");
				blood_type= update_res.getString("blood_group");
				location= update_res.getString("location");
				
			}
			
		}catch(Exception uex) {
			uex.printStackTrace();
		}
		
		uf = new JFrame();
		
		uf = new JFrame("Update Employee");
		uf.setBackground(Color.white);
		uf.setLayout(null);
		uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		h1 = new JLabel("Update Employee Details");
		h1.setFont(new Font("serif", Font.ITALIC, 35));
		h1.setBounds(170, 20, 500, 50);
		uf.add(h1);


		l1 = new JLabel("Name");
		l1.setBounds(30, 100, 100, 30);
		l1.setFont(new Font("serif", Font.PLAIN, 20));
		uf.add(l1);

		l2 = new JLabel("Emp ID");
		l2.setFont(new Font("serif", Font.PLAIN, 20));
		l2.setBounds(30, 175, 100, 30);
		uf.add(l2);

		l3 = new JLabel("Designation");
		l3.setFont(new Font("serif", Font.PLAIN, 20));
		l3.setBounds(30, 250, 100, 30);
		uf.add(l3);

		l4 = new JLabel("Email");
		l4.setFont(new Font("serif", Font.PLAIN, 20));
		l4.setBounds(30, 325, 100, 30);
		uf.add(l4);

		l5 = new JLabel("Phone");
		l5.setFont(new Font("serif", Font.PLAIN, 20));
		l5.setBounds(30, 400, 100, 30);
		uf.add(l5);

		l6 = new JLabel("DOB");
		l6.setFont(new Font("serif", Font.PLAIN, 20));
		l6.setBounds(370, 100, 100, 30);
		uf.add(l6);

		l7 = new JLabel("Salary");
		l7.setFont(new Font("serif", Font.PLAIN, 20));
		l7.setBounds(370, 175, 100, 30);
		uf.add(l7);

		l8 = new JLabel("Education");
		l8.setFont(new Font("serif", Font.PLAIN, 20));
		l8.setBounds(370, 250, 100, 30);
		uf.add(l8);

		l9 = new JLabel("Blood Type");
		l9.setFont(new Font("serif", Font.PLAIN, 20));
		l9.setBounds(370, 325, 100, 30);
		uf.add(l9);

		l10 = new JLabel("Location");
		l10.setFont(new Font("serif", Font.PLAIN, 20));
		l10.setBounds(370, 400, 100, 30);
		uf.add(l10);

		f1 = new JTextField();
		f1.setBounds(140, 100, 150, 30);
		f1.setText(name);
		uf.add(f1);

		f2 = new JTextField();
		f2.setBounds(140, 175, 150, 30);
		f2.setText(emp_id);
		uf.add(f2);

		f3 = new JTextField();
		f3.setBounds(140, 250, 150, 30);
		f3.setText(designation);
		uf.add(f3);

		f4 = new JTextField();
		f4.setBounds(140, 325, 150, 30);
		f4.setText(email);
		uf.add(f4);

		f5 = new JTextField();
		f5.setBounds(140, 400, 150, 30);
		f5.setText(phone);
		uf.add(f5);

		f6 = new JTextField();
		f6.setBounds(500, 100, 150, 30);
		f6.setText(dob);
		uf.add(f6);

		f7 = new JTextField();
		f7.setBounds(500, 175, 150, 30);
		f7.setText(salary);
		uf.add(f7);

		f8 = new JTextField();
		f8.setBounds(500, 250, 150, 30);
		f8.setText(education);
		uf.add(f8);

		f9 = new JTextField();
		f9.setBounds(500, 320, 150, 30);
		f9.setText(blood_type);
		uf.add(f9);

		f10 = new JTextField();
		f10.setBounds(500, 400, 150, 30);
		f10.setText(location);
		uf.add(f10);

		b1 = new JButton("UPDATE");
		b1.setFont(new Font("serif", Font.BOLD, 20));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(170, 470, 150, 40);
		b1.addActionListener(this);
		uf.add(b1);

		b2 = new JButton("CANCEL");
		b2.setFont(new Font("serif", Font.BOLD, 20));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(400, 470, 150, 40);
		b2.addActionListener(this);
		uf.add(b2);

		uf.getContentPane().setBackground(Color.white);

		uf.setVisible(true);
		uf.setSize(700, 600);
		uf.setLocation(300, 100);
		
		
	}
	
	public void actionPerformed(ActionEvent ue) {
		
		if(ue.getSource() == b1) {
			
			name = f1.getText();
			emp_id=f2.getText();
			designation = f3.getText();
			email = f4.getText();
			phone= f5.getText();
			salary = f7.getText();
			dob= f6.getText();
			education = f8.getText();
			blood_type= f9.getText();
			location= f10.getText();
			
			
			try {
								
				connection set_con = new connection();
				
				String set_data = "UPDATE `emp_details` SET `name`='"+name+"',`emp_id`='"+emp_id+"',`designation`='"+designation+"',`email`='"+email+"',`phone`='"+phone+"',`dob`='"+dob+"',`salary`='"+salary+"',`education`='"+education+"',`blood_group`='"+blood_type+"',`location`='"+location+"' WHERE emp_id = '"+emp_id+"'";

				set_con.stmnt.execute(set_data);
				uf.setVisible(false);				
				JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully !");
				new details();
				
			}catch(Exception uex) {
				uex.printStackTrace();
			}
			
		}
		
		if(ue.getSource() == b2) {
			uf.setVisible(false);
			new Search_Employee();
		}
		
	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Update_Employee ue = new Update_Employee("");
	}
	
}
