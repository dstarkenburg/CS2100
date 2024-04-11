/**
Duncan Starkenburg
CS 2100, Week 12 HW
*/


public class Course implements Comparable<Course>
{
   // Declare private members
   private String subject;
   private int number;
   private String title;
   private int crn;
   private String section;
   private String instructor;
   
   /**
   * Constructor for a course object
   * @param subject    the course subject
   * @param number     the course number
   * @param title      the course title
   * @param section    the section letter
   * @param instructor the instructor name
   */
   public Course(String subject, int number, String title,
                 int crn, String section, String instructor)
   {
      this.subject = subject;
      this.number = number;
      this.title = title;
      this.crn = crn;
      this.section = section;
      this.instructor = instructor;
   }
   
   /**
   * Accessor function for crn member
   * @return returns the crn number
   */
   public int getCrn()
   {
      return this.crn;
   }
   
   /**
   * The toString method
   * @return A String object containing the subject, number,
   * title, crn, section, and instructor.
   */
   @Override
   public String toString()
   {
      return String.format("%s %d %s %d %s %s", subject, number,
                           title, crn, section, instructor);
   }

   /**
   * The equals method
   * @return True if all members are equal
   */   
   @Override
   public boolean equals(Object obj2)
   {
      Course cour2 = (Course)obj2;
      return this.subject.equals(cour2.subject) &&
             this.number == cour2.number &&
             this.title.equals(cour2.title) &&
             this.crn == cour2.crn &&
             this.section.equals(cour2.section) &&
             this.instructor.equals(cour2.instructor);
   
   }
   
   @Override
   public int compareTo(Course t)
   {
      if (this.crn > t.crn)
      {
         return 1;
      }
      else if (this.crn < t.crn)
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
}