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
	final int CHECK_OUT_LIMIT = 5; // 인당 총 대여 가능 수

	// 검색결과를 테이블에 출력
	String printSearchResult(List<?> result, JTable table) { // 매개변수는 회원리스트 or 도서리스트
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();  // 검색결과(회원리스트)출력할 테이블 생성
		tableModel.setRowCount(0); // 테이블 초기화	

		if (result==null) // result가 null인 경우는 고객검색 시 검색조건을 잘못 입력했을 경우
			return "휴대전화 끝 네자리 번호를 입력하세요.";
		else if (result.isEmpty()) return "검색 결과가 없습니다."; // 리스트가 비어있을 경우

		else if (result.get(0) instanceof Customer) { // 매개변수가 회원리스트인 경우
			for (int i = 0; i < result.size(); i++) { // 회원리스트 읽기
				Customer customer = (Customer) result.get(i); // 회원리스트에 저장된 회원의
				String phoneForm = MainData.customerC.phone(customer.getPhoneNum());
				String[] tableRecord = { customer.getIrum(), phoneForm, customer.getAddress() }; // 속성값을 테이블 행에 추가(1)
				tableModel.addRow(tableRecord); // 속성값을 테이블 행에 추가(2)
			}
		}
		else { // if (result.get(0) instanceof Book) { // 매개변수가 도서리스트인 경우
			for (int i = 0; i < result.size(); i++) { // 도서리스트 읽기
				Book book = (Book) result.get(i); // 도서리스트에 저장된 도서의
				// 속성값을 테이블 행에 추가
				String[] tableRecord = { book.getBookNo(), book.getSort(), book.getTitle(), book.getAuthor(), getCheckOutAble(book.getBookNo()) };
				// 대여가능일의 경우  getCheckOutAble()로 해당 책의 도서번호를 이용해 가능여부 확인
				tableModel.addRow(tableRecord);
			}
		}
		return null;
	}
	// 대예 예정 목록에 도서 추가
	void addCheckOut(JTable bookTable, JTable checkOutTable) {
		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();

		List<Book> selectBooks = new ArrayList<Book>(); // 대여예정 도서리스트
		int bookSelectRow[] = bookTable.getSelectedRows(); // 선택된 행의 번호를 값으로 가지는 배열생성
		String selectBookNo[] = new String[bookSelectRow.length]; // 선택된 행의 수만큼 저장할 도서번호 생성		

		for(int i=0; i<selectBookNo.length; i++) {
			selectBookNo[i] = (String)bookTable.getModel().getValueAt(bookSelectRow[i], 0); // 선택된 행의 도서번호 입력
			Book selectBook = MainData.bookC.searchBookNo(selectBookNo[i]); // 도서번호와 일치하는 도서를 검색해서 대여예정 도서에 저장
			if( getCheckOutAble(selectBook.getBookNo()) != "대여가능")	{ // 해당 도서가 대여가능이 아닐 경우
				System.out.println("대여 중인 도서가 선택되었습니다.");
				continue;
			}
			else {
				boolean duplicateInput = false; // 리스트에 추가되었는지 확인용 변수
				for(int j=0; j<checkOutTableModel.getRowCount(); j++) { // 대여예정 리스트 읽기
					if(selectBook.getBookNo().equals(checkOutTableModel.getValueAt(j, 0))) { // 리스트에 같은 도서번호를 가진 도서가 있을 경우 
						duplicateInput = true;
						break;
					}	
				}
				if (!duplicateInput) // 리스트에 추가되어 있지 않을 경우
					selectBooks.add(selectBook); // 대여예정 도서리스트에 저장
				else 
					System.out.println("이미 선택된 도서가 있습니다.");
			}
		}

		// 대여예정 도서리스트를 도서대여목록 테이블에 추가
		for (int i = 0; i < selectBooks.size(); i++) {
			Book book = selectBooks.get(i);
			String[] checkOutTableTuple = { book.getBookNo(), book.getTitle(), book.getAuthor(), book.getDate() };
			if(checkOutTableModel.getRowCount()<CHECK_OUT_LIMIT)
				checkOutTableModel.addRow(checkOutTableTuple);
			else System.out.println("대여목록이 "+CHECK_OUT_LIMIT+"권 초과되었습니다.");
		}

	}
	// 대여 예정 목록 테이블에서 도서 삭제
	void removeCheckOut (JTable checkOutTable) {
		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();
		int bookSelectRow[] = checkOutTable.getSelectedRows(); // 선택된 행의 번호를 값으로 가지는 배열생성
		for(int i=bookSelectRow.length-1; 0<=i; i--) {
			checkOutTableModel.removeRow(bookSelectRow[i]);
		}
	}
	// 대여 목록 추가
	String checkOut(String phoneNum,JTable checkOutTable) {
		DefaultTableModel checkOutTableModel = (DefaultTableModel) checkOutTable.getModel();
		String resultMsg="";  // 대여 등록 후 출력할 메시지

		Customer customer = MainData.customerC.searchCustomer(phoneNum);
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String coDate = dateForm.format(new Date());
		int checkOutCnt = 0; // 대여 권수 카운트

		try {
			for(int i=0; i<checkOutTableModel.getRowCount(); i++) {
				Book book = MainData.bookC.searchBookNo((String)checkOutTableModel.getValueAt(i, 0));
				String ciDate = getCheckInDate(book.getDate(), dateForm);
				CheckOut checkOut = new CheckOut(book.getBookNo(), book.getTitle(), customer.getIrum(), customer.getPhoneNum(), coDate, ciDate);
				// 대여 정보 저장 전 중복 값 있는지 조회 (대여 버튼 다중 클릭 방지)
				if(getCheckOutAble(book.getBookNo())=="대여가능") {
					if(checkOutLimit(customer.getPhoneNum())) {
						return resultMsg = "대여 중인 도서가 "+CHECK_OUT_LIMIT+"권 초과되었습니다.";
					}
					else {
						MainData.addCheckOutInfo(checkOut);
						checkOutCnt++;
					}
				} else
					return resultMsg = "이미 대여 중인 도서입니다.";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return resultMsg = "대여 기능 실행 중 오류 발생(error : ex2)";
		}

		checkOutTableModel.setRowCount(0);
		return resultMsg = customer.getIrum()+"님이 "+checkOutCnt+"권 대여하였습니다.";
	}
	// 반납일자 리턴
	String getCheckInDate(String period, SimpleDateFormat dateForm) {
		Calendar ciDate = Calendar.getInstance();
		ciDate.setTime(new Date());
		ciDate.add(Calendar.DATE, Integer.parseInt(period));

		return dateForm.format(ciDate.getTime());
	}
	// 대여가능여부 리턴
	String getCheckOutAble(String bookNo) {
		String able = "대여가능";

		if(getLastReturnDate(bookNo)!=null) { // 반납된 날짜를 확인하여 반납여부 확인
			return able;
		}
		else return getReturnScheduledDate(bookNo)+" 이후"; // 반납예정일을 확인하여 리턴
	}
	// 마지막 반납일자 리턴
	private String getLastReturnDate(String bookNo) { // 마지막 반납일자 리턴
		for(int i=MainData.getCheckOutInfo().size()-1; i>=0; i--) { // 대여정보 읽기
			if(MainData.getCheckOutInfo().get(i).getBookNo().equals(bookNo)) {
				return MainData.getCheckOutInfo().get(i).getReturnDate(); // 반납된 날짜 리턴, 미반납 시 null값으로 저장되어있음
			}
		}
		return "대여기록없음";
	}
	// 반납예정일 리턴
	private String getReturnScheduledDate(String bookNo) {
		for(int i=MainData.getCheckOutInfo().size()-1; i>=0; i--) {
			if(MainData.getCheckOutInfo().get(i).getBookNo().equals(bookNo)) {
				return MainData.getCheckOutInfo().get(i).getCiDate();
			}
		}
		return "대여기록없음";
	}
	// 인당 도서 대여 최대 수 초과 확인
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
