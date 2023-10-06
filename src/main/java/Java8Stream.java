import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Stream {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filteredList = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filteredList);
		
		
		Random random = new Random();
		//forEach , Limit
		random.ints().limit(10).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//get list of unique squares
		List<Integer> squareList = numbers.stream().map(s -> s * s).collect(Collectors.toList());
		System.out.println(squareList);
		
		Random random1 = new Random();
		//forEach , Limit, sorted
		random1.ints().limit(10).sorted().forEach(System.out::println);
		
		
		//count a list of empty string
		List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		long emptyStringCount = stringList.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(emptyStringCount);
		
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		IntSummaryStatistics summaryStat = integers.stream().mapToInt((x) -> x).summaryStatistics();
		
		System.out.println("max number " + summaryStat.getMax());
		System.out.println("min number " + summaryStat.getMin());
		System.out.println("average number " + summaryStat.getAverage());
		System.out.println("sum of all numbers " + summaryStat.getSum());
		
		
		//filtered, sorted list
		List<Integer> integerList = Arrays.asList(1, 3, 5, 7, 9, 6, 10, 15, 7, 9, 20);
		List<Integer> sortFilteredList = integerList.stream().filter(s -> (s > 5)).sorted().collect(Collectors.toList());
		System.out.println(sortFilteredList);
		
		List<Integer> sortFilteredList1 = integerList.stream().filter(s -> (s > 5)).limit(3).sorted().collect(Collectors.toList());
		System.out.println(sortFilteredList1);
		
		integerList.stream().forEach(System.out::println);
		
		//Swap two numbers without using another variable
		int a = 10;
		int b = 20;
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println( "a " + a + " b " + b);
		
		String a1 = "A";
		String b1 = "A";
		String c= new String(a1);
		String d= new String(b1).intern();
		
		System.out.println(b1==c);
		System.out.println(b1==d);
		System.out.println(c==d);
		System.out.println(Double.parseDouble("-1"));
		
		String s1 = "1";
		String s2 = "2";
		System.out.println(s1.charAt(0) - '0' + s2.charAt(0) - '0');
		
	}	
}

class Parent{    
	  void msg() throws Exception {  
	    System.out.println("parent method");  
  }    
}    
    
class TestExceptionChild1 extends Parent{    
  void msg() throws Exception, ArithmeticException {    
    System.out.println("child method");    
  } 
  }
