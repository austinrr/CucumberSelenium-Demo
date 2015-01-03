package testFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfigFile {

	static File file = new File("./bin/testFramework/config.properties");

	public static Properties getProps() {

		FileInputStream fileInput = null;

		try {
//			System.out.println(new File("./").getCanonicalPath().toString());
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
