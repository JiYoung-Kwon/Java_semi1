/*
package Project;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	
	public static List<Book> books = new ArrayList<Book>();
	
	public String append(Book b) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";
		try {
			books.add(b);
		}catch(Exception e) {
			e.printStackTrace();
			msg = "������ ���忡 �����Ͽ����ϴ�.";
		}
		return msg;
	}
	
	public String update(Book b) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
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
			msg = "������ ���� �� ������ �߻��Ͽ����ϴ�.";
		}
		return msg;
	}
	
	public String delete(Book b) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
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
			msg = "������ ���� �� ������ �߻��Ͽ����ϴ�.";
		}
		return msg;
	}
	
	public List<Book> search(String findStr){
		List<Book> returnList = new ArrayList<Book>();
		
		for(int index=0; index<books.size(); index++) {
			Book target = books.get(index);
			if(target.getName().indexOf(findStr)>-1 ||
			   target.getAuthor().indexOf(findStr)>-1 ) {
				returnList.add(target);
			}
			
		}
		return returnList;
	}
}*/
