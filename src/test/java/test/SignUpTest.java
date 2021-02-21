package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.SignUpPage;

public class SignUpTest extends WebDriverSettings {

    private WebDriver driver;
    private String dataLogin = "gordeeva1991@mail.ru";
    private String dataPassword = "SofiaBunakova2020";

    @Test
    public void signUpTest() {
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.open();
        signUpPage.clickOnEntryBtn();
        signUpPage.inputLogin(dataLogin);
        signUpPage.clickLoginBtn();
        signUpPage.inputPasswd(dataPassword);
        signUpPage.clickOnPasswrdBtn();

    }
}


