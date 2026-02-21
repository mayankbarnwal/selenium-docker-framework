package framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String browser = Config.getBrowser();

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");

                WebDriver remoteDriver = new RemoteWebDriver(
                        new URL(Config.getGridUrl()),
                        options
                );
                driver.set(remoteDriver);
            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize remote WebDriver", e);
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
