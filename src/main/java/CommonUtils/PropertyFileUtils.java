package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {
	

public String getdatafromProprtyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Login.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
}
}
