package person;

public class Student implements Person {
	private Student self = this;
	
	private String id;
	private String name;
	private int age;
	
	public Student( String i, String n, int a ) {
		self.id = i;
		self.name = n;
		self.age = a;
	}
	
	protected int studyHours() {
		return self.age / 2;		// just a guess
	}
	
	public String getID() {
		return self.id;				// ID of the student
	}
	
	public String getName() {
		return self.name;			// from Person interface
	}
	
	public int getAge() {
		return self.age;			// from Person interface
	}
	
	public boolean equalTo( Person other ) {	// from Person interface
		Student otherStudent = ( Student ) other;
		return ( id.equals( otherStudent.getID() ) );
	}
	
	@Override
	public String toString() { 		// for printing
		return "Student(ID: " + self.id +
		", Name: " + self.name +
		", Age: " + age + ")";
	}
}
