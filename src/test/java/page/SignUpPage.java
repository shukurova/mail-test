package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;
    private SignUpPage loginPage;
    private WebDriverWait waitForPassword;
    @FindBy(name = "username")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[2]/div[2]/div[3]/div/div[1]/button/span")
    private WebElement loginBtn;
    @FindBy(name = "password")
    private WebElement passwdField;
    @FindBy(xpath = "//*[@id=\"ph-whiteline\"]/div/div[2]/button")
    private WebElement entryBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[2]/div/div[3]/div/div[1]/div/button/span")
    private WebElement passwrdBtn;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        waitForPassword = new WebDriverWait(driver, 10);
    }

    public void inputLogin(String login) {
        String dataLogin = "gordeeva1991@mail.ru";
        email.sendKeys(dataLogin + Keys.ENTER);
    }

    public void inputPasswd(String passwd) {
        String dataPassword = "SofiaBunakova2020";
        passwdField.sendKeys(dataPassword + Keys.ENTER);
    }

    public void open() {
        driver.get("https://mail.ru/");
    }

    public void clickOnEntryBtn() {
        entryBtn.click();
    }

    public void clickOnPasswrdBtn() {
        passwrdBtn.click();
    }

    public void clickLoginBtn() {
        loginBtn.click();
        waitForPassword.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(By.name("password")),
                ExpectedConditions.visibilityOfElementLocated(By.name("password"))
        ));
    }
}
