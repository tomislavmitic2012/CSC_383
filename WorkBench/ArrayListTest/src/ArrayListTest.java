import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.PrintStream;

public class ArrayListTest {
	private static final PrintStream output = new PrintStream( System.out );
	
	public static void main( String[] args ) {
		// fill the staff array list with three Employee objects
		ArrayList< Employee > staff = new ArrayList< Employee >();
		
		staff.add( new Employee( "Carl Cracker", 75000, 1987, 12, 15 ) );
		staff.add( new Employee( "Harry Hacker", 50000, 1989, 10, 1 ) );
		staff.add( new Employee( "Tony Tester", 40000, 1990, 3, 15 ) );
		
		// raise everyone's salary by 5% 
		for( Employee e : staff ) {
			e.raiseSalary( 5 );
		}
		
		// print out information about all Employee objects
		for( Employee e : staff ) {
			ArrayListTest.output.println( "name = " + e.getName() + ", salary = " +
					e.getSalary() + ", hire day = " + e.getHireDay() );
		}
	}
}

class Employee {
	private Employee self = this;
	
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee( String n, double s, int year, int month, int day ) {
		self.name = n;
		self.salary = s;
		GregorianCalendar calendar = new GregorianCalendar( year, month - 1, day );
		self.hireDay = calendar.getTime();
	}
	
	public String getName() {
		return self.name;
	}
	
	public double getSalary() {
		return self.salary;
	}
	
	public Date getHireDay() {
		return self.hireDay;
	}
	
	public void raiseSalary( double byPercent ) {
		double raise = self.salary * byPercent / 100;
		self.salary += raise;
	}
}