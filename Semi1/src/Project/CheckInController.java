//�ݳ� ��� ��Ʈ�ѷ�

package Project;

import java.util.ArrayList;
import java.util.List;

public class CheckInController {
	public static List<CheckOut> checkouts = new ArrayList<CheckOut>();

	// �׽�Ʈ�� ������ �߰�
	public void init(CheckOut c) {
		checkouts.add(c);
	}

	// �뿩 ��� -> ����Ʈ �߰�
	/*
	 * public String append(CheckOut c) { String msg = "�뿩�� �Ϸ�Ǿ����ϴ�.";
	 * 
	 * try { // �����͸� ����Ʈ�� �߰� checkouts.add(c); } catch (Exception e) {
	 * e.printStackTrace(); msg = "�뿩 �� ���� �߻�"; }
	 * 
	 * return msg; }
	 */

	// �ݳ� ��� -> �ݳ� ������ �߰�
	public String append(CheckOut c) {
		String msg = "�ݳ� �Ϸ�";

		try {
			for (int index = 0; index < checkouts.size(); index++) {
				CheckOut target = checkouts.get(index);

				if (target.getId() == c.getId()) { // string �� -> equals�� ���ؾ� ��! ������ ��� X
					checkouts.set(index, c);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "�ݳ� �� ���� �߻�";
		}

		return msg;
	}

	// ���� ���
	public String update(CheckOut c) {
		String msg = "���� ������ �Ϸ�Ǿ����ϴ�.";

		try {
			// ����Ʈ�� �ִ� �� �����ϱ�
			for (int index = 0; index < checkouts.size(); index++) {
				CheckOut target = checkouts.get(index);

				if (target.getId() == c.getId()) {
					checkouts.set(index, c);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "���� �� ���� �߻�";
		}

		return msg;
	}

	// ���� ���
	public String delete(CheckOut c) {
		String msg = "�뿩 ������ �����߽��ϴ�.";

		try {
			for (int index = checkouts.size() - 1; index >= 0; index--) {
				CheckOut target = checkouts.get(index);

				if (target.getId() == c.getId()) {
					checkouts.remove(index);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "���� �� ���� �߻�";
		}

		return msg;
	}

	// ��ȸ ���
	public List<CheckOut> search(String findStr, String type) {
		List<CheckOut> returnList = new ArrayList<CheckOut>();

		for (int index = 0; index < checkouts.size(); index++) {
			CheckOut target = checkouts.get(index);
			switch (type) {
			case "������":
				if (target.getTitle().indexOf(findStr) > -1)
					returnList.add(target);
				break;
			case "�̸�":
				if (target.getIrum().indexOf(findStr) > -1)
					returnList.add(target);
				break;

			}
		}
		return returnList;
	}
}
