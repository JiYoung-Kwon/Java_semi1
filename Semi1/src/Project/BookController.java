package Project;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	
	public static List<Book> books = new ArrayList<Book>();
	
	//���� ����Ʈ �߰�
	public String append(Book b) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";
		try {
			MainData.addBook(b);
		}catch(Exception e) {
			e.printStackTrace();
			msg = "������ ���忡 �����Ͽ����ϴ�.";
		}
		return msg;
	}
	
	public void update(int index ,String title, String author,String sort,String date) {
		MainData.getBooks().get(index).setTitle(title);
		MainData.getBooks().get(index).setAuthor(author);
		MainData.getBooks().get(index).setSort(sort);
		MainData.getBooks().get(index).setDate(date.replace("��", ""));	
	}
	
	public String delete(Book b) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			for(int index=books.size()-1; index>=0; index--) {
				Book target = books.get(index);
				
				if(target.getTitle().equals(b.getTitle())) {
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
		
		for(int i=0; i<MainData.getBooks().size(); i++) {
		 if(MainData.getBooks().get(i).getBookNo().indexOf(findStr)>-1) {         // ���� No�� ��ġ�ϴ� ��ü�� �߰�
			returnList.add(MainData.getBooks().get(i));}}
		
		
		return returnList;
	}
	
	public List<Book> search(String findStr, String findStr2){
		List<Book> returnList = new ArrayList<Book>();
		
		
		for(int i=0; i<MainData.getBooks().size(); i++) {
			if(findStr.length()==0) {                 // ������(or No.)�� �˻�� ���°��
				if(MainData.getBooks().get(i).getAuthor().indexOf(findStr2)>-1) {       // ���ڸ�� ��ġ�ϴ� ��ü�� �߰�.
					returnList.add(MainData.getBooks().get(i));}
				    }
			else if (findStr2.length()==0) {          // ���ڸ��� �˻�� ���°��
				if(MainData.getBooks().get(i).getTitle().indexOf(findStr)>-1) {         // ������(or No.)�� ��ġ�ϴ� ��ü�� �߰�
					returnList.add(MainData.getBooks().get(i));}
				}
			else {if(MainData.getBooks().get(i).getTitle().indexOf(findStr)>-1&&   // �Ѵ� �˻��Ѱ��.
				     MainData.getBooks().get(i).getAuthor().indexOf(findStr2)>-1)  // �Ѵ� ��ġ�ϴ� ��ü�� �߰�
					  returnList.add(MainData.getBooks().get(i));}			
			}
		

		
		return returnList;     // ����� ����Ʈ ��ȯ.
	}
//		for(int index=0; index<books.size(); index++) {
//			Book target = books.get(index);
//			if(target.getBookNo().indexOf(findStr)>-1 ||
//  			   target.getTitle().indexOf(findStr)>-1 ||
//			   target.getAuthor().indexOf(findStr)>-1 ) {
//				returnList.add(target);
//			}
//			
//		}
//		return returnList;
	
	
	public int selectOne(String BookNo) {       // ���� No.���� �ش� ��ü �ε��� ã��
		int index = 0;
		
		for(int i=0; i<MainData.getBooks().size();i++) {    // å List���� �ش� No�� ���� ��ü ã��.
		if(BookNo.equals(MainData.getBooks().get(i).getBookNo())) {    // ��ġ�Ұ�� �ش� �ε��� ��ȣ ���
			index=i;	
			break;
			}
		else {index=-1;}          // ��ġ�ϴ� ���� ���� ��� -1�� ���
		}
		return index;
	}
	
}















