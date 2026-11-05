package StepDefinitions;

import Pages.LeftNav;
import Pages.RegistrationPage;
import Utilities.ConfigReader;
import Utilities.FakerClass;
import Utilities.GWD;
import com.github.javafaker.Faker;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class _RegisterSteps_ {

    Faker faker = new Faker();
    RegistrationPage rp = new RegistrationPage(GWD.getDriver());
    LeftNav ln = new LeftNav(GWD.getDriver());
    @Given("the user is on the ParaBank home page")
    public void theUserIsOnTheParaBankHomePage() {
    GWD.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @When("the user clicks on the Register link")
    public void theUserClicksOnTheRegisterLink() {
        ln.myClick(ln.registerButton);
    }

    @And("the user fills out the registration form with valid information")
    public void theUserFillsOutTheRegistrationFormWithValidInformation() {
        rp.mySendKeys(rp.firstnameInputRegisterPage, FakerClass.firstName());
        rp.mySendKeys(rp.lastnameInputRegisterPage, FakerClass.lastName());
        rp.mySendKeys(rp.addressInputRegisterPage,faker.address().fullAddress());
        rp.mySendKeys(rp.cityInputRegisterPage,faker.address().city());
        rp.mySendKeys(rp.stateInputRegisterPage,faker.address().state());
        rp.mySendKeys(rp.zipCodeInputRegisterPage,faker.address().zipCode());
        rp.mySendKeys(rp.phoneNumberInputRegisterPage,faker.phoneNumber().cellPhone());
        rp.mySendKeys(rp.ssnInputRegisterPage,faker.idNumber().ssnValid());
        rp.mySendKeys(rp.usernameInputRegisterPage,faker.name().username()+System.currentTimeMillis());
        rp.mySendKeys(rp.passwordInputRegisterPage,ConfigReader.getProperty("password"));
        rp.mySendKeys(rp.confirmPasswordInputRegisterPage,ConfigReader.getProperty("password"));

    }

    @And("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
    rp.myClick(rp.registerButtonOnTheRegisterPage);
    }

    @Then("the user should see a successful registration message")
    public void theUserShouldSeeASuccessfulRegistrationMessage() {
        rp.textAssert(rp.successfullyTextRegister,"successfully");
    }

    @And("the user should see a welcome message containing their username")
    public void theUserShouldSeeAWelcomeMessageContainingTheirUsername() {
        Assert.assertTrue(rp.registerPageWelcomeText.isDisplayed());
    }
}
