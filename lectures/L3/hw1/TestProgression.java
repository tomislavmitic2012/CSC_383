/** Test program for the progression classes */
class TestProgression {
  public static void main(String[] args) {
    Progression prog;
    // test ArithProgression
    System.out.println("Arithmetic progression with default increment:");
    prog = new ArithProgression();
    prog.printProgression(10);
    System.out.println("Arithmetic progression with increment 5:");
    prog = new ArithProgression(5);
    prog.printProgression(10);
    // test GeomProgression
    System.out.println("Geometric progression with default base:");
    prog = new GeomProgression();
    prog.printProgression(10);
    System.out.println("Geometric progression with base 3:");
    prog = new GeomProgression(3);
    prog.printProgression(10);
    // test FibonacciProgression
    System.out.println("Fibonacci progression with default start values:");
    prog = new FibonacciProgression();
    prog.printProgression(10);
    System.out.println("Fibonacci progression with start values 4 and 6:");
    prog = new FibonacciProgression(4,6);
    prog.printProgression(10);
  }
}
