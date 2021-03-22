//ȸ�� ���� CRUD ��Ʈ�ѷ�

package Project;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
	public static List<Customer> customers = new ArrayList<Customer>();
	
	//ȸ�� ���� �Է±��
	public String append(Customer c) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";
		try {
			customers.add(c); //������ ����Ʈ�� �߰�
		}catch(Exception ex){
			ex.printStackTrace();
			msg = "������ ���� �� �����߻�.";
		}
		return msg;
	}
	//���� ���
	public String update(Customer c,String a) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		System.out.println(c.getId());
		try {
			//����Ʈ ���� ����
			for(int index = 0; index < customers.size(); index++) {
				Customer target = customers.get(index);
				
				if(target.getId().equals(a)) {
					customers.set(index, c);
					break;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			msg = "������ ���� �� ���� �߻�.";
		}
		return msg;
	}
	//���� ���
	public String delete(Customer c) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			for(int index = customers.size()-1; index >= 0; index--) {
				Customer target = customers.get(index);
				
				if(target.getId().equals(c.getId())) {
					customers.remove(index);
					break;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			msg = "������ ���� �� ���� �߻�";
		}
		return msg;
	}
	//��ȸ ���
	public List<Customer>search(String findStr){
		List<Customer>returnList = new ArrayList<Customer>();
		
			for(int index = 0; index < customers.size(); index++) {
				Customer target = customers.get(index);
				if(target.getId().indexOf(findStr)>-1||
						target.getId().indexOf(findStr)>-1||
						target.getIrum().indexOf(findStr)>-1||
						target.getAddress().indexOf(findStr)>-1){
							returnList.add(target);
						}
			}
		return returnList;
	}
	
		public Customer selectOne(String id) {
			Customer c = null;
			for(int i = 0; i <customers.size(); i++) {
				Customer target = customers.get(i);
				if(id.equals(target.getId()));{
					c = target;
					break;
				}
			}
		return c;
		
	}
}







