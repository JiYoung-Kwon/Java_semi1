package Project;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.Button;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BookPanel() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("NO. \uAC80\uC0C9");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		chckbxNewCheckBox.setBackground(new Color(102, 51, 0));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(346, 39, 115, 23);
		add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
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
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(153, 51, 0));
		btnNewButton_1.setBounds(5, 62, 68, 23);
		add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1 = new JButton("\uC870\uD68C");
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
		
		JLabel lblNewLabel_3 = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(123, 43, 50, 15);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 84, 145, 23);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC800\uC790");
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(123, 87, 43, 15);
		add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 40, 145, 23);
		add(textField_2);
		textField_2.setColumns(10);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.control);
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBounds(104, 133, 520, 303);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		table.setSelectionBackground(SystemColor.control);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"NO.", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uD604\uD669", "\uB300\uC5EC\uC790", "\uB300\uC5EC\uD69F\uC218"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setMinWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(75);
		table.getColumnModel().getColumn(4).setMinWidth(75);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setMinWidth(70);
		table.setGridColor(Color.BLACK);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(102, 51, 0));
		lblNewLabel_5.setBounds(104, 19, 520, 108);
		add(lblNewLabel_5);
		



		


	}
}
