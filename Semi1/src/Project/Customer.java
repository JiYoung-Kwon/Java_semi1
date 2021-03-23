//회원 정보 데이터 클래스

package Project;

public class Customer {
	
	//phoneNum 은 휴대폰 번호 기본값
	//irum 은 성명
	//addess 는 주소
	
	
	private String phoneNum;
	private String irum;
	private String address;
	
	public Customer(String phoneNum, String irum, String address) {
		this.phoneNum = phoneNum;
		this.irum = irum;
		this.address = address;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
