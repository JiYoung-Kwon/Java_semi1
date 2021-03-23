//대여 및 반납 기능 데이터 클래스

package Project;

public class CheckOut {

	private int id = 1; // 대여목록 키 초기값
	private static int idCnt = 0; // 객체 생성 시 id+=idCnt++로 id값 1씩 증가.
	private String irum; // 대여자 이름
	private String phone; // 대여자 번호
	private String bookNo; // 대여도서 번호
	private String title; // 대여도서 제목
	private String coDate; // 도서 대여일
	private String ciDate; // 도서 반납일
	private String returnDate; // 실제 반납일(반납현황)

	// CheckOut(){};

	CheckOut(String bookNo, String title, String irum, String phone, String coDate, String ciDate) {
		this.id = id + idCnt++;
		this.bookNo = bookNo;
		this.irum = irum;
		this.title = title;
		this.phone = phone;
		this.coDate = coDate;
		this.ciDate = ciDate;
		this.returnDate = null;
	}

	public String getId() {
		return Integer.toString(id);
	}
 
	public String getIrum() {
		return irum;
	}

//	public void setIrum(String irum) {
//		this.irum = irum;
//	}

	public String getPhone() {
		return phone;
	}

//	public void setPhone(String phone) {
//		this.phone = phone;
//	}

	public String getBookNo() {
		return bookNo;
	}

//	public void setBookNo(String bookNo) {
//		this.bookNo = bookNo;
//	}

	public String getTitle() {
		return title;
	}

//	public void setTitle(String title) {
//		this.title = title;
//	}

	public String getCoDate() {
		return coDate;
	}

	public void setCoDate(String coDate) {
		this.coDate = coDate;
	}

	public String getCiDate() {
		return ciDate;
	}

	public void setCiDate(String ciDate) {
		this.ciDate = ciDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
}