package test;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page.SignUpPage;

public class SignUpTest extends BaseTest {

    private String dataLogin = "gordeeva1991@mail.ru";
    private String dataPassword = "SofiaBunakova2020";

    @Test
    public void signUpTest() {
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.inputLogin(dataLogin);
        signUpPage.clickLoginBtn();
        signUpPage.inputPasswd(dataPassword);
        signUpPage.clickOnPasswrdBtn();
    }
}


