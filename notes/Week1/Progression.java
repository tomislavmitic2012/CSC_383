import java.math.BigInteger;

/**
 * A class for numeric progressions.
 */
public class Progression {

  /** First value of the progression.  */
  protected BigInteger first;

  /** Current value of the progression.  */
  protected BigInteger cur;

  /** Default constructor.  */
  Progression() {
    cur = first = BigInteger.ZERO;
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
    cur = cur.add(BigInteger.ONE); // default next value
    return cur;
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
_______________________________

import java.math.BigInteger;

/**
 * Arithmetic progression.
 */
class ArithProgression extends Progression {

  /** Increment. */
  protected BigInteger inc;

  // Inherits variables first and cur.

  /** Default constructor setting a unit increment. */
  ArithProgression() {
    this(BigInteger.ONE);
  }

  /** Parametric constructor providing the increment. */
  ArithProgression(BigInteger increment) {
    inc = increment; 
  }

  /** Advances the progression by adding the increment to the current value.
   * 
   * @return next value of the progression
   */
  protected long nextValue() {
    cur.add(inc);
    return cur;
  }

  //  Inherits methods firstValue() and printProgression(int).
}
_______________________________________

import java.math.BigInteger;

/**
 * Geometric Progression
 */
class GeomProgression extends Progression {

  /** Base. */
  protected BigInteger base;

  // Inherits variables first and cur.

  /** Default constructor setting base 2. */
  GeomProgression() {
    this(new BigInteger("2"));
  }

  /** Parametric constructor providing the base.
   *
   * @param b base of the progression.
   */
  GeomProgression(BigInteger b) {
    base = b;
    first = BigInteger.ONE;
    cur = first;
  }

  /** Advances the progression by multiplying the base with the current value.
   * 
   * @return next value of the progression
   */
  protected long nextValue() {
    cur.multiply(base);
    return cur;
  }

  //  Inherits methods firstValue() and printProgression(int).
}
_________________________________________________

import java.math.BigInteger;

/**
 * Fibonacci progression.
 */
class FibonacciProgression extends Progression {
  /** Previous value. */
  BigInteger prev;   
  // Inherits variables first and cur.

  /** Default constructor setting 0 and 1 as the first two values. */
  FibonacciProgression() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }
  /** Parametric constructor providing the first and second values.
   *
   * @param value1 first value.
   * @param value2 second value.
   */
  FibonacciProgression(BigInteger value1, BigInteger value2) {
      first = value1;
      prev = value2.subtract(value1); // fictitious value preceding the first
  }

  /** Advances the progression by adding the previous value to the current value.
   * 
   * @return next value of the progression
   */
  protected long nextValue() {
    BigInteger temp = prev;
    prev = cur;
    cur.add(temp);
    return cur;
  }
  // Inherits methods firstValue() and printProgression(int).
}
