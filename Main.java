import java.lang.String;
import java.util.*;


public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String userChoice, author, title, isbn, bookObjectChoice;
    String[] bookInput;
    int index = 0;
    int libraryCount = 0;
    int bookStoreCount = 0;
    
    Book [] books = new Book[100];
    
    while (true)
    {
        System.out.printf("Would you like to create a book object?:(yes/no): ");
        do
        {
            bookObjectChoice = in.nextLine().trim().toLowerCase();
            if (bookObjectChoice.equals("yes") == false && bookObjectChoice.equals("no") == false)
              System.out.println("Oops! That's not a valid entry. Please try again: ");

        } while(bookObjectChoice.equals("yes") != true && bookObjectChoice.equals("no") != true);

        if (bookObjectChoice.equals("yes")) 
        {
            System.out.printf("Enter the author, title, and isbn of the book seperated by /: ");
            userChoice = in.nextLine();
            
            bookInput = userChoice.split("/");
            author = bookInput[0];
            title = bookInput[1];
            isbn = bookInput[2];

            System.out.printf("Got it!\n\n");
            System.out.printf("Now, tell me if it's a bookstore book or a library book(Enter BB for bookstore book or LB for library book): ");
            do
            {
                bookObjectChoice = in.nextLine().trim().toLowerCase();

                if (bookObjectChoice.equals("bb") == false && bookObjectChoice.equals("lb") == false)
                    System.out.printf("Oops! That's not a valid entry. Please try again: ");

            }  while(bookObjectChoice.equals("bb") != true && bookObjectChoice.equals("lb") != true);
            System.out.println("Got it!");

            if (bookObjectChoice.equals("bb")) 
            {
                BookstoreBook bookStore = new BookstoreBook(title, author, isbn);
                double listPrice;
                boolean onsale;
                double saleRate;
                double bookPrice;

                System.out.print("Enter the list price of " + bookStore.getTitle().toUpperCase() + " by " + author.toUpperCase() + ": $");
                listPrice = in.nextDouble();
                in.nextLine();
                bookStore.setPrice(listPrice);
                System.out.printf("Is it on sale?(yes/no): ");
                userChoice = in.nextLine();


                if (userChoice.equals("yes"))
                    onsale = true;
                else
                    onsale = false;
                  
                bookStore.setOnSale(onsale);

                System.out.printf("Deduction percentage: ");
                userChoice = in.nextLine();
                userChoice = userChoice.replace('%', ' ');
                saleRate = Double.parseDouble(userChoice);

                bookStore.setSaleRate(saleRate);

                System.out.printf("Got it!\n\n");

                System.out.println("Here is your bookstore book information: ");
                listPrice = bookStore.getPrice();

                if (bookStore.getOnSale())
                {
                    bookPrice = listPrice * (1 - (saleRate / 100));
                    bookStore.setPrice(listPrice);
                    bookStore.setSaleRate(bookPrice);
                    System.out.println(bookStore);
                    books[index] = bookStore;
                    bookStoreCount++;
                    index++;
                }
                else
                {
                    System.out.println("[" + bookStore.getIsbn() + "-" + bookStore.getTitle().toUpperCase() + " by " + bookStore.getAuthor().toUpperCase() + "-$" + String.format("%.2f", bookStore.getPrice()));
                    books[index] = bookStore;
                    bookStoreCount++;
                    index++;
                }

            }
            else if (bookObjectChoice.equals("lb"))
            {
                LibraryBook library = new LibraryBook(title, author, isbn);
                String subjectLetter = "Z";
                int flag = 0;
                System.out.printf("What's the subject: ");
                while (flag == 0)
                {
                    userChoice = in.nextLine().trim().toLowerCase();

                    switch(userChoice) {
                        case "general":
                            subjectLetter = "A";
                            flag = 1;
                            break;
                        case "philosophy":
                            subjectLetter = "B";
                            flag = 1;
                            break;
                        case "religion":
                            subjectLetter = "C";
                            flag = 1;
                            break;
                        case "world history":
                            subjectLetter = "D";
                            flag = 1;
                            break;
                        case "history of the americas":
                            subjectLetter = "E";
                            flag = 1;
                            break;
                        case "geography":
                            subjectLetter = "F";
                            flag = 1;
                            break;
                        case "anthropology":
                            subjectLetter = "G";
                            flag = 1;
                            break;
                        case "social sciences":
                            subjectLetter = "H";
                            flag = 1;
                            break;
                        case "internet":
                            subjectLetter = "I";
                            flag = 1;
                            break;
                        case "political science":
                            subjectLetter = "J";
                            flag = 1;
                            break;
                        case "law":
                            subjectLetter = "K";
                            flag = 1;
                            break;
                        case "education":
                            subjectLetter = "L";
                            flag = 1;
                            break;
                        case "music":
                            subjectLetter = "L";
                            flag = 1;
                            break;
                        case "fine arts":
                            subjectLetter = "N";
                            flag = 1;
                            break;
                        case "language":
                            subjectLetter = "P";
                            flag = 1;
                            break;
                        case "science":
                            subjectLetter = "Q";
                            flag = 1;
                            break;
                        case "medicine":
                            subjectLetter = "R";
                            flag = 1;
                            break;
                        case "agriculture":
                            subjectLetter = "S";
                            flag = 1;
                            break;
                        case "technology":
                            subjectLetter = "T";
                            flag = 1;
                            break;
                        case "military":
                            subjectLetter = "U";
                            flag = 1;
                            break;
                  
                        default:
                            System.out.printf("Oops that's not a valid entry. Please Try Again: ");
                    }
                }
                System.out.println("Got it!");
                System.out.printf("\n\n");
                int randomNum = (int) Math.floor(Math.random() * (15 - 1 + 1) + 1);
                int length = isbn.length() - 1;
                char letterIsbn = library.getIsbn().charAt(length);

                library.setCallNumber(subjectLetter, Integer.toString(randomNum), library.getAuthor().substring(0, 3), Character.toString(letterIsbn));
                System.out.println("Here is your library book information: ");
                System.out.printf("\n");
                System.out.println(library);
                System.out.printf("\n\n");
                books[index] = library;
                libraryCount++;
                index++;
            }
        }
        else
        {
            System.out.println("Sure!");
            System.out.printf("\n\n");
            System.out.println("Here are all the books you entered..." + String.format("\n\n"));

            System.out.printf("Library Books(%d)\n", libraryCount);
            for (int i = 0; i < libraryCount; i++)
                System.out.printf("\t%s\n", books[i]);
            System.out.println("----");
            
            System.out.printf("Bookstore Books(%d)\n", bookStoreCount);
            for (int i = 0; i < bookStoreCount; i++)
                System.out.printf("\t%s\n", books[i]);
            System.out.println("----");

            
            do
            {
                System.out.print("Would you like to search for a book?(yes/no): ");
                bookObjectChoice = in.nextLine().trim().toLowerCase();
                if (bookObjectChoice.equals("yes") == false && bookObjectChoice.equals("no") == false)
                    System.out.println("Oops! That's not a valid entry. Please try again.");
            }   while(bookObjectChoice.equals("yes") != true && bookObjectChoice.equals("no") != true);

            if (bookObjectChoice.equals("yes"))
            {
                System.out.println("Search by isbn, author, or title? ");
                userChoice = in.nextLine().toLowerCase().trim();
                boolean found = false;
                if (userChoice.equals("isbn"))
                {
                    System.out.println("Enter the isbn of your book: ");
                    userChoice = in.nextLine().trim().toUpperCase();
                    

                    System.out.println("Here are the books which were found: ");
                    for (int i = 0; i < index; i++)
                    {
                        if (books[i].getIsbn().equals(userChoice))
                        {
                            found = true;
                            System.out.println(books[i]);
                        }
                    }
                }
                else if (userChoice.equals("author"))
                {
                    System.out.println("Enter the first three letters of the author: ");
                    userChoice = in.nextLine().trim().toUpperCase();
                    

                    System.out.println("Here are the books which were found: ");
                    for (int i = 0; i < index; i++)
                    {
                        if (books[i].getAuthor().substring(0, 3).equals(userChoice))
                        {
                            found = true;
                            System.out.println(books[i]);
                        }
                        
                    }
                        
                }
                else
                {
                    System.out.println("Enter the name of your book: ");
                    userChoice = in.nextLine().toUpperCase().trim();
                    

                    System.out.println("Here are the books which were found: ");
                    for (int i = 0; i < index; i++)
                    {
                        if (books[i].getTitle().equals(userChoice))
                        {
                            found = true;
                            System.out.println(books[i]);
                        }
                    }
                    
                }
                if (!found)
                {
                    System.out.println("...");
                    System.out.println("No books were found which match your search.");
                }
                System.out.println(String.format("\n\n") + "Take Care!");
                    break;
            }
            else
            {
                System.out.println("Take Care!");
                break;
            }
        }
    }
    in.close();
  }

}

