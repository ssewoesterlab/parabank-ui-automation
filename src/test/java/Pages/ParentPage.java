package Pages;

import StepDefinitions.Hooks;
import Utilities.FakerClass;
import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ParentPage extends GWD{

    FakerClass fakerClass = new FakerClass();


    public static  WebElement myClick(WebElement element) {
        Hooks.setLastUsedElement(element);
        scrollToElement(element);
        element.click();
        return element;
    }

     public static void mySendKeys(WebElement element, String text) {
        Hooks.setLastUsedElement(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js =
                (JavascriptExecutor) GWD.getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView();", element);
    }


    public static void scrolltoElementFalse(WebElement element) {
        JavascriptExecutor js =
                (JavascriptExecutor) GWD.getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView(false);", element);
    }


    public static void scrollTopWithActions() {
        Actions actions = new Actions(GWD.getDriver());
        actions.keyDown(Keys.CONTROL)
                .sendKeys(Keys.UP)
                .keyUp(Keys.CONTROL)
                .perform();
    }

    public static void textAssert(WebElement element,String text){
        Assert.assertTrue(element.getText().toLowerCase().contains(text),"Error");
    }

    public static void webElementAssert(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}