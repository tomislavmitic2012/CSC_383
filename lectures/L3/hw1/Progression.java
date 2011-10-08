/**
 * A class for numeric progressions.
 */
public class Progression {

  /** First value of the progression.  */
  protected long first;

  /** Current value of the progression.  */
  protected long cur;

  /** Default constructor.  */
  Progression() {
    cur = first = 0;
  }

  /** Resets the progression to the first value.
   * 
   * @return first value
   */
  protected long firstValue() {
    cur = first;
    return cur;
  }

  /** Advances the progression to the next value.
   *
   * @return next value of the progression
   */
  protected long nextValue() {
    return ++cur; // default next value
  }

  /** Prints the first n values of the progression.
   * 
   * @param n number of values to print
   */
  public void printProgression(int n) {
    System.out.print(firstValue());
    for (int i = 2; i <= n; i++) 
      System.out.print(" " + nextValue());
    System.out.println(); // ends the line
  }

   
}
