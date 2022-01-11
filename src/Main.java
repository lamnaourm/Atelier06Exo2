import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private JList list1;
	private JList list2;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	DefaultListModel<String> model1 = new DefaultListModel<>();
	DefaultListModel<String> model2 = new DefaultListModel<>();
	private JLabel lblListe;
	private JLabel lblListe_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Exo2 - Atelier06");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list1 = new JList(model1);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				manageButton();
			}
		});
		model1.addElement("Lundi");
		model1.addElement("Mardi");
		model1.addElement("Mercredi");
		model1.addElement("Jeudi");
		model1.addElement("Vendredi");
		model1.addElement("Samedi");
		model1.addElement("Dimanche");
		list1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list1.setBounds(10, 39, 174, 268);
		contentPane.add(list1);
		
		b1 = new JButton(">>");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<model1.size();i++) {
					model2.addElement(model1.get(i));
				}
				model1.clear();
				manageButton();
			}
		});
		b1.setBounds(194, 92, 89, 23);
		contentPane.add(b1);
		
		b2 = new JButton(">");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model2.addElement(list1.getSelectedValue().toString());
				model1.remove(list1.getSelectedIndex());
			}
		});
		b2.setBounds(194, 126, 89, 23);
		contentPane.add(b2);
		
		b3 = new JButton("<<");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<model2.size();i++) {
					model1.addElement(model2.get(i));
				}
				model2.clear();
				manageButton();
			}
		});
		b3.setBounds(194, 160, 89, 23);
		contentPane.add(b3);
		
		b4 = new JButton("<");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model1.addElement(list2.getSelectedValue().toString());
				model2.remove(list2.getSelectedIndex());
			}
		});
		b4.setBounds(194, 194, 89, 23);
		contentPane.add(b4);
		
		list2 = new JList();
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				manageButton();
			}
		});
		list2.setModel(model2);
		list2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list2.setBounds(293, 39, 174, 268);
		contentPane.add(list2);
		
		lblListe = new JLabel("Liste 1");
		lblListe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListe.setBounds(10, 11, 174, 24);
		contentPane.add(lblListe);
		
		lblListe_2 = new JLabel("Liste 2");
		lblListe_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListe_2.setBounds(293, 14, 174, 21);
		contentPane.add(lblListe_2);
		
		manageButton();
	}

	void manageButton() {
		if(model1.size()==0) 
			b1.setEnabled(false);
		else 
			b1.setEnabled(true);
		
		if(list1.getSelectedIndex()==-1) 
			b2.setEnabled(false);
		else 
			b2.setEnabled(true);
		
		if(model2.size()==0) 
			b3.setEnabled(false);
		else 
			b3.setEnabled(true);
		
		if(list2.getSelectedIndex()==-1) 
			b4.setEnabled(false);
		else 
			b4.setEnabled(true);
	}
}
