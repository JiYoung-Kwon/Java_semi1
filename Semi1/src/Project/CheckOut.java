//�ݳ� ��� ������ Ŭ����

package Project;

public class CheckOut {

	//�ʿ䵥���� : id, �뿩����, �뿩��, �뿩�� å
	//�뿩�� : �� Ŭ������ id
	//�뿩�� å : ���� Ŭ������ id
	
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
