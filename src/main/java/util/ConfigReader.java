package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private ConfigReader() {
        throw new IllegalStateException("ConfigReader class");
    }

    private static Properties getProperties() {
        File file = new File(System.getProperty("user.dir") + "\\config.properties");
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key) {
        Properties properties = getProperties();
        return properties.getProperty(key);
    }
}
