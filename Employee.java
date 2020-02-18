public class Employee{
	private int id;
	private String name;
	private int age;
	private double monthlySalary;

	public Employee(){
		id = 0;
		name = "";
		age = 0;
		monthlySalary = 0;
	}
	public Employee(String name){
		id = 0;
		this.name = name;
		age = 0;
		monthlySalary = 0;
	}
	public Employee(int id, String name){
		this.id = id;
		this.name = name;
		age = 0;
		monthlySalary = 0;
	}
	public Employee(int id, String name, int age, double salary){
		this.id = id;
		this.name = name;
		this.age = age;
		this.monthlySalary = salary;
	}

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name= name;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public double getMonthlySalary(){
		return this.monthlySalary;
	}
	public void setMonthlySalary(double salary){
		this.monthlySalary = salary;
	}


}
