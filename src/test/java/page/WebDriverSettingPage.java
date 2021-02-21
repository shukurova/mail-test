package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class WebDriverSettingPage {

    public static SignUpPage loginPage;
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void waitVisibility(By ElementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ElementBy));

    }

    public void click(By ElementBy) {
        waitVisibility(ElementBy);
        driver.findElement(ElementBy).click();
    }

    public void isElementDisplayed(By ElementBy) {
        waitVisibility(ElementBy);
        assertTrue(driver.findElement(ElementBy).isDisplayed());
    }


}
