import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;


public class JSONLoader {

	/**
	 * @param args
	 */

   public JSONArray Cat = new JSONArray();
   public JSONArray Dog = new JSONArray();
   public JSONArray others = new JSONArray();
    



  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      json = (JSONObject) json.get("result");
    
      return json;
    } finally {
      is.close();
    }
  }
  
  
  
  public static JSONArray read_the_OB(JSONObject input) throws IOException, JSONException {
	  JSONArray temp =  (JSONArray)input.get("results");
	  
	  return temp;
  }
  
  public static JSONArray read_json(int type) throws JSONException, IOException{
	  
	  
	  JSONObject json = readJsonFromUrl("http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=f4a75ba9-7721-4363-884d-c3820b0b917c");
	    
	    
	    JSONArray result = read_the_OB(json);
	    
	    JSONArray Cat = new JSONArray();
	    JSONArray Dog = new JSONArray();
	    JSONArray others = new JSONArray();
	    
	    for (int i=0;i<result.length();i++) {
	      //  System.out.println(result.get(i).toString());
	        if(result.getJSONObject(i).get("Type").equals("貓")){
	        	Cat.put(result.getJSONObject(i));
	        }
	        else if(result.getJSONObject(i).get("Type").equals("犬")){
	        	Dog.put(result.getJSONObject(i));
	        }
	        else if(result.getJSONObject(i).get("Type").equals("其他")){
	        	others.put(result.getJSONObject(i));
	        }
	    }
	    if(type==0)
	    	return Cat;
	    else if(type==1)
	    	return Dog;
		return others;
  }




}
