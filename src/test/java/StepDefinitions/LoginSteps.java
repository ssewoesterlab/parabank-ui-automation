package StepDefinitions;

import Pages.LoginPage;
import Pages.RegistrationPage;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    LoginPage lp = new LoginPage(GWD.getDriver());

    @When("the user enters valid login credentials")
    public void theUserEntersValidLoginCredentials() {
    lp.mySendKeys(lp.usernameInputLoginPage, ConfigReader.getProperty("username"));
    lp.mySendKeys(lp.passwordInputLoginPage, ConfigReader.getProperty("password"));

    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        lp.myClick(lp.loginButtonLoginPage);
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        Assert.assertTrue(lp.loginDashboardWelcomeText.isDisplayed());
    }
}
