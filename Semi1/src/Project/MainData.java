package Project;

import java.util.ArrayList;
import java.util.List;

public class MainData { // 메인 데이터 객체
	private static List<Customer> customers = new ArrayList<Customer>(); // 고객정보 리스트
	private static List<Book> books = new ArrayList<Book>(); // 도서정보 리스트
	private static List<CheckOut> checkOutInfo = new ArrayList<CheckOut>(); // 대여정보 리스트
	static CustomerController customerC = new CustomerController(); // 고객관리 컨트롤러
	static BookController bookC = new BookController(); // 도서관리 컨트롤러
	static CheckOutController checkOutCtrl = new CheckOutController(); // 대여관리 컨트롤러
	static CheckInController checkInC = new CheckInController(); // 반납관리 컨트롤러
	
	// 테스트용 데이터를 위해 생성자로 입력함
	MainData(){
		//Customer(String id, String irum, String address)
		Customer customer1 = new Customer("01000001111","김길동","서울 강북구");
		Customer customer2 = new Customer("01000002222","홍심청","서울 강북구");
		Customer customer3 = new Customer("01000003333","양꺽정","서울 노원구");
		Customer customer4 = new Customer("01000004444","최놀부","서울 도봉구");
		Customer customer5 = new Customer("01000005555","최흥부","서울 관악구");
		Customer customer6 = new Customer("01000006666","최홍만","경기도 안산시");
		Customer customer7 = new Customer("01000007777","김동현","경기도 일산시");
		Customer customer8 = new Customer("01000008888","타이슨","경기도 구리시");
		Customer customer9 = new Customer("01000009999","사이먼","서울 종로구");
		Customer customer10 = new Customer("01000000001","도미닉","서울 동대문구");
		
		customers.add(customer1); customers.add(customer2); customers.add(customer3); customers.add(customer4); customers.add(customer5);
		customers.add(customer6); customers.add(customer7); customers.add(customer8); customers.add(customer9); customers.add(customer10);
		
		//Book(String name, String author,String br,String date)
		Book book1 = new Book("나무","베르나르베르베르","소설","7");
		Book book2 = new Book("오만과 편견","제인 오스틴","소설","7");
		Book book3 = new Book("한성부, 달 밝은 밤에","김이삭","소설","7");
		Book book4 = new Book("유다","아모스","소설","7");
		Book book5 = new Book("인간실격","디자이 오사무","소설","7");
		Book book6 = new Book("환한 숨","조해진","소설","3");
		Book book7 = new Book("진격의 거인 1권","나카무라","만화책","3");
		Book book8 = new Book("원피스 3권","오다","만화책","3");
		Book book9 = new Book("스파이 패밀리 7권","다꽝","만화책","3");
		Book book10 = new Book("초밥 5권","스끼다시","만화책","3");
		Book book11 = new Book("약속의 네버랜드","사쿠라","만화책","3");
		Book book12 = new Book("주술회전11권","문관영","만화책","3");
		Book book13 = new Book("귀멸의 칼날 4권","김시영","만화책","3");
		Book book14 = new Book("킹덤 48권","야스이사 하라","만화책","3");
		Book book15 = new Book("하이큐 17권","김연경","만화책","3");
		Book book16 = new Book("나의 히어로 아카데미아 23권","윤동관","만화책","3");
		Book book17 = new Book("코난 150권","아오야마 고쇼","만화책","3");
		Book book18 = new Book("소년탐정 김전일 11권","김정일","만화책","3");
		Book book19 = new Book("괴짜가족 26권","하마오카 켄지","만화책","3");
		Book book20 = new Book("회장님은 메이드사마! 5권","후지와라 히로","만화책","3");
		Book book21 = new Book("블리치 38권","쿠보 타이토","만화책","3");
		Book book22 = new Book("원펀맨 15권 ","사이타마","만화책","3");
		Book book23 = new Book("나루토 33권","지보로","만화책","3");
		
		books.add(book1); books.add(book2); books.add(book3); books.add(book4); books.add(book5); books.add(book6); books.add(book7);
		books.add(book8); books.add(book9); books.add(book10); books.add(book11); books.add(book12); books.add(book13); books.add(book14);
		books.add(book15); books.add(book16); books.add(book17); books.add(book18); books.add(book19); books.add(book20); books.add(book21);
		books.add(book22); books.add(book23);
		
		//(String bookNo, String title,String irum,String phone,String coDate,String ciDate)
		CheckOut checkOut1 = new CheckOut (book1.getBookNo(), book1.getTitle(), customer1.getIrum(), customer1.getPhoneNum(),
				"2021-03-23", "2021-03-26" ); // 날짜 설정하는 메소드 구현해야함
		CheckOut checkOut2 = new CheckOut (book2.getBookNo(), book2.getTitle(), customer2.getIrum(), customer2.getPhoneNum(),
				"2021-03-23", "2021-03-26" );
		CheckOut checkOut3 = new CheckOut (book3.getBookNo(), book3.getTitle(), customer3.getIrum(), customer3.getPhoneNum(),
				"2021-03-23", "2021-03-29" );
		checkOutInfo.add(checkOut1); checkOutInfo.add(checkOut2); checkOutInfo.add(checkOut3);
	}


	public static List<Customer> getCustomers() { // 고객정보 리스트 반환
		return customers;
	}


	public static void addCustomer(Customer customer) { // 고객정보 리스트에 고객정보 추가
		customers.add(customer);
	}


	public static List<Book> getBooks() { // 도서정보 리스트 반환
		return books;
	}


	public static void addBook(Book book) { // 도서정보 리스트에 도서정보 추가
		books.add(book);
	}


	public static List<CheckOut> getCheckOutInfo() { // 대여정보 리스트 반환
		return checkOutInfo;
	}


	public static void addCheckOutInfo(CheckOut checkOut) { // 대여정보 리스트에 대여정보 추가
		checkOutInfo.add(checkOut);
	}
}
