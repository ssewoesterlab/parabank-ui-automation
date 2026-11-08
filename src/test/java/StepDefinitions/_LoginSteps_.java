package StepDefinitions;

import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class _LoginSteps_ {
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

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        lp.mySendKeys(lp.usernameInputLoginPage, username);
        lp.mySendKeys(lp.passwordInputLoginPage, password);
    }

    @Then("the user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {
        lp.webElementAssert(lp.errorMessage);
        Assert.assertTrue(lp.errorMessage.isDisplayed());
    }

}
