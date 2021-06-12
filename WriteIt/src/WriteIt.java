import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WriteIt implements ActionListener {

	JFrame f;
	JPanel p;
	JMenuBar mb;
	JMenu m1, m2, m3;
	JTextField t;
	JTextArea a;
	JScrollPane scr;
	JMenuItem m11, m12, m13, m14, m21, m22, m23, m24, m31;
	JLabel l1;
	static String str;

	WriteIt() {

		f = new JFrame("WriteIt");
		f.setLayout(null);

		mb = new JMenuBar();
		mb.setBounds(0, 0, 700, 20);
		f.add(mb);

		m1 = new JMenu("File");
		mb.add(m1);

		m11 = new JMenuItem("New");
		m11.addActionListener(this);
		m1.add(m11);
		m12 = new JMenuItem("Save");
		m12.addActionListener(this);
		m1.add(m12);
		m13 = new JMenuItem("Save As");
		m13.addActionListener(this);
		m1.add(m13);
		m14 = new JMenuItem("Exit");
		m14.addActionListener(this);
		m1.add(m14);

		m2 = new JMenu("Change Color");
		mb.add(m2);

		m21 = new JMenuItem("Red");
		m21.addActionListener(this);
		m2.add(m21);
		m22 = new JMenuItem("Blue");
		m22.addActionListener(this);
		m2.add(m22);
		m23 = new JMenuItem("Orange");
		m23.addActionListener(this);
		m2.add(m23);
		m24 = new JMenuItem("Green");
		m24.addActionListener(this);
		m2.add(m24);

		m3 = new JMenu("Help");
		mb.add(m3);

		m31 = new JMenuItem("About WriteIt");
		m31.addActionListener(this);
		m3.add(m31);

		p = new JPanel();
		p.setBounds(0, 20, 700, 580);

		a = new JTextArea();
		a.setLineWrap(true);
		a.setFont(new Font("Sansserrif", Font.BOLD+Font.ITALIC,15));
		scr = new JScrollPane(a);
		scr.setBounds(0, 20, 700, 580);
		f.add(scr);

		f.add(p);
				

		f.setVisible(true);
		f.setSize(700, 600);
		f.setLocation(300, 100);

	}

	public void actionPerformed(ActionEvent ee) {

		str = a.getText();

		if (ee.getSource() == m31) {
			new AboutWriteIt();
		}

		if (ee.getSource() == m11) {
			f.setVisible(false);
			new WriteIt();
		}

		if (ee.getSource() == m12) {
			Save(str);
		}

		if (ee.getSource() == m13) {
			new SaveAs();
		}

		if (ee.getSource() == m14) {
			System.exit(0);
		}
		
		if (ee.getSource() == m21) {
			a.setBackground(Color.red);
		}
		
		if (ee.getSource() == m22) {
			a.setBackground(Color.blue);
		}
		
		if (ee.getSource() == m23) {
			a.setBackground(Color.decode("#FFA500"));
		}
		
		if (ee.getSource() == m24) {
			a.setBackground(Color.green);
		}

	}

	public static void Save(String s) {

		try {

			File file = new File("New WriteIt.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s);
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.black));
		uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
		JFrame.setDefaultLookAndFeelDecorated(true);

		new WriteIt();

	}

}
