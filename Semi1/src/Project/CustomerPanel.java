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
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerPanel extends JPanel {
	private JButton btnNewButton;
	private JButton btnNewButton_1_2;
	private JLabel lblNewLabel_3_1;
	private JTextField tfIrum;
	private JLabel lblNewLabel_3_1_1;
	private JTextField tfId;
	private JLabel lblNewLabel_3;
	private JTextField tfAddress;
	private JLabel lblNewLabel_5_1_1_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3_2;
	private JTextField tfUIrum;
	private JButton btnNewButton_1_1_1_1;
	private JLabel lblNewLabel_3_1_2;
	private JTextField tfUId;
	private JLabel lblNewLabel_3_1_1_1;
	private JTextField tfUAddress;
	private JButton btnNewButton_1_1_1;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_5_1_1;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getBtnNewButton());
		add(getBtnNewButton_1_2());
		add(getLblNewLabel_3_1());
		add(getTfIrum());
		add(getLblNewLabel_3_1_1());
		add(getTfId());
		add(getLblNewLabel_3());
		add(getTfAddress());
		add(getLblNewLabel_5_1_1_1());
		add(getLblNewLabel_5());
		add(getLblNewLabel_3_2());
		add(getTfUIrum());
		add(getBtnNewButton_1_1_1_1());
		add(getLblNewLabel_3_1_2());
		add(getTfUId());
		add(getLblNewLabel_3_1_1_1());
		add(getTfUAddress());
		add(getBtnNewButton_1_1_1());
		add(getLblNewLabel_5_1());
		add(getLblNewLabel_5_1_1());
		add(getScrollPane());

	}
	public JButton getBtnNewButton() { 	//회원 정보 검색 버튼
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CustomerController cc = new CustomerController();
					String findId = tfId.getText();
					List<Customer>list = cc.search(findId);
					
					DefaultTableModel model = 
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);
					for(int i = 0; i < list.size(); i++) {
						Customer c = list.get(i);
						String [] data = {c.getIrum(),c.getId(),c.getAddress()};
						model.addRow(data);
					}
					
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(new Color(153, 51, 0));
			btnNewButton.setBounds(436, 30, 80, 23);
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1_2() { //회원 정보 등록 버튼
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("\uB4F1\uB85D");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cId = tfId.getText();
					String cIrum = tfIrum.getText();
					String cAddress = tfAddress.getText();				
					
					int result = JOptionPane.showConfirmDialog(null, "회원 정보를 등록 하시겠습니까?",
												"Confirm",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION) {
						
					}
					else if(result == JOptionPane.YES_OPTION) {
					Customer c = new Customer(cId, cIrum, cAddress);
					CustomerController cc = new CustomerController();
					String msg = cc.append(c);
					JOptionPane.showMessageDialog(CustomerPanel.this, msg);
					}
					else {
						
					}
				
				}
			});
			btnNewButton_1_2.setForeground(Color.WHITE);
			btnNewButton_1_2.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton_1_2.setBorderPainted(false);
			btnNewButton_1_2.setBackground(new Color(153, 51, 0));
			btnNewButton_1_2.setBounds(448, 119, 68, 23);
		}
		return btnNewButton_1_2;
	}
	public JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_3_1.setForeground(Color.WHITE);
			lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 12));
			lblNewLabel_3_1.setBounds(41, 78, 50, 15);
		}
		return lblNewLabel_3_1;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setColumns(10);
			tfIrum.setBounds(103, 31, 104, 23);
		}
		return tfIrum;
	}
	public JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_3_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
			lblNewLabel_3_1_1.setBounds(219, 35, 50, 15);
		}
		return lblNewLabel_3_1_1;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(288, 31, 125, 23);
		}
		return tfId;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC774\uB984");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(41, 34, 50, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setDragEnabled(true);
			tfAddress.setColumns(10);
			tfAddress.setBounds(103, 75, 310, 23);
		}
		return tfAddress;
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
			lblNewLabel_3_2 = new JLabel("\uC774\uB984");
			lblNewLabel_3_2.setForeground(Color.WHITE);
			lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 12));
			lblNewLabel_3_2.setBounds(41, 422, 50, 15);
		}
		return lblNewLabel_3_2;
	}
	public JTextField getTfUIrum() {
		if (tfUIrum == null) {
			tfUIrum = new JTextField();
			tfUIrum.setColumns(10);
			tfUIrum.setBounds(103, 418, 174, 23);
		}
		return tfUIrum;
	}
	public JButton getBtnNewButton_1_1_1_1() { //회원 정보 삭제 기능
		if (btnNewButton_1_1_1_1 == null) {
			btnNewButton_1_1_1_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String irum = tfUIrum.getText();
					String id = tfUId.getText();
					String address = tfUAddress.getText();
					
					int result = JOptionPane.showConfirmDialog(null, "회원 정보를 삭제 하시겠습니까?",
								"confirm",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION) {
						
					}
					else if(result == JOptionPane.YES_OPTION) {
					Customer c = new Customer(id, irum, address);
					CustomerController cc = new CustomerController();
					String msg = cc.delete(c);
					JOptionPane.showMessageDialog(CustomerPanel.this,msg);
					}
					else {
						
					}
				
				}
			});
			btnNewButton_1_1_1_1.setForeground(Color.WHITE);
			btnNewButton_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton_1_1_1_1.setBorderPainted(false);
			btnNewButton_1_1_1_1.setBackground(new Color(153, 51, 0));
			btnNewButton_1_1_1_1.setBounds(460, 527, 68, 23);
		}
		return btnNewButton_1_1_1_1;
	}
	public JLabel getLblNewLabel_3_1_2() {
		if (lblNewLabel_3_1_2 == null) {
			lblNewLabel_3_1_2 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_3_1_2.setForeground(Color.WHITE);
			lblNewLabel_3_1_2.setFont(new Font("굴림", Font.PLAIN, 12));
			lblNewLabel_3_1_2.setBounds(41, 455, 50, 15);
		}
		return lblNewLabel_3_1_2;
	}
	public JTextField getTfUId() {
		if (tfUId == null) {
			tfUId = new JTextField();
			tfUId.setEnabled(false);
			tfUId.setColumns(10);
			tfUId.setBounds(103, 451, 174, 23);
		}
		return tfUId;
	}
	public JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_1_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
			lblNewLabel_3_1_1_1.setBounds(41, 486, 50, 15);
		}
		return lblNewLabel_3_1_1_1;
	}
	public JTextField getTfUAddress() {
		if (tfUAddress == null) {
			tfUAddress = new JTextField();
			tfUAddress.setColumns(10);
			tfUAddress.setBounds(103, 484, 174, 23);
		}
		return tfUAddress;
	}
	public JButton getBtnNewButton_1_1_1() { //회원 정보 수정기능
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("\uC218\uC815");
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				String irum = tfUIrum.getText();
				String id = tfUId.getText();
				String address = tfUAddress.getText();
				
				int result = JOptionPane.showConfirmDialog(null, "회원 정보를 수정 하시겠습니까?",
									"Confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION)
				{
					
				}
				else if(result == JOptionPane.YES_OPTION) {
				Customer c = new Customer(id, irum, address);
				CustomerController cc = new CustomerController();
				String msg = cc.update(c);
				JOptionPane.showMessageDialog(CustomerPanel.this, msg);
				}
				else {
					
				}
				}
			});
			btnNewButton_1_1_1.setForeground(Color.WHITE);
			btnNewButton_1_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
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
			lblNewLabel_5_1.setFont(new Font("돋움", Font.BOLD, 14));
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
					
					tfUIrum.setText((String)table.getModel().getValueAt(row, 0));
					tfUId.setText((String)table.getModel().getValueAt(row,1));
					tfUAddress.setText((String)table.getModel().getValueAt(row, 2));
					
				}
			});
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
				},
				new String[] {
					"\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(70);
			table.getColumnModel().getColumn(0).setMinWidth(70);
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(1).setMinWidth(120);
			table.getColumnModel().getColumn(2).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setMinWidth(200);
		}
		return table;
	}
}
