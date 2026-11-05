package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends ParentPage{
    public LeftNav(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
