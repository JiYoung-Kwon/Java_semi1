package Project;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	
	public static List<Book> books = new ArrayList<Book>();
	
	//도서 리스트 추가
	public String append(Book b) {
		String msg = "데이터가 정상적으로 저장되었습니다.";
		try {
			books.add(b);
		}catch(Exception e) {
			e.printStackTrace();
			msg = "데이터 저장에 실패하였습니다.";
		}
		return msg;
	}
	
	public String update(Book b) {
		String msg = "데이터가 정상적으로 수정되었습니다.";
		try {
			for(int index=0; index<books.size(); index++) {
				Book target = books.get(index);
				
				if(target.getName().equals(b.getName())) {
					books.set(index, b);
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			msg = "데이터 수정 중 오류가 발생하였습니다.";
		}
		return msg;
	}
	
	public String delete(Book b) {
		String msg = "데이터가 정상적으로 삭제되었습니다.";
		try {
			for(int index=books.size()-1; index>=0; index--) {
				Book target = books.get(index);
				
				if(target.getName().equals(b.getName())) {
					books.remove(index);
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			msg = "데이터 삭제 중 오류가 발생하였습니다.";
		}
		return msg;
	}
	
	public List<Book> search(String findStr){
		List<Book> returnList = new ArrayList<Book>();
		
		for(int index=0; index<books.size(); index++) {
			Book target = books.get(index);
			if(Integer.toString(target.getNum()).indexOf(findStr)>-1 ||
  			   target.getName().indexOf(findStr)>-1 ||
			   target.getAuthor().indexOf(findStr)>-1 ) {
				returnList.add(target);
			}
			
		}
		return returnList;
	}
	
	public Book selectOne(String name) {
		Book b = null;
		for(int i=0; i<books.size();i++) {
			Book target = books.get(i);
			if(name.equals(target.getName())) {
				b = target;
				break;
			}
		}
		return b;
	}
	
}















