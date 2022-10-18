//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: LinkedQueue.java
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * A generic implementation of a linked queue
 * 
 * @author Marin Suzuki
 *
 */
public class LinkedQueue<T> implements QueueADT<T> {

  // The number of elements in the queue
  private int n;

  // The node at the front of the queue, added LEAST recently
  protected Node<T> front;

  // The node at the back of the queue, added MOST recently
  protected Node<T> back;

  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * 
   * @param data - the data to add
   */
  @Override
  public void enqueue(T data) {

    Node<T> newNode = new Node<T>(data);

    if (this.n == 0) {

      this.front = newNode;
      this.back = newNode;

      // size changed
      this.n = 1;

    } else {

      // add element to the next node
      this.back.setNext​(newNode);
      this.back = newNode;

      // size changed
      this.n = this.n + 1;

    }

  }

  /**
   * Removes and returns the item from this queue that was least recently added
   * 
   * @return the item from this queue that was least recently added
   * @throws NoSuchElementException - if this queue is empty
   */
  @Override
  public T dequeue() throws NoSuchElementException {

    if (this.n == 0) {
      throw new NoSuchElementException("this queue is empty");
    } else if (this.n == 1) {

      T frontNode = this.front.getData(); // get frontNode

      this.front = null; // remove node
      this.back = null;

      this.n = 0; // size decreased

      return frontNode;

    } else {

      T frontNode = this.front.getData(); // get frontNode

      this.front = this.front.getNext(); // remove the front node

      this.n = this.n - 1; // size decreased

      return frontNode;
    }
  }

  /**
   * Returns the item least recently added to this queue without removing it
   * 
   * @return the item least recently added to this queue
   * @throws NoSuchElementException - if this queue is empty
   */
  @Override
  public T peek() throws NoSuchElementException {

    if (this.n == 0) {
      throw new NoSuchElementException("this queue is empty");
    } else {

      T frontNode = this.front.getData(); // get backNode

      return frontNode;
    }
  }

  /**
   * Checks whether the queue contains any elements
   * 
   * @return true if this queue is empty; false otherwise
   */
  @Override
  public boolean isEmpty() {

    if (this.n == 0) {
      return true;
    }

    return false; // not empty

  }

  /**
   * Returns the number of items in this queue
   * 
   * @return the number of items in this queue
   */
  @Override
  public int size() {

    return this.n;

  }

  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) of
   * the queue and ending at the back (most recently added). An empty queue is represented as an
   * empty string; otherwise items in the queue are represented using their data separated by spaces
   * 
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {

    if (this.isEmpty()) {

      return "";

    } else {

      String representation = "" + this.front.getData();
      Node<T> newNode = this.front;

      try {
        for(int i = 1; i < n; i ++) {
          newNode = newNode.getNext();
          representation = representation + " " + newNode.getData();
        }
      } catch (Exception e) {
        // when there is no more next node
      }

      return representation.trim();

    }
  }

}
