//회원 정보 데이터 클래스

package Project;

public class Customer {
	
	//id 는 휴대폰 번호
	//irum 은 성명
	//addess 는 주소
	
	
	String id;
	String irum;
	String address;
	
	public Customer(String id, String irum, String address) {
		this.id = id;
		this.irum = irum;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
