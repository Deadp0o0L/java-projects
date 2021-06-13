import javax.swing.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

public class WriteIt implements ActionListener {

	JFrame f;
	JPanel p;
	JMenuBar mb;
	JMenu m1, m2, m3, m4;
	JTextField t;
	JTextArea a;
	JScrollPane scr;
	JMenuItem m11, m12, m13, m14, m15, m21, m22, m23, m24, m25, m31, m32, m33, m34, m35, m41;
	JLabel l1;
	static String str;
	String Title;

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
		m14 = new JMenuItem("Save As PDF");
		m14.addActionListener(this);
		m1.add(m14);
		m15 = new JMenuItem("Exit");
		m15.addActionListener(this);
		m1.add(m15);

		m2 = new JMenu("Color");
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
		m25 = new JMenuItem("Default");
		m25.addActionListener(this);
		m2.add(m25);

		m3 = new JMenu("Font");
		mb.add(m3);

		m31 = new JMenuItem("Serrif");
		m31.addActionListener(this);
		m3.add(m31);
		m32 = new JMenuItem("MonoSpaced");
		m32.addActionListener(this);
		m3.add(m32);
		m33 = new JMenuItem("Verdana");
		m33.addActionListener(this);
		m3.add(m33);
		m34 = new JMenuItem("Helvetica");
		m34.addActionListener(this);
		m3.add(m34);
		m35 = new JMenuItem("Default");
		m35.addActionListener(this);
		m3.add(m35);

		m4 = new JMenu("Help");
		mb.add(m4);

		m41 = new JMenuItem("About WriteIt");
		m41.addActionListener(this);
		m4.add(m41);

		p = new JPanel();
		p.setBounds(0, 20, 700, 580);

		a = new JTextArea();
		a.setLineWrap(true);
		a.setFont(new Font("Sansserrif", Font.BOLD + Font.ITALIC, 15));
		scr = new JScrollPane(a);
		scr.setBounds(0, 20, 700, 580);
		f.add(scr);

		f.add(p);

		f.setVisible(true);
		f.setSize(700, 600);
		f.setLocation(300, 100);

		f.addWindowStateListener(new WindowAdapter() {

			public void windowStateChanged(WindowEvent w) {
				int newState = w.getNewState();
				int oldState = w.getOldState();

				if ((oldState & JFrame.MAXIMIZED_BOTH) == 0 && (newState & JFrame.MAXIMIZED_BOTH) != 0) {
					mb.setBounds(0, 0, 1366, 20);
					p.setBounds(0, 20, 1366, 718);
					scr.setBounds(0, 20, 1366, 718);
					f.add(scr);
					f.add(p);
				}

				if ((oldState & JFrame.MAXIMIZED_BOTH) != 0 && (newState & JFrame.MAXIMIZED_BOTH) == 0) {
					mb.setBounds(0, 0, 700, 20);
					p.setBounds(0, 20, 700, 580);
					scr.setBounds(0, 20, 700, 580);
					f.add(scr);
					f.add(p);
				}

			}

		});

		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent ee) {

		str = a.getText();

		if (ee.getSource() == m41) {
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
			selectFile(str);

		}

		if (ee.getSource() == m14) {
			try {
				SaveAsPDF(str);
			} catch (Exception e) {
			}
		}

		if (ee.getSource() == m15) {
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
		
		if (ee.getSource() == m25) {
			a.setBackground(Color.white);
		}

		if (ee.getSource() == m31) {
			a.setFont(new Font("serrif", Font.PLAIN, 15));
		}

		if (ee.getSource() == m32) {
			a.setFont(new Font("monospaced", Font.PLAIN, 15));
		}

		if (ee.getSource() == m33) {
			a.setFont(new Font("Verdana", Font.PLAIN, 15));
		}

		if (ee.getSource() == m34) {
			a.setFont(new Font("Helvetica", Font.PLAIN, 15));
		}

		if (ee.getSource() == m35) {
			a.setFont(new Font("Sansserrif", Font.BOLD + Font.ITALIC, 15));
		}

	}

	public void SaveAsPDF(String content) throws Exception {

		try {

			JFileChooser filechooser = new JFileChooser();

			int option = filechooser.showSaveDialog(null);

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = filechooser.getSelectedFile();

				Document doc = new Document();
				PdfWriter.getInstance(doc, new FileOutputStream(file + ".pdf"));

				doc.open();
				Paragraph para = new Paragraph(content);
				doc.add(para);
				doc.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public void selectFile(String content) {

		JFileChooser filechooser = new JFileChooser();

		int option = filechooser.showSaveDialog(null);

		if (option == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();

			f.setTitle("WriteIt | " + file.getName());

			try {

				FileWriter fw = new FileWriter(file + ".txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.flush();
				bw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

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
