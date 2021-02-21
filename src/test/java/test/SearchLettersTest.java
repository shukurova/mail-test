package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.SearchLettersPage;

public class SearchLettersTest extends WebDriverSettings {
    private WebDriver driver;
    private String dataLogin = "noname@gmail.com";
    private String dataPassword = "password";
    private String dataFrom = "Илья email";
    private String dataTo = "noname@gmail.com";
    private String dataSubject = "demo";
    private String dataMessage = "Hello, we found %d messages from %s";

    @Test
    public void searchLettersTest() throws InterruptedException {
        SearchLettersPage searchLettersPage = PageFactory.initElements(driver, SearchLettersPage.class);
        searchLettersPage.clickOnSearch();
        searchLettersPage.search();
    }
}
