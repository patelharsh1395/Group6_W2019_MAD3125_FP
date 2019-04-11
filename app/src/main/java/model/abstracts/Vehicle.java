package model.abstracts;



import model.inter.IPrintable;

public abstract class Vehicle implements IPrintable {
		private String make;
		private String plate;
		private int mileage;
		
		
		
		
		public Vehicle(String make, String plate, int mileage) {
			this.make = make;
			this.plate = plate;
			this.mileage = mileage;
		}
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public String getPlate() {
			return plate;
		}
		public void setPlate(String plate) {
			this.plate = plate;
		}
		public int getMileage() {
			return mileage;
		}
		public void setMileage(int mileage) {
			this.mileage = mileage;
		}
		
		
		
}
