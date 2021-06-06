package www.newgen.com;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class login implements ActionListener {

	JFrame lf;
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;

	login() {

		lf = new JFrame("Login Page");
		lf.setBackground(Color.white);
		lf.setLayout(null);

		l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 30);
		lf.add(l1);

		l2 = new JLabel("Password");
		l2.setBounds(40, 70, 100, 30);
		lf.add(l2);

		t1 = new JTextField();
		t1.setBounds(150, 20, 150, 30);
		lf.add(t1);

		t2 = new JPasswordField();
		t2.setBounds(150, 70, 150, 30);
		lf.add(t2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("www/newgen/com/icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(350, 20, 170, 170);
		lf.add(l3);

		b1 = new JButton("LOGIN");
		b1.setBounds(40, 140, 120, 30);
		b1.setFont(new Font("serif", Font.ITALIC, 15));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		lf.add(b1);

		b2 = new JButton("CANCEL");
		b2.setBounds(180, 140, 120, 30);
		b2.setFont(new Font("serif", Font.ITALIC, 15));
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		lf.add(b2);

		lf.getContentPane().setBackground(Color.WHITE);

		lf.setVisible(true);
		lf.setSize(600, 250);
		lf.setLocation(350, 300);

	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() == b1) {
			try {

				connection c = new connection();
				String u = t1.getText();
				@SuppressWarnings("deprecation")
				String v = t2.getText();

				String q = "SELECT * FROM LOGIN WHERE username='" + u + "' and password='" + v + "'";

				ResultSet rs = c.stmnt.executeQuery(q);

				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL !");
					new details();
					lf.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "INVALID LOGIN CREDENTIALS");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (a.getSource() == b2) {
			lf.setVisible(false);
			new Front_Page();
		}

	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		login l = new login();

	}

}
