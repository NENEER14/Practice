import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Java8Tester implements FuntianlIntefaceExample, Vehicle {
	
	final static String salutation = "Hello! ";
	
	public static void main(String[] args) {
		List<String> names1 = new ArrayList<>();
		names1.add("Mahesh");
		names1.add("Suresh");
		names1.add("Ramesh");
		names1.add("Naresh");
		names1.add("Kalpesh");
		
		List<String> names2 = new ArrayList<>();
		names2.add("Mahesh");
		names2.add("Suresh");
		names2.add("Ramesh");
		names2.add("Naresh");
		names2.add("Kalpesh");
		
		Java8Tester test = new Java8Tester();
		
		test.sortUsingJava7(names1);
		System.out.println(names1);
		
		test.sortUsingJava8(names2);
		System.out.println(names2);
		
		//Lambda Expressions
		GreetingService greetService1 = message -> 
			System.out.println(salutation + message);
		greetService1.sayMessage("Mahesh");
		  
		//Method Reference
	    names1.forEach(System.out::println);
	    
	    //Calling Functional Interface methods
	    test.abstartMethod();
	    test.noAbstratMethod();
	    
	    //Calling normal interface methods
	    test.interfaceMethod1();
	    test.interfaceMethod2();
	    test.printName1();
	    test.printName2();
	    
	    //Calling static method from an interface
	    Vehicle.blowHorn();
	    
	    Integer value1 = null;
	    @SuppressWarnings("removal")
		Integer value2 = new Integer(10);
			
	    //Optional.ofNullable - allows passed parameter to be null.  
	    Optional<Integer> a = Optional.ofNullable(value1);
	      
	    //Optional.of - throws NullPointerException if passed parameter is null
	    Optional<Integer> b = Optional.of(value2);
	    System.out.println(test.sum(a,b));
	    
	}
	
	public void sortUsingJava7(List<String> names){
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}
	
	public void sortUsingJava8(List<String> names){
		
		//Lambda Expression
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

	@Override
	public void abstartMethod() {
		System.out.println("Abstrat Method from Functional Interface");
	}

	@Override
	public void interfaceMethod1() {
		System.out.println("Interface Method Implementation interfaceMethod1");
	}

	@Override
	public void interfaceMethod2() {
		System.out.println("Interface Method Implementation interfaceMethod2");
	}
	
	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		
		//Optional.isPresent - checks the value is present or not
		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());
		
		//Optional.orElse - returns the value if present otherwise returns
		//the default value passed.
		@SuppressWarnings("removal")
		Integer value1 = a.orElse(new Integer(0));
		
		//Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}

	
}

interface GreetingService {
    void sayMessage(String message);
}

//Functional interface will have exactly one abstract method, Single Abstract Method (SAM)
@FunctionalInterface
interface FuntianlIntefaceExample {
	
	void abstartMethod();
	
	//default method
	default void noAbstratMethod() {
		System.out.println("No Abstrat Method from Functional Interface");
	}
}

interface Vehicle {
	void interfaceMethod1();
	void interfaceMethod2();
    
	//default method
	default void printName1() {
      System.out.println("I am a vehicle1 !");
   }
	
	//default method
	default void printName2() {
      System.out.println("I am a vehicle2 !");
   }
	
	//static method inside an interface.
	static void blowHorn() {
	      System.out.println("Blowing horn!!!");
	   }
}
