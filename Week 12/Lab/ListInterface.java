// ********************************************************
// Interface ListInterface for the ADT list.
// THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON
// *********************************************************
public interface ListInterface<E> {
  /** return true if the size of the list is 0
  */
  public boolean isEmpty();
  
  /** return size of list (number of elements in the list
  */ 
  public int size();
 
  /** add specified item at specified index, index is 1 based
      @param index, location to add item (1 based)
      @param item, data to be added to list 
      @throws ListIndexOutOfBoundsException if index < 1 or index > size
  */
   public void add(int index, E item) 
                  throws ListIndexOutOfBoundsException;
 
  /** return item at specified index, index is 1 based
      @param index - location of requested item
      @param item - object to be added
      @throws ListIndexOutOfBoundsException if index < 1 or index > size
  */
  public E get(int index) 
                  throws ListIndexOutOfBoundsException;
  /** remove item at specified index, index is 1 based
      @param index - location of item to be removed
      @throws ListIndexOutOfBoundsException if index < 1 or index > size
  */
 
  public void remove(int index) 
                  throws ListIndexOutOfBoundsException;
  /** remove all items from the list
  */ 
   public void removeAll();
}  

