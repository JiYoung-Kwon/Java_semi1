package Project;

import java.util.ArrayList;
import java.util.List;

public class MainData { // ���� ������ ��ü
	private static List<Customer> customers = new ArrayList<Customer>(); // ������ ����Ʈ
	private static List<Book> books = new ArrayList<Book>(); // �������� ����Ʈ
	private static List<CheckOut> checkOutInfo = new ArrayList<CheckOut>(); // �뿩���� ����Ʈ
	static CustomerController customerC = new CustomerController(); // ������ ��Ʈ�ѷ�
	static BookController bookC = new BookController(); // �������� ��Ʈ�ѷ�
	static CheckOutController checkOutCtrl = new CheckOutController(); // �뿩���� ��Ʈ�ѷ�
	static CheckInController checkInC = new CheckInController(); // �ݳ����� ��Ʈ�ѷ�
	
	// �׽�Ʈ�� �����͸� ���� �����ڷ� �Է���
	MainData(){
		//Customer(String id, String irum, String address)
		Customer customer1 = new Customer("01000001111","��浿","���� ���ϱ�");
		Customer customer2 = new Customer("01000002222","ȫ��û","���� ���ϱ�");
		Customer customer3 = new Customer("01000003333","�粩��","���� �����");
		Customer customer4 = new Customer("01000004444","�ֳ��","���� ������");
		Customer customer5 = new Customer("01000005555","�����","���� ���Ǳ�");
		Customer customer6 = new Customer("01000006666","��ȫ��","��⵵ �Ȼ��");
		Customer customer7 = new Customer("01000007777","�赿��","��⵵ �ϻ��");
		Customer customer8 = new Customer("01000008888","Ÿ�̽�","��⵵ ������");
		Customer customer9 = new Customer("01000009999","���̸�","���� ���α�");
		Customer customer10 = new Customer("01000000001","���̴�","���� ���빮��");
		
		customers.add(customer1); customers.add(customer2); customers.add(customer3); customers.add(customer4); customers.add(customer5);
		customers.add(customer6); customers.add(customer7); customers.add(customer8); customers.add(customer9); customers.add(customer10);
		
		//Book(String name, String author,String br,String date)
		Book book1 = new Book("����","����������������","�Ҽ�","7");
		Book book2 = new Book("������ ���","���� ����ƾ","�Ҽ�","7");
		Book book3 = new Book("�Ѽ���, �� ���� �㿡","���̻�","�Ҽ�","7");
		Book book4 = new Book("����","�Ƹ�","�Ҽ�","7");
		Book book5 = new Book("�ΰ��ǰ�","������ ���繫","�Ҽ�","7");
		Book book6 = new Book("ȯ�� ��","������","�Ҽ�","3");
		Book book7 = new Book("������ ���� 1��","��ī����","��ȭå","3");
		Book book8 = new Book("���ǽ� 3��","����","��ȭå","3");
		Book book9 = new Book("������ �йи� 7��","�ٲ�","��ȭå","3");
		Book book10 = new Book("�ʹ� 5��","�����ٽ�","��ȭå","3");
		Book book11 = new Book("����� �׹�����","�����","��ȭå","3");
		Book book12 = new Book("�ּ�ȸ��11��","������","��ȭå","3");
		Book book13 = new Book("�͸��� Į�� 4��","��ÿ�","��ȭå","3");
		Book book14 = new Book("ŷ�� 48��","�߽��̻� �϶�","��ȭå","3");
		Book book15 = new Book("����ť 17��","�迬��","��ȭå","3");
		Book book16 = new Book("���� ����� ��ī���̾� 23��","������","��ȭå","3");
		Book book17 = new Book("�ڳ� 150��","�ƿ��߸� ���","��ȭå","3");
		Book book18 = new Book("�ҳ�Ž�� ������ 11��","������","��ȭå","3");
		Book book19 = new Book("��¥���� 26��","�ϸ���ī ����","��ȭå","3");
		Book book20 = new Book("ȸ����� ���̵�縶! 5��","�����Ͷ� ����","��ȭå","3");
		Book book21 = new Book("��ġ 38��","�� Ÿ����","��ȭå","3");
		Book book22 = new Book("���ݸ� 15�� ","����Ÿ��","��ȭå","3");
		Book book23 = new Book("������ 33��","������","��ȭå","3");
		
		books.add(book1); books.add(book2); books.add(book3); books.add(book4); books.add(book5); books.add(book6); books.add(book7);
		books.add(book8); books.add(book9); books.add(book10); books.add(book11); books.add(book12); books.add(book13); books.add(book14);
		books.add(book15); books.add(book16); books.add(book17); books.add(book18); books.add(book19); books.add(book20); books.add(book21);
		books.add(book22); books.add(book23);
		
		//(String bookNo, String title,String irum,String phone,String coDate,String ciDate)
		CheckOut checkOut1 = new CheckOut (book1.getBookNo(), book1.getTitle(), customer1.getIrum(), customer1.getPhoneNum(),
				"2021-03-23", "2021-03-26" ); // ��¥ �����ϴ� �޼ҵ� �����ؾ���
		CheckOut checkOut2 = new CheckOut (book2.getBookNo(), book2.getTitle(), customer2.getIrum(), customer2.getPhoneNum(),
				"2021-03-23", "2021-03-26" );
		CheckOut checkOut3 = new CheckOut (book3.getBookNo(), book3.getTitle(), customer3.getIrum(), customer3.getPhoneNum(),
				"2021-03-23", "2021-03-29" );
		checkOutInfo.add(checkOut1); checkOutInfo.add(checkOut2); checkOutInfo.add(checkOut3);
	}


	public static List<Customer> getCustomers() { // ������ ����Ʈ ��ȯ
		return customers;
	}


	public static void addCustomer(Customer customer) { // ������ ����Ʈ�� ������ �߰�
		customers.add(customer);
	}


	public static List<Book> getBooks() { // �������� ����Ʈ ��ȯ
		return books;
	}


	public static void addBook(Book book) { // �������� ����Ʈ�� �������� �߰�
		books.add(book);
	}


	public static List<CheckOut> getCheckOutInfo() { // �뿩���� ����Ʈ ��ȯ
		return checkOutInfo;
	}


	public static void addCheckOutInfo(CheckOut checkOut) { // �뿩���� ����Ʈ�� �뿩���� �߰�
		checkOutInfo.add(checkOut);
	}
}
