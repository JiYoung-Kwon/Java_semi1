package Project;

public class Book {
	int num;	//No.
	String name;	//책제목
	String author;	//저자
	String br;	//분류(만화,소설)
	String date;   //대여가능일
	

	public Book(int num, String name, String author,String br,String date) {
		this.num = num;
		this.name = name;
		this.author = author;
		this.br = br;
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBr() {
		return br;
	}
	
	public void setBr(String br) {
		this.br = br;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
