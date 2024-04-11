// ****************************************************
// Reference-based implementation of ADT list.
// THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON
// ****************************************************
public class ListReferenceBased<E> implements ListInterface<E> { 
  
  private Node<E> head; // reference to linked list of items
  private int numItems; // number of items in list

  /** Create empty list
  */
  public ListReferenceBased() {
    numItems = 0;
    head = null;
  }  
  /** return true if the size of the list is 0
       @return numItems == 0
   */
  public boolean isEmpty() {
    return numItems == 0;
  }  
   /** return size of list (number of elements in the list
       @return number of elements in list
   */ 

  public int size() {
    return numItems;
  }  
  /** 
   Locate a specified node in a linked list.
   @param index is the number of the desired node. 
   Assumes that 1 <= index <= numItems
   @return a reference to the desired node.
   */
   private Node<E> find(int index) {
      Node<E> curr = head;
      for (int skip = 1; skip < index; skip++) {
         curr = curr.getNext();
      } 
      return curr;
   } 
   /** return item at specified index, index is 1 based
      @param index - location of requested item
      @return data of item at index specified
      @throws ListIndexOutOfBoundsException if index <1 or index > numItems
   */  
  public E get(int index) 
                throws ListIndexOutOfBoundsException {
    if (index >= 1 && index <= numItems) {
      // get reference to node, then data in node
      Node<E> curr = find(index);
      E dataItem = curr.getItem();
      return dataItem;
    } 
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
    } 
  } 
  
  /** add specified item at specified index, index is 1 based
     @param index, location to add item
     @param item, data to be added to list 
     @throws ListIndexOutOfBoundsException if index < 1 or index > numItems+1
  */

  public void add(int index, E item)
                  throws ListIndexOutOfBoundsException {
    if (index >= 1 && index <= numItems+1) {
      if (index == 1) {
        // insert the new node containing item at
        // beginning of list
        Node<E> newNode = new Node<E>(item, head);
        head = newNode;
      } 
      else {
        Node<E> prev = find(index-1);
        // insert the new node containing item after 
        // the node that prev references
        Node<E> newNode = new Node<E>(item, prev.getNext());
        prev.setNext(newNode);
      } 
      numItems++;
    } 
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on add");
    } 
  }  
  /** remove item at specified index, index is 1 based
      @param index - location of item to be removed
      @throws ListIndexOutOfBoundsException if index < 1 or index > numItems
  */
  public void remove(int index) 
                     throws ListIndexOutOfBoundsException {
    if (index >= 1 && index <= numItems) {
      if (index == 1) {
        // delete the first node from the list
        head = head.getNext();
      } 
      else {
        Node<E> prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
        
        Node<E> curr = prev.getNext(); 
        prev.setNext(curr.getNext());
      
      } 
      
      numItems--;
    } 
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
    } 
  }   
  /** remove all items from the list
  */
  public void removeAll() {
    // setting head to null causes list to be unreachable 
    // and thus marked for garbage collection
    head = null;
    numItems = 0;
  } 
   /** display list as a string
      @return a string representation of the list
   */  
   @Override
   public String toString()
   {
      String s = "";
      Node<E> curr = head;
      while (curr != null)
      {
         s+= (curr.getItem() + " ");
         curr = curr.getNext();
      }
      return s;
   
   }  

} 