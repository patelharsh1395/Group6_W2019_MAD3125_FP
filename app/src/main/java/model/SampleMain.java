package model;

import java.util.ArrayList;
import java.util.List;



import model.enums.gender;

public class SampleMain {

	public static void main(String[] args) {
		//System.out.println("Hello world");
		
		//Employee e1 = new Employee("Mahesh", 20);
		
		//System.out.println(e1.calcBirthYear());
		
		

			
		
		
		Intern in = new Intern("Lambton","Mahesh", -20, gender.MALE , null);
		FullTime ft = new FullTime(10000, 500,"Raju", 30, gender.MALE ,new MotorCycle("Audi","A4" , "CA123", 15));
		CommissionBasedPartTime cm = new CommissionBasedPartTime(10, 5, 5, "Gurminder", 27 , gender.FEMALE ,new Car("Audi","A4" , "CA123", 15) );
		FixedBasedPartTime fp = new FixedBasedPartTime(1000, 5, 5,"Rohan", 27 , gender.MALE ,new MotorCycle("Audi","A4" , "CA123", 15) );
		
		
		SingleToneExample  singleton = SingleToneExample.getObj();
		singleton.addIntoList(in);
		singleton.addIntoList(ft);
		singleton.addIntoList(cm);
		singleton.addIntoList(fp);
				
		singleton.displayList();		
		
		
		
				
	}

}
