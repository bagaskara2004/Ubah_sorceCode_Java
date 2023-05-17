import java.util.ArrayList;

class Member {
  public String id;
  public String name;
  public static ArrayList<Book> borrowedBooks = new ArrayList<Book>();

  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }
  public void popUp(){
    System.out.println("tambah Member sukses");
  }
}