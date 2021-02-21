package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmailPage {
    WebDriverWait waitForForm;
    By formLocator = By.name("to");
    By subjectLocator = By.name("subjectbox");
    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private String dataTo = "noname@gmail.com";
    private String dataSubject = "Тестовое задание";
    private String dataMessage = "Hello, we found %d messages from %s";
    private String dataFrom = "Илья email";
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]/div[1]/div/div/div/div[1]/div/div/a/span/span/svg")
    private WebElement writeLetterBtn;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]/div[1]")
    private WebElement to;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")
    private WebElement subject;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]")
    private WebElement message;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span/span")
    private WebElement sendBtn;

    public SendEmailPage(WebDriver driver) {
        this.driver = driver;
        waitForForm = new WebDriverWait(driver, 10);
    }

    public void openForm() {
        to.click();
        waitForForm.until(ExpectedConditions.presenceOfElementLocated(formLocator));
    }

    public void fillFieldTo() {
        to.sendKeys(dataTo);
    }

    public void openSubjectForm() {
        driver.findElement(subjectLocator);
    }

    public void fillSubject() {
        subject.sendKeys(dataSubject);
    }

    public void fillMessageField() {
        driver.findElement(By.className("gmail_signature"))
                .findElement(By.xpath("../..")).findElement(By.cssSelector("[contenteditable=true]"));
    }

    public void makeMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String result = driver.findElements(By.cssSelector("span.Dj")).stream()
                .filter(WebElement::isDisplayed).findFirst().orElseThrow(() ->
                        new RuntimeException("no displayed element with search result"))
                .findElement(By.cssSelector("span.ts:last-child")).getText();
        ;
        js.executeScript("arguments[0].innerHTML=arguments[1] + arguments[0].innerHTML;", message,
                String.format(dataMessage, Integer.parseInt(result), dataFrom));

        subject.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER));
    }


}
