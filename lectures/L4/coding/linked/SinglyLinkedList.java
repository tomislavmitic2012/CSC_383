public class SinglyLinkedList { 

      private SinglyLinkedListNode head; 

      private SinglyLinkedListNode tail; 

 

      public SinglyLinkedList() { 

            head = null; 

            tail = null; 

      } 

       public int traverse() { 

            int sum = 0; 

            SinglyLinkedListNode current = head; 

            SinglyLinkedListNode previous = null; 

            while (current != null) { 

                  sum += current.value; 

                  previous = current; 

                  current = current.next; 

            } 

            return sum; 

      } 

      public void addLast(SinglyLinkedListNode newNode) { 

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

 

      public void addFirst(SinglyLinkedListNode newNode) { 

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

 

      public void insertAfter(SinglyLinkedListNode previous, 

                  SinglyLinkedListNode newNode) { 

            if (newNode == null) 

                  return; 

            else { 

                  if (previous == null) 

                        addFirst(newNode); 

                  else if (previous == tail) 

                        addLast(newNode); 

                  else { 

                        SinglyLinkedListNode next = previous.next; 

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

                        SinglyLinkedListNode previousToTail = head; 

                        while (previousToTail.next != tail) 

                             previousToTail = previousToTail.next; 

                        tail = previousToTail; 

                        tail.next = null; 

                  } 

            } 

      } 

 

      public void removeNext(SinglyLinkedListNode previous) { 

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
