package model.abstracts;


import java.util.Calendar;

import model.UserDefinedExe;
import model.enums.Gender;
import model.interfaces.IPrintable;

public abstract class Employee implements IPrintable {
	private String Name;
	private int age;	
	private Gender gen;
	
	private Vehicle vehicle;
	
	
	
	public Employee()
	{
		
	}
	
	public Employee(String name, int age, Gender gen, Vehicle vehicle) {
		super();
		Name = name;
		this.age = age;
		this.vehicle= vehicle;
		this.gen= gen;
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
	
	
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
			
	public int calcBirthYear() 
	{
		
		try {
			
			
			if(this.getAge() < 0)
			{
				throw new UserDefinedExe("Age is negative");
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return (Calendar.getInstance().get(Calendar.YEAR)-this.getAge());
	}
	
	public int calcEarning()
	{
		return 1000;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Gender getGen() {
		return gen;
	}

	public void setGen(Gender gen) {
		this.gen = gen;
	}

			
}
