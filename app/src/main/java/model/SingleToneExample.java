package model;


import java.util.ArrayList;
import java.util.List;

import model.abstracts.Employee;
import model.enums.Gender;


public class SingleToneExample {
			
	
			static SingleToneExample obj = null;
			List<Employee> employees;
			private SingleToneExample()
			{


				employees = new ArrayList<>();

				Intern in = new Intern("Lambton","Mahesh", -20, Gender.MALE , null);
				FullTime ft = new FullTime(10000, 500,"Raju", 30, Gender.MALE ,new MotorCycle("Audi","A4" , "CA123", 15));
				CommissionBasedPartTime cm = new CommissionBasedPartTime(10, 5, 5, "Gurminder", 27 , Gender.FEMALE ,new Car("Audi","A4" , "CA123", 15) );
				FixedBasedPartTime fp = new FixedBasedPartTime(1000, 5, 5,"Rohan", 27 , Gender.MALE ,new MotorCycle("Audi","A4" , "CA123", 15) );



				addIntoList(in);
				addIntoList(ft);
				addIntoList(cm);
				addIntoList(fp);
			}
			public static SingleToneExample getObj()
			{
				if(obj == null)
				{
					obj = new SingleToneExample();
				
				}
				return obj;
			}
			public void addIntoList(Employee temp)
			{
				employees.add(temp);
				
			}
			public void  displayList()
			{
				for(Employee e : this.employees)
				{
					System.out.print(e.printData());
					System.out.print("\n");
				}
			}
			public ArrayList<Employee> getList()
			{
				return  ((ArrayList<Employee>)this.employees);
			}
			
			
			
}
