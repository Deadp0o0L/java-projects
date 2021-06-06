package www.newgen.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Front_Page implements ActionListener {
	
	JFrame j;
	JLabel id, l1;
	JButton b;
	
	Front_Page(){
		
		j = new JFrame("Employee Management System");
		j.setBackground(Color.RED);
		j.setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("www/newgen/com/icons/front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1200,700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);		
		l1.setBounds(0, 150, 1360, 530);
		j.add(l1);
		
		
		b = new JButton("CLICK HERE TO CONTINUE");
	    b.setFont(new Font("serif",Font.ITALIC,20));
		b.setBackground(Color.WHITE);
		b.setForeground(Color.BLACK);		
		b.setBounds(500,590,300,40);
		b.addActionListener(this);
		
		id = new JLabel();
		id.setBounds(0,0,1360,750);
		id.setLayout(null);
		
		JLabel lid = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		lid.setBounds(120, 30, 1600, 100);
		lid.setFont(new Font("serif",Font.ITALIC,70));
		lid.setForeground(Color.BLACK);
	    id.add(lid);
	    
	    id.add(b);
	    j.add(id);
	    
	    j.getContentPane().setBackground(Color.WHITE);
	    
	    
	    j.setVisible(true);
		j.setExtendedState(JFrame.MAXIMIZED_BOTH);
		j.setLocation(5, 10);
		
	    
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b) {
			j.setVisible(false);
			
			@SuppressWarnings("unused")
			login l = new login();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Front_Page fp = new Front_Page();
		
	}

}
