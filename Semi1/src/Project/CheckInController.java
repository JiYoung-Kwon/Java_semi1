//�ݳ� ��� ��Ʈ�ѷ�

package Project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckInController {


	// �ݳ� ��� -> �ݳ� ������ �߰�
	public String append(String id) {
		String msg = "�ݳ� �Ϸ�";
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String returnDate = format1.format(now);
		
		System.out.println(id);
		
		try {
			for (int index = 0; index < MainData.getCheckOutInfo().size(); index++) {
		
				if (MainData.getCheckOutInfo().get(index).getId().equals(id)) { // string �� -> equals�� ���ؾ� ��!
					MainData.getCheckOutInfo().get(index).setReturnDate(returnDate);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "�ݳ� �� ���� �߻�";
		}

		return msg;
	}

	// ���� ��� -> �뿩����, �ݳ����� ����
	public String update(String id, String coDate, String ciDate) {
		String msg = "���� ������ �Ϸ�Ǿ����ϴ�.";

		try {
			// ����Ʈ�� �ִ� �� �����ϱ�
			for (int index = 0; index < MainData.getCheckOutInfo().size(); index++) {
				
				if (MainData.getCheckOutInfo().get(index).getId().equals(id)) {
					MainData.getCheckOutInfo().get(index).setCoDate(coDate);
					MainData.getCheckOutInfo().get(index).setCiDate(ciDate);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "���� �� ���� �߻�";
		}

		return msg;
	}

	// ���� ��� -> id�� �ش��ϴ� ����Ʈ ����
	public String delete(String id) {
		String msg = "�뿩 ������ �����߽��ϴ�.";

		try {
			for (int index = MainData.getCheckOutInfo().size() - 1; index >= 0; index--) {

				if (MainData.getCheckOutInfo().get(index).getId().equals(id)) {
					MainData.getCheckOutInfo().remove(index);
					break; 
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "���� �� ���� �߻�";
		}

		return msg;
	}

	// ��ȸ ��� -> ������/�̸� ��ȸ
	public List<CheckOut> search(String findStr, String type) {
		List<CheckOut> returnList = new ArrayList<CheckOut>();

		for (int index = 0; index < MainData.getCheckOutInfo().size(); index++) {
			switch (type) {
			case "������":
				if (MainData.getCheckOutInfo().get(index).getTitle().indexOf(findStr) > -1)
					returnList.add(MainData.getCheckOutInfo().get(index));
				break;
			case "�̸�":
				if (MainData.getCheckOutInfo().get(index).getIrum().indexOf(findStr) > -1)
					returnList.add(MainData.getCheckOutInfo().get(index));
				break;

			}
		}
		return returnList;
	}
}
