package Project;

public class Book {
	private int bookNo = 1;	//�����ѹ�
	private static int bookNoCnt=0;
	String title;	//å����
	String author;	//����
	String sort;	//�з�(��ȭ,�Ҽ�)
	String date;   //�뿩������
	

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
