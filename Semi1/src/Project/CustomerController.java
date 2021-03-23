//회원 정보 CRUD 컨트롤러

package Project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CustomerController {

	MainData md = new MainData(); // 테스트용

	// 회원 정보 입력기능
	public String append(Customer c, boolean isSame) {
		String msg = "데이터가 정상적으로 저장되었습니다.";

		try {
			// 빈칸이 있을 경우
			if (!(c.getIrum().length() != 0 && c.getPhoneNum().length() != 0 && c.getAddress().length() != 0)) {
				msg = "값을 입력해주세요.";
			} else { // 빈칸이 없는데, ID가 중복일 경우 check
				if (isSame) // 아이디가 존재한다면
					msg = "이미 가입된 회원입니다.";
				else {
					MainData.addCustomer(c); // 정보를 리스트에 추가
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "데이터 저장 중 오류발생.";
		}
		return msg;
	}

	// 수정 기능
	public String update(String id, String irum, String address) {
		String msg = "데이터가 정상적으로 수정되었습니다.";

		try {
			if (id.length() == 0)
				msg = "값을 선택해주세요.";
			// 빈칸이 있을 경우
			else if (!(irum.length() != 0 && address.length() != 0))
				msg = "수정할 값을 입력해주세요.";
			else {
				// 리스트 내용 수정
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
			msg = "데이터 수정 중 오류 발생.";
		}
		return msg;
	}

	// 삭제 기능
	public String delete(String id) {
		String msg = "데이터가 정상적으로 삭제되었습니다.";
		try {
			if (id.length() == 0)
				msg = "값을 선택해주세요.";
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
			msg = "데이터 삭제 중 오류 발생";
		}
		return msg;
	}

	// 조회 기능
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
