package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setTitle("\uB3C4\uC11C\uAD00\uB9AC\uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 654);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setBounds(0, 39, 572, 576);
		contentPane.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JButton btn_menu1 = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btn_menu1.setBounds(0, 0, 97, 39);
		contentPane.add(btn_menu1);
		btn_menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerPanel Mp = new CustomerPanel();
				panel1.removeAll();
				panel1.add(Mp);
				panel1.updateUI();
			}
		});
		btn_menu1.setForeground(Color.WHITE);
		btn_menu1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		btn_menu1.setBorderPainted(false);
		btn_menu1.setBackground(new Color(102, 51, 0));
		
		JButton btn_menu2 = new JButton("\uB3C4\uC11C\uAD00\uB9AC");
		btn_menu2.setBounds(97, 0, 97, 39);
		contentPane.add(btn_menu2);
		btn_menu2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		btn_menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookPanel Bp = new BookPanel();
				panel1.removeAll();
				panel1.add(Bp);
				panel1.updateUI();
			}
		});
		btn_menu2.setForeground(Color.WHITE);
		btn_menu2.setBorderPainted(false);
		btn_menu2.setBackground(new Color(102, 51, 0));
		
		JButton btn_menu3 = new JButton("\uB300\uC5EC & \uBC18\uB0A9");
		btn_menu3.setBounds(194, 0, 106, 39);
		contentPane.add(btn_menu3);
		btn_menu3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		btn_menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnPanel Rp = new ReturnPanel();
				panel1.removeAll();
				panel1.add(Rp);
				panel1.updateUI();
			}
		});
		btn_menu3.setForeground(Color.WHITE);
		btn_menu3.setBorderPainted(false);
		btn_menu3.setBackground(new Color(102, 51, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBackground(new Color(102, 51, 0));
		lblNewLabel.setBounds(0, 0, 572, 41);
		contentPane.add(lblNewLabel);
		
		btn_menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_menu1.setBackground(new Color(153, 102, 51));
				btn_menu2.setBackground(new Color(102, 51, 0));
				btn_menu3.setBackground(new Color(102, 51, 0));
			}
		});
		
		btn_menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_menu1.setBackground(new Color(102, 51, 0));
				btn_menu2.setBackground(new Color(153, 102, 51));
				btn_menu3.setBackground(new Color(102, 51, 0));
			}
		});
		
		btn_menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_menu1.setBackground(new Color(102, 51, 0));
				btn_menu2.setBackground(new Color(102, 51, 0));
				btn_menu3.setBackground(new Color(153, 102, 51));
			}
		});
			
		

		

		

	}
}
