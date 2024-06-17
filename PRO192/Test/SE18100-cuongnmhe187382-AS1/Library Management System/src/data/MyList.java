/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package data;

/**
 *
 * @author Admin
 * @param <T>
 */
public class MyList<T> {

  private Node<T> head;

  public MyList() {
    this.head = null;
  }

  /**
   * Get list size
   *
   * @return size
   */
  public int size() {
    int count = 0;
    Node<T> current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  /**
   * Add to last position
   *
   * @param data Data of variables
   */
  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  /**
   * Add at the beginning
   *
   * @param data Data of variables
   */
  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.next = head;
    head = newNode;
  }

  /**
   * Remove data in list
   *
   * @param data Data of variables
   * @return removed or not
   */
  public boolean remove(T data) {
    if (head == null) {
      return false;
    }

    if (head.data.equals(data)) {
      head = head.next;
      return true;
    }

    Node<T> current = head;
    while (current.next != null && !current.next.data.equals(data)) {
      current = current.next;
    }

    if (current.next == null) {
      return false;
    }

    current.next = current.next.next;
    return true;
  }

  /**
   * Remove data in list
   *
   * @param index Position of data need to remove
   * @return removed or not
   */
  public boolean removeByIndex(int index) {
    if (head == null || index < 0) {
      return false;
    }

    if (index == 0) {
      head = head.next;
      return true;
    }

    Node<T> current = head;
    for (int i = 0; i < index - 1; i++) {
      if (current.next == null) {
        return false;
      }
      current = current.next;
    }

    if (current.next == null) {
      return false;
    }

    current.next = current.next.next;
    return true;
  }

  /**
   * Search by data
   *
   * @param data variable need to find
   * @return found or not
   */
  public boolean contains(T data) {
    Node<T> current = head;
    while (current != null) {
      if (current.data.equals(data)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  /**
   * Print all element
   */
  public void printList() {
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.data + "\n ");
      current = current.next;
    }
    System.out.println();
  }

  /**
   * Get list data in specific index
   *
   * @param index position
   * @return data need to find
   */
  public T get(int index) {
    Node<T> current = head;
    int count = 0;
    while (current != null) {
      if (count == index) {
        return current.data;
      }
      count++;
      current = current.next;
    }
    throw new IndexOutOfBoundsException("Index out of range");
  }

  /**
   * Check list empty or not
   *
   * @return Empty or not
   */
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * Inserts a new node with the given data after the node at the specified
   * index.
   *
   * @param index The index after which the new node should be inserted.
   * @param data The data to be stored in the new node.
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
   * >= size()).
   */
  public void insertAfter(int index, T data) {
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      if (current == null) {
        throw new IndexOutOfBoundsException("Index out of range");
      }
      current = current.next;
    }
    if (current == null) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    Node<T> newNode = new Node<>(data);
    newNode.next = current.next;
    current.next = newNode;
  }

  /**
   * Replaces the data at the specified index in the linked list with the new
   * data.
   *
   * @param index The index of the node to replace the data.
   * @param newData The new data to set at the specified index.
   * @throws IndexOutOfBoundsException if the specified index is out of range.
   */
  public void replace(int index, T newData) {
    Node<T> current = head;
    int count = 0;

    while (current != null) {
      if (count == index) {
        current.data = newData;
        return; // Data replaced, exit the method
      }
      count++;
      current = current.next;
    }

    // If index is out of range, throw an exception
    throw new IndexOutOfBoundsException("Index out of range: " + index);
  }
}
