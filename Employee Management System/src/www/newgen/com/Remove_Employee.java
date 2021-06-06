package www.newgen.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Remove_Employee implements ActionListener {

	JFrame rf;
	JButton b1, b2, b3, b4;
	JLabel l, l1, l2, l3, l4, l5, d1, d2, d3, h;
	JTextField f;
	String name, designation, email;

	Remove_Employee() {

		rf = new JFrame("Remove Employee");
		rf.setBackground(Color.white);
		rf.setLayout(null);

		l1 = new JLabel("Enter Emp ID");
		l1.setBounds(100, 40, 200, 30);
		l1.setFont(new Font("serif", Font.ITALIC, 20));
		rf.add(l1);

		f = new JTextField();
		f.setBounds(280, 40, 150, 30);
		f.setBackground(Color.WHITE);
		rf.add(f);

		l2 = new JLabel("Name");
		l2.setBounds(50, 200, 200, 30);
		l2.setFont(new Font("serif", Font.ITALIC, 20));
		l2.setVisible(false);
		rf.add(l2);

		l3 = new JLabel("Email");
		l3.setBounds(50, 240, 50, 30);
		l3.setFont(new Font("serif", Font.ITALIC, 20));
		l3.setVisible(false);
		rf.add(l3);

		l4 = new JLabel("Designation");
		l4.setBounds(50, 280, 200, 30);
		l4.setFont(new Font("serif", Font.ITALIC, 20));
		l4.setVisible(false);
		rf.add(l4);

		b1 = new JButton("SEARCH");
		b1.setBounds(150, 120, 100, 30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("serif", Font.ITALIC, 15));
		b1.addActionListener(this);
		rf.add(b1);

		b2 = new JButton("BACK");
		b2.setBounds(300, 120, 100, 30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(new Font("serif", Font.ITALIC, 15));
		b2.addActionListener(this);
		rf.add(b2);

		

		b3 = new JButton("REMOVE");
		b3.setBounds(225, 340, 100, 30);
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setFont(new Font("serif", Font.ITALIC, 15));
		b3.addActionListener(this);
		b3.setVisible(false);
		rf.add(b3);

		rf.getContentPane().setBackground(Color.white);

		rf.setVisible(true);
		rf.setSize(500, 500);
		rf.setLocation(350, 100);

	}

	public void actionPerformed(ActionEvent re) {

		connection rem_con = new connection();
		String str = f.getText();
		
		if (re.getSource() == b1) {

			try {

				String sql = "SELECT name,email,designation FROM emp_details WHERE emp_id = '" + str + "'";
				ResultSet rem_res = rem_con.stmnt.executeQuery(sql);

				while (rem_res.next()) {

					name = rem_res.getString("name");
					email = rem_res.getString("email");
					designation = rem_res.getString("designation");

				}
				
				l2.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				b3.setVisible(true);
				
				d1 = new JLabel(name);
				d1.setBounds(200, 200, 300, 30);
				d1.setFont(new Font("serif",Font.ITALIC,20));
				d1.setForeground(Color.BLUE);
				rf.add(d1);

				d2 = new JLabel(email);
				d2.setBounds(200, 240, 250, 30);
				d2.setFont(new Font("serif",Font.ITALIC,20));
				d2.setForeground(Color.BLUE);
				rf.add(d2);
				
				d3 = new JLabel(designation);
				d3.setBounds(200, 280, 200, 30);
				d3.setFont(new Font("serif",Font.ITALIC,20));
				d3.setForeground(Color.BLUE);
				rf.add(d3);
				
								
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
		}

		if (re.getSource() == b2) {

			rf.setVisible(false);
			new details();
		}

		if (re.getSource() == b3) {

			String rem_sql = "DELETE FROM emp_details WHERE emp_id='"+str+"'";
			try {
				rem_con.stmnt.execute(rem_sql);
				rf.setVisible(false);
				JOptionPane.showMessageDialog(null, "Employee Details Removed Successfully !");
				new details();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Remove_Employee r = new Remove_Employee();

	}

}
