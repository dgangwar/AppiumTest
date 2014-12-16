package test.jav;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJson {

	
public static Properties properties = null;
public static JSONObject jsonObject = null;

static {

	properties = new Properties();
		}

		public static void main(String[] args) {

		    try {

		        JSONParser jsonParser = new JSONParser();

		        File file = new File("//Users//dgangwar//Documents//MobileTest//testJava//src//test//jav//read.json");

		        Object object = jsonParser.parse(new FileReader(file));

		        jsonObject = (JSONObject) object;

		        parseJson(jsonObject);

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}

		public static void getArray(Object object2) throws ParseException {

		    JSONArray jsonArr = (JSONArray) object2;

		    for (int k = 0; k < jsonArr.size(); k++) {

		        if (jsonArr.get(k) instanceof JSONObject) {
		            parseJson((JSONObject) jsonArr.get(k));
		        } else {
		            System.out.println("Array object -" +jsonArr.get(k));
		        }

		    }
		}

		public static void parseJson(JSONObject jsonObject) throws ParseException {

		    Set<Object> set = jsonObject.keySet();
		    System.out.println(jsonObject.values());
		    System.out.println(set.size());
		    Iterator iterator = set.iterator();

		    while (iterator.hasNext()) {
		        Object obj = iterator.next();
		        if (jsonObject.get(obj) instanceof JSONArray) {
		            System.out.println("To String -"+ obj.toString());
		            getArray(jsonObject.get(obj));
		        } else {
		            if (jsonObject.get(obj) instanceof JSONObject) {
		                parseJson((JSONObject) jsonObject.get(obj));
		            } else {
		                System.out.println("Array Data "+obj.toString() + "\t"
		                        + jsonObject.get(obj));
		            }
		        }
		    }

		}
}
