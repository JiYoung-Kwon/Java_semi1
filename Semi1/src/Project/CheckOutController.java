//�ݳ� ��� ��Ʈ�ѷ�

package Project;

import java.util.ArrayList;
import java.util.List;

public class CheckOutController {
	public static List<CheckOut> checkouts = new ArrayList<CheckOut>();

	// �뿩 ��� -> ����Ʈ �߰�
	public String append(CheckOut c) {
		String msg = "�뿩�� �Ϸ�Ǿ����ϴ�.";

		try {
			// �����͸� ����Ʈ�� �߰�
			checkouts.add(c);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "�뿩 �� ���� �߻�";
		}

		return msg;
	}

	// ���� ���
	public String update(CheckOut c) {
		String msg = "�뿩 ���� ������ �Ϸ�Ǿ����ϴ�.";

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
	public List<CheckOut> search(String findStr) {
		List<CheckOut> returnList = new ArrayList<CheckOut>();

		for (int index = 0; index < checkouts.size(); index++) {
			CheckOut target = checkouts.get(index);
			if (Integer.toString(target.getId()).indexOf(findStr) > -1 || target.getBook().indexOf(findStr) > -1
					|| target.getPerson().indexOf(findStr) > -1 || target.getDate().indexOf(findStr) > -1) {

				returnList.add(target);
			}
		}
		return returnList;
	}
}
