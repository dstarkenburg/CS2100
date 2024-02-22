/**
Duncan Starkenburg
CS 2100, Week 5 HW
This class creates the Book object
*/

public class Book
{
   // Declare private members;
   private String isbn;
   private String title;
   private Author author;
   private String publisher;
   private int numPages;
   
   /**
   * Constructor for a new Book object that sets parameters 
   * isbnStr, titleStr, authorObj, publisherStr, and numPagesInt respectively.
   * @param isbnStr       the Book object's isbn 
   * @param titleStr      the Book object's title
   * @param authorObj     the Book object's author
   * @param publisherStr  the Book object's publisher
   * @param numPagesInt   the Book object's page count
   */
   public Book(String isbnStr, String titleStr, Author authorObj, String publisherStr, int numPagesInt)
   {
      isbn = isbnStr;
      title = titleStr;
      author = authorObj;
      publisher = publisherStr;
      numPages = numPagesInt;
   }
   
   /**
   * Copy constructor to create a new deep copy of the 
   * passed in book object.
   * @param book2     the Book object to deep copy
   */
   public Book(Book book2)
   {
      isbn = book2.getIsbn();
      title = book2.getTitle();
      author = book2.getAuthor();
      publisher = book2.getPublisher();
      numPages = book2.getNumPages();
   }
   
   /**
   * Mutator function that changes Book's Isbn
   * @param titleStr   the new isbn string
   */
   public void setIsbn(String isbnStr)
   {
      isbn = isbnStr;
   }
   
   /**
   * Mutator function that changes Book's title
   * @param titleStr   the new title string
   */
   public void setTitle(String titleStr)
   {
      title = titleStr;
   }
   
   /**
   * Mutator function that changes Book's author object
   * @param authorObj   the new auhtor object to set
   */
   public void setAuthor(Author authorObj)
   {
      author = authorObj;
   }
   
   /**
   * Mutator function that changes Book's publisher
   * @param publisherStr the new publisher string
   */
   public void setPublisher(String publisherStr)
   {
      publisher = publisherStr;
   }
   
   /**
   * Mutator function that changes Book's page count variable numPages
   * @param numPagesInt the number of pages as an int
   */
   public void setNumPages(int numPagesInt)
   {
      numPages = numPagesInt;
   }
   
   /**
   * Accessor function that returns Book's isbn variable 
   * @return         the book's isbn as an string
   */
   public String getIsbn()
   {
      return isbn;
   }
   
   /**
   * Accessor function that returns Book's title variable 
   * @return         the book's title as an string
   */
   public String getTitle()
   {
      return title;
   }
   
   /**
   * Accessor function that returns Book's author object 
   * @return         the book's Author object
   */
   public Author getAuthor()
   {
      return author;
   }
   
   /**
   * Accessor function that returns Book's publisher variable 
   * @return         the book's publisher as an string
   */
   public String getPublisher()
   {
      return publisher;
   }
   
   /**
   * Accessor function that returns Book's numPages variable 
   * @return         the amount of pages in the book as an int
   */
   public int getNumPages()
   {
      return numPages;
   }
   
   /**
   * toString method returns a formatted string that shows the state of the Book object  
   * @return         the title, author, isbn, and page count as a formated string 
   */
   @Override
   public String toString()
   {
      String str = title + ", " + author + " (ISBN-10 #" + isbn + ", " + numPages + " pages)";
      return str;
   }

   /**
   * Method to overide comparison (==) to check for similar fields
   * @param book2    the Book object to check equality to
   * @return         returns true if objects have same title, author, and isbn
   */
   @Override
   public boolean equals(Object obj)
   {
      Book book2 = (Book)obj;
      boolean isEqual;
      
      if (this.getTitle() == book2.getTitle()
      && this.getAuthor() == book2.getAuthor()
      && this.getIsbn() == book2.getIsbn())
      {
         isEqual = true;
      }
      else
      {
         isEqual = false;
      }
      return isEqual;
   }
}