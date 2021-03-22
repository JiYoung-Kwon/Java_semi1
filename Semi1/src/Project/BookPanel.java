package Project;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookPanel extends JPanel {
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_2;
	private JLabel lblNewLabel_3_1;
	private JTextField textField;
	private JLabel lblNewLabel_3_1_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_5_1_1_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3_2;
	private JTextField textField_5;
	private JButton btnNewButton_1_1_1_1;
	private JLabel lblNewLabel_3_1_2;
	private JTextField textField_6;
	private JLabel lblNewLabel_3_1_1_1;
	private JTextField textField_7;
	private JButton btnNewButton_1_1_1;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_3_1_2_1;
	private JLabel lblNewLabel_3_1_1_1_1;
	private JLabel lblNewLabel_5_1_1;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BookPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getBtnNewButton());
		add(getBtnNewButton_1());
		add(getBtnNewButton_1_2());
		add(getLblNewLabel_3_1());
		add(getTextField());
		add(getLblNewLabel_3_1_1());
		add(getTextField_1());
		add(getLblNewLabel_3());
		add(getTextField_2());
		add(getTextField_3());
		add(getTextField_4());
		add(getLblNewLabel_5_1_1_1());
		add(getLblNewLabel_5());
		add(getLblNewLabel_3_2());
		add(getTextField_5());
		add(getBtnNewButton_1_1_1_1());
		add(getLblNewLabel_3_1_2());
		add(getTextField_6());
		add(getLblNewLabel_3_1_1_1());
		add(getTextField_7());
		add(getBtnNewButton_1_1_1());
		add(getLblNewLabel_5_1());
		add(getLblNewLabel_3_1_2_1());
		add(getLblNewLabel_3_1_1_1_1());
		add(getLblNewLabel_5_1_1());
		add(getScrollPane());

	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(new Color(153, 51, 0));
			btnNewButton.setBounds(436, 30, 80, 23);
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uAC80\uC0C9");
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton_1.setBorderPainted(false);
			btnNewButton_1.setBackground(new Color(153, 51, 0));
			btnNewButton_1.setBounds(436, 74, 80, 23);
		}
		return btnNewButton_1;
	}
	public JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("\uB4F1\uB85D");
			btnNewButton_1_2.setForeground(Color.WHITE);
			btnNewButton_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton_1_2.setBorderPainted(false);
			btnNewButton_1_2.setBackground(new Color(153, 51, 0));
			btnNewButton_1_2.setBounds(448, 119, 68, 23);
		}
		return btnNewButton_1_2;
	}
	public JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("\uC800\uC790");
			lblNewLabel_3_1.setForeground(Color.WHITE);
			lblNewLabel_3_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1.setBounds(41, 78, 50, 15);
		}
		return lblNewLabel_3_1;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(103, 75, 104, 23);
		}
		return textField;
	}
	public JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("NO.");
			lblNewLabel_3_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_1.setBounds(219, 78, 50, 15);
		}
		return lblNewLabel_3_1_1;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(288, 75, 125, 23);
		}
		return textField_1;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uB3C4\uC11C\uBA85");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(41, 34, 50, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setDragEnabled(true);
			textField_2.setColumns(10);
			textField_2.setBounds(103, 31, 310, 23);
		}
		return textField_2;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(379, 451, 125, 23);
		}
		return textField_3;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(379, 484, 125, 23);
		}
		return textField_4;
	}
	public JLabel getLblNewLabel_5_1_1_1() {
		if (lblNewLabel_5_1_1_1 == null) {
			lblNewLabel_5_1_1_1 = new JLabel("");
			lblNewLabel_5_1_1_1.setOpaque(true);
			lblNewLabel_5_1_1_1.setBackground(new Color(153, 102, 51));
			lblNewLabel_5_1_1_1.setBounds(22, 404, 520, 4);
		}
		return lblNewLabel_5_1_1_1;
	}
	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setOpaque(true);
			lblNewLabel_5.setBackground(new Color(102, 51, 0));
			lblNewLabel_5.setBounds(22, 10, 520, 150);
		}
		return lblNewLabel_5;
	}
	public JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("\uB3C4\uC11C\uBA85");
			lblNewLabel_3_2.setForeground(Color.WHITE);
			lblNewLabel_3_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_2.setBounds(41, 422, 50, 15);
		}
		return lblNewLabel_3_2;
	}
	public JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(103, 418, 148, 23);
		}
		return textField_5;
	}
	public JButton getBtnNewButton_1_1_1_1() {
		if (btnNewButton_1_1_1_1 == null) {
			btnNewButton_1_1_1_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1_1_1_1.setForeground(Color.WHITE);
			btnNewButton_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton_1_1_1_1.setBorderPainted(false);
			btnNewButton_1_1_1_1.setBackground(new Color(153, 51, 0));
			btnNewButton_1_1_1_1.setBounds(460, 527, 68, 23);
		}
		return btnNewButton_1_1_1_1;
	}
	public JLabel getLblNewLabel_3_1_2() {
		if (lblNewLabel_3_1_2 == null) {
			lblNewLabel_3_1_2 = new JLabel("\uC800\uC790");
			lblNewLabel_3_1_2.setForeground(Color.WHITE);
			lblNewLabel_3_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_2.setBounds(41, 455, 50, 15);
		}
		return lblNewLabel_3_1_2;
	}
	public JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(103, 451, 148, 23);
		}
		return textField_6;
	}
	public JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_1_1.setBounds(41, 486, 50, 15);
		}
		return lblNewLabel_3_1_1_1;
	}
	public JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(103, 484, 148, 23);
		}
		return textField_7;
	}
	public JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("\uC218\uC815");
			btnNewButton_1_1_1.setForeground(Color.WHITE);
			btnNewButton_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton_1_1_1.setBorderPainted(false);
			btnNewButton_1_1_1.setBackground(new Color(153, 51, 0));
			btnNewButton_1_1_1.setBounds(379, 527, 68, 23);
		}
		return btnNewButton_1_1_1;
	}
	public JLabel getLblNewLabel_5_1() {
		if (lblNewLabel_5_1 == null) {
			lblNewLabel_5_1 = new JLabel("    \uC815 \uBCF4 \uC218 \uC815");
			lblNewLabel_5_1.setOpaque(true);
			lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_5_1.setForeground(Color.WHITE);
			lblNewLabel_5_1.setFont(new Font("µ¸¿ò", Font.BOLD, 14));
			lblNewLabel_5_1.setBackground(new Color(102, 51, 0));
			lblNewLabel_5_1.setBounds(22, 379, 520, 30);
		}
		return lblNewLabel_5_1;
	}
	public JLabel getLblNewLabel_3_1_2_1() {
		if (lblNewLabel_3_1_2_1 == null) {
			lblNewLabel_3_1_2_1 = new JLabel("\uB300\uC5EC\uC77C\uC790");
			lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_2_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_2_1.setBounds(300, 455, 50, 15);
		}
		return lblNewLabel_3_1_2_1;
	}
	public JLabel getLblNewLabel_3_1_1_1_1() {
		if (lblNewLabel_3_1_1_1_1 == null) {
			lblNewLabel_3_1_1_1_1 = new JLabel("\uBC18\uB0A9\uC77C\uC790");
			lblNewLabel_3_1_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_1_1_1.setBounds(300, 488, 50, 15);
		}
		return lblNewLabel_3_1_1_1_1;
	}
	public JLabel getLblNewLabel_5_1_1() {
		if (lblNewLabel_5_1_1 == null) {
			lblNewLabel_5_1_1 = new JLabel("");
			lblNewLabel_5_1_1.setOpaque(true);
			lblNewLabel_5_1_1.setBackground(new Color(102, 51, 0));
			lblNewLabel_5_1_1.setBounds(22, 379, 520, 182);
		}
		return lblNewLabel_5_1_1;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 170, 520, 199);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
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
				},
				new String[] {
					"NO.", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uD604\uD669", "\uB300\uC5EC\uC790", "\uB300\uC5EC\uD69F\uC218"
				}
			));
		}
		return table;
	}
}
