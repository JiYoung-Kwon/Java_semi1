package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CheckOutPanel extends JPanel {
	private JScrollPane customerScrollPane;
	private JTextField customerSearchTF;
	private JLabel customerSearch;
	private JLabel bookSearch;
	private JTextField bookSearchTF;
	private JScrollPane bookScrollPane;
	private JButton checkOutBTN;
	private JButton customerSearchBTN;
	private JButton bookSearchBTN;
	private JButton addBooktBTN;
	private JScrollPane checkOutScrollPane;
	private JLabel checkOutList;
	private JTextField selectPhoneNum;
	private JButton removeBooktBTN;
	private JLabel backdrop;
	private JTable bookTable;
	private JTable customerTable;
	private JTable checkOutTable;

	private String resultMsg; // �˻������ ���̺� ����� �� ����� ����. �޽������̾�α׿� ��� ����.
	/**
	 * Create the panel.
	 */
	public CheckOutPanel() {
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 572, 576));
		setLayout(null);
		add(getCustomerScrollPane());
		add(getCustomerSearchTF());
		add(getCustomerSearch());
		add(getBookSearch());
		add(getBookSearchTF());
		add(getBookScrollPane());
		add(getCheckOutBTN());
		add(getCustomerSearchBTN());
		add(getBookSearchBTN());
		add(getAddBooktBTN());
		add(getCheckOutScrollPane());
		add(getCheckOutList());
		add(getSelectPhoneNum());
		add(getRemoveBooktBTN());
		add(getBackdrop());
	}
	// ȸ�� �˻� ����
	void actionCustomerSearch() { 
		resultMsg = MainData.checkOutCtrl.printSearchResult( // ���̺� �˻������ ���
				MainData.customerC.searchCustomers(customerSearchTF.getText()), // �˻���� : List<Customer>
				customerTable); // ����� ���̺�

		if(resultMsg!=null) { // �˻� ������ �ùٸ��� �Էµ��� �ʰų�, �˻� ����� ���� ���
			JOptionPane.showMessageDialog(CheckOutPanel.this, resultMsg); // ��� �޽��� ���̾�α� ���
			// �޴���ȭ �� ���ڸ� �Է� : customerSearchTF �ʱ�ȭ
			customerSearchTF.setText("\uD734\uB300\uC804\uD654 \uB05D \uB124\uC790\uB9AC \uC785\uB825");
		}
	}
	// ���� �˻� ����
	void actionBookSearch() { 
		resultMsg = MainData.checkOutCtrl.printSearchResult( // ���̺� �˻������ ���
				MainData.bookC.searchTitle(bookSearchTF.getText()), // �˻����
				bookTable); // ����� ���̺�
		bookSearchTF.setText(""); // bookSearchTF �ʱ�ȭ

		if(resultMsg!=null) { // �˻� ������ �ùٸ��� �Էµ��� �ʰų�, �˻� ����� ���� ���
			JOptionPane.showMessageDialog(CheckOutPanel.this, resultMsg); // ��� �޽��� ���̾�α� ���
			// bookSearchTF �ʱ�ȭ (���� ���� �Է�)
			bookSearchTF.setText("\uB3C4\uC11C \uC81C\uBAA9 \uC785\uB825"); // ���� ���� �Է�
		}
	}
	// �뿩 ����
	void actionCheckOut() {
		String phoneNum = selectPhoneNum.getText().replaceAll("-", "");
		try {
			if (phoneNum.length()==0)
				resultMsg = "�뿩�ڸ� �������ּ���.";//
			else if(checkOutTable.getRowCount()==0)
				resultMsg = "�뿩�� ������ �Է����ּ���.";
			else {
				// ȸ�����̺� �ʱ�ȭ
				DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
				customerTableModel.setRowCount(0);
				// �������̺� �ʱ�ȭ
				DefaultTableModel bookTableModel = (DefaultTableModel) bookTable.getModel();
				bookTableModel.setRowCount(0);
				// �뿩 �޼ҵ� ȣ��
				resultMsg = MainData.checkOutCtrl.checkOut(phoneNum, checkOutTable);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMsg = "�뿩 ��� ���� �� ���� �߻�(error : ex1)";
		} finally {
			JOptionPane.showMessageDialog(CheckOutPanel.this, resultMsg);
		}
	}
	
	public JScrollPane getCustomerScrollPane() {
		if (customerScrollPane == null) {
			customerScrollPane = new JScrollPane();
			customerScrollPane.setBounds(37, 53, 488, 85);
			customerScrollPane.setViewportView(getCustomerTable());
		}
		return customerScrollPane;
	}
	public JTextField getCustomerSearchTF() {
		if (customerSearchTF == null) {
			customerSearchTF = new JTextField();
			customerSearchTF.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) { // ȸ�� �˻� â���� Ű �Է� ��
					if (e.getKeyCode()== 10) { // �Է�Ű�� ����Ű�� ���
						actionCustomerSearch(); // ȸ���˻����� �޼ҵ� ȣ��
					}
				}
			});
			customerSearchTF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // ȸ�� �˻� â Ŭ����
					customerSearchTF.setText(""); // �ԷµǾ� �ִ� ���� ����
				}
			});
			customerSearchTF.setHorizontalAlignment(SwingConstants.CENTER);
			customerSearchTF.setText("\uD734\uB300\uC804\uD654 \uB05D \uB124\uC790\uB9AC \uC785\uB825"); // �޴���ȭ �� ���ڸ� �Է�
			customerSearchTF.setColumns(10);
			customerSearchTF.setBounds(237, 23, 207, 21);
		}
		return customerSearchTF;
	}
	public JLabel getCustomerSearch() {
		if (customerSearch == null) {
			customerSearch = new JLabel("\uD68C\uC6D0\uAC80\uC0C9"); // ȸ���˻�
			customerSearch.setHorizontalAlignment(SwingConstants.CENTER);
			customerSearch.setForeground(Color.WHITE);
			customerSearch.setFont(new Font("����", Font.PLAIN, 12));
			customerSearch.setBounds(158, 23, 80, 20);
		}
		return customerSearch;
	}
	public JLabel getBookSearch() {
		if (bookSearch == null) {
			bookSearch = new JLabel("\uB3C4\uC11C\uAC80\uC0C9"); // �����˻�
			bookSearch.setHorizontalAlignment(SwingConstants.CENTER);
			bookSearch.setForeground(Color.WHITE);
			bookSearch.setFont(new Font("����", Font.PLAIN, 12));
			bookSearch.setBounds(158, 154, 80, 20);
		}
		return bookSearch;
	}
	public JTextField getBookSearchTF() {
		if (bookSearchTF == null) {
			bookSearchTF = new JTextField();
			bookSearchTF.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) { // ���� �˻� â���� Ű �Է� ��
					if (e.getKeyCode()== 10) { // �Է�Ű�� ����Ű�� ���
						actionBookSearch(); // �����˻����� �޼ҵ� ȣ��
					}
				}
			});
			bookSearchTF.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // ���� �˻� â Ŭ�� ��
					bookSearchTF.setText(""); // �ԷµǾ� �ִ� ���� ����
				}
			});
			bookSearchTF.setHorizontalAlignment(SwingConstants.CENTER);
			bookSearchTF.setText("\uB3C4\uC11C \uC81C\uBAA9 \uC785\uB825"); // ���� ���� �Է�
			bookSearchTF.setColumns(10);
			bookSearchTF.setBounds(237, 154, 207, 21);
		}
		return bookSearchTF;
	}
	public JScrollPane getBookScrollPane() {
		if (bookScrollPane == null) {
			bookScrollPane = new JScrollPane();
			bookScrollPane.setBounds(37, 184, 488, 170);
			bookScrollPane.setViewportView(getBookTable());
		}
		return bookScrollPane;
	}
	public JButton getCheckOutBTN() {
		if (checkOutBTN == null) {
			checkOutBTN = new JButton("\uB300\uC5EC"); // �뿩
			checkOutBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // �̺�Ʈ �߻� ��
					actionCheckOut(); // �뿩���� �޼ҵ� ȣ��
				}
			});
			checkOutBTN.setForeground(Color.WHITE);
			checkOutBTN.setFont(new Font("����", Font.PLAIN, 12));
			checkOutBTN.setBorderPainted(false);
			checkOutBTN.setBackground(new Color(153, 51, 0));
			checkOutBTN.setBounds(437, 522, 88, 23);
		}
		return checkOutBTN;
	}
	public JButton getCustomerSearchBTN() {
		if (customerSearchBTN == null) {
			customerSearchBTN = new JButton("\uAC80\uC0C9"); // ȸ�� �˻� ��ư
			customerSearchBTN.addActionListener(new ActionListener() { // �׼Ǹ�����
				public void actionPerformed(ActionEvent e) { // �׼� �߻� ��
					actionCustomerSearch(); // ȸ���˻����� �޼ҵ� ȣ��
				}
			});
			customerSearchBTN.setForeground(Color.WHITE);
			customerSearchBTN.setFont(new Font("����", Font.PLAIN, 12));
			customerSearchBTN.setBorderPainted(false);
			customerSearchBTN.setBackground(new Color(153, 51, 0));
			customerSearchBTN.setBounds(456, 23, 68, 23);
		}
		return customerSearchBTN;
	}
	public JButton getBookSearchBTN() {
		if (bookSearchBTN == null) {
			bookSearchBTN = new JButton("\uAC80\uC0C9"); // ���� �˻� ��ư
			bookSearchBTN.addActionListener(new ActionListener() { // �׼Ǹ�����
				public void actionPerformed(ActionEvent e) { // �׼� �߻� ��
					actionBookSearch(); // �����˻����� �޼ҵ� ȣ��
				}
			});
			bookSearchBTN.setForeground(Color.WHITE);
			bookSearchBTN.setFont(new Font("����", Font.PLAIN, 12));
			bookSearchBTN.setBorderPainted(false);
			bookSearchBTN.setBackground(new Color(153, 51, 0));
			bookSearchBTN.setBounds(456, 154, 68, 23);
		}
		return bookSearchBTN;
	}
	public JButton getAddBooktBTN() {
		if (addBooktBTN == null) {
			addBooktBTN = new JButton("\uB300\uC5EC\uBAA9\uB85D \uCD94\uAC00"); // �뿩��� �߰�
			addBooktBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // �׼� �߻� ��
					MainData.checkOutCtrl.addCheckOut(bookTable, checkOutTable); // �뿩����߰� �޼ҵ� ȣ��
				}
			});
			addBooktBTN.setForeground(new Color(153, 51, 51));
			addBooktBTN.setFont(new Font("�������", Font.PLAIN, 12));
			addBooktBTN.setBackground(SystemColor.menu);
			addBooktBTN.setBounds(301, 372, 109, 23);
		}
		return addBooktBTN;
	}
	public JScrollPane getCheckOutScrollPane() {
		if (checkOutScrollPane == null) {
			checkOutScrollPane = new JScrollPane();
			checkOutScrollPane.setBounds(37, 405, 488, 102);
			checkOutScrollPane.setViewportView(getCheckOutTable());
		}
		return checkOutScrollPane;
	}
	public JLabel getCheckOutList() {
		if (checkOutList == null) {
			checkOutList = new JLabel("\uB2D8\uC758 \uB300\uC5EC \uC608\uC815 \uBAA9\uB85D"); // ���� �뿩 ���� ���
			checkOutList.setForeground(Color.WHITE);
			checkOutList.setFont(new Font("����", Font.PLAIN, 12));
			checkOutList.setBounds(158, 373, 117, 21);
		}
		return checkOutList;
	}
	public JTextField getSelectPhoneNum() {
		if (selectPhoneNum == null) {
			selectPhoneNum = new JTextField();
			selectPhoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
			selectPhoneNum.setFont(new Font("����", Font.PLAIN, 15));
			selectPhoneNum.setEditable(false);
			selectPhoneNum.setColumns(10);
			selectPhoneNum.setBounds(37, 372, 113, 21);
		}
		return selectPhoneNum;
	}
	public JButton getRemoveBooktBTN() {
		if (removeBooktBTN == null) {
			removeBooktBTN = new JButton("\uB300\uC5EC\uBAA9\uB85D \uC81C\uAC70");
			removeBooktBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainData.checkOutCtrl.removeCheckOut(checkOutTable); // �뿩������� �޼ҵ� ȣ��
				}
			});
			removeBooktBTN.setForeground(new Color(153, 51, 51));
			removeBooktBTN.setFont(new Font("�������", Font.PLAIN, 12));
			removeBooktBTN.setBackground(SystemColor.menu);
			removeBooktBTN.setBounds(416, 372, 109, 23);
		}
		return removeBooktBTN;
	}
	public JLabel getBackdrop() {
		if (backdrop == null) {
			backdrop = new JLabel("");
			backdrop.setOpaque(true);
			backdrop.setBackground(new Color(102, 51, 0));
			backdrop.setBounds(22, 10, 520, 550);
		}
		return backdrop;
	}
	public JTable getBookTable() {
		if (bookTable == null) {
			bookTable = new JTable();
			bookTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\uB3C4\uC11C\uBC88\uD638", "\uBD84\uB958", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uAC00\uB2A5\uC77C"
				}
			));
			bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);
			bookTable.getColumnModel().getColumn(0).setMinWidth(20);
			bookTable.getColumnModel().getColumn(0).setMaxWidth(60);
			bookTable.getColumnModel().getColumn(1).setPreferredWidth(60);
			bookTable.getColumnModel().getColumn(1).setMinWidth(60);
			bookTable.getColumnModel().getColumn(1).setMaxWidth(100);
			bookTable.getColumnModel().getColumn(2).setPreferredWidth(150);
			bookTable.getColumnModel().getColumn(2).setMinWidth(150);
			bookTable.getColumnModel().getColumn(3).setMinWidth(75);
			bookTable.getColumnModel().getColumn(4).setMinWidth(75);
		}
		return bookTable;
	}
	public JTable getCustomerTable() {
		if (customerTable == null) {
			customerTable = new JTable();
			customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			customerTable.addMouseListener(new MouseAdapter() { // ȸ�����̺� ���콺������
				@Override
				public void mouseClicked(MouseEvent e) { // ���콺 Ŭ�� ��
					int customerSelectRow = customerTable.getSelectedRow(); // �ش� ���̺��� Ŭ���� ���� �����ϰ�
					selectPhoneNum.setText((String) customerTable.getModel().getValueAt(customerSelectRow, 1)); // ����� �࿡ 1��° ��(�޴���ȭ)�� selectPhoneNum�� ����
				}
			});
			customerTable.setModel(new DefaultTableModel(
				new Object[][] {
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
		}
		return customerTable;
	}
	public JTable getCheckOutTable() {
		if (checkOutTable == null) {
			checkOutTable = new JTable();
			checkOutTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\uB3C4\uC11C\uBC88\uD638", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uAE30\uAC04"
				}
			));
			checkOutTable.getColumnModel().getColumn(0).setPreferredWidth(50);
			checkOutTable.getColumnModel().getColumn(0).setMinWidth(20);
			checkOutTable.getColumnModel().getColumn(0).setMaxWidth(60);
			checkOutTable.getColumnModel().getColumn(1).setPreferredWidth(250);
			checkOutTable.getColumnModel().getColumn(1).setMinWidth(150);
			checkOutTable.getColumnModel().getColumn(2).setMinWidth(75);
			checkOutTable.getColumnModel().getColumn(3).setPreferredWidth(60);
			checkOutTable.getColumnModel().getColumn(3).setMinWidth(60);
			checkOutTable.getColumnModel().getColumn(3).setMaxWidth(60);
		}
		return checkOutTable;
	}
}
