public abstract class Book {
  private String title;
  private String author;
  private String isbn;

  //
  public void setTitle(String title) {
    this.title = title.toUpperCase();
  }
  public String getTitle() {
    return this.title;
  }

  public void setAuthor(String author) {
    this.author = author.toUpperCase();
  }
  public String getAuthor() {
    return this.author;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn.toUpperCase();
  }
  public String getIsbn() {
    return this.isbn;
  }

  public abstract String getBookType();
  
  public Book(String title, String author, String isbn)
  {
    this.title = title.toUpperCase();
    this.author = author.toUpperCase();
    this.isbn = isbn.toUpperCase();
  }

  public Book(String title, String author)
  {
    this.title = title;
    this.author = author;
  }

  @Override
  public String toString() {
    return "[ " + isbn.toUpperCase() + "-" + title.toUpperCase() + " by " + author.toUpperCase();
  }
}
