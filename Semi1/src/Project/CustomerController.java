//회원 정보 CRUD 컨트롤러

package Project;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
	public static List<Customer> customers = new ArrayList<Customer>();
	
	//회원 정보 입력기능
	public String append(Customer c) {
		String msg = "데이터가 정상적으로 저장되었습니다.";
		try {
			customers.add(c); //정보를 리스트에 추가
		}catch(Exception ex){
			ex.printStackTrace();
			msg = "데이터 저장 중 오류발생.";
		}
		return msg;
	}
	//수정 기능
	public String update(Customer c,String a) {
		String msg = "데이터가 정상적으로 수정되었습니다.";
		System.out.println(c.getId());
		try {
			//리스트 내용 수정
			for(int index = 0; index < customers.size(); index++) {
				Customer target = customers.get(index);
				
				if(target.getId().equals(a)) {
					customers.set(index, c);
					break;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			msg = "데이터 수정 중 오류 발생.";
		}
		return msg;
	}
	//삭제 기능
	public String delete(Customer c) {
		String msg = "데이터가 정삭적으로 삭제되었습니다.";
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
			msg = "데이터 삭제 중 오류 발생";
		}
		return msg;
	}
	//조회 기능
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







