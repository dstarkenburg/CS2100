/**
Duncan Starkenburg
CS 2100, Week 5 Lab
*/

public class ColoredCircle
{  
   // Declare private members
   private double radius;
   private String color;
   
   /**
   * ColoredCircle constructor that takes in a positive radius double
   * and color String and sets the values of the private members
   * @param radius the radius as a double
   * @param color  the color as a string
   */
   public ColoredCircle(double radius, String color)
   {
      setRadius(radius);
      setColor(color);
   }
   
   /**
   * ColoredCircle constructor that takes in no params
   * and sets the values of the private members to 
   * 1.0 and blue for radius and color respectively
   */
   public ColoredCircle()
   {
      this(1.0, "blue");
   }
   
   /**
   * ColoredCircle constructor that takes in a positive radius double
   * and sets the color string to blue.
   * @param radius the radius as a double
   */
   public ColoredCircle(double radius)
   {
      this(radius, "blue");
   }
   
   /**
   * ColoredCircle constructor that takes in a color string
   * and sets the radius string to 1.0.
   * @param radius the radius as a double
   */
   public ColoredCircle(String color)
   {
      this(1.0, color);
   }
   
   /**
   * ColoredCircle accessor function to get the objects radius
   * as a positive double
   * @return returns this ColoredCircle's radius
   */
   public double getRadius()
   {
      return this.radius;
   }
   
   /**
   * ColoredCircle accessor function to get the objects color
   * as a string
   * @return returns this ColoredCircle's color
   */
   public String getColor()
   {
      return this.color;
   }
   
   /**
   * ColoredCircle method function to calculate the objects area
   * and return it as a double
   * @return returns the area of the circle object as a double
   */
   public double getArea()
   {
      return (Math.pow(this.getRadius(), 2) * Math.PI);
   }
   
   /**
   * ColoredCircle mutator function to set the objects radius
   * @param radius a double to set as object's radius
   */
   public void setRadius(double radius)
   {
      radius = Math.abs(radius);
      this.radius = radius;
   }
   
   /**
   * ColoredCircle mutator function to set the objects radius
   * @param color a string to set as object's color
   */
   public void setColor(String color)
   {
      this.color = color;
   }
}