//반납 기능 컨트롤러

package Project;

import java.util.ArrayList;
import java.util.List;

public class CheckInController {
	public static List<CheckOut> checkouts = new ArrayList<CheckOut>();

	// 테스트용 데이터 추가
	public void init(CheckOut c) {
		checkouts.add(c);
	}

	// 대여 기능 -> 리스트 추가
	/*
	 * public String append(CheckOut c) { String msg = "대여가 완료되었습니다.";
	 * 
	 * try { // 데이터를 리스트에 추가 checkouts.add(c); } catch (Exception e) {
	 * e.printStackTrace(); msg = "대여 중 오류 발생"; }
	 * 
	 * return msg; }
	 */

	// 반납 기능 -> 반납 데이터 추가
	public String append(CheckOut c) {
		String msg = "반납 완료";

		try {
			for (int index = 0; index < checkouts.size(); index++) {
				CheckOut target = checkouts.get(index);

				if (target.getId() == c.getId()) { // string 값 -> equals로 비교해야 함! 연산자 사용 X
					checkouts.set(index, c);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "반납 중 오류 발생";
		}

		return msg;
	}

	// 수정 기능
	public String update(CheckOut c) {
		String msg = "정보 수정이 완료되었습니다.";

		try {
			// 리스트에 있는 것 수정하기
			for (int index = 0; index < checkouts.size(); index++) {
				CheckOut target = checkouts.get(index);

				if (target.getId() == c.getId()) {
					checkouts.set(index, c);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "수정 중 오류 발생";
		}

		return msg;
	}

	// 삭제 기능
	public String delete(CheckOut c) {
		String msg = "대여 정보를 삭제했습니다.";

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
			msg = "삭제 중 오류 발생";
		}

		return msg;
	}

	// 조회 기능
	public List<CheckOut> search(String findStr, String type) {
		List<CheckOut> returnList = new ArrayList<CheckOut>();

		for (int index = 0; index < checkouts.size(); index++) {
			CheckOut target = checkouts.get(index);
			switch (type) {
			case "도서명":
				if (target.getTitle().indexOf(findStr) > -1)
					returnList.add(target);
				break;
			case "이름":
				if (target.getIrum().indexOf(findStr) > -1)
					returnList.add(target);
				break;

			}
		}
		return returnList;
	}
}
