/**
Duncan Starkenburg
CS 2100, Week 5 Lab Driver
THIS FILE IS A DRIVER FOR WEEK 5 LAB 
*/

public class Driver_1
{
    public static void main(String[] args)
    {
         // Test get method
          ColoredCircle c1 = new ColoredCircle();
          double d = c1.getRadius();
          String s = c1.getColor();
          
          // Alt constructor test
          c1 = new ColoredCircle(12.3, "red");
          System.out.println(c1.getRadius());
          System.out.println(c1.getColor());
          
          // Default constructor test
          ColoredCircle c2 = new ColoredCircle(12.3, "red");
          System.out.println(c2.getRadius());
          System.out.println(c2.getColor());
          
          // Alt constructor test double only
          ColoredCircle c3 = new ColoredCircle(41.3);
          System.out.println(c3.getRadius());
          System.out.println(c3.getColor());
          
          // Alt constructor test string only
          ColoredCircle c4 = new ColoredCircle("orange");
          System.out.println(c4.getRadius());
          System.out.println(c4.getColor());
          
          // Set methods for radius
          c1.setRadius(1.2);
          System.out.println(c1.getRadius());
          c1.setRadius(-1.2);
          System.out.println(c1.getRadius());
          
          // Set method for color
          c2.setColor("green");
          System.out.println(c2.getColor());
          
          // Method to calculate area
          double area = c3.getArea();
          System.out.println(area);
          
    }
}