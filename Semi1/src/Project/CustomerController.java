//ȸ�� ���� CRUD ��Ʈ�ѷ�

package Project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CustomerController {

	// ȸ�� ���� �Է±��
	public String append(Customer c, boolean isSame) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";

		try {
			// ��ĭ�� ���� ���
			if (!(c.getIrum().length() != 0 && c.getPhoneNum().length() != 0 && c.getAddress().length() != 0)) { // �˻�����
																													// ������
																													// ���
				msg = "���� �Է����ּ���.";
			} else if (phoneNumCheck(c.getPhoneNum())) // �޴���ȭ ���Ἲ Ȯ��, ��ȣ�� �ƴ� ��� msg ǥ��
				msg = "�ùٸ� �޴���ȭ ���� �ƴմϴ�.";
			else { // ��ĭ�� ���µ�, ID�� �ߺ��� ��� check
				if (isSame) // ���̵� �����Ѵٸ�
					msg = "�̹� ���Ե� ȸ���Դϴ�.";
				else {
					MainData.addCustomer(c); // ������ ����Ʈ�� �߰�
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "������ ���� �� �����߻�.";
		}
		return msg;
	}

	// ���� ���
	public String update(String id, String phoneNum, String irum, String address) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";

		try {
			if (id.length() == 0)
				msg = "���� �������ּ���.";
			// ��ĭ�� ���� ���
			else if (!(id.length() != 0 && irum.length() != 0 && address.length() != 0)) // �Է°��� ������ ���
				msg = "������ ���� �Է����ּ���.";
			else {
				// ����Ʈ ���� ����
				Loop1: for (int index = 0; index < MainData.getCustomers().size(); index++) {
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) { // ��ȭ��ȣ�� ���� ��� Ȯ��
						System.out.println(id);
						System.out.println(target.getPhoneNum());
						System.out.println(phoneNum);
						for (int i = 0; i < MainData.getCustomers().size(); i++) {
							System.out.println(MainData.getCustomers().get(i).getPhoneNum());
							if (MainData.getCustomers().get(i).getPhoneNum().equals(phoneNum)) {
								msg = "�̹� ���Ե� ȸ����ȣ�δ� ������ �� �����ϴ�.";
								break Loop1;
							}
						}

						MainData.getCustomers().get(index).setPhoneNum(phoneNum); // ����� �����͸� set �� ���Ͽ� ����
						MainData.getCustomers().get(index).setIrum(irum);
						MainData.getCustomers().get(index).setAddress(address);
					}
				}
				for (int index = 0; index < MainData.getCustomers().size(); index++) {
					Customer target = MainData.getCustomers().get(index);
					{
						if (target.getPhoneNum().equals(id)) {
							if (target.getPhoneNum().equals(phoneNum))
								msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
							MainData.getCustomers().get(index).setIrum(irum);
							MainData.getCustomers().get(index).setAddress(address);
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "������ ���� �� ���� �߻�.";
		}
		return msg;
	}

	// ���� ���
	public String delete(String id) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			if (id.length() == 0) // ���� ���� ������ ���
				msg = "���� �������ּ���.";
			else {
				for (int index = MainData.getCustomers().size() - 1; index >= 0; index--) { // ������ �ƴҰ�� �ε����� ������ Ÿ���� ã�´�
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) { // Ÿ���� ��ġ �� ��� ��� �����͸� ����
						MainData.getCustomers().remove(index);
						break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "������ ���� �� ���� �߻�";
		}
		return msg;
	}

	// ��ȸ ���
	public List<Customer> search(String findID, String findIrum) {
		List<Customer> returnList = new ArrayList<Customer>(); // �迭 ����

		for (int index = 0; index < MainData.getCustomers().size(); index++) {
			Customer target = MainData.getCustomers().get(index);
			if (findID.length() == 0) { // ȸ�� ��ȭ��ȣ�� �˻�� ���� ���
				if (target.getIrum().indexOf(findIrum) > -1) { // ȸ���� ��ġ�ϴ� ��ü�� �߰�.
					returnList.add(target);
				}
			} else if (findIrum.length() == 0) { // ȸ������ �˻�� ���°��
				if (target.getPhoneNum().indexOf(findID) > -1) { // ȸ���� ��ġ�ϴ� ��ü�� �߰�
					returnList.add(target);
				}
			} else {
				if (target.getPhoneNum().indexOf(findID) > -1 && target.getIrum().indexOf(findIrum) > -1) // �Ѵ� ��ġ�ϴ� ��ü��
																											// �߰�
					returnList.add(target);
			}
		}
		return returnList;
	}

	// ȸ�� �˻� �޼ҵ�
	Customer searchCustomer(String PhoneNum) {
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			if (MainData.getCustomers().get(i).getPhoneNum().equals(PhoneNum))
				return MainData.getCustomers().get(i);
		}
		return null;
	}

	List<Customer> searchCustomers(String endPhoneNum) { // �˻�����(�޴���ȭ ����ȣ 4��)
		// �Է��� �˻����� ���Ἲ Ȯ��
		if (endPhoneNum.length() != 4) { // �Է°��� ���ڸ��� �ƴ� ���
			return null;
		} else
			try {
				Integer.parseInt(endPhoneNum); // ���ڰ� �ƴҰ��
			} catch (Exception ex) {
				return null;
			}
		// searchEndPhoneNum �޼ҵ带 ���� ���ڸ� ��ȣ 4���� ��ġ�ϴ� ȸ������Ʈ�� ����
		List<Customer> searchCustomerList = searchEndPhoneNum(endPhoneNum);

		return searchCustomerList; // �˻��� ȸ������Ʈ�� ��ȯ
	}

	// ����ȣ ���ڸ��� �˻�
	List<Customer> searchEndPhoneNum(String findNum) {
		List<Customer> returnList = new ArrayList<Customer>();
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			String endNum = MainData.getCustomers().get(i).getPhoneNum()
					.substring(MainData.getCustomers().get(i).getPhoneNum().length() - 4);
			if (findNum.equals(endNum)) // ��ġ���� Ȯ��
				returnList.add(MainData.getCustomers().get(i));
		}
		return returnList;
	}

	// �޴���ȭ ���Ἲ Ȯ��
	private boolean phoneNumCheck(String num) {
		if (num.length() != 11) // ��ȭ��ȣ ���� 11�ڸ�
			return true;
		else {
			if (num.charAt(0) != '0' || num.charAt(1) != '1' || num.charAt(2) != '0') // �޴���ȭ ó�� 3�ڸ� ��ȣ ó���ڸ� ����
				return true;
			for (int i = 3; i < num.length(); i++) {
				if (!('0' <= num.charAt(i) && num.charAt(i) <= '9')) // 010 ���� ��ȣ ���� 0~9�� ����
					return true;
			}
		}
		return false;
	}

	public String phone(String src) { // ��ȭ��ȣ �Է½� ������(-)�� �߰��ǵ��� �ϴ� ���Խ� �޼���

		String aa = src.substring(7, 11);
		String a = String.format("%s-%s-%s", src.substring(0, 3), src.substring(3, 7), src.substring(7, 11));

		return a;

		// String id = tfUPhoneNum.getText().replaceAll("\\D", ""); // ȭ�鿡�� get���� �޾ƿ�
		// ��ȣ�� ������(-) ���� ���
		// ���� ����,���� ������ -�� �ν��ϸ� raplaceAll�� ���
	}

}
