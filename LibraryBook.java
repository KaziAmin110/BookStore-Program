public class LibraryBook extends Book {

  String subject;
  String callNumber;

  public void setSubject (String subject) {
    this.subject = subject;
  }

  public void setCallNumber(String subject, String floorNumber, String author, String isbn) {
    this.callNumber = subject + '.' + floorNumber + '.' + author + '.' + isbn;
  }

  public String getCallNumber() {
    return callNumber;
  }

  public String getSubject() {
    return subject;
  }

  public LibraryBook(String title, String author, String isbn, String subject, String callNumber) {
    super(title, author, isbn);
    this.subject = subject;
    this.callNumber = callNumber;
  }

  public LibraryBook(String title, String author, String isbn) {
    super(title, author, isbn);
  }

  @Override
  public String getBookType() {
    return "Library Book";
  }

  @Override
  public String toString() {
    return super.toString() + "-" + callNumber.toUpperCase() + "]";   
  }

}

