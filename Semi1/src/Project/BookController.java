package Project;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	
	//���� ����Ʈ �߰�
	public String append(Book b) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";
		try {
			if((b.getTitle().length() ==0 || b.getAuthor().length() ==0 )) {
				msg = "���� �Է����ּ���.";
			} else {
				MainData.addBook(b);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			msg = "������ ���忡 �����Ͽ����ϴ�.";
		}
		return msg;
	}
	
	public String update(int index ,String title, String author,String sort,String date) {  // ���� �޼ҵ�
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		
		try {
			if (title.length() == 0 || author.length() ==0) {			
				msg = "���� �Է����ּ���.";
			}else {
					MainData.getBooks().get(index).setTitle(title);         // �ش� �ε����� ��ü �����͸� �Է� ������ ����.
					MainData.getBooks().get(index).setAuthor(author);       
					MainData.getBooks().get(index).setSort(sort);
					MainData.getBooks().get(index).setDate(date.replace("��", ""));
					
					for(int i= 0; i<MainData.getCheckOutInfo().size(); i++) {
						CheckOut c = MainData.getCheckOutInfo().get(i);
						System.out.println(c.getBookNo());
						System.out.println(index+1);
						if(c.getBookNo().equals(Integer.toString(index+1)))
						{
							System.out.println("������");
							c.setTitle(title);
							}
					}		
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			msg = "������ ������ �� ������ �߻��Ͽ����ϴ�.";
		}
		
		return msg;
	}
	
	public String delete(String title) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			if(title.length() == 0)
				msg = "���� �������ּ���.";
			else {
				for(int index=MainData.getBooks().size()-1; index>=0; index--) {
					Book target = MainData.getBooks().get(index);
					
					if(target.getTitle().equals(title)) {
						MainData.getBooks().remove(index);
						break;
					}
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
		List<Book> returnList = new ArrayList<Book>();   // ��ȯ���� ����Ʈ ����
		
		
		for(int i=0; i<MainData.getBooks().size(); i++) { //��ü ������
			if(findStr.length()==0) {                 // �������� �˻�� ���°��
				if(MainData.getBooks().get(i).getAuthor().indexOf(findStr2)>-1) {       // ���ڸ�� ��ġ�ϴ� ��ü�� �߰�.
					returnList.add(MainData.getBooks().get(i));}
				    }
			else if (findStr2.length()==0) {          // ���ڸ��� �˻�� ���°��
				if(MainData.getBooks().get(i).getTitle().indexOf(findStr)>-1) {         // ������� ��ġ�ϴ� ��ü�� �߰�
					returnList.add(MainData.getBooks().get(i));}
				}
			else {if(MainData.getBooks().get(i).getTitle().indexOf(findStr)>-1&&   // �Ѵ� �˻��Ѱ��.
				     MainData.getBooks().get(i).getAuthor().indexOf(findStr2)>-1)  // �Ѵ� ��ġ�ϴ� ��ü�� �߰�
					  returnList.add(MainData.getBooks().get(i));}			
			}
		

		
		return returnList;     // ����� ����Ʈ ��ȯ.
	}
	
	
	public Book searchBookNo(String num) {
	      for(int i=0; i<MainData.getBooks().size(); i++) {
	         if(MainData.getBooks().get(i).getBookNo().equals(num))
	            return MainData.getBooks().get(i);
	      }
	      return null;
	   }
	
	
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
	
	List<Book> searchTitle(String title) {
	      List<Book> resultList = new ArrayList<Book>();
	      
	      for(int i=0; i<MainData.getBooks().size(); i++) {
	         if(MainData.getBooks().get(i).getTitle().contains(title))
	            resultList.add(MainData.getBooks().get(i));            
	      }
	      
	      return resultList;
	   }
	
}