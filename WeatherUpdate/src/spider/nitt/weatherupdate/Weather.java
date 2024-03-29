package spider.nitt.weatherupdate;


public class Weather {
	
	public Location location = new Location();
	public CurrentCondition currentCondition = new CurrentCondition();
	public Temperature temperature = new Temperature();
	public Wind wind = new Wind();
	
	public byte[] iconData;
	
	public  class CurrentCondition {
		private int weatherId;
		private String condition;
		private String descr;
		private String icon;
		
		private float pressure;
		private float humidity;
		
		public int getWeatherId() {
			return weatherId;
		}
		public void setWeatherId(int weatherId) {
			this.weatherId = weatherId;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public float getPressure() {
			return pressure;
		}
		public void setPressure(float pressure) {
			this.pressure = pressure;
		}
		public float getHumidity() {
			return humidity;
		}
		public void setHumidity(float humidity) {
			this.humidity = humidity;
		}
		
		
	}
	
	public  class Temperature {
		private float temp;
		
		public float getTemp() {
			return temp;
		}
		public void setTemp(float temp) {
			this.temp = temp;
		}
		
	}
	
	public  class Wind {
		private float speed;
		
		public float getSpeed() {
			return speed;
		}
		public void setSpeed(float speed) {
			this.speed = speed;
		}
		
		
	}
	
	public class Location{

		private String country;
		private String city;
		
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
	}

}
