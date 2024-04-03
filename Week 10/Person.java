/**
Duncan Starkenburg
CS 2100, Week 10 HW
*/

public class Person
{
   // Declare private members
   private String name;
   private String address;
   private String phone;
   
   
   /**
   *  Constructor method for Person object
   *  @param name the name of the person
   *  @param address the address of the person
   *  @param phone the phone number of the person
   */
   public Person(String name, String address, String phone)
   {
      this.name = name;
      this.address = address;
      this.phone = phone;
   }
   
   /**
   * Accessor function for private name member
   * @return the name string for person object
   */
   public String getName()
   {
      return this.name;
   }
   
   /**
   * Accessor function for private address memeber
   * @return the address string for person object
   */
   public String getAddress()
   {
      return this.address;
   }
   
   /**
   * Accessor function for the private phone number 
   * member
   * @return the phone number string for person object
   */
   public String getPhone()
   {
      return this.phone;
   }
   
   /**
   * Mutator function for the name member
   * @param name name of person to set
   */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
   * Mutator function for the address member
   * @param address address of person to set
   */
   public void setAddress(String address)
   {
      this.address = address;
   }
   
   /**
   * Mutator function for the phone member
   * @param phone phone number to set
   */
   public void setPhone(String phone)
   {
      this.phone = phone;
   }
   
   /**
   * The toString method
   * @return A String object containing the name of
   * the person, their address, and phone number.
   */
   @Override
   public String toString()
   {
      return String.format("%s, %s, %s", name, address, phone);
   }
   
   /**
   * The equals method
   * @return True if all members are equal
   */
   @Override
   public boolean equals(Object obj2)
   {
      Person per2 = (Person)obj2;
      return this.name.equals(per2.getName()) &&
             this.address.equals(per2.getAddress()) &&
             this.phone.equals(per2.getPhone());
   }
}