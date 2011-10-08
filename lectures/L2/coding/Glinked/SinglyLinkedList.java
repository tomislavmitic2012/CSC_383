import java.util.*;
import java.io.*;

public class SinglyLinkedList <T> { 

      private SinglyLinkedListNode<T>  head; 

      private SinglyLinkedListNode<T> tail; 

 
      public boolean isEmpty() {
                 return ( head == null) ;
      }

      public SinglyLinkedList() { 

            head = null; 

            tail = null; 

      } 

       public void traverse() { 



            SinglyLinkedListNode current = head; 

            SinglyLinkedListNode previous = null; 

            while (current != null) { 

   

                 System.out.println(current.value) ;

                  previous = current; 

                  current = current.next; 

            } 

           System.out.println("Done!\n") ;

      } 

      public void addLast(SinglyLinkedListNode<T> newNode) { 

            if (newNode == null) 

                  return; 

            else { 

                  newNode.next = null; 

                  if (head == null) { 

                        head = newNode; 

                        tail = newNode; 

                  } else { 

                        tail.next = newNode; 

                        tail = newNode; 

                  } 

            } 

      } 

 

      public void addFirst(SinglyLinkedListNode<T> newNode) { 

            if (newNode == null) 

                  return; 

            else { 

                  if (head == null) { 

                        newNode.next = null; 

                        head = newNode; 

                        tail = newNode; 

                  } else { 

                        newNode.next = head; 

                        head = newNode; 

                  } 

            } 

      } 

 

      public void insertAfter(SinglyLinkedListNode<T> previous, 

                  SinglyLinkedListNode<T> newNode) { 

            if (newNode == null) 

                  return; 

            else { 

                  if (previous == null) 

                        addFirst(newNode); 

                  else if (previous == tail) 

                        addLast(newNode); 

                  else { 

                        SinglyLinkedListNode <T> next = previous.next; 

                        previous.next = newNode; 

                        newNode.next = next; 

                  } 

            } 

      }

            public void removeFirst() { 

            if (head == null) 

                  return; 

            else { 

                  if (head == tail) { 

                        head = null; 

                        tail = null; 

                  } else { 


                        head = head.next; 

                  } 

            } 

      } 

 

      public void removeLast() { 

            if (tail == null) 

                  return; 

            else { 

                  if (head == tail) { 

                        head = null; 

                        tail = null; 

                  } else { 

                        SinglyLinkedListNode <T> previousToTail = head; 

                        while (previousToTail.next != tail) 

                             previousToTail = previousToTail.next; 

                        tail = previousToTail; 

                        tail.next = null; 

                  } 

            } 

      } 

 

      public void removeNext(SinglyLinkedListNode<T> previous) { 

            if (previous == null) 

                  removeFirst(); 

            else if (previous.next == tail) { 

                  tail = previous; 

                  tail.next = null; 

            } else if (previous == tail) 

                  return; 

            else { 

                  previous.next = previous.next.next; 

            } 

      } 





}
