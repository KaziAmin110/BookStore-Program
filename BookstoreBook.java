public class BookstoreBook extends Book {
    private double price;
    private boolean onSale;
    private double saleRate;

    //setter getters-----------------------
    public void setPrice(double price) {
    this.price = price;
    }

    public double getPrice() {
        return this.price;
    }  

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean getOnSale() {
        return onSale;
    }

    public void setSaleRate(double saleRate) {
        this.saleRate = saleRate;
    }
    public double getSaleRate() {
      return saleRate;
    }
  //--------------------------------------
  
  //constructor
  public BookstoreBook(String title, String author, String isbn, double price, boolean onSale, double saleRate)
  {
    super(title, author, isbn);
    this.price = price;
    this.onSale = onSale;
    this.saleRate = saleRate;
  }
  public BookstoreBook(String title, String author, String isbn)
  {
    super(title, author, isbn);
  }


  //tostring
@Override
public String toString() 
{
  return super.toString() + "-$" + String.format("%.2f", price) + " listed for " + "$" + String.format("%.2f", saleRate) + " ]";
}

@Override
public String getBookType() {
  return "Bookstore Book";
}
}
