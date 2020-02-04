package core.configuration;

import core.browser.DriverType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String RESOURCES_PATH = "src\\main\\resources\\";
    private static Properties properties;

    public static void readProperties() {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            properties.load(new FileReader(new File(RESOURCES_PATH, "env.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "chrome.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "browser.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "firefox.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "api.properties")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DriverType getDriverType() {
        initializationProperties();
        return DriverType.valueOf(properties.getProperty("browserType"));
    }

    public static String getMainUrl() {
        initializationProperties();
        return (properties.getProperty("mainUrl"));
    }
    public static String getAccessToken() {
        initializationProperties();
        return properties.getProperty("vkAccessToken");
    }

    public static String getOwnerId() {
        initializationProperties();
        return properties.getProperty("ownerId");
    }

    public static String getMessageText() {
        initializationProperties();
        return properties.getProperty("vkMessage");
    }

    public static String getEditedMessageText() {
        initializationProperties();
        return properties.getProperty("vkEditedMessage");
    }

    public static String getVersion() {
        initializationProperties();
        return properties.getProperty("vkVersion");
    }

    public static void initializationProperties(){
        if (properties == null) {
            readProperties();
        }
    }
}


