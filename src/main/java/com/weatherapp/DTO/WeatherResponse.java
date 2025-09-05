package com.weatherapp.DTO;

public class WeatherResponse {
	    private String city;
	    private double temperature;
	    private String description;
	    private String iconUrl;
	    private String error;
		public WeatherResponse(String city, double temperature, String description, String iconUrl, String error) {
			super();
			this.city = city;
			this.temperature = temperature;
			this.description = description;
			this.iconUrl = iconUrl;
			this.error = error;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public double getTemperature() {
			return temperature;
		}
		public void setTemperature(double temperature) {
			this.temperature = temperature;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIconUrl() {
			return iconUrl;
		}
		public void setIconUrl(String iconUrl) {
			this.iconUrl = iconUrl;
		}
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
	    
	    

}
