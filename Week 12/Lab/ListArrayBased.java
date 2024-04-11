import java.util.Arrays;

// ****************************************************
// An array based implementation of ADT list.
// THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON
// ****************************************************
public class ListArrayBased<E> implements ListInterface<E> {

   private E[] list;  // the data
   private static int DEF_CAPACITY = 20;  // initial capacity
   private int size;  // actual size

   /** Create empty list
   */
   @SuppressWarnings("unchecked")
   public ListArrayBased() 
   {
      list = (E[])(new Object[DEF_CAPACITY]);
      size = 0;
   }   
   /** return true if the size of the list is 0
       @return size == 0
   */
   public boolean isEmpty() 
   {
      return size == 0;
   }
   /** return size of list (number of elements in the list
       @return number of elements in list
   */ 
   public int size() 
   {
      return size;
   }
   /** return item at specified index, index is 1 based
      @param index - location of requested item
      @return data of item at index specified
      @throws ListIndexOutOfBoundsException if index <1 or index > size
   */
   public E get(int index) 
                throws ListIndexOutOfBoundsException 
   {
      if (index > 0 && index <= size)
          return list[index-1];

      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
   }
   
  
   /** add specified item at specified index, index is 1 based
      @param index, location to add item, if size < index < length add to end
      @param item, data to be added to list 
      @throws ListIndexOutOfBoundsException if index <1 or index > size+1
   */
   public void add(int index, E item)
                  throws ListIndexOutOfBoundsException {

      index = index-1;  //list is 1-based, array is 0 based
      try
      {

         if (size == list.length)
         {
            // resize (double)
            int newSize = size * 2;
            list = Arrays.copyOf(list,newSize);
            
         }
         if (index > size)
            throw new IndexOutOfBoundsException();         
         if (index == size)
            list[size]=item;
         else 
         {   
            // make room for new element
            for (int i = size; i > index; i--)
               list[i]=list[i-1];
            // drop it in
            list[index] = item;
         }
         size++;
      }
      catch(IndexOutOfBoundsException e)
      {   
         System.out.println(e);
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds on add");
      } 
   }  
  /** remove item at specified index, index is 1 based
      @param index - location of item to be removed
      @throws ListIndexOutOfBoundsException if index <1 or index > size
  */
   public void remove(int index) 
                     throws ListIndexOutOfBoundsException 
   {
       index = index-1; // list is 1-based, array is 0-based
       try
      {
         if (index > size)
            throw new IndexOutOfBoundsException();
         for (int i = index; i <size-1; i++)
            list[i]=list[i+1];
         size--;
      }
      catch(IndexOutOfBoundsException e)
      {   
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
      } 
   }
   /** display list as a string
      @return a string representation of the list
   */
   @Override
   public String toString()
   {
      String s = "";
      
      for (int i = 0; i < size; i++)
      {
         s+= (list[i] + " ");
      }
      return s;
   
   }
   /** remove all items from the list
   */
   @SuppressWarnings("unchecked")
   public void removeAll() 
   {
      list = (E[])(new Object[DEF_CAPACITY]);
      size = 0;
   } 
 }
