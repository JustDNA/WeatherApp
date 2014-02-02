package spider.nitt.weatherupdate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class JSONParser {

	public static Weather getWeather(String data) throws JSONException  {
		Weather weather = new Weather();

		// We create out JSONObject from the data
		JSONObject jObj = new JSONObject(data);
		
		
		
		JSONObject sysObj = getObject("sys", jObj);
		weather.location.setCountry(getString("country", sysObj));
		weather.location.setCity(getString("name", jObj));
		
		
		// We get weather info (This is an array)
		JSONArray jArr = jObj.getJSONArray("weather");
		
		// We use only the first value
		JSONObject JSONWeather = jArr.getJSONObject(0);
		weather.currentCondition.setWeatherId(getInt("id", JSONWeather));
		weather.currentCondition.setDescr(getString("description", JSONWeather));
		weather.currentCondition.setCondition(getString("main", JSONWeather));
		weather.currentCondition.setIcon(getString("icon", JSONWeather));
		
		JSONObject mainObj = getObject("main", jObj);
		weather.currentCondition.setHumidity(getInt("humidity", mainObj));
		weather.currentCondition.setPressure(getInt("pressure", mainObj));
		weather.temperature.setTemp(getFloat("temp", mainObj));
		
		// Wind
		JSONObject wObj = getObject("wind", jObj);
		weather.wind.setSpeed(getFloat("speed", wObj));
		
		
		// We download the icon to show
		
		
		return weather;
	}
	
	
	private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
		JSONObject subObj = jObj.getJSONObject(tagName);
		return subObj;
	}
	
	private static String getString(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getString(tagName);
	}

	private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
		return (float) jObj.getDouble(tagName);
	}
	
	private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getInt(tagName);
	}
	
}
