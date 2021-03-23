package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class BookPanel extends JPanel {
	private JButton btnNewButton;
	private JButton btnNewButton_1_2;
	private JLabel lblNewLabel_3_1;
	private JTextField tfAuthor;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblNewLabel_3;
	private JTextField tfTitle;
	private JLabel lblNewLabel_5_1_1_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3_2;
	private JTextField tfUAuthor;
	private JButton btnNewButton_1_1_1_1;
	private JLabel lblNewLabel_3_1_2;
	private JTextField tfUTitle;
	private JLabel lblNewLabel_3_1_1_1;
	private JTextField tfUBookNo;
	private JButton btnNewButton_1_1_1;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_5_1_1;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BookPanel() {
		

		
		setBackground(Color.WHITE);
		setLayout(null);
		add(getCbDate());
		add(getBtnNewButton());
		add(getCbUDate());
		add(getCbSort());
		add(getCbUSort());
		add(getBtnNewButton_1_2());
		add(getLblNewLabel_3_1());
		add(getTfAuthor());
		add(getLblNewLabel_3_1_1());
		add(getLblNewLabel_3());
		add(getTfTitle());
		add(getLblNewLabel_3_1_1_2());
		add(getLblNewLabel_5_1_1_1());
		add(getLblNewLabel_5());
		add(getLblNewLabel_3_2());
		add(getLblNewLabel_3_2_1());
		add(getLblNewLabel_3_1_2_1());
		add(getTfUAuthor());
		add(getBtnNewButton_1_1_1_1());
		add(getLblNewLabel_3_1_2());
		add(getTfUTitle());
		add(getLblNewLabel_3_1_1_1());
		add(getTfUBookNo());
		add(getBtnNewButton_1_1_1());
		add(getLblNewLabel_5_1());
		add(getLblNewLabel_5_1_1());
		add(getScrollPane());
	
	

	}
	boolean searchCheck = false; // No.���� �˻��� üũ�ڽ����� Ȯ��
	
	
	private JLabel lblNewLabel_3_2_1;
	private JLabel lblNewLabel_3_1_2_1;
	private JLabel lblNewLabel_3_1_1_2;
	private JComboBox comboBox_1;
	private JComboBox cbUDate;
	private JComboBox cbSort;
	private JComboBox cbUSort;
	private JComboBox cbDate;
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");      // �˻� ��ư
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DefaultTableModel model =               // �� ����
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);                   //���� ǥ�õ� �����͸� ��� ����
					
					if(tfTitle.getText().length()==0&&tfAuthor.getText().length()==0) {      // ������� ������ �˻�� �������.
						for(int i=0; i<MainData.getBooks().size(); i++) {                    // Books ����Ʈ�� �ִ� ��ü�� ���� ����ϱ�.
							Book b = MainData.getBooks().get(i);
							String[] data = {b.getBookNo(),b.getTitle(), b.getAuthor(),"�뿩��Ȳ", b.getSort(), String.format("%s��",b.getDate())};
							model.addRow(data);}}
						
						
						
					 // �˻�� ���� �ϳ� �̻� �ִ� ���.
					else {String findStr = tfTitle.getText();     // ã�� �˻���(������ or No.)               
					      String findStr2 = tfAuthor.getText();   // ã�� ���� 
					     List<Book> list = MainData.bookC.search(findStr, findStr2);   // �˻���� ��ġ�ϴ� �ش� ��ü�� ����Ʈ�� �ҷ����� �޼ҵ�.
					     	
								for(int i=0; i<list.size(); i++) {       // �ش� ��ü���� ����Ʈ�� ���.
									Book b = list.get(i);
									String[] data = {b.getBookNo(),b.getTitle(), b.getAuthor(),"�뿩��Ȳ", b.getSort(), String.format("%s��",b.getDate())};
									model.addRow(data);
								}}
					
				    
					
					/*  if(findStr.equals("")) {
						for(int i=0; i<BookController.books.size(); i++) {
						Book b = BookController.books.get(i);
						String[] data = {String.format("%s", b.getBookNo()), b.getTitle(), b.getAuthor(),"", b.getSort(),b.getDate()};
						model.addRow(data);}
						}
					else {
					for(int i=0; i<BookController.books.size(); i++) {
						Book b = BookController.books.get(i);
						if(b.title.equals(findStr)) {
							String[] data = {String.format("%s", b.getBookNo()), b.getTitle(), b.getAuthor(), "", b.getSort(), b.getDate()};
						model.addRow(data);}}}
						*/
					
						
				}
				
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("����", Font.PLAIN, 12));
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(new Color(153, 51, 0));
			btnNewButton.setBounds(448, 30, 68, 23);
		}
		return btnNewButton;
		
	}
	public JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("\uB4F1\uB85D");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    		
					 
					String bTitle = tfTitle.getText();          //�ؽ�Ʈ �ʵ忡�� �� �ҷ��ͼ� �� ������ ����.
					String bAuthor = tfAuthor.getText();
					String bSort = (String) cbSort.getSelectedItem();
					String bDate = (String) cbDate.getSelectedItem();
					
					
					Book b = new Book(bTitle, bAuthor, bSort, bDate.replace("��", ""));   // �� �������� Book ��ü�� ����
					String msg = MainData.bookC.append(b);                  // ������ ��ü�� books ����Ʈ�� ����
					JOptionPane.showMessageDialog(null, msg);               // ���� Ȯ�� �޽��� ���.
					
					DefaultTableModel model =                            
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);//���� ǥ�õ� �����͸� ��� ����
					
					for(int i=0; i<MainData.getBooks().size(); i++) {    // Books�� �ִ� ��ü ��� model�� ����ϱ�.
						b = MainData.getBooks() .get(i);
						String[] data = {b.getBookNo(), b.getTitle(), b.getAuthor(),"", b.getSort(),String.format("%s��", b.getDate())};
						model.addRow(data);}
					
				}
			});
			btnNewButton_1_2.setForeground(Color.WHITE);
			btnNewButton_1_2.setFont(new Font("����", Font.PLAIN, 12));
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
			lblNewLabel_3_1.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_1.setBounds(41, 78, 50, 15);
		}
		return lblNewLabel_3_1;
	}
	public JTextField getTfAuthor() {
		if (tfAuthor == null) {
			tfAuthor = new JTextField();
			tfAuthor.setColumns(10);
			tfAuthor.setBounds(103, 75, 104, 23);
		}
		return tfAuthor;
	}
	public JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("\uBD84\uB958");
			lblNewLabel_3_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_1_1.setBounds(219, 78, 50, 15);
		}
		return lblNewLabel_3_1_1;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uB3C4\uC11C\uBA85");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(41, 34, 50, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setDragEnabled(true);
			tfTitle.setColumns(10);
			tfTitle.setBounds(103, 31, 310, 23);
		}
		return tfTitle;
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
			lblNewLabel_3_2.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_2.setBounds(41, 455, 50, 15);
		}
		return lblNewLabel_3_2;
	}
	public JTextField getTfUAuthor() {
		if (tfUAuthor == null) {
			tfUAuthor = new JTextField();
			tfUAuthor.setColumns(10);
			tfUAuthor.setBounds(103, 485, 148, 23);
		}
		return tfUAuthor;
	}
	public JButton getBtnNewButton_1_1_1_1() {
		if (btnNewButton_1_1_1_1 == null) {
			btnNewButton_1_1_1_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String findStr = tfUBookNo.getText(); // ã�� �� (No.)
					int index = MainData.bookC.selectOne(findStr);  // ������ ��ü �ε��� ã��
					MainData.getBooks().remove(index);      // ��ü ����
					List<Book> list = MainData.bookC.search(findStr);
				     
					DefaultTableModel model =               // �� ����
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);                   //���� ǥ�õ� �����͸� ��� ����
			   							
						for(int i=0; i<list.size(); i++) {  // �ش� �� ���� �Ǿ����� Ȯ���ϱ�. (��� �����)
							Book b = list.get(i);
							String[] data = {b.getBookNo(),b.getTitle(), b.getAuthor(),"�뿩��Ȳ", b.getSort(), String.format("%s��",b.getDate())};
							model.addRow(data);}				
				}
			});
			btnNewButton_1_1_1_1.setForeground(Color.WHITE);
			btnNewButton_1_1_1_1.setFont(new Font("����", Font.PLAIN, 12));
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
			lblNewLabel_3_1_2.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_1_2.setBounds(41, 489, 50, 15);
		}
		return lblNewLabel_3_1_2;
	}
	public JTextField getTfUTitle() {
		if (tfUTitle == null) {
			tfUTitle = new JTextField();
			tfUTitle.setColumns(10);
			tfUTitle.setBounds(103, 451, 148, 23);
		}
		return tfUTitle;
	}
	public JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel("No.");
			lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1_1.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_1_1_1.setBounds(41, 418, 50, 15);
		}
		return lblNewLabel_3_1_1_1;
	}
	public JTextField getTfUBookNo() {
		if (tfUBookNo == null) {
			tfUBookNo = new JTextField();
			tfUBookNo.setDisabledTextColor(Color.BLACK);
			tfUBookNo.setEnabled(false);
			tfUBookNo.setColumns(10);
			tfUBookNo.setBounds(103, 418, 148, 23);
		}
		return tfUBookNo;
	}
	public JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("\uC218\uC815");     // ���� ��ư
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				String findStr = tfUBookNo.getText(); // ������ ��ü�� ã�� �˻���(No.)
				
				String title  = tfUTitle.getText();         // ������ ���� ���� (�ؽ�Ʈ �ش� �ʵ忡�� �ҷ���)
				String author =  tfUAuthor.getText();
				String sort   = (String) cbUSort.getSelectedItem();
				String date   = (String) cbUDate.getSelectedItem();
				
				int index = MainData.bookC.selectOne(findStr);      // �˻���(No)���� ã�� ��ü�� �ε��� ��ȣ�� �������� �޼ҵ�.
			
				MainData.bookC.update(index, title, author, sort, date);   // ������ �������� ������Ʈ.
										     
				DefaultTableModel model =               // �� ����
						(DefaultTableModel)table.getModel();
				model.setRowCount(0);                   //���� ǥ�õ� �����͸� ��� ����
		   					
				Book b = MainData.getBooks().get(index);     // �ش� �ε����� ��ü�� ������.(ȭ�� ������ ����)
				String[] data = {b.getBookNo(),b.getTitle(), b.getAuthor(),"�뿩��Ȳ", b.getSort(), String.format("%s��",b.getDate())};
				model.addRow(data);   // �ش� ���� model�� ���
				
				
				}
			});
			btnNewButton_1_1_1.setForeground(Color.WHITE);
			btnNewButton_1_1_1.setFont(new Font("����", Font.PLAIN, 12));
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
			lblNewLabel_5_1.setFont(new Font("����", Font.BOLD, 14));
			lblNewLabel_5_1.setBackground(new Color(102, 51, 0));
			lblNewLabel_5_1.setBounds(22, 379, 520, 30);
		}
		return lblNewLabel_5_1;
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
			table.setBackground(Color.WHITE);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int row = table.getSelectedRow();
					
					tfUBookNo.setText((String) table.getModel().getValueAt(row, 0));
					tfUTitle.setText((String) table.getModel().getValueAt(row, 1));
					tfUAuthor.setText((String) table.getModel().getValueAt(row, 2));
					
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\uB3C4\uC11C\uBC88\uD638", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uD604\uD669", "\uBD84\uB958", "\uB300\uC5EC\uC77C"
				}
			));
		}
		return table;
	}
	private JLabel getLblNewLabel_3_2_1() {
		if (lblNewLabel_3_2_1 == null) {
			lblNewLabel_3_2_1 = new JLabel("\uBD84\uB958");
			lblNewLabel_3_2_1.setForeground(Color.WHITE);
			lblNewLabel_3_2_1.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_2_1.setBounds(298, 422, 50, 15);
		}
		return lblNewLabel_3_2_1;
	}
	private JLabel getLblNewLabel_3_1_2_1() {
		if (lblNewLabel_3_1_2_1 == null) {
			lblNewLabel_3_1_2_1 = new JLabel("\uB300\uC5EC\uC77C");
			lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_2_1.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_1_2_1.setBounds(298, 456, 50, 15);
		}
		return lblNewLabel_3_1_2_1;
	}
	private JLabel getLblNewLabel_3_1_1_2() {
		if (lblNewLabel_3_1_1_2 == null) {
			lblNewLabel_3_1_1_2 = new JLabel("\uB300\uC5EC\uC77C");
			lblNewLabel_3_1_1_2.setForeground(Color.WHITE);
			lblNewLabel_3_1_1_2.setFont(new Font("����", Font.PLAIN, 12));
			lblNewLabel_3_1_1_2.setBounds(219, 122, 50, 15);
		}
		return lblNewLabel_3_1_1_2;
	}

	private JComboBox getCbUDate() {
		if (cbUDate == null) {
			cbUDate = new JComboBox();
			cbUDate.setBackground(Color.WHITE);
			cbUDate.setModel(new DefaultComboBoxModel(new String[] {"3\uC77C", "7\uC77C"}));
			cbUDate.setBounds(360, 451, 148, 23);
		}
		return cbUDate;
	}
	private JComboBox getCbSort() {
		if (cbSort == null) {
			cbSort = new JComboBox();
			cbSort.setBackground(Color.WHITE);
			cbSort.setModel(new DefaultComboBoxModel(new String[] {"\uB9CC\uD654", "\uC18C\uC124"}));
			cbSort.setBounds(288, 74, 125, 23);
		}
		return cbSort;
	}
	private JComboBox getCbUSort() {
		if (cbUSort == null) {
			cbUSort = new JComboBox();
			cbUSort.setBackground(Color.WHITE);
			cbUSort.setModel(new DefaultComboBoxModel(new String[] {"\uB9CC\uD654", "\uC18C\uC124"}));
			cbUSort.setBounds(360, 418, 148, 23);
		}
		return cbUSort;
	}
	

	private JComboBox getCbDate() {
		if (cbDate == null) {
			cbDate = new JComboBox();
			cbDate.setBackground(Color.WHITE);
			cbDate.setModel(new DefaultComboBoxModel(new String[] {"3\uC77C", "7\uC77C"}));
			cbDate.setBounds(288, 118, 125, 23);
		}
		return cbDate;
	}
}
