//회원 정보 CRUD 컨트롤러

package Project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CustomerController {

	// 회원 정보 입력기능
	public String append(Customer c, boolean isSame) {
		String msg = "데이터가 정상적으로 저장되었습니다.";

		try {
			// 빈칸이 있을 경우
			if (!(c.getIrum().length() != 0 && c.getPhoneNum().length() != 0 && c.getAddress().length() != 0)) { // 검색값이
																													// 공란일
																													// 경우
				msg = "값을 입력해주세요.";
			} else if (phoneNumCheck(c.getPhoneNum())) // 휴대전화 무결성 확인, 번호가 아닐 경우 msg 표시
				msg = "올바른 휴대전화 값이 아닙니다.";
			else { // 빈칸이 없는데, ID가 중복일 경우 check
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
	public String update(String id, String phoneNum, String irum, String address) {
		String msg = "데이터가 정상적으로 수정되었습니다.";

		try {
			if (id.length() == 0)
				msg = "값을 선택해주세요.";
			// 빈칸이 있을 경우
			else if (!(id.length() != 0 && irum.length() != 0 && address.length() != 0)) // 입력값이 공란일 경우
				msg = "수정할 값을 입력해주세요.";
			else {
				// 리스트 내용 수정
				Loop1: for (int index = 0; index < MainData.getCustomers().size(); index++) {
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) { // 전화번호가 같을 경우 확인
						System.out.println(id);
						System.out.println(target.getPhoneNum());
						System.out.println(phoneNum);
						for (int i = 0; i < MainData.getCustomers().size(); i++) {
							System.out.println(MainData.getCustomers().get(i).getPhoneNum());
							if (MainData.getCustomers().get(i).getPhoneNum().equals(phoneNum)) {
								msg = "이미 가입된 회원번호로는 수정할 수 없습니다.";
								break Loop1;
							}
						}

						MainData.getCustomers().get(index).setPhoneNum(phoneNum); // 저장된 데이터를 set 을 통하여 변경
						MainData.getCustomers().get(index).setIrum(irum);
						MainData.getCustomers().get(index).setAddress(address);
					}
				}
				for (int index = 0; index < MainData.getCustomers().size(); index++) {
					Customer target = MainData.getCustomers().get(index);
					{
						if (target.getPhoneNum().equals(id)) {
							if (target.getPhoneNum().equals(phoneNum))
								msg = "데이터가 정상적으로 수정되었습니다.";
							MainData.getCustomers().get(index).setIrum(irum);
							MainData.getCustomers().get(index).setAddress(address);
						}
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
			if (id.length() == 0) // 선택 값이 공란일 경우
				msg = "값을 선택해주세요.";
			else {
				for (int index = MainData.getCustomers().size() - 1; index >= 0; index--) { // 공란이 아닐경우 인덱스의 끝에서 타겟을 찾는다
					Customer target = MainData.getCustomers().get(index);

					if (target.getPhoneNum().equals(id)) { // 타겟이 일치 할 경우 모든 데이터를 삭제
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
	public List<Customer> search(String findID, String findIrum) {
		List<Customer> returnList = new ArrayList<Customer>(); // 배열 생성

		for (int index = 0; index < MainData.getCustomers().size(); index++) {
			Customer target = MainData.getCustomers().get(index);
			if (findID.length() == 0) { // 회원 전화번호의 검색어가 없는 경우
				if (target.getIrum().indexOf(findIrum) > -1) { // 회원과 일치하는 객체만 추가.
					returnList.add(target);
				}
			} else if (findIrum.length() == 0) { // 회원명의 검색어가 없는경우
				if (target.getPhoneNum().indexOf(findID) > -1) { // 회원과 일치하는 객체만 추가
					returnList.add(target);
				}
			} else {
				if (target.getPhoneNum().indexOf(findID) > -1 && target.getIrum().indexOf(findIrum) > -1) // 둘다 일치하는 객체만
																											// 추가
					returnList.add(target);
			}
		}
		return returnList;
	}

	// 회원 검색 메소드
	Customer searchCustomer(String PhoneNum) {
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			if (MainData.getCustomers().get(i).getPhoneNum().equals(PhoneNum))
				return MainData.getCustomers().get(i);
		}
		return null;
	}

	List<Customer> searchCustomers(String endPhoneNum) { // 검색조건(휴대전화 끝번호 4개)
		// 입력한 검색조건 무결성 확인
		if (endPhoneNum.length() != 4) { // 입력값이 네자리가 아닐 경우
			return null;
		} else
			try {
				Integer.parseInt(endPhoneNum); // 숫자가 아닐경우
			} catch (Exception ex) {
				return null;
			}
		// searchEndPhoneNum 메소드를 통해 끝자리 번호 4개가 일치하는 회원리스트를 생성
		List<Customer> searchCustomerList = searchEndPhoneNum(endPhoneNum);

		return searchCustomerList; // 검색된 회원리스트를 반환
	}

	// 끝번호 네자리로 검색
	List<Customer> searchEndPhoneNum(String findNum) {
		List<Customer> returnList = new ArrayList<Customer>();
		for (int i = 0; i < MainData.getCustomers().size(); i++) {
			String endNum = MainData.getCustomers().get(i).getPhoneNum()
					.substring(MainData.getCustomers().get(i).getPhoneNum().length() - 4);
			if (findNum.equals(endNum)) // 일치여부 확인
				returnList.add(MainData.getCustomers().get(i));
		}
		return returnList;
	}

	// 휴대전화 무결성 확인
	private boolean phoneNumCheck(String num) {
		if (num.length() != 11) // 전화번호 길이 11자리
			return true;
		else {
			if (num.charAt(0) != '0' || num.charAt(1) != '1' || num.charAt(2) != '0') // 휴대전화 처음 3자리 번호 처음자리 고정
				return true;
			for (int i = 3; i < num.length(); i++) {
				if (!('0' <= num.charAt(i) && num.charAt(i) <= '9')) // 010 이후 번호 범위 0~9로 제한
					return true;
			}
		}
		return false;
	}

	public String phone(String src) { // 전화번호 입력시 하이픈(-)이 추가되도록 하는 정규식 메서드

		String aa = src.substring(7, 11);
		String a = String.format("%s-%s-%s", src.substring(0, 3), src.substring(3, 7), src.substring(7, 11));

		return a;

		// String id = tfUPhoneNum.getText().replaceAll("\\D", ""); // 화면에서 get으로 받아온
		// 번호의 하이픈(-) 제거 기능
		// 만약 수정,삭제 하이픈 -을 인식하면 raplaceAll을 사용
	}

}
