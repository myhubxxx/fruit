package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	private static Properties prop = null;
	
	static{
		
		try {
			
		InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("service.properties");
		
		prop = new Properties();
		
			prop.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getValue(String key){
		
		return prop.getProperty(key);
	}
	
	public static Object getBean(String key) {
		
		Object obj;
		try {
			String className = getValue(key);
			Class clazz = Class.forName(className);
			obj = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return obj;
	}
}
