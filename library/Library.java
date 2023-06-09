import java.util.*;

class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();
  public ArrayList<Supplyer> supply = new ArrayList<Supplyer>();

  public void addBook(Book book) {
    this.books.add(book);
  }

  public void addMember(Member member) {
    this.members.add(member);
  }

  public void addSupplyer(Supplyer supplyer){
    this.supply.add(supplyer);
  }

  // public Boolean isMemberIdExist(String id) {
  //   Boolean isExist = false;
  //   for (Member member : this.members) {
  //     if (member.id == id) {
  //       isExist = true;
  //     }
  //   }
  //   return isExist;
  // }

  public void giveBook(String memberId, String bookId) {
    Book book = this.getBookById(bookId);
    this.books.remove(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }

  public void receiveBook(String bookId, String memberId) {
    Book book = this.getBookByIds(bookId);
    this.books.add(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.remove(book);
  }

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
  private Book getBookByIds(String id) {
    for (Book book : Member.borrowedBooks){
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
}