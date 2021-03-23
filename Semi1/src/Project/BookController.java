package Project;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	
	public static List<Book> books = new ArrayList<Book>();
	
	//도서 리스트 추가
	public String append(Book b) {
		String msg = "데이터가 정상적으로 저장되었습니다.";
		try {
			MainData.addBook(b);
		}catch(Exception e) {
			e.printStackTrace();
			msg = "데이터 저장에 실패하였습니다.";
		}
		return msg;
	}
	
	public void update(int index ,String title, String author,String sort,String date) {
		MainData.getBooks().get(index).setTitle(title);
		MainData.getBooks().get(index).setAuthor(author);
		MainData.getBooks().get(index).setSort(sort);
		MainData.getBooks().get(index).setDate(date.replace("일", ""));	
	}
	
	public String delete(Book b) {
		String msg = "데이터가 정상적으로 삭제되었습니다.";
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
			msg = "데이터 삭제 중 오류가 발생하였습니다.";
		}
		return msg;
	}
	
	public List<Book> search(String findStr){
		List<Book> returnList = new ArrayList<Book>();
		
		for(int i=0; i<MainData.getBooks().size(); i++) {
		 if(MainData.getBooks().get(i).getBookNo().indexOf(findStr)>-1) {         // 도서 No과 일치하는 객체만 추가
			returnList.add(MainData.getBooks().get(i));}}
		
		
		return returnList;
	}
	
	public List<Book> search(String findStr, String findStr2){
		List<Book> returnList = new ArrayList<Book>();
		
		
		for(int i=0; i<MainData.getBooks().size(); i++) {
			if(findStr.length()==0) {                 // 도서명(or No.)의 검색어가 없는경우
				if(MainData.getBooks().get(i).getAuthor().indexOf(findStr2)>-1) {       // 저자명과 일치하는 객체만 추가.
					returnList.add(MainData.getBooks().get(i));}
				    }
			else if (findStr2.length()==0) {          // 저자명의 검색어가 없는경우
				if(MainData.getBooks().get(i).getTitle().indexOf(findStr)>-1) {         // 도서명(or No.)과 일치하는 객체만 추가
					returnList.add(MainData.getBooks().get(i));}
				}
			else {if(MainData.getBooks().get(i).getTitle().indexOf(findStr)>-1&&   // 둘다 검색한경우.
				     MainData.getBooks().get(i).getAuthor().indexOf(findStr2)>-1)  // 둘다 일치하는 객체만 추가
					  returnList.add(MainData.getBooks().get(i));}			
			}
		

		
		return returnList;     // 저장된 리스트 반환.
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
	
	
	public int selectOne(String BookNo) {       // 도서 No.으로 해당 객체 인덱스 찾기
		int index = 0;
		
		for(int i=0; i<MainData.getBooks().size();i++) {    // 책 List에서 해당 No을 가진 객체 찾기.
		if(BookNo.equals(MainData.getBooks().get(i).getBookNo())) {    // 일치할경우 해당 인덱스 번호 출력
			index=i;	
			break;
			}
		else {index=-1;}          // 일치하는 값이 없을 경우 -1을 출력
		}
		return index;
	}
	
}















