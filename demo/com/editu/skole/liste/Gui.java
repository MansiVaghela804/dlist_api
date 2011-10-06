package com.editu.skole.liste;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	JTextArea one;
	JTextArea two;
	JButton gen;
	preference pref = new preference();
	CEncrypt dc = new CEncrypt();

	public Gui() {

		this.setTitle("List Generator");
		setLayout(new FlowLayout());
		final Date time = new Date();

		final JTextArea one = new JTextArea();
		final JTextArea two = new JTextArea();
		JLabel p = new JLabel("   +   ");
		gen = new JButton("Generer");

		JMenuBar jmenu = new JMenuBar();
		setJMenuBar(jmenu);
		JMenu file = new JMenu("File");
		JMenuItem reset = new JMenuItem("Reset Database");
		file.add(reset);
		jmenu.add(file);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String Input = JOptionPane.showInputDialog(null,
						"Write the password to reset the database",
						"Database Reset", 1);
				if (Integer.decode(Input) == 5384) {
					try {
						pref.clear();
						System.out.println("#");
					} catch (BackingStoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});
		pref.printList();
		gen.setActionCommand("Generate");
		gen.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getActionCommand().equals("Generate")) {
					int ti = time.getMonth();
					int p1 = (int) ((Math.random() * 123456789) % 23);
					int p2 = (int) ((Math.random() * 987654321) % 23);
					int p1Int = pref.getLastDate(p1);
					int p2Int = pref.getLastDate(p2);
					System.out.println("First Generation. " + p1 + "    " + p2);
					int i = 1;
					while (p1 == p2 && (p1Int == ti && p1Int == (ti+1) && p1Int == (ti+2)) && (p2Int == ti && p2Int == (ti+1) && p2Int == (ti+2))) {
						p1Int = pref.getLastDate(p1);
						p2Int = pref.getLastDate(p2);
						
						p1 = (int) ((Math.random() * (Math.random() * 999999999 / Math
								.random()*1020)) % 23);
						p2 = (int) ((Math.random() * (Math.random() * 111111111 / Math
								.random()*1200)) % 23);

						i++;
						System.out.println(i+". "+p1+"  ;   "+p2);
					}

					two.setText(list.jlist[p1]);
					one.setText(list.jlist[p2]);

					pref.setCurrentDate(p1, time.getMonth());
					pref.setCurrentDate(p2, time.getMonth());
					//gen.disable();
					//gen.hide();
				}
			}

		});

		one.setEditable(false);
		one.setSize(100, 100);
		one.setText("                      ");

		two.setEditable(false);
		two.setSize(100, 100);
		two.setText("                      ");

		p.setFont(new Font("Sifze", 1, 28));
		one.setFont(new Font("Sifze", 1, 20));
		two.setFont(new Font("Sifze", 1, 20));
		this.add(one);
		this.add(p);
		this.add(two);
		this.add(gen, -1);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 150);
		this.setLocationByPlatform(true);
		this.setVisible(true);

	}

}
