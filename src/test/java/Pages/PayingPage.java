package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayingPage extends ParentPage{

    public PayingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//input[@name='payee.name']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@name='payee.address.street']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@name='payee.address.city']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@name='payee.address.state']")
    public WebElement stateInput;

    @FindBy(xpath = "//input[@name='payee.address.zipCode']")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//input[@name='payee.phoneNumber']")
    public WebElement phoneInput;

    @FindBy(xpath = "//input[@name='payee.accountNumber']")
    public WebElement accountNumberInput;

    @FindBy(xpath = "//input[@name='verifyAccount']")
    public WebElement accountNumberVerifyInput;

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement amountInput;

    @FindBy(xpath = "//select[@name='fromAccountId']")
    public WebElement fromAccountSelect;

    @FindBy(xpath = "//input[@value='Send Payment']")
    public WebElement sendPaymentButton;

    @FindBy(xpath = "//h1[text()='Bill Payment Complete']")
    public WebElement paymentCompleteText;

    @FindBy(xpath = "//span[@id='amount']")
    public WebElement sendenAmoundText;

    @FindBy(xpath = "//span[@id='fromAccountId']")
    public WebElement fromAccountText;

































}
