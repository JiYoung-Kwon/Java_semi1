//반납 기능 컨트롤러

package Project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckInController {


	// 반납 기능 -> 반납 데이터 추가
	public String append(String id) {
		String msg = "반납 완료";
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String returnDate = format1.format(now);
		
		System.out.println(id);
		
		try {
			for (int index = 0; index < MainData.getCheckOutInfo().size(); index++) {
		
				if (MainData.getCheckOutInfo().get(index).getId().equals(id)) { // string 값 -> equals로 비교해야 함!
					MainData.getCheckOutInfo().get(index).setReturnDate(returnDate);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "반납 중 오류 발생";
		}

		return msg;
	}

	// 수정 기능 -> 대여일자, 반납일자 수정
	public String update(String id, String coDate, String ciDate) {
		String msg = "정보 수정이 완료되었습니다.";

		try {
			// 리스트에 있는 것 수정하기
			for (int index = 0; index < MainData.getCheckOutInfo().size(); index++) {
				
				if (MainData.getCheckOutInfo().get(index).getId().equals(id)) {
					MainData.getCheckOutInfo().get(index).setCoDate(coDate);
					MainData.getCheckOutInfo().get(index).setCiDate(ciDate);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "수정 중 오류 발생";
		}

		return msg;
	}

	// 삭제 기능 -> id에 해당하는 리스트 삭제
	public String delete(String id) {
		String msg = "대여 정보를 삭제했습니다.";

		try {
			for (int index = MainData.getCheckOutInfo().size() - 1; index >= 0; index--) {

				if (MainData.getCheckOutInfo().get(index).getId().equals(id)) {
					MainData.getCheckOutInfo().remove(index);
					break; 
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "삭제 중 오류 발생";
		}

		return msg;
	}

	// 조회 기능 -> 도서명/이름 조회
	public List<CheckOut> search(String findStr, String type) {
		List<CheckOut> returnList = new ArrayList<CheckOut>();

		for (int index = 0; index < MainData.getCheckOutInfo().size(); index++) {
			switch (type) {
			case "도서명":
				if (MainData.getCheckOutInfo().get(index).getTitle().indexOf(findStr) > -1)
					returnList.add(MainData.getCheckOutInfo().get(index));
				break;
			case "이름":
				if (MainData.getCheckOutInfo().get(index).getIrum().indexOf(findStr) > -1)
					returnList.add(MainData.getCheckOutInfo().get(index));
				break;

			}
		}
		return returnList;
	}
}
