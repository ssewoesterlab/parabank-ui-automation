package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInputLoginPage;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputLoginPage;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButtonLoginPage;

    @FindBy(xpath = "//b[text()='Welcome']")
    public WebElement loginDashboardWelcomeText;

    @FindBy(xpath = "//*[@class='error']")
    public WebElement errorMessage;



}
