package model;



import model.abstracts.PartTime;
import model.abstracts.Vehicle;
import model.enums.gender;

public class CommissionBasedPartTime extends PartTime {
		

		private int commission;
		
		
		public CommissionBasedPartTime(int commission, int rate, float hours, String name, int age , gender gen , Vehicle vehicle) {
			super(rate, hours, name, age, gen , vehicle);
			this.commission = commission;
		}
		
		public int getCommission() {
			return commission;
		}

		public void setCommission(int commission) {
			this.commission = commission;
		}
		
		public float commissionCalcEarnings()
		{	
			return ((float)this.getCommission()/100*(this.getHours()*this.getRate()))+(this.getHours()*this.getRate());
		}
		
		

		@Override
		public String printData() {
			String temp = "\nName : "+this.getName()+"\nYear of Birth : "+this.calcBirthYear()+"\nGender : "+this.getGen()+"\nEmployee is PartTime / Commissioned"+"\nRate : "+this.getRate()+"\nHours : "+this.getHours()+"\nCommission : "+this.getCommission()+"\n Earnings : "+this.commissionCalcEarnings()+"( "+((float)this.getHours()*this.getRate())+" + "+this.getCommission()+"% of "+((float)this.getHours()*this.getRate())+")";
			
			if(this.getVehicle() != null)
			{
				if(this.getVehicle() instanceof Car)
				{
					temp+= ((Car)this.getVehicle()).printData();
					
				}
				else
				{
					temp+= ((MotorCycle)this.getVehicle()).printData();
					
				}
			}
			else
			{
				temp += "\nEmployee dont have vehicle";
			}
			
			return temp;
		}
		
		
		
}
