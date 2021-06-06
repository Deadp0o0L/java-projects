package www.newgen.com;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Add_Employee implements ActionListener {

	JFrame aef;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, h1;
	JButton b1, b2;
	JTextField f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;

	Add_Employee(int i) {
	}

	Add_Employee() {

		aef = new JFrame("Add Employee");
		aef.setBackground(Color.white);
		aef.setLayout(null);
		aef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		h1 = new JLabel("Enter Employee Details");
		h1.setFont(new Font("serif", Font.ITALIC, 35));
		h1.setBounds(170, 20, 500, 50);
		aef.add(h1);


		l1 = new JLabel("Name");
		l1.setBounds(30, 100, 100, 30);
		l1.setFont(new Font("serif", Font.PLAIN, 20));
		aef.add(l1);

		l2 = new JLabel("Emp ID");
		l2.setFont(new Font("serif", Font.PLAIN, 20));
		l2.setBounds(30, 175, 100, 30);
		aef.add(l2);

		l3 = new JLabel("Designation");
		l3.setFont(new Font("serif", Font.PLAIN, 20));
		l3.setBounds(30, 250, 100, 30);
		aef.add(l3);

		l4 = new JLabel("Email");
		l4.setFont(new Font("serif", Font.PLAIN, 20));
		l4.setBounds(30, 325, 100, 30);
		aef.add(l4);

		l5 = new JLabel("Phone");
		l5.setFont(new Font("serif", Font.PLAIN, 20));
		l5.setBounds(30, 400, 100, 30);
		aef.add(l5);

		l6 = new JLabel("DOB");
		l6.setFont(new Font("serif", Font.PLAIN, 20));
		l6.setBounds(370, 100, 100, 30);
		aef.add(l6);

		l7 = new JLabel("Salary");
		l7.setFont(new Font("serif", Font.PLAIN, 20));
		l7.setBounds(370, 175, 100, 30);
		aef.add(l7);

		l8 = new JLabel("Education");
		l8.setFont(new Font("serif", Font.PLAIN, 20));
		l8.setBounds(370, 250, 100, 30);
		aef.add(l8);

		l9 = new JLabel("Blood Type");
		l9.setFont(new Font("serif", Font.PLAIN, 20));
		l9.setBounds(370, 325, 100, 30);
		aef.add(l9);

		l10 = new JLabel("Location");
		l10.setFont(new Font("serif", Font.PLAIN, 20));
		l10.setBounds(370, 400, 100, 30);
		aef.add(l10);

		f1 = new JTextField();
		f1.setBounds(140, 100, 150, 30);
		aef.add(f1);

		f2 = new JTextField();
		f2.setBounds(140, 175, 150, 30);
		aef.add(f2);

		f3 = new JTextField();
		f3.setBounds(140, 250, 150, 30);
		aef.add(f3);

		f4 = new JTextField();
		f4.setBounds(140, 325, 150, 30);
		aef.add(f4);

		f5 = new JTextField();
		f5.setBounds(140, 400, 150, 30);
		aef.add(f5);

		f6 = new JTextField();
		f6.setBounds(500, 100, 150, 30);
		aef.add(f6);

		f7 = new JTextField();
		f7.setBounds(500, 175, 150, 30);
		aef.add(f7);

		f8 = new JTextField();
		f8.setBounds(500, 250, 150, 30);
		aef.add(f8);

		f9 = new JTextField();
		f9.setBounds(500, 320, 150, 30);
		aef.add(f9);

		f10 = new JTextField();
		f10.setBounds(500, 400, 150, 30);
		aef.add(f10);

		b1 = new JButton("SUBMIT");
		b1.setFont(new Font("serif", Font.BOLD, 20));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(170, 470, 150, 40);
		b1.addActionListener(this);
		aef.add(b1);

		b2 = new JButton("BACK");
		b2.setFont(new Font("serif", Font.BOLD, 20));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(400, 470, 150, 40);
		b2.addActionListener(this);
		aef.add(b2);

		aef.getContentPane().setBackground(Color.white);

		aef.setVisible(true);
		aef.setSize(700, 600);
		aef.setLocation(300, 100);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String s1 = f1.getText();
		String s2 = f2.getText();
		String s3 = f3.getText();
		String s4 = f4.getText();
		String s5 = f5.getText();
		String s6 = f6.getText();
		String s7 = f7.getText();
		String s8 = f8.getText();
		String s9 = f9.getText();
		String s10 = f10.getText();
		
		
		if(e.getSource() == b1) {
			
			connection cc = new connection();
			
			String q = "INSERT INTO emp_details VALUES ('" + s1 + "' , '" +s2+ "' , '" + s3 + "' ,'" + s4 + "' ,'" + s5 + "' ,'" + s6 + "' ,'" + s7 + "' ,'" + s8 + "' ,'" + s9 + "' ,'" + s10 + "')";
			try {
				cc.stmnt.execute(q);
				JOptionPane.showMessageDialog(null, "DETAILS ENTERED SUCCESSFULLY !");
				aef.setVisible(false);
				new details();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == b2) {
			aef.setVisible(false);
			new details();
		}

	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Add_Employee ae = new Add_Employee();

	}

}
