//대여 및 반납 기능 데이터 클래스

package Project;

public class CheckOut {

	//필요데이터 : id, 대여일자, 대여자, 대여할 책
	//대여자 : 고객 클래스의 id
	//대여할 책 : 도서 클래스의 id
	
	int id;
	String date;
	String irum;
	String title;
	String phone;
	String coDate;
	String ciDate;
	String returnDate;
	
	CheckOut(){};
	
	CheckOut(int id, String title,String irum,String phone,String coDate,String ciDate,String returnDate){
		this.id = id;
		this.irum = irum;
		this.title = title;
		this.phone = phone;
		this.coDate = coDate;
		this.ciDate = ciDate;
		this.returnDate = returnDate;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
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

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
