package commonUtils;


import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class ReadData {
	
	Properties prop;
	
    String propertyFile;
	
	public ReadData(String filename){
		
		this.propertyFile = filename;

	}
	
	public Map<String,String> readData()
	{
		Map<String,String> map = new LinkedHashMap<String, String>();
		try
		
		{
			
		prop = new Properties();
		
		InputStream input = getClass().getResourceAsStream(propertyFile);
		
		if(input==null)
			System.out.println("hi");
		else
			prop.load(input);
		
		for(Object o :prop.keySet())
			map.put((String)o, (String)(prop.get(o)));
		
		return map;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	
	

}
