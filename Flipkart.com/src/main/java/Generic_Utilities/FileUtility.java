
package Generic_Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is used to handle file utilities
 * @author SanjayBabu
 *
 */
public class FileUtility 
{
	    /**
	     * this method is used to get value from the property File
	     * @param key
	     * @return
	     * @throws IOException
	     */
		public String getPropertyKeyValue(String key) throws IOException
		{
			System.out.println("control come inside getProprtyvalue method ");
			FileInputStream fileInputStream = new FileInputStream(IPathConstants.propertyFilePath);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String value = properties.getProperty(key);
			System.out.println(value);
			return value;
		}
	}



