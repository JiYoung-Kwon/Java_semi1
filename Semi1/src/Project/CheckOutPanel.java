package Project;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;

public class CheckOutPanel extends JPanel {
	private JTextField irumTF;
	private JTable customerTable;
	private JTextField bookTitleTF;
	private JTable bookTable;
	private JTable checkOutTable;
	private JTextField selectIrum;
	private JLabel lblNewLabel;
	
	/**
	 * Create the panel.
	 */
	public CheckOutPanel() {
		setBounds(new Rectangle(0, 0, 572, 576));
		setLayout(null);

		JScrollPane customerScrollPane = new JScrollPane();
		customerScrollPane.setBounds(37, 53, 488, 120);
		add(customerScrollPane);

		customerTable = new JTable();
		customerTable.setEnabled(false);
		customerTable.addMouseListener(new MouseAdapter() { // 고객테이블 마우스리스너
			@Override
			public void mouseClicked(MouseEvent e) { // 마우스 클릭 시 
				int customerSelectRow = customerTable.getSelectedRow(); // 해당 테이블의 클릭된 행을 저장하고
				selectIrum.setText((String) customerTable.getModel().getValueAt(customerSelectRow, 0)); // 저장된 행에 0번째 열(이름)을 selectIrum에 설정
			}
		});
		customerTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C"
			}
		));
		customerTable.getColumnModel().getColumn(0).setMinWidth(75);
		customerTable.getColumnModel().getColumn(1).setPreferredWidth(130);
		customerTable.getColumnModel().getColumn(1).setMinWidth(130);
		customerTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		customerTable.getColumnModel().getColumn(2).setMinWidth(300);
		customerScrollPane.setViewportView(customerTable);

		irumTF = new JTextField();
		irumTF.setBounds(237, 23, 207, 21);
		add(irumTF);
		irumTF.setColumns(10);

		JLabel irumLabel = new JLabel("\uD68C\uC6D0\uAC80\uC0C9"); // 번호 뒷자리
		irumLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		irumLabel.setForeground(Color.WHITE);
		irumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		irumLabel.setBounds(158, 23, 80, 20);
		add(irumLabel);

		JLabel bookTitle = new JLabel("\uB3C4\uC11C\uAC80\uC0C9"); // 도서명
		bookTitle.setFont(new Font("굴림", Font.PLAIN, 12));
		bookTitle.setForeground(Color.WHITE);
		bookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bookTitle.setBounds(158, 180, 80, 20);
		add(bookTitle);

		bookTitleTF = new JTextField();
		bookTitleTF.setBounds(237, 180, 207, 21);
		add(bookTitleTF);
		bookTitleTF.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 208, 488, 120);
		add(scrollPane);

		bookTable = new JTable();
		bookTable.setEnabled(false);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\uB3C4\uC11C\uBC88\uD638", "\uBD84\uB958", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uD604\uD669"
			}
		));
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		bookTable.getColumnModel().getColumn(0).setMinWidth(50);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(70);
		bookTable.getColumnModel().getColumn(1).setMinWidth(70);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		bookTable.getColumnModel().getColumn(2).setMinWidth(150);
		bookTable.getColumnModel().getColumn(3).setMinWidth(75);
		bookTable.getColumnModel().getColumn(4).setMinWidth(75);
		scrollPane.setViewportView(bookTable);

		JButton checkOutBTN = new JButton("\uB300\uC5EC"); //대여
		checkOutBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkOutBTN.setForeground(Color.WHITE);
		checkOutBTN.setFont(new Font("굴림", Font.PLAIN, 12));
		checkOutBTN.setBorderPainted(false);
		checkOutBTN.setBackground(new Color(153, 51, 0));
		checkOutBTN.setBounds(437, 522, 88, 23);
		add(checkOutBTN);

		JButton customerSearchBTN = new JButton("\uAC80\uC0C9"); // 고객 검색 버튼
		customerSearchBTN.addActionListener(new ActionListener() { // 액션리스너
			public void actionPerformed(ActionEvent e) { 
				
			}
		});
		customerSearchBTN.setForeground(Color.WHITE);
		customerSearchBTN.setFont(new Font("굴림", Font.PLAIN, 12));
		customerSearchBTN.setBorderPainted(false);
		customerSearchBTN.setBackground(new Color(153, 51, 0));
		customerSearchBTN.setBounds(456, 23, 68, 23);
		add(customerSearchBTN);

		JButton bookSearchBTN = new JButton("\uAC80\uC0C9"); // 도서 검색 버튼
		bookSearchBTN.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bookSearchBTN.setForeground(Color.WHITE);
		bookSearchBTN.setFont(new Font("굴림", Font.PLAIN, 12));
		bookSearchBTN.setBorderPainted(false);
		bookSearchBTN.setBackground(new Color(153, 51, 0));
		bookSearchBTN.setBounds(456, 180, 68, 23);
		add(bookSearchBTN);
		
		JButton addBooktBTN = new JButton("\uB300\uC5EC\uBAA9\uB85D \uCD94\uAC00"); // 대여목록 추가
		addBooktBTN.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		addBooktBTN.setForeground(new Color(153, 51, 51));
		addBooktBTN.setBackground(SystemColor.control);
		addBooktBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 값 지우고 만들었어요!
			}
		});
		addBooktBTN.setBounds(301, 357, 109, 23);
		add(addBooktBTN);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 392, 487, 120);
		add(scrollPane_1);
		
		checkOutTable = new JTable();
		checkOutTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uB3C4\uC11C\uBC88\uD638", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uAE30\uAC04"
			}
		));
		scrollPane_1.setViewportView(checkOutTable);
		
		JLabel checkOutList = new JLabel("\uB2D8\uC758 \uB300\uC5EC \uC608\uC815 \uBAA9\uB85D");
		checkOutList.setForeground(Color.WHITE);
		checkOutList.setFont(new Font("돋움", Font.PLAIN, 12));
		checkOutList.setBounds(169, 357, 117, 21);
		add(checkOutList);
		
		selectIrum = new JTextField();
		selectIrum.setHorizontalAlignment(SwingConstants.RIGHT);
		selectIrum.setFont(new Font("굴림", Font.PLAIN, 25));
		selectIrum.setEditable(false);
		selectIrum.setBounds(65, 357, 95, 21);
		add(selectIrum);
		selectIrum.setColumns(10);
		
		JButton addBooktBTN_1 = new JButton("\uB300\uC5EC\uBAA9\uB85D \uC81C\uAC70");
		addBooktBTN_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		addBooktBTN_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addBooktBTN_1.setForeground(new Color(153, 51, 51));
		addBooktBTN_1.setBackground(SystemColor.control);
		addBooktBTN_1.setBounds(416, 357, 109, 23);
		add(addBooktBTN_1);
		add(getLblNewLabel());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBackground(new Color(102, 51, 0));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBounds(22, 10, 520, 550);
		}
		return lblNewLabel;
	}
}
