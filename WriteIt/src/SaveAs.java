import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class SaveAs implements ActionListener {
	
	JFrame sf;
	JLabel l1;
	JButton b;
	JTextField t1;
	String FileName;
	
	SaveAs(){
		
		
		sf = new JFrame("Save As | WriteIt");
		sf.setLayout(null);
		sf.setVisible(true);

		l1 = new JLabel("Save File As : ");
		l1.setBounds(25, 30, 100, 20);
		sf.add(l1);

		t1 = new JTextField();
		t1.setBounds(120, 30, 100, 20);
		sf.add(t1);

		b = new JButton("Save");
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		b.setBounds(80, 100, 75, 25);
		b.addActionListener(this);
		sf.add(b);

		sf.setVisible(true);
		sf.setSize(275, 200);
		sf.setLocation(400, 250);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b) {
			Save(WriteIt.str,t1.getText());
			sf.setVisible(false);
		}
		
	}
	
	public static void Save(String s, String Filename) {

		
		
		try {

			File file = new File(Filename + ".txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s);
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

			
}
