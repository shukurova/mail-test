package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchLettersPage {
    private WebDriver driver;
    private String dataFrom = "Илья email";
    private WebDriverWait waitForSearch;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[1]/span/div[3]/div/div[3]/div/div/span/span/div/input")
    private WebElement search;

    public SearchLettersPage(WebDriver driver) {
        this.driver = driver;
        waitForSearch = new WebDriverWait(driver, 10);
    }

    public void search() {
        search.sendKeys("from: " + dataFrom + Keys.ENTER);
    }

    public void clickOnSearch() throws InterruptedException {
        waitForSearch.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(By.name("q")),
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        ));
        Thread.sleep(5000L);
    }
}
