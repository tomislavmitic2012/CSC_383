import java.util.*;

/**
 * This program uses a set to print all unique words in System.in.
 * @version 1.10 2003-08-02
 * @author Cay Horstmann
 */
public class TreeSetTest
{
   public static void main(String[] args)
   {
      Set<String> words = new TreeSet<String>(); //TreeSet implements Set
      long totalTime1 = 0;
      long totalTime2 = 0;

      Scanner in = new Scanner(System.in);   

      while (in.hasNext())
      {
         String word = process(in.next());
         
         long callTime =  System.nanoTime() ;    // System.currentTimeMillis();
         long callTime2 =  System.currentTimeMillis();
         words.add(word);
         callTime = System.nanoTime() - callTime;   // System.currentTimeMillis() - callTime;
         callTime2 =  System.currentTimeMillis() - callTime2;
         totalTime1 += callTime;
    	 totalTime2 += callTime2;
      }

      Iterator<String> iter = words.iterator();
      for (int i = 1; i <= 20 && iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(". . .");
      System.out.println(words.size() + " distinct words. " + totalTime1 + " nanoseconds or "+ totalTime2 + "  ms.");
   }
  
  static String process(String s) {

    if (s.length() == 0 ) return s ;

    char c = s.charAt(0) ;

   if ( c== '\"' ||  c== '.' || c == ';' || c == ','|| c == '\'' || c == '(' || c == ')') s = s.substring(1) ;
     int len = s.length() ;
     
   if ( len == 0 )  return s ;
     c = s.charAt(len-1) ;

    if ( c== '\"' ||  c== '.' || c == ';' || c == ','|| c == '\''|| c == '(' || c == ')') s = s.substring(0,len-1) ;

    return s ;


  }
}
