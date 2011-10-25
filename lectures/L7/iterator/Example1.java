import java.util.ArrayList;
import java.util.Iterator;
 
public class Example1 {
 
public static void main(String[] args) {
 
//create an ArrayList object
ArrayList<String> arrayList = new ArrayList<String>();
 
//Add elements to Arraylist
arrayList.add("1");
arrayList.add("2");
arrayList.add("3");
arrayList.add("4");
arrayList.add("5");
 
//get an Iterator object for ArrayList using iterator() method.
Iterator itr = arrayList.iterator();
 
//use hasNext() and next() methods of Iterator to iterate through the elements
System.out.println("Iterating through ArrayList elements...");
while(itr.hasNext())
System.out.println(itr.next());
 
}
}
 
/*
Output would be
Iterating through ArrayList elements...
1
2
3
4
5
*/