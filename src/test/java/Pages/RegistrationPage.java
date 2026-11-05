package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends ParentPage{

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@id='customer.firstName']")
    public WebElement firstnameInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    public WebElement lastnameInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    public WebElement addressInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    public WebElement cityInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    public WebElement stateInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    public WebElement zipCodeInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    public WebElement phoneNumberInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    public WebElement ssnInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.username']")
    public WebElement usernameInputRegisterPage;

    @FindBy(xpath = "//input[@id='customer.password']")
    public WebElement passwordInputRegisterPage;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    public WebElement confirmPasswordInputRegisterPage;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerButtonOnTheRegisterPage;

    @FindBy(xpath = "//p[contains(text(),'successfully')]")
    public WebElement successfullyTextRegister;

    @FindBy(xpath = "//h1[contains(text(),'Welcome')]")
    public WebElement registerPageWelcomeText;






















































}
