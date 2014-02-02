package spider.nitt.weatherupdate;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

	
	private TextView place;
	private TextView condition;
	private TextView temperature;
	private TextView pressure;
	private TextView wind;
	private TextView humidity;
	private ImageView Icon;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		
		SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(this);
        String city = getPref.getString("loc", "london");
        
		place = (TextView) findViewById(R.id.place);
		condition = (TextView) findViewById(R.id.condition);
		temperature = (TextView) findViewById(R.id.temperature);
		humidity = (TextView) findViewById(R.id.humidity);
		pressure = (TextView) findViewById(R.id.pressure);
		wind = (TextView) findViewById(R.id.wind);
		Icon = (ImageView) findViewById(R.id.Icon);
		
		JSONWeatherTask task = new JSONWeatherTask();
		task.execute(new String[]{city});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(this);
        String city = getPref.getString("loc", "london");
    	JSONWeatherTask task = new JSONWeatherTask();
		task.execute(new String[]{city});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.loc:{
			Intent OpenApp = new Intent("spider.nitt.weatherupdate.LOCATIONSETTING");
        	startActivity(OpenApp);
        	return true;		
		}
		}
		return false;
	}


	private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {
		
		@Override
		protected Weather doInBackground(String... params) {
			Weather weather = new Weather();
			String data = ( (new HttpClient()).getWeatherData(params[0]));

			try {
				weather = JSONParser.getWeather(data);
				
				// Let's retrieve the icon
				weather.iconData = ( (new HttpClient()).getImage(weather.currentCondition.getIcon()));
				
			} catch (JSONException e) {				
				e.printStackTrace();
			}
			return weather;
		
	}
		
		
		
		
	@Override
		protected void onPostExecute(Weather weather) {			
			super.onPostExecute(weather);
			
			place.setText(weather.location.getCity() + "," + weather.location.getCountry());
			condition.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
			temperature.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + "°C");
			humidity.setText("" + weather.currentCondition.getHumidity() + "%");
			pressure.setText("" + weather.currentCondition.getPressure() + " hPa");
			wind.setText("" + weather.wind.getSpeed() + " mps");

			Resources res = getResources();
			if(weather.currentCondition.getIcon().equals("01d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z01d));
			}
			if(weather.currentCondition.getIcon().equals("01n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z01n));
			}
			if(weather.currentCondition.getIcon().equals("02d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z02d));
			}
			if(weather.currentCondition.getIcon().equals("02n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z02n));
			}
			if(weather.currentCondition.getIcon().equals("03d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z03d));
			}
			if(weather.currentCondition.getIcon().equals("03n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z03n));
			}
			if(weather.currentCondition.getIcon().equals("04d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z04d));
			}
			if(weather.currentCondition.getIcon().equals("04n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z04n));
			}
			if(weather.currentCondition.getIcon().equals("09d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z09d));
			}
			if(weather.currentCondition.getIcon().equals("09n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z09n));
			}
			if(weather.currentCondition.getIcon().equals("10d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z10d));
			}
			if(weather.currentCondition.getIcon().equals("10n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z10n));
			}
			if(weather.currentCondition.getIcon().equals("11d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z11d));
			}
			if(weather.currentCondition.getIcon().equals("11n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z11n));
			}
			if(weather.currentCondition.getIcon().equals("13d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z13d));
			}
			if(weather.currentCondition.getIcon().equals("13n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z13n));
			}
			if(weather.currentCondition.getIcon().equals("50d"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z50d));
			}
			if(weather.currentCondition.getIcon().equals("50n"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.z50n));
			}
			if(weather.currentCondition.getIcon().equals("r"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.zr));
			}
			if(weather.currentCondition.getIcon().equals("sn50"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.zsn50));
			}
			if(weather.currentCondition.getIcon().equals("t50"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.zt50));
			}
			if(weather.currentCondition.getIcon().equals("w50"))
			{
			
				Icon.setImageDrawable(res.getDrawable(R.drawable.zw50));
			}


		/*	if (weather.iconData != null && weather.iconData.length > 0) {
				Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length); 
				Icon.setImageBitmap(img);
			}else
			{
				condition.append("\nIMAGE FETCHING FAILED!");
			}  */
			
				
		}

	
	}
}