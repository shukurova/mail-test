package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.SignUpPage;

import static org.junit.Assert.assertEquals;

public class WebDriverSettings {

    public static SignUpPage loginPage;
    public static WebDriver driver;


    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://mail.ru/");
    }

    @AfterClass
    public static void cleanUp() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void currentURLTest() {
        assertEquals("https://mail.ru/", driver.getCurrentUrl());
    }

    @Test
    public void currentTittleTest() {
        assertEquals("Mail.ru: почта, поиск в интернете, новости, игры", driver.getTitle());
    }
}
