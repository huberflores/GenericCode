package ee.ut.cs.pattern.observer.javasupport;

public class WeatherStationMain {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(50, 45, 31.4f);			
		weatherData.setMeasurements(33, 67, 15.2f);
		weatherData.setMeasurements(77, 83, 38.5f);
	}
}
