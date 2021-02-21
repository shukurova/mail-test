package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.SendEmailPage;

public class SendEmailTest extends WebDriverSettings {
    private WebDriver driver;
    private String dataTo = "gordeeva1991@mail.ru";

    @Test
    public void sendEmailTest() {
        SendEmailPage sendEmailPage = PageFactory.initElements(driver, SendEmailPage.class);
        sendEmailPage.openForm();
        sendEmailPage.fillFieldTo();
        sendEmailPage.openSubjectForm();
        sendEmailPage.fillSubject();
        sendEmailPage.makeMessage();
    }
}
