//ȸ�� ���� ������ Ŭ����

package Project;

public class Customer {
	
	//phoneNum �� �޴��� ��ȣ �⺻��
	//irum �� ����
	//addess �� �ּ�
	
	
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
