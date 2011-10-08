/**
 * Arithmetic progression.
 */
class ArithProgression extends Progression {

  /** Increment. */
  protected long inc;

  // Inherits variables first and cur.

  /** Default constructor setting a unit increment. */
  ArithProgression() {
    this(1);
  }

  /** Parametric constructor providing the increment. */
  ArithProgression(long increment) {
    inc = increment; 
  }

  /** Advances the progression by adding the increment to the current value.
   * 
   * @return next value of the progression
   */
  protected long nextValue() {
    cur += inc;
    return cur;
  }

  //  Inherits methods firstValue() and printProgression(int).
}
