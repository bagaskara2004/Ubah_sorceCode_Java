import java.util.Scanner;

abstract class Main {

  static Scanner scan = new Scanner(System.in);
  static Library library = new Library();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

      if (selectedMenu == 1) {
        showBooks();
      } else if (selectedMenu == 2) {
        showMembers();
      } else if (selectedMenu == 3) {
        addBook();
      } else if (selectedMenu == 4) {
        addMember();
      } else if (selectedMenu == 5) {
        borrowBook();
      } else if (selectedMenu == 6) {
        returnBook();
      } else if (selectedMenu == 7) {
        donate();
      } else if (selectedMenu == 8) {
        ShowDonate();
      } else {
        System.out.println("wrong input");
      }

      System.out.print("continue ? (y/n)=> ");
      isContinue = scan.next();
    }
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show books list");
    System.out.println("2. show members list");
    System.out.println("3. add book");
    System.out.println("4. add member");
    System.out.println("5. borrow book");
    System.out.println("6. return book");
    System.out.println("7. donate");
    System.out.println("8. show supplyer");
    System.out.println("================================");
  }

  public static void initLibraryData() {
    Book book1 = new Book();
    book1.id = "1";
    book1.title = "pemrograman java";

    Book book2 = new Book();
    book2.id = "2";
    book2.title = "pemrograman oop";

    Book book3 = new Book();
    book3.id = "3";
    book3.title = "pemrograman android";

    Member member1 = new Member();
    member1.id = "1";
    member1.name = "aka";

    Member member2 = new Member();
    member2.id = "2";
    member2.name = "budi";

    Member member3 = new Member();
    member3.id = "3";
    member3.name = "tono";

    library.books.add(book1);
    library.books.add(book2);
    library.books.add(book3);

    library.members.add(member1);
    library.members.add(member2);
    library.members.add(member3);
  }

  public static int chooseMenu() {
    int pilihan=0;
    try{
      System.out.print("choose menu : ");
      pilihan = scan.nextInt();
    }catch(Exception e){
      System.out.println("inputan salah");
    }
    return pilihan;
  }

  public static void showBooks() {
    for (Book book : library.books) {
      System.out.println(book.id + " " + book.title);
    }
  }

  public static void showMembers() {
    for (Member member : library.members) {
      System.out.println(member.id + " " + member.name);
    }
  }
//====================add book=============================================
  public static void addBook() {
    Book book = new Book();
    boolean repeat;
  do{
    repeat = false;
    System.out.print("id : ");
    book.id = scan.next();

    System.out.print("title : ");
    book.title = scan.next();

    for (Book bookz : library.books) {
      if (bookz.id.equals(book.id)) {
        System.out.println("note : id already exists");
        System.out.println("===input again===");
        repeat = true;
      }
    }
  }while(repeat == true);
    library.addBook(book);
  }
//=======================end book==========================================
  public static void addMember() {
    boolean repeat = true;
    Member member = new Member();

    System.out.print("id : ");
    member.id = scan.next();

    System.out.print("name : ");
    member.name = scan.next();

    for (Member memberz : library.members) {
      if (memberz.id.equals(member.id)) {
        System.out.println("id sudah ada");
        repeat = false;
      }
    }
    if (repeat == true) {
      library.addMember(member);
    }
  }

  public static void borrowBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.giveBook(memberId, bookId);
  }

  public static void returnBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.receiveBook(bookId, memberId);
  }

  public static void donate(){
    Scanner input = new Scanner(System.in);
    Supplyer supply = new Supplyer();
    System.out.print("name : ");
    supply.name = scan.next();

    System.out.print("quantity : ");
    int qty = input.nextInt();
    supply.setQty(qty);

    for (int i = 1;i<=qty ;i++ ) {
      System.out.println("====masukan buku ke-"+i+"====");
      addBook();
    }
    library.addSupplyer(supply);
  }
  public static void ShowDonate() {
    for (Supplyer supply : library.supply) {
      System.out.println("name = "+supply.name + " , Qty = " + supply.getQty());
    }
  }
}