package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class MemberPanel extends JPanel {
	private JTextField tf_irum;
	private JTextField tf_id;
	private JTextField tf_address;
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	
	public MemberPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(153, 51, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(5, 25, 68, 23);
		add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 52, 80, 4);
		add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {							
		}});
		
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(153, 51, 0));
		btnNewButton_1.setBounds(5, 62, 68, 23);
		add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1 = new JButton("\uC870\uD68C");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(new Color(153, 51, 0));
		btnNewButton_1_1.setBounds(7, 98, 68, 23);
		add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(0, 124, 80, 4);
		add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBackground(new Color(153, 51, 0));
		btnNewButton_1_2.setBounds(6, 133, 68, 23);
		add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(0, 89, 80, 4);
		add(lblNewLabel_1_1);

		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(153, 51, 0));
		lblNewLabel.setBounds(0, 19, 80, 140);
		add(lblNewLabel);
		
		tf_irum = new JTextField();
		tf_irum.setBackground(UIManager.getColor("Button.highlight"));
		tf_irum.setBounds(185, 40, 104, 23);
		add(tf_irum);
		tf_irum.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(123, 43, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(314, 41, 57, 15);
		add(lblNewLabel_3);
		
		tf_id = new JTextField();
		tf_id.setBounds(383, 40, 157, 23);
		add(tf_id);
		tf_id.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(123, 87, 57, 15);
		add(lblNewLabel_4);
		
		tf_address = new JTextField();
		tf_address.setBounds(185, 84, 357, 23);
		add(tf_address);
		tf_address.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(102, 51, 0));
		lblNewLabel_5.setBounds(104, 19, 520, 108);
		add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBounds(104, 133, 520, 303);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionBackground(SystemColor.control);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uD68C\uC6D0\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setMinWidth(250);
		table.setGridColor(Color.BLACK);
		scrollPane.setViewportView(table);
		

		


		


	}
}
