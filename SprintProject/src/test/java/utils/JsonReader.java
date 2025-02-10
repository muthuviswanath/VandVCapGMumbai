package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;

public class JsonReader {

	public static JSONObject readJsonData() {
		JSONParser json_Parser = new JSONParser();
		FileReader file_reader = null;
		try {
			file_reader = new FileReader("./resources/jsonfile/JsonData.json");
		} catch (FileNotFoundException e) {
			Reporter.log(e.getMessage());
		}
		Object obj=null;
		try {
			obj = json_Parser.parse(file_reader);
		} catch (IOException e) {
			Reporter.log(e.getMessage());
		} catch (ParseException e) {
			Reporter.log(e.getMessage());
		}
		JSONObject json_Object = (JSONObject)obj;
		return json_Object;
	}
}