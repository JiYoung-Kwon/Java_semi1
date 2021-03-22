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
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;

public class CheckInPanel extends JPanel {
	private JButton btnNewButton;
	private JButton btnNewButton_1_2;
	private JTextField tfFindTitle;
	private JTextField tfCODate;
	private JTextField tfCIDate;
	private JLabel lblNewLabel_5_1_1_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3_2;
	private JTextField tfTitle;
	private JButton btnNewButton_1_1_1_1;
	private JLabel lblNewLabel_3_1_2;
	private JTextField tfIrum;
	private JLabel lblNewLabel_3_1_1_1;
	private JTextField tfPhone;
	private JButton btnNewButton_1_1_1;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_3_1_2_1;
	private JLabel lblNewLabel_3_1_1_1_1;
	private JLabel lblNewLabel_5_1_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	int tfId;
	String tfReturnDate;
	CheckInController cc = new CheckInController();
	
	public CheckInPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("µµ¼­¸í");
		comboBox.addItem("ÀÌ¸§");
		comboBox.setBounds(32, 31, 68, 22);

		add(comboBox);
		add(getBtnNewButton());
		add(getBtnNewButton_1_2());
		add(getTfFindTitle());
		add(getTfCODate());
		add(getTfCIDate());
		add(getLblNewLabel_5_1_1_1());
		add(getLblNewLabel_5());
		add(getLblNewLabel_3_2());
		add(getTfTitle());
		add(getBtnNewButton_1_1_1_1());
		add(getLblNewLabel_3_1_2());
		add(getTfIrum());
		add(getLblNewLabel_3_1_1_1());
		add(getTfPhone());
		add(getBtnNewButton_1_1_1());
		add(getLblNewLabel_5_1());
		add(getLblNewLabel_3_1_2_1());
		add(getLblNewLabel_3_1_1_1_1());
		add(getLblNewLabel_5_1_1());
		add(getScrollPane());

		// Å×½ºÆ®¿ë ´Ù¸¥ ÄÚµå °¡Á®¿À±â
		Customer customer1 = new Customer("01020758297", "±ÇÁö¿µ", "¼ö¿ø½Ã");
		
		CheckOut k = new CheckOut();
		k.setId(1);
		k.setTitle("¾È³çÇÏ¼¼¿ä");
		k.setIrum(customer1.getIrum());
		k.setPhone(customer1.getId());
		k.setCoDate("20210322");
		k.setCiDate("20210325");
		cc.init(k);

		CheckOut z = new CheckOut();
		z.setId(2);
		z.setTitle("¾È³ç");
		z.setIrum(customer1.getIrum());
		z.setPhone(customer1.getId());
		z.setCoDate("20210322");
		z.setCiDate("20210325");
		cc.init(z);	
		
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
					String findStr = tfFindTitle.getText();
					String type = comboBox.getSelectedItem().toString();
					List<CheckOut> list = cc.search(findStr, type);

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (int i = 0; i < list.size(); i++) {
						CheckOut c = list.get(i);
						String[] data = { Integer.toString(c.getId()), c.getTitle(), c.getIrum(), c.getPhone(),
								c.getCoDate(),c.getCiDate(),c.getReturnDate()};
						model.addRow(data);
					}

				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(new Color(153, 51, 0));
			btnNewButton.setBounds(436, 31, 80, 23);
		}
		return btnNewButton;
	}

	public JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("\uBC18\uB0A9");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = tfId;
					String title = tfTitle.getText();
					String irum = tfIrum.getText();
					String phone = tfPhone.getText();
					String coDate = tfCODate.getText();
					String ciDate = tfCIDate.getText();
					
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					Date now = new Date();
					String returnDate = format1.format(now);

					CheckOut c = new CheckOut(id, title, irum, phone, coDate, ciDate, returnDate);

					CheckInController cc = new CheckInController();

					String msg = "¹Ý³³ÇÏ½Ã°Ú½À´Ï±î?";
					int result = JOptionPane.showConfirmDialog(CheckInPanel.this, msg);
					
					if(result == JOptionPane.YES_OPTION) {
						msg = cc.append(c);
						JOptionPane.showMessageDialog(CheckInPanel.this, msg);
					}
					
				}
			});
			btnNewButton_1_2.setForeground(Color.WHITE);
			btnNewButton_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			btnNewButton_1_2.setBorderPainted(false);
			btnNewButton_1_2.setBackground(new Color(153, 51, 0));
			btnNewButton_1_2.setBounds(436, 82, 80, 23);
		}
		return btnNewButton_1_2;
	}

	public JTextField getTfFindTitle() {
		if (tfFindTitle == null) {
			tfFindTitle = new JTextField();
			tfFindTitle.setDragEnabled(true);
			tfFindTitle.setColumns(10);
			tfFindTitle.setBounds(116, 31, 310, 23);
		}
		return tfFindTitle;
	}

	public JTextField getTfCODate() {
		if (tfCODate == null) {
			tfCODate = new JTextField();
			tfCODate.setColumns(10);
			tfCODate.setBounds(379, 451, 125, 23);
		}
		return tfCODate;
	}

	public JTextField getTfCIDate() {
		if (tfCIDate == null) {
			tfCIDate = new JTextField();
			tfCIDate.setColumns(10);
			tfCIDate.setBounds(379, 484, 125, 23);
		}
		return tfCIDate;
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

	public JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setColumns(10);
			tfTitle.setBounds(103, 418, 148, 23);
		}
		return tfTitle;
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
			lblNewLabel_3_1_2 = new JLabel("\uC774\uB984");
			lblNewLabel_3_1_2.setForeground(Color.WHITE);
			lblNewLabel_3_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
			lblNewLabel_3_1_2.setBounds(41, 455, 50, 15);
		}
		return lblNewLabel_3_1_2;
	}

	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setColumns(10);
			tfIrum.setBounds(103, 451, 148, 23);
		}
		return tfIrum;
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

	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(103, 484, 148, 23);
		}
		return tfPhone;
	}

	public JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("\uC218\uC815");
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = tfId;
					String title = tfTitle.getText();
					String irum = tfIrum.getText();
					String phone = tfPhone.getText();
					String coDate = tfCODate.getText();
					String ciDate = tfCIDate.getText();
					String returnDate = tfReturnDate;
					
					CheckOut c = new CheckOut(id, title, irum, phone, coDate, ciDate, returnDate);
					
					String msg = cc.update(c);
					JOptionPane.showMessageDialog(CheckInPanel.this, msg);
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
			DefaultTableModel model = new DefaultTableModel(
					new Object[][] { { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null }, },
					new String[] { "NO.", "\uB3C4\uC11C\uBA85", "\uB300\uC5EC\uC790", "\uC804\uD654\uBC88\uD638",
							"\uB300\uC5EC\uC77C\uC790", "\uBC18\uB0A9\uC77C\uC790", "\uBC18\uB0A9\uD604\uD669" });

			table.setModel(model);
			table = new JTable(model);

			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							int row = table.getSelectedRow();
							// int col = table.getSelectedColumn();

							tfId = Integer.parseInt((String)table.getModel().getValueAt(row, 0));
							tfTitle.setText((String) table.getModel().getValueAt(row, 1));
							tfIrum.setText((String) table.getModel().getValueAt(row, 2));
							tfPhone.setText((String) table.getModel().getValueAt(row, 3));
							tfCODate.setText((String) table.getModel().getValueAt(row, 4));
							tfCIDate.setText((String) table.getModel().getValueAt(row, 5));
							tfReturnDate = (String) table.getModel().getValueAt(row, 6);
						}
					});
				}
			});
		}

		return table;
	}
}
