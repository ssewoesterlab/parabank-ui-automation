package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends ParentPage{
    public DialogContent(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
