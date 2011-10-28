
class Pair<T,S> {
   public T first;
   public S second;
   public Pair( T a, S b ) {  // Constructor.
      first = a;
      second = b;
   }

   public String toString() {
        String str = "" ;
        str = first + " : " + second; 
      return str ;   
    }

}
