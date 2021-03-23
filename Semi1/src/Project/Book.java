package Project;

public class Book {
	private int bookNo = 1;	//도서넘버
	private static int bookNoCnt=0;
	String title;	//책제목
	String author;	//저자
	String sort;	//분류(만화,소설)
	String date;   //대여가능일
	

	public Book(String title, String author,String sort,String date) {
		this.bookNo += bookNoCnt;
		bookNoCnt++;
		this.title = title;
		this.author = author;
		this.sort = sort;
		this.date = date;
	}

	public String getBookNo() {
		return Integer.toString(bookNo);
	}

//	public void setNum(int num) {
//		this.num = num;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSort() {
		return sort;
	}
	
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
