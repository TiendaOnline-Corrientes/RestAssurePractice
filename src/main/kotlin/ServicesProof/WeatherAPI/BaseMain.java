package ServicesProof.WeatherAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseMain {

    // Here we initialized three things to fetch values from properties
    // properties object allow us get the property, FileInputStream for reading properties
    private final Properties properties;
    public BaseMain(){
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/APIProperties/properties.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String property){
        return properties.getProperty(property);
    }


}
