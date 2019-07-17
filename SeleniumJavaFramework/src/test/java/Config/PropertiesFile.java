package Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_Demo;

public class PropertiesFile {

	static	Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
		setProperties1();
		getProperties();
	}

	public static void getProperties() {
		try {
			Properties prop = new Properties();

			InputStream input = new FileInputStream(projectPath+"/src/test/java/Config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			TestNG_Demo.browsername=browser;

		}catch (Exception exp) {
			System.out.println(exp.getMessage()); 
			System.out.println(exp.getCause());  
			exp.printStackTrace();
		}

	}

	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/Config/config.properties");
			prop.setProperty("browser", "chrome");
			prop.store(output, null);
		
		}catch (Exception exp) {
			System.out.println(exp.getMessage()); 
			System.out.println(exp.getCause());  
			exp.printStackTrace();
		}
	}
	public static void setProperties1() {
		try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/Config/config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
		
		}catch (Exception exp) {
			System.out.println(exp.getMessage()); 
			System.out.println(exp.getCause());  
			exp.printStackTrace();
		}
	}
}


