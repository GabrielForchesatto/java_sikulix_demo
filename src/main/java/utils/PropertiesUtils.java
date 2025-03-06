package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    public static String getProperty(String name) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\url.properties");
        properties.load(file);
        return properties.getProperty(name);
    }

}