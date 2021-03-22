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

public class ReturnPanel extends JPanel {
	private JTextField textField_2;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ReturnPanel() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("NO. \uAC80\uC0C9");
		chckbxNewCheckBox_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_1.setBackground(new Color(102, 51, 0));
		chckbxNewCheckBox_1.setBounds(346, 39, 80, 23);
		add(chckbxNewCheckBox_1);
		
		JButton btnNewButton = new JButton("\uB300\uC5EC");
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
		
		JButton btnNewButton_1 = new JButton("\uBC18\uB0A9");
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
		
		JLabel lblNewLabel_3_1 = new JLabel("\uC774\uB984");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(123, 87, 50, 15);
		add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(185, 84, 104, 23);
		add(textField);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(305, 87, 50, 15);
		add(lblNewLabel_3_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(377, 84, 157, 23);
		add(textField_1);

		
		
		
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
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"NO.", "\uB3C4\uC11C\uBA85", "\uB300\uC5EC\uC790", "\uC804\uD654\uBC88\uD638", "\uB300\uC5EC\uC77C\uC790", "\uBC18\uB0A9\uC77C\uC790", "\uBC18\uB0A9\uD604\uD669"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setMinWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setMinWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setMinWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setMinWidth(60);
		table.setGridColor(Color.BLACK);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(102, 51, 0));
		lblNewLabel_5.setBounds(104, 19, 520, 108);
		add(lblNewLabel_5);
		

		

		




		


	}
}
