//ȸ�� ���� CRUD ��Ʈ�ѷ�

package Project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CustomerController {

	MainData md = new MainData(); // �׽�Ʈ��

	// ȸ�� ���� �Է±��
	public String append(Customer c, boolean isSame) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";

		try {
			// ��ĭ�� ���� ���
			if (!(c.getIrum().length() != 0 && c.getPhoneNum().length() != 0 && c.getAddress().length() != 0)) {
				msg = "���� �Է����ּ���.";
			} else { // ��ĭ�� ���µ�, ID�� �ߺ��� ��� check
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
	public String update(String id, String irum, String address) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";

		try {
			if (id.length() == 0)
				msg = "���� �������ּ���.";
			// ��ĭ�� ���� ���
			else if (!(irum.length() != 0 && address.length() != 0))
				msg = "������ ���� �Է����ּ���.";
			else {
				// ����Ʈ ���� ����
				for (int index = 0; index < MainData.getCustomers().size(); index++) {
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) {
						MainData.getCustomers().get(index).setIrum(irum);
						MainData.getCustomers().get(index).setAddress(address);
						break;
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
			if (id.length() == 0)
				msg = "���� �������ּ���.";
			else {
				for (int index = MainData.getCustomers().size() - 1; index >= 0; index--) {
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) {
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
	public List<Customer> search(String findStr) {
		List<Customer> returnList = new ArrayList<Customer>();

		for (int index = 0; index < MainData.getCustomers().size(); index++) {
			Customer target = MainData.getCustomers().get(index);
			if (target.getPhoneNum().indexOf(findStr) > -1 || target.getPhoneNum().indexOf(findStr) > -1
					|| target.getIrum().indexOf(findStr) > -1) {
				returnList.add(target);
			}
		}
		return returnList;
	}
}
