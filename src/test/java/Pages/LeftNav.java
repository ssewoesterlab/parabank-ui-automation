package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends ParentPage {

    public LeftNav(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[text()='Bill Pay']")
    public WebElement billPayButton;



}
