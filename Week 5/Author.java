/**
Duncan Starkenburg
CS 2100, Week 5 HW
This class creates the Author object
*/

public class Author
{
   // Declare private members
   private String firstName;
   private String lastName;
   private String email;
   
   /**
   * Copy constructor to create a new deep copy of the 
   * passed in author object.
   * @param author2 the Author object to be deep copied 
   */
   public Author(Author author2)
   {
      firstName = author2.getFirstName();
      lastName = author2.getLastName();
      email = author2.getEmail();
   }
   
   /**
   * Constructor for a new Author object that sets parameters 
   * first name, last name, and email respectively.
   * @param firstNameStr the Author objects first name 
   * @param laseNameStr  the Author objects last name
   * @param emailStr     the Author objects email
   */
   public Author(String firstNameStr, String lastNameStr, String emailStr)
   {
      firstName = firstNameStr;
      lastName = lastNameStr;
      email = emailStr;
   }
   
   /**
   * Mutator function that changes Author's first name variable 
   * @param firstNameStr the string to set as author's first name 
   */
   public void setFirstName(String firstNameStr)
   {
      firstName = firstNameStr;
   }

   /**
   * Mutator function that changes Author's last name variable 
   * @param lastNameStr the string to set as author's last name 
   */
   public void setLastName(String lastNameStr)
   {
      lastName = lastNameStr;
   }
   
   /**
   * Mutator function that changes Author's email variable 
   * @param emailStr the string to set as author's email
   */
   public void setEmail(String emailStr)
   {
      email = emailStr;
   }
   
   /**
   * Accessor function that returns Author's first name variable 
   * @return         the author's first name as a string 
   */
   public String getFirstName()
   {
      return firstName;
   }
   
   /**
   * Accessor function that returns Author's last name variable 
   * @return         the author's last name as a string 
   */
   public String getLastName()
   {
      return lastName;
   }
   
   /**
   * Accessor function that returns Author's email  variable 
   * @return         the author's email as a string 
   */
   public String getEmail()
   {
      return email;
   }
   
   /**
   * toString method returns a formatted string that shows the state of the Author object  
   * @return         the first name, last name, and email as a formated string 
   */
   public String toString()
   {
      String str = firstName + " " + lastName + " <" + email + ">";
      return str;
   }
   
   /**
   * @Override 
   * Method to overide comparison (==) to check for similar fields
   * @param author2  the Author object to check equality to
   * @return         returns true if objects are identical or false otherwise
   */
   public boolean equals(Author author2)
   {
      boolean isEqual;
      
      if (this.getFirstName() == author2.getFirstName()
      && this.getLastName() == author2.getLastName()
      && this.getEmail() == author2.getEmail())
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