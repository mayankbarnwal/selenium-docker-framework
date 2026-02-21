package tests;

import base.BaseTest;
import framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title should contain 'Google'");
    }

    @Test
    public void searchForText() {
        By searchBox = By.name("q");
        WaitUtils.waitForVisible(searchBox).sendKeys("Selenium WebDriver\n");

        // simple assertion
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium webdriver"));
    }
}
