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
	l1.setBounds(190,20,75,30);
	l1.setFont(new Font("veranda",Font.ITALIC,25));
	af.add(l1);
	
	l2 = new JLabel(String.format("<html><body style=\"text-align: justify; text-justify:inter-word;\" >%s</body></html>","WriteIt is Java based application which comes with various functionalities including saving the file as text or pdf , changing the backgroud and font as well.<br><br>Credit to Hina Kausar for the name of the Application. <br> Also I would like to thanks Mr. Engimachii Niraj K Gupta for the valuable inputs. <br><br> NEIL © COPYRIGHT "));
	l2.setBounds(5,60,470,200);
	l2.setFont(new Font("veranda",Font.ITALIC,15));
	af.add(l2);
	
	b = new JButton("Back");
	b.setBackground(Color.black);
	b.setForeground(Color.white);
	b.setBounds(200,250,75,25);
	b.addActionListener(this);
	af.add(b);
	
	af.getContentPane().setBackground(Color.white);
	af.setVisible(true);
	af.setSize(500,400);
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
