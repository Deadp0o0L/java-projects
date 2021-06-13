import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutWriteIt implements ActionListener {

	JFrame af;
	JLabel l1,l2;
	JButton b;

	AboutWriteIt() {

	af = new JFrame("About WriteIt");
	af.setLayout(null);
	
	
	l1 = new JLabel("WriteIt");
	l1.setBounds(150,20,75,30);
	l1.setFont(new Font("veranda",Font.ITALIC,25));
	af.add(l1);
	
	l2 = new JLabel(String.format("<html><body style=\"text-align: justify; text-justify:inter-word;\" >%s</body></html>","Credit to Hina Kausar for the name of the Application. Also I would like to thanks Mr. Engimachii Niraj K Gupta for the valuable inputs."));
	l2.setBounds(5,60,370,100);
	l2.setFont(new Font("veranda",Font.ITALIC,15));
	af.add(l2);
	
	b = new JButton("Back");
	b.setBackground(Color.black);
	b.setForeground(Color.white);
	b.setBounds(150,200,75,25);
	b.addActionListener(this);
	af.add(b);
	
	af.getContentPane().setBackground(Color.white);
	af.setVisible(true);
	af.setSize(400,300);
	af.setLocation(400,200);
		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b) {
			af.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AboutWriteIt();
	}

}
