package ee.ut.cs.pattern.observer;

public class WeatherStationMain {
	
	
	public static void main(String []args){
		WeatherData weatherData = new WeatherData();
		
		//observers
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statDisplay = new StatisticsDisplay(weatherData);
		
		
		weatherData.setMeasurements(50, 45, 31.4f);	
		weatherData.removeObserver(currentDisplay);
		
		weatherData.setMeasurements(33, 67, 15.2f);
		weatherData.setMeasurements(77, 83, 38.5f);
	}

}
