package Project;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class BookPanel extends JPanel {
	private JButton btnNewButton;
	private JButton btnNewButton_1_2;
	private JLabel lblNewLabel_3_1;
	private JTextField tfAuthor;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblNewLabel_3;
	private JTextField tfName;
	private JLabel lblNewLabel_5_1_1_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3_2;
	private JTextField tfUAuthor;
	private JButton btnNewButton_1_1_1_1;
	private JLabel lblNewLabel_3_1_2;
	private JTextField tfUName;
	private JLabel lblNewLabel_3_1_1_1;
	private JTextField tfUNum;
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
		add(getCbBr());
		add(getCbUBr());
		add(getBtnNewButton_1_2());
		add(getLblNewLabel_3_1());
		add(getTfAuthor());
		add(getLblNewLabel_3_1_1());
		add(getLblNewLabel_3());
		add(getTfName());
		add(getLblNewLabel_3_1_1_2());
		add(getLblNewLabel_5_1_1_1());
		add(getLblNewLabel_5());
		add(getLblNewLabel_3_2());
		add(getLblNewLabel_3_2_1());
		add(getLblNewLabel_3_1_2_1());
		add(getTfUAuthor());
		add(getBtnNewButton_1_1_1_1());
		add(getLblNewLabel_3_1_2());
		add(getTfUName());
		add(getLblNewLabel_3_1_1_1());
		add(getTfUNum());
		add(getBtnNewButton_1_1_1());
		add(getLblNewLabel_5_1());
		add(getLblNewLabel_5_1_1());
		add(getScrollPane());
	

	}
	
	int count=0;
	BookController bc;
	private JLabel lblNewLabel_3_2_1;
	private JLabel lblNewLabel_3_1_2_1;
	private JLabel lblNewLabel_3_1_1_2;
	private JComboBox comboBox_1;
	private JComboBox cbUDate;
	private JComboBox cbBr;
	private JComboBox cbUBr;
	private JComboBox cbDate;
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bc = new BookController();
					String findStr = tfName.getText();
					
					DefaultTableModel model = 
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);//±âÁ¸ Ç¥½ÃµÈ µ¥ÀÌÅÍ¸¦ ¸ðµÎ »èÁ¦
					
					if(findStr.equals("")) {
						for(int i=0; i<BookController.books.size(); i++) {
						Book b = BookController.books.get(i);
						String[] data = {String.format("%s", b.getNum()), b.getName(), b.getAuthor(),"", b.getBr(),b.getDate()};
						model.addRow(data);}
						}
					else {
					for(int i=0; i<BookController.books.size(); i++) {
						Book b = BookController.books.get(i);
						if(b.name.equals(findStr)) {
							String[] data = {String.format("%s", b.getNum()), b.getName(), b.getAuthor(), "", b.getBr(), b.getDate()};
						model.addRow(data);}
					}
					}	
					
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(new Color(153, 51, 0));
			btnNewButton.setBounds(436, 30, 80, 23);
		}
		return btnNewButton;
		
	}
	public JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("\uB4F1\uB85D");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    count++;
				    
				    		
					String bName = tfName.getText();
					String bAuthor = tfAuthor.getText();
					String br = (String) cbBr.getSelectedItem();
					String date = (String) cbDate.getSelectedItem();
					
					
					Book b = new Book(count,bName, bAuthor,br,date);
					bc = new BookController();
					String msg = bc.append(b);
					JOptionPane.showMessageDialog(null, msg);
					
					DefaultTableModel model = 
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);//±âÁ¸ Ç¥½ÃµÈ µ¥ÀÌÅÍ¸¦ ¸ðµÎ »èÁ¦
					
					for(int i=0; i<BookController.books.size(); i++) {
						b = BookController.books.get(i);
						String[] data = {String.format("%s", b.getNum()), b.getName(), b.getAuthor(),"", b.getBr(),b.getDate()};
						model.addRow(data);}
					
				}
			});
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
			lblNewLabel_3_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_1.setBounds(219, 78, 50, 15);
		}
		return lblNewLabel_3_1_1;
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
	public JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setDragEnabled(true);
			tfName.setColumns(10);
			tfName.setBounds(103, 31, 310, 23);
		}
		return tfName;
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
			lblNewLabel_3_1_2.setBounds(41, 489, 50, 15);
		}
		return lblNewLabel_3_1_2;
	}
	public JTextField getTfUName() {
		if (tfUName == null) {
			tfUName = new JTextField();
			tfUName.setColumns(10);
			tfUName.setBounds(103, 451, 148, 23);
		}
		return tfUName;
	}
	public JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel("No.");
			lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_1_1.setBounds(41, 418, 50, 15);
		}
		return lblNewLabel_3_1_1_1;
	}
	public JTextField getTfUNum() {
		if (tfUNum == null) {
			tfUNum = new JTextField();
			tfUNum.setEnabled(false);
			tfUNum.setColumns(10);
			tfUNum.setBounds(103, 418, 148, 23);
		}
		return tfUNum;
	}
	public JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("\uC218\uC815");
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				}
			});
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int row = table.getSelectedRow();
					
					tfUNum.setText((String) table.getModel().getValueAt(row, 0));
					tfUName.setText((String) table.getModel().getValueAt(row, 1));
					tfUAuthor.setText((String) table.getModel().getValueAt(row, 2));
					
					
				}
			});
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
					"NO.", "\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uB300\uC5EC\uD604\uD669", "\uBD84\uB958", "\uB300\uC5EC\uC77C"
				}
			));
		}
		return table;
	}
	private JLabel getLblNewLabel_3_2_1() {
		if (lblNewLabel_3_2_1 == null) {
			lblNewLabel_3_2_1 = new JLabel("\uBD84\uB958");
			lblNewLabel_3_2_1.setForeground(Color.WHITE);
			lblNewLabel_3_2_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_2_1.setBounds(298, 422, 50, 15);
		}
		return lblNewLabel_3_2_1;
	}
	private JLabel getLblNewLabel_3_1_2_1() {
		if (lblNewLabel_3_1_2_1 == null) {
			lblNewLabel_3_1_2_1 = new JLabel("\uB300\uC5EC\uC77C");
			lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_2_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_2_1.setBounds(298, 456, 50, 15);
		}
		return lblNewLabel_3_1_2_1;
	}
	private JLabel getLblNewLabel_3_1_1_2() {
		if (lblNewLabel_3_1_1_2 == null) {
			lblNewLabel_3_1_1_2 = new JLabel("\uB300\uC5EC\uC77C");
			lblNewLabel_3_1_1_2.setForeground(Color.WHITE);
			lblNewLabel_3_1_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_1_2.setBounds(219, 122, 50, 15);
		}
		return lblNewLabel_3_1_1_2;
	}

	private JComboBox getCbUDate() {
		if (cbUDate == null) {
			cbUDate = new JComboBox();
			cbUDate.setModel(new DefaultComboBoxModel(new String[] {"3\uC77C", "7\uC77C"}));
			cbUDate.setBounds(360, 451, 148, 23);
		}
		return cbUDate;
	}
	private JComboBox getCbBr() {
		if (cbBr == null) {
			cbBr = new JComboBox();
			cbBr.setModel(new DefaultComboBoxModel(new String[] {"\uB9CC\uD654", "\uC18C\uC124"}));
			cbBr.setBounds(288, 74, 125, 23);
		}
		return cbBr;
	}
	private JComboBox getCbUBr() {
		if (cbUBr == null) {
			cbUBr = new JComboBox();
			cbUBr.setModel(new DefaultComboBoxModel(new String[] {"\uB9CC\uD654", "\uC18C\uC124"}));
			cbUBr.setBounds(360, 418, 148, 23);
		}
		return cbUBr;
	}
	

	private JComboBox getCbDate() {
		if (cbDate == null) {
			cbDate = new JComboBox();
			cbDate.setModel(new DefaultComboBoxModel(new String[] {"3\uC77C", "7\uC77C"}));
			cbDate.setBounds(288, 118, 125, 23);
		}
		return cbDate;
	}
}
