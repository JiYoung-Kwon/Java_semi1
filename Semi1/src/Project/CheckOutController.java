package Project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CheckOutController {
	final int CHECK_OUT_LIMIT = 5; // �δ� �� �뿩 ���� ��

	// �˻������ ���̺� ���
	String printSearchResult(List<?> result, JTable table) { // �Ű������� ȸ������Ʈ or ��������Ʈ
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();  // �˻����(ȸ������Ʈ)����� ���̺� ����
		tableModel.setRowCount(0); // ���̺� �ʱ�ȭ	

		if (result==null) // result�� null�� ���� ���˻� �� �˻������� �߸� �Է����� ���
			return "�޴���ȭ �� ���ڸ� ��ȣ�� �Է��ϼ���.";
		else if (result.isEmpty()) return "�˻� ����� �����ϴ�."; // ����Ʈ�� ������� ���

		else if (result.get(0) instanceof Customer) { // �Ű������� ȸ������Ʈ�� ���
			for (int i = 0; i < result.size(); i++) { // ȸ������Ʈ �б�
				Customer customer = (Customer) result.get(i); // ȸ������Ʈ�� ����� ȸ����
				String phoneForm = MainData.customerC.phone(customer.getPhoneNum());
				String[] tableRecord = { customer.getIrum(), phoneForm, customer.getAddress() }; // �Ӽ����� ���̺� �࿡ �߰�(1)
				tableModel.addRow(tableRecord); // �Ӽ����� ���̺� �࿡ �߰�(2)
			}
		}
		else { // if (result.get(0) instanceof Book) { // �Ű������� ��������Ʈ�� ���
			for (int i = 0; i < result.size(); i++) { // ��������Ʈ �б�
				Book book = (Book) result.get(i); // ��������Ʈ�� ����� ������
				// �Ӽ����� ���̺� �࿡ �߰�
				String[] tableRecord = { book.getBookNo(), book.getSort(), book.getTitle(), book.getAuthor(), getCheckOutAble(book.getBookNo()) };
				// �뿩�������� ���  getCheckOutAble()�� �ش� å�� ������ȣ�� �̿��� ���ɿ��� Ȯ��
				tableModel.addRow(tableRecord);
			}
		}
		return null;
	}
	// �뿹 ���� ��Ͽ� ���� �߰�
	void addCheckOut(JTable bookTable, JTable checkOutTable) {
		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();

		List<Book> selectBooks = new ArrayList<Book>(); // �뿩���� ��������Ʈ
		int bookSelectRow[] = bookTable.getSelectedRows(); // ���õ� ���� ��ȣ�� ������ ������ �迭����
		String selectBookNo[] = new String[bookSelectRow.length]; // ���õ� ���� ����ŭ ������ ������ȣ ����		

		for(int i=0; i<selectBookNo.length; i++) {
			selectBookNo[i] = (String)bookTable.getModel().getValueAt(bookSelectRow[i], 0); // ���õ� ���� ������ȣ �Է�
			Book selectBook = MainData.bookC.searchBookNo(selectBookNo[i]); // ������ȣ�� ��ġ�ϴ� ������ �˻��ؼ� �뿩���� ������ ����
			if( getCheckOutAble(selectBook.getBookNo()) != "�뿩����")	{ // �ش� ������ �뿩������ �ƴ� ���
				System.out.println("�뿩 ���� ������ ���õǾ����ϴ�.");
				continue;
			}
			else {
				boolean duplicateInput = false; // ����Ʈ�� �߰��Ǿ����� Ȯ�ο� ����
				for(int j=0; j<checkOutTableModel.getRowCount(); j++) { // �뿩���� ����Ʈ �б�
					if(selectBook.getBookNo().equals(checkOutTableModel.getValueAt(j, 0))) { // ����Ʈ�� ���� ������ȣ�� ���� ������ ���� ��� 
						duplicateInput = true;
						break;
					}	
				}
				if (!duplicateInput) // ����Ʈ�� �߰��Ǿ� ���� ���� ���
					selectBooks.add(selectBook); // �뿩���� ��������Ʈ�� ����
				else 
					System.out.println("�̹� ���õ� ������ �ֽ��ϴ�.");
			}
		}

		// �뿩���� ��������Ʈ�� �����뿩��� ���̺� �߰�
		for (int i = 0; i < selectBooks.size(); i++) {
			Book book = selectBooks.get(i);
			String[] checkOutTableTuple = { book.getBookNo(), book.getTitle(), book.getAuthor(), book.getDate() };
			if(checkOutTableModel.getRowCount()<CHECK_OUT_LIMIT)
				checkOutTableModel.addRow(checkOutTableTuple);
			else System.out.println("�뿩����� "+CHECK_OUT_LIMIT+"�� �ʰ��Ǿ����ϴ�.");
		}

	}
	// �뿩 ���� ��� ���̺��� ���� ����
	void removeCheckOut (JTable checkOutTable) {
		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();
		int bookSelectRow[] = checkOutTable.getSelectedRows(); // ���õ� ���� ��ȣ�� ������ ������ �迭����
		for(int i=bookSelectRow.length-1; 0<=i; i--) {
			checkOutTableModel.removeRow(bookSelectRow[i]);
		}
	}
	// �뿩 ��� �߰�
	String checkOut(String phoneNum,JTable checkOutTable) {
		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();
		String resultMsg="";  // �뿩 ��� �� ����� �޽���

		Customer customer = MainData.customerC.searchCustomer(phoneNum);
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String coDate = dateForm.format(new Date());
		int checkOutCnt = 0; // �뿩 �Ǽ� ī��Ʈ

		try {
			for(int i=0; i<checkOutTableModel.getRowCount(); i++) {
				Book book = MainData.bookC.searchBookNo((String)checkOutTableModel.getValueAt(i, 0));
				String ciDate = getCheckInDate(book.getDate(), dateForm);
				CheckOut checkOut = new CheckOut(book.getBookNo(), book.getTitle(), customer.getIrum(), customer.getPhoneNum(), coDate, ciDate);
				// �뿩 ���� ���� �� �ߺ� �� �ִ��� ��ȸ (�뿩 ��ư ���� Ŭ�� ����)
				if(getCheckOutAble(book.getBookNo())=="�뿩����") {
					if(checkOutLimit(customer.getPhoneNum())) {
						return resultMsg = "�뿩 ���� ������ "+CHECK_OUT_LIMIT+"�� �ʰ��Ǿ����ϴ�.";
					}
					else {
						MainData.addCheckOutInfo(checkOut);
						checkOutCnt++;
					}
				} else
					return resultMsg = "�̹� �뿩 ���� �����Դϴ�.";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return resultMsg = "�뿩 ��� ���� �� ���� �߻�(error : ex2)";
		}

		checkOutTableModel.setRowCount(0);
		return resultMsg = customer.getIrum()+"���� "+checkOutCnt+"�� �뿩�Ͽ����ϴ�.";
	}
	// �ݳ����� ����
	String getCheckInDate(String period, SimpleDateFormat dateForm) {
		Calendar ciDate = Calendar.getInstance();
		ciDate.setTime(new Date());
		ciDate.add(Calendar.DATE, Integer.parseInt(period));

		return dateForm.format(ciDate.getTime());
	}
	// �뿩���ɿ��� ����
	String getCheckOutAble(String bookNo) {
		String able = "�뿩����";

		if(getLastReturnDate(bookNo)!=null) { // �ݳ��� ��¥�� Ȯ���Ͽ� �ݳ����� Ȯ��
			return able;
		}
		else return getReturnScheduledDate(bookNo)+" ����"; // �ݳ��������� Ȯ���Ͽ� ����
	}
	// ������ �ݳ����� ����
	private String getLastReturnDate(String bookNo) { // ������ �ݳ����� ����
		for(int i=MainData.getCheckOutInfo().size()-1; i>=0; i--) { // �뿩���� �б�
			if(MainData.getCheckOutInfo().get(i).getBookNo().equals(bookNo)) {
				return MainData.getCheckOutInfo().get(i).getReturnDate(); // �ݳ��� ��¥ ����, �̹ݳ� �� null������ ����Ǿ�����
			}
		}
		return "�뿩��Ͼ���";
	}
	// �ݳ������� ����
	private String getReturnScheduledDate(String bookNo) {
		for(int i=MainData.getCheckOutInfo().size()-1; i>=0; i--) {
			if(MainData.getCheckOutInfo().get(i).getBookNo().equals(bookNo)) {
				return MainData.getCheckOutInfo().get(i).getCiDate();
			}
		}
		return "�뿩��Ͼ���";
	}
	// �δ� ���� �뿩 �ִ� �� �ʰ� Ȯ��
	boolean checkOutLimit(String phoneNum) {
		int checkOutCnt=0;
		for(int i=MainData.getCheckOutInfo().size()-1; 0<=i; i--) {
			if(	MainData.getCheckOutInfo().get(i).getPhone().equals(phoneNum)
					&& MainData.getCheckOutInfo().get(i).getReturnDate()==null)
			{
				checkOutCnt++;
				if (checkOutCnt>CHECK_OUT_LIMIT) {
					System.out.println(checkOutCnt);
					return true;
				}
			}
		}
		return false;
	}
}
