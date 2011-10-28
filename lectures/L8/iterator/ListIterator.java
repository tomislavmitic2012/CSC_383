import java.io.IOException;

public class ListIterator {
  private Link current; 

  private Link previous;

  private LinkList ourList;

  public ListIterator(LinkList list) {
    ourList = list;
    reset();
  }
  //   start at 'first'
  public void reset() {
    current = ourList.getFirst();
    previous = null;
  }

  public boolean atEnd() {
    return (current.next == null);
  }

  //   go to next link
  public void nextLink() {
    previous = current;
    current = current.next;
  }

  public Link getCurrent() {
    return current;
  }

  public void insertAfter(long dd) {
    Link newLink = new Link(dd);

    if (ourList.isEmpty()) {
      ourList.setFirst(newLink);
      current = newLink;
    } else // not empty
    {
      newLink.next = current.next;
      current.next = newLink;
      nextLink(); // point to new link
    }
  }

  public void insertBefore(long data) {
    Link newLink = new Link(data);
    if (previous == null) {
      newLink.next = ourList.getFirst();
      ourList.setFirst(newLink);
      reset();
    }// not beginning
    else {
      newLink.next = previous.next;
      previous.next = newLink;
      current = newLink;
    }
  }

  //   delete item at current
  public long deleteCurrent() {
    long value = current.dData;
    //     beginning of list
    if (previous == null) {
      ourList.setFirst(current.next);
      reset();
    }// not beginning
    else {
      previous.next = current.next;
      if (atEnd())
        reset();
      else
        current = current.next;
    }
    return value;
  }

  public static void main(String[] args) throws IOException {
    LinkList theList = new LinkList(); 
    ListIterator iter1 = theList.getIterator(); 
    long value;

    iter1.insertAfter(20); 
    iter1.insertAfter(40);
    iter1.insertAfter(80);
    iter1.insertBefore(60);

    if (!theList.isEmpty())
      theList.displayList();
    else
      System.out.println("List is empty");
  }
}

class LinkList {
  private Link first;

  public LinkList() {
    first = null;
  } 

  public Link getFirst() {
    return first;
  }

  public void setFirst(Link f) {
    first = f;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public ListIterator getIterator() {
    return new ListIterator(this); 
  }

  public void displayList() {

    Link current = first;

    while (current != null) {
      current.displayLink();
      current = current.next; 
    }
    System.out.println("");
  }

}

class Link {
  public long dData; 

  public Link next; 

  public Link(long dd) {
    dData = dd;
  }

  public void displayLink() {
    System.out.print(dData + " ");
  }
}

