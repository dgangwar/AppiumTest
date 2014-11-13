package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

final public class ReadData 
{
	private static Properties prop;
	static String propertyFilePath = "Data.properties";
	
	private static Properties loadProperty()
	{
		if(prop==null)
		{
			prop = new Properties();
			try
			{
				prop.load(new FileInputStream(propertyFilePath));
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		return prop;
	}
		
	public static String getProperty(String propertyName) throws IOException
	{
		return loadProperty().getProperty(propertyName);
	}
		
}
