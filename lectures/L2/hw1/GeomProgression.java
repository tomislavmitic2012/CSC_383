/**
 * Geometric Progression
 */
class GeomProgression extends Progression {

  /** Base. */
  protected long base;

  // Inherits variables first and cur.

  /** Default constructor setting base 2. */
  GeomProgression() {
    this(2);
  }

  /** Parametric constructor providing the base.
   *
   * @param b base of the progression.
   */
  GeomProgression(long b) {
    base = b;
    first = 1;
    cur = first;
  }

  /** Advances the progression by multiplying the base with the current value.
   * 
   * @return next value of the progression
   */
  protected long nextValue() {
    cur *= base;
    return cur;
  }

  //  Inherits methods firstValue() and printProgression(int).
}
