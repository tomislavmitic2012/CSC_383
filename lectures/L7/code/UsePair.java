import java.util.*;

class Pair<K,V> {
  private K key;
  private V value;

  public void set(K parm1, V parm2) {
    key = parm1;
    value = parm2;
  }

  public K getKey( ) { return key; }

  public V getValue( ) { return value; }

  public String toString( ) {
    return "[" + key + ", " + value + "]";
  }
}

public class UsePair {
  public static <K extends Comparable, V> int comparePairs(Pair<K,V> p,
       Pair<K,V> q) {
    return p.getKey( ).compareTo(q.getKey( ));
}

  public static void main(String [ ] args) {
    Pair<String, Integer> p = new Pair<String,Integer>( );
    Pair<String, Integer> p1 = new Pair<String,Integer>( );
    Pair<String, Number> p2 = new Pair<String,Number>( );
    Pair<String, List> p3 = new Pair<String,List>( );

    p.set("abc", new Integer(1));
    p1.set("def", new Integer(1));
    p2.set("abc", new Integer(1));
    p3.set("abc", new ArrayList<Integer>( ));
    System.out.println(p);
    System.out.println(p2);
    System.out.println(p3);
    System.out.println(comparePairs(p,p1));
  }
}

