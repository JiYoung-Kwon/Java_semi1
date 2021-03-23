//�뿩 �� �ݳ� ��� ������ Ŭ����

package Project;

public class CheckOut {

	private int id = 1; // �뿩��� Ű �ʱⰪ
	private static int idCnt = 0; // ��ü ���� �� id+=idCnt++�� id�� 1�� ����.
	private String irum; // �뿩�� �̸�
	private String phone; // �뿩�� ��ȣ
	private String bookNo; // �뿩���� ��ȣ
	private String title; // �뿩���� ����
	private String coDate; // ���� �뿩��
	private String ciDate; // ���� �ݳ���
	private String returnDate; // ���� �ݳ���(�ݳ���Ȳ)

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