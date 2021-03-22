//반납 기능 데이터 클래스

package Project;

public class CheckOut {

	//필요데이터 : id, 대여일자, 대여자, 대여할 책
	//대여자 : 고객 클래스의 id
	//대여할 책 : 도서 클래스의 id
	
	int id;
	String date;
	String person;
	String book;
	String phone;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	
}
