/**
Duncan Starkenburg
CS 2100, Week 6 In Class Assignment
THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON @ UVM
*/

public class Address
{
   // instance variables
   private String street;
   private String city;
   private String state;
   private String zip;
   /**
      Create an address with street, city, state and zip
   */
   public Address(String street, String city, String state, String zip)
   {
      this.street = street;
      this.city = city;
      this.state = state;
      this.zip = zip;
   }
   
   /** 
       @return street address
   */
   public String getStreet()
   {
      return street;
   }
   /** 
       @return city of address
   */
   public String getCity()
   {
      return city;
   }
   /** 
       @return state of address
   */
   public String getState()
   {
      return state;
   }
   /** 
       @return address zip code
   */  
   public String getZip()
   {
      return zip;
   }
   /**
      set the street address
      @param s the street address
   */
   public void setStreet(String s)
   {
      street = s;
   }
   /**
      set the city of address
      @param c the city
   */
   public void setCity(String c)
   {
      city = c;
   }
   /**
      set the state of address
      @param s the state
   */
   public void setState(String s)
   {
      state = s;
   }
   /**
      set the zip code of address
      @param z the zip
   */
   public void setZip(String z)
   {
      zip = z;
   }
   
   @Override
   public String toString()
   {
      String output;
      output = String.format("%s\n%s, %s %s", this.getStreet(),
                this.getCity(), this.getState(), this.getZip());
      return output;
   }
   
   @Override
   public boolean equals(Object other)
   {
      Address adrObj = (Address)other;
      return this.street.equals(adrObj.street)
             && this.city.equals(adrObj.city)
             && this.state.equals(adrObj.state)
             && this.zip.equals(adrObj.zip);
   }
}