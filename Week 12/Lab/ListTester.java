/**
Duncan Starkenburg
CS 2100, Week 12 Lab
THIS DOCUMENT WAS PARTIALLY WRITTEN BY JACKIE HORTON
*/
public class ListTester
{

	public static void main(String [] args)
	{
      final int N = 10000;
	   long time1,time2, diff;
      ListInterface<Integer> list1 = new ListArrayBased<>();
      ListInterface<Integer> list2 = new ListReferenceBased<>();

      // add to the beginning of an array based list N times
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= 50000; i++)
         list1.add(1, 10);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("array, add beginning: "+diff);
      
      // add to the beginning of a ref based list N times
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= 50000; i++)
         list2.add(1, 10);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("ref based, add beginning: "+diff +"\n");
      
      // remove from the beginning of an array based list
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= list1.size(); i++)
         list1.remove(1);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("array, remove begining: "+diff);

      // remove from the beginning of an ref based list      
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= list2.size(); i++)
         list2.remove(1);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("ref based, remove begining: "+diff+"\n");
            
      // add to the end of an array based list N times
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= 50000; i++)
         list1.add(i, 10);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("array, add end: "+diff);
      
      // add to the end of a ref based list N times
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= 50000; i++)
         list2.add(i, 10);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("ref based, add end: "+diff+"\n");
      
      // traverse an array based list
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= list1.size(); i++)
         list1.get(i);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("array, traverse: "+diff);
      
      // traverse an ref based list
      time1 = System.currentTimeMillis();
      for (int i = 1; i <= list2.size(); i++)
         list2.get(i);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("ref based, traverse: "+diff+"\n");
            
      // remove from the end of an array based list
      time1 = System.currentTimeMillis();
      for (int i = list1.size(); i > 0; i--)
         list1.remove(i);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("array, remove end: "+diff);

      // remove from the end of an ref based list
      time1 = System.currentTimeMillis();
      for (int i = list2.size(); i > 0; i--)
         list2.remove(i);

      time2 = System.currentTimeMillis();
      diff = time2-time1;
      System.out.println("ref based, remove end: "+diff+"\n");
      


	}
   // Traverse list displaying data in teach item
	public static void displayList(ListInterface list)
	{
		for (int i = 1; i<=list.size();i++)
			//System.out.println(list.get(i));
         list.get(i); 

	
	
	}
}