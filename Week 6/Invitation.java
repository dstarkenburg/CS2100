/** 
Duncan Starkenburg
CS 2100, Week 6 In Class Assignment
*/

public class Invitation
{
   // Instance Variables
   private String invitee;
   private String event;
   private String date;
   private Address location;
   private Address addressOfInvitee;
   private boolean attending;
   
   public Invitation(String i, String e, String d, Address l, Address aoi, boolean a)
   {
      invitee = i;
      event = e;
      location = l;
      addressOfInvitee = aoi;
      attending = a;
   }
   
   public Invitation(String i, String e, String d, Address l, Address aoi)
   {
      this(i, e, d, l, aoi, false);
   }
   
   public void positiveResponse()
   {
      this.attending = true;
   }
   
   public String toString()
   {
      return String.format("%s\n%s\n%s\n%s\n%s\n", invitee, event, date, location, attending ? "attending" : "Not attending");
   }
   
   public boolean equals(Object obj)
   {
      Invitation inv2 = (Invitation)obj;
      return (this.date.equals(inv2.date) 
              && this.location.equals(inv2.location));
   } 
}