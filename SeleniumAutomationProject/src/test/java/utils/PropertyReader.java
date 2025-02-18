package utils;

import java.util.Properties;

import org.testng.Reporter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class PropertyReader {
	public static Properties readPropertiesData() {
		FileReader reader = null;
		try {
			reader = new FileReader("./resources/properties/TestData.properties");
		} catch (FileNotFoundException e) {
			Reporter.log(e.getMessage());
		}
		Properties props = new Properties();
		try {
			props.load(reader);
		} catch (IOException e) {
			Reporter.log(e.getMessage());
		}
		return props;
	}
}
