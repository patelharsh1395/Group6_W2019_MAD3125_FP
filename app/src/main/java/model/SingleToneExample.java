package model;


import java.util.ArrayList;
import java.util.List;

import model.abstracts.Employee;

public class SingleToneExample {
			
	
			static SingleToneExample obj = null;
			List<Employee> ee;
			private SingleToneExample()
			{
				 ee = new ArrayList<>();
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
				ee.add(temp);
				
			}
			public void  displayList()
			{
				for(Employee e : this.ee)
				{
					System.out.print(e.printData());
					System.out.print("\n");
				}
			}
			public ArrayList<Employee> getList()
			{
				return  ((ArrayList<Employee>)this.ee);
			}
			
			
			
}
