/** Represents one node to be used in a linked list
    Contains data and reference to next in list
    THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON
*/

public class Node<E>{
  private E item;
  private Node<E> next;

  /** Create new node with specified data
      Have it reference null
      @param newItem is data to added to new node
  */
  public Node(E newItem) {
    item = newItem;
    next = null;
  } 
  
  /** Create new node with specified data
      Have it reference nextNode
      @param newItem is data to added to new node
      @param nextNode is reference that new Node's next will hold
      
  */
  public Node(E newItem, Node<E> nextNode) {
    item = newItem;
    next = nextNode;
  } 
  /** set data field (item) of Node
      @param newItem, to set item field to
  */
  public void setItem(E newItem) {
    item = newItem;
  } 

  /** get data field (item) of Node
      @return item field
  */
  public E getItem() {
    return item;
  } 

  /** set next field  of Node
      @param nextNode, to set next field to
  */
  public void setNext(Node<E> nextNode) {
    next = nextNode;
  } 

  /** get next field  Node
      @return next field
  */
  public Node<E> getNext() {
    return next;
  }

} 