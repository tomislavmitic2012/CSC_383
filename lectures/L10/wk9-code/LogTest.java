
//import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;


public class LogTest {
  public static void main(String[] args)  {
    

    Map<String, Integer> map = new TreeMap<String, Integer>();

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String word = scanner.next();
      Integer count = map.get(word);
      count = (count == null ? 1 : count + 1);
      map.put(word, count);
    }
    scanner.close();

  for(Map.Entry<String,Integer> entry : map.entrySet()) { 
  String key = entry.getKey(); 
  Integer value = entry.getValue(); 
 
  System.out.printf("%-20s : %3d\n",key , value); 
} 

  }
}