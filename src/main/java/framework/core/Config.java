package framework.core;

public class Config {

    public static String getGridUrl() {
        // could be externalized to env var or properties
        return System.getProperty("grid.url", "http://localhost:4444/wd/hub");
    }

    public static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }

    public static String getBaseUrl() {
        return System.getProperty("base.url", "https://www.google.com");
    }
}
