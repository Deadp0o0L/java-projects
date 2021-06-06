package www.newgen.com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class details implements ActionListener {

	JFrame df;
	JLabel l1, l2,l3,l4,l5;
	JButton b1, b2, b3, b4,b5;

	details() {

		df = new JFrame("Employee Detail");
		df.setBackground(Color.WHITE);
		df.setLayout(null);

		l1 = new JLabel("Employee Details");
		l1.setFont(new Font("serif", Font.ITALIC, 25));
		l1.setBounds(50, 10, 200, 50);
		df.add(l1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("www/newgen/com/icons/add.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		l2 = new JLabel(i3);
		l2.setBounds(30, 80, 100, 100);
		l2.setLayout(null);

		df.add(l2);
		
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("www/newgen/com/icons/remove.png"));
		Image i5 = i4.getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		l3 = new JLabel(i6);
		l3.setBounds(170, 80, 100, 100);
		l3.setLayout(null);

		df.add(l3);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("www/newgen/com/icons/update.png"));
		Image i8 = i7.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		l4 = new JLabel(i9);
		l4.setBounds(30, 250, 120, 120);
		l4.setLayout(null);

		df.add(l4);
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("www/newgen/com/icons/view.png"));
		Image i11 = i10.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		l5 = new JLabel(i12);
		l5.setBounds(170, 250, 120, 120);
		l5.setLayout(null);

		df.add(l5);
		
		

		b1 = new JButton("Add");
		b1.setBounds(30, 180, 90, 30);
		b1.setFont(new Font("serif", Font.BOLD, 15));
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.black);
		b1.addActionListener(this);
		df.add(b1);

		b2 = new JButton("Remove");
		b2.setBounds(170, 180, 90, 30);
		b2.setFont(new Font("serif", Font.BOLD, 15));
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.black);
		b2.addActionListener(this);
		df.add(b2);

		b3 = new JButton("View");
		b3.setBounds(170, 370, 90, 30);
		b3.setFont(new Font("serif", Font.BOLD, 15));
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.black);
		b3.addActionListener(this);
		df.add(b3);

		b4 = new JButton("Update");
		b4.setBounds(30, 370, 90, 30);
		b4.setFont(new Font("serif", Font.BOLD, 15));
		b4.setBackground(Color.WHITE);
		b4.setForeground(Color.black);
		b4.addActionListener(this);
		df.add(b4);
		
		b5 = new JButton("Back");
		b5.setBounds(100, 450, 90, 30);
		b5.setFont(new Font("serif", Font.BOLD, 15));
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		b5.addActionListener(this);
		df.add(b5);
		
		df.getContentPane().setBackground(Color.white);

		df.setVisible(true);
		df.setSize(330, 550);
		df.setLocation(450, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			df.setVisible(false);
			new Add_Employee();
		}
		if (e.getSource() == b2) {
			df.setVisible(false);
			new Remove_Employee();
		}
		if (e.getSource() == b3) {
			df.setVisible(false);
			new View_Employee();
		}
		if (e.getSource() == b4) {
			df.setVisible(false);
			new Search_Employee();
		}
		if (e.getSource() == b5) {
			df.setVisible(false);
			@SuppressWarnings("unused")
			Front_Page fp = new Front_Page();
		}

	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		details d = new details();

	}

}
