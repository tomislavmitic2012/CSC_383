import java.util.*;

/**
 * This program uses a set to print all unique words in System.in.
 * @version 1.10 2003-08-02
 * @author Cay Horstmann
 */
public class SetTest
{
   public static void main(String[] args)
   {
      Set<String> words = new HashSet<String>(); // HashSet implements Set
      long totalTime1 = 0;
      long totalTime2 = 0;

      Scanner in = new Scanner(System.in);
      while (in.hasNext())
      {
         String word = in.next();
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
}
