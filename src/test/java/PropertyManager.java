import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private String base_url;
    private String browser;
    private static PropertyManager propertyManager;
    private Properties properties;
    private PropertyManager()
    {
            try
            {
              InputStream  inputStream=new FileInputStream("config/config.properties");
                properties=new Properties();
                properties.load(inputStream);
            }
            catch (Exception e)
            {
                System.out.println(e.getStackTrace()+" "+e.getMessage());
            }
    }
    public static PropertyManager getInstance() {
        if (propertyManager == null)
        {
            propertyManager=new PropertyManager();
            return propertyManager;
        }
        else
        {
            return propertyManager;
        }
    }
    public String get_baseurl()
    {
   return  properties.getProperty("Base_Url");
    }
    public String get_browser()
    {
        return properties.getProperty("browser");
    }
}
