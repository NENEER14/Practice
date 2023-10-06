import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
	String name;
	int salary;
	public Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}
	
	int getSalary() {
		return salary;
	}
}

public class ExmapleClass {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("name1", 500));
		employeeList.add(new Employee("name2", 700));
		employeeList.add(new Employee("name3", 200));
		
		Optional<Employee> ee = employeeList.stream().sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.salary - o1.salary;
			}
		}).findFirst();
		
		System.out.println("Max salary "+ ee.get().name + " " + ee.get().salary);
		
		Optional<Employee> ee1 = employeeList.stream().sorted((empl, emp2) -> emp2.getSalary() - empl.getSalary()).findFirst();
		
		System.out.println("Max salary "+ ee1.get().name + " " + ee1.get().salary);
		
		Employee e1 = employeeList.stream().max(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.salary - o2.salary;
			}
		}).get();
		
		System.out.println("Max salary "+ e1.name + " " + e1.salary);
		
		Employee e2 = employeeList.stream().max(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.salary - o2.salary;
			}
		}).get();
		
		System.out.println("max salary " + e2.salary);
		
		
		Employee e3 = employeeList.stream().max(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.salary - o2.salary;
			}
		}).get();
		System.out.println(e3.salary);
		
		
		Employee e4 = employeeList.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
		System.out.println(e4.salary);
		
		Employee e5 = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(e5.salary);
		
		Optional<Employee> e6 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
		System.out.println(e6.get().getSalary());
		
		int salary = employeeList.stream().map(Employee::getSalary).max(Integer::compare).get();
		System.out.println("salary " + salary);
		
		//List<Employee> result = employeeList.stream().max(i -> i.getSalary()).collect(Collectors.toList());
		
		employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList());
		
		
		Employee e7 = employeeList.stream().max((o1, o2) -> (o1.getSalary() > o2.getSalary())? 1 : -1).get();
		System.out.println("salary " + e7.getSalary());
		
	}
	
}
