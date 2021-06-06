package www.newgen.com;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class View_Employee implements ActionListener {

	JFrame vf;
	JLabel l1, l2;
	JButton b1, b2;
	JTextField t;

	View_Employee() {

		vf = new JFrame("View Employee Details");
		vf.setBackground(Color.white);
		vf.setLayout(null);

		l1 = new JLabel();
		l1.setBounds(0, 0, 500, 270);
		l1.setLayout(null);
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("www/newgen/com/icons/view.jpg"));
//		l1.setIcon(i1);

		t = new JTextField();
		t.setBounds(250, 72, 150, 30);
		l1.add(t);

		l2 = new JLabel("Enter Employee ID");
		l2.setBounds(20, 60, 250, 50);
		l2.setFont(new Font("serif", Font.BOLD, 25));
		l2.setForeground(Color.black);
		l1.add(l2);
		vf.add(l1);

		b1 = new JButton("SEARCH");
		b1.setBounds(90, 150, 100, 30);
		b1.setFont(new Font("serif", Font.BOLD, 15));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		vf.add(b1);

		b2 = new JButton("CANCEL");
		b2.setBounds(250, 150, 100, 30);
		b2.setFont(new Font("serif", Font.BOLD, 15));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		vf.add(b2);
		
		vf.getContentPane().setBackground(Color.white);

		vf.setVisible(true);
		vf.setSize(450, 270);
		vf.setLocation(380, 200);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String view_emp = t.getText();
		
		if (e.getSource() == b1) {

			connection view_con = new connection();

			try {

				String u = "SELECT * FROM emp_details WHERE emp_id = ' "+ view_emp +" '";

				ResultSet view_res = view_con.stmnt.executeQuery(u);
				
				if (view_res.next()) {
					vf.setVisible(false);
					JOptionPane.showMessageDialog(null, "EMPLOYEE DETAILS FOUND !");
					new Print_Data(view_emp);

				}else {
					vf.setVisible(false);
					JOptionPane.showMessageDialog(null, "NO EMPLOYEE DETAILS FOUND !");	
					new details();
				}
				

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}

		if (e.getSource() == b2) {
			vf.setVisible(false);
			new details();
		}

	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		View_Employee ve = new View_Employee();

	}

}
