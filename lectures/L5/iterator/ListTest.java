  // Fig. 19.4: ListTest.java
  // Using LinkLists.
  import java.util.List;
  import java.util.LinkedList;
  import java.util.ListIterator;
  
  public class ListTest 
  {
     private static final String colors[] = { "black", "yellow", 
        "green", "blue", "violet", "silver" };
     private static final String colors2[] = { "gold", "white", 
        "brown", "blue", "gray", "silver" };
                    
     // set up and manipulate LinkedList objects
     public ListTest()
     {
        List< String > list1 = new LinkedList< String >(); 

        List< String > list2 = new LinkedList< String >();
  
        // add elements to list link
        for ( String color : colors )
           list1.add( color );
  
        // add elements to list link2
        for ( String color : colors2 )
           list2.add( color );
  
        list1.addAll( list2 ); // concatenate lists
        list2 = null; // release resources
        printList( list1 ); // print list1 elements 
  
        convertToUppercaseStrings( list1 ); // convert to upper case string
        printList( list1 ); // print list1 elements 
  
        System.out.print( "\nDeleting elements 4 to 6..." );
        removeItems( list1, 4, 7 ); // remove items 4-7 from list
        printList( list1 ); // print list1 elements 
        printReversedList( list1 ); // print list in reverse order
     } // end ListTest constructor
  
     // output List contents
     public void printList( List< String > list )
     {
        System.out.println( "\nlist: " );
     
        for ( String color : list )
           System.out.printf( "%s ", color );
  
        System.out.println();
     } // end method printList
  
     // locate String objects and convert to uppercase
     private void convertToUppercaseStrings( List< String > list )
     {
        ListIterator< String > iterator = list.listIterator();
  
        while ( iterator.hasNext() ) 
        {
           String color = iterator.next();  // get item                 
           iterator.set( color.toUpperCase() ); // convert to upper case
        } // end while
     } // end method convertToUppercaseStrings
  
     // obtain sublist and use clear method to delete sublist items
     private void removeItems( List< String > list, int start, int end )
     {
        list.subList( start, end ).clear();  // remove items
     } // end method removeItems
  
     // print reversed list
     private void printReversedList( List< String > list )
     {
        ListIterator< String > iterator = list.listIterator( list.size() );
  
        System.out.println( "\nReversed List:" );
  
        // print list in reverse order
        while ( iterator.hasPrevious() ) 
           System.out.printf( "%s ", iterator.previous() ); 
     } // end method printReversedList
     
     public static void main( String args[] )
     {
        new ListTest();
     } // end main                                          
  } // end class ListTest


/*  output 

list:
black yellow green blue violet silver gold white brown blue gray silver
                                
list:
BLACK YELLOW GREEN BLUE VIOLET SILVER GOLD WHITE BROWN BLUE GRAY SILVER
                                
Deleting elements 4 to 6...
list:
BLACK YELLOW GREEN BLUE WHITE BROWN BLUE GRAY SILVER
                                
Reversed List:
SILVER GRAY BLUE BROWN WHITE BLUE GREEN YELLOW BLACK

*/
