package StepDefinitions;

import Pages.LeftNav;
import Pages.ParentPage;
import Pages.PayingPage;
import Utilities.FakerClass;
import Utilities.GWD;
import com.github.javafaker.Faker;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class _PayingSteps_ {
    LeftNav ln = new LeftNav(GWD.getDriver());
    PayingPage pp = new PayingPage(GWD.getDriver());
    Faker faker = new Faker();
    String accountNumber = faker.number().digits(8);

    @Given("the user opens the Bill Pay page")
    public void theUserOpensTheBillPayPage() {
        ln.myClick(ln.billPayButton);
    }


    @When("the user enters {string} as the payee name")
    public void theUserEntersAsThePayeeName(String name) {
        pp.mySendKeys(pp.nameInput, name);
    }

    @And("the user fills in the other payee details with random values")
    public void theUserFillsInTheOtherPayeeDetailsWithRandomValues() {
        pp.mySendKeys(pp.addressInput, faker.address().fullAddress());
        pp.mySendKeys(pp.cityInput, faker.address().city());
        pp.mySendKeys(pp.stateInput, faker.address().state());
        pp.mySendKeys(pp.zipCodeInput, faker.address().zipCode());
        pp.mySendKeys(pp.phoneInput, faker.phoneNumber().cellPhone());
        pp.mySendKeys(pp.accountNumberInput,accountNumber);
        pp.mySendKeys(pp.accountNumberVerifyInput,accountNumber);
    }

    @And("the user enters {string} as the amount")
    public void theUserEntersAsTheAmount(String amount) {
        pp.mySendKeys(pp.amountInput,amount);
    }

    @And("the user selects the payment account")
    public void theUserSelectsThePaymentAccount() {
        Select select = new Select(pp.fromAccountSelect);
        select.selectByIndex(0);
    }

    @And("the user clicks the pay button")
    public void theUserClicksThePayButton() {
        pp.myClick(pp.sendPaymentButton);
    }

    @Then("the payment should be completed successfully")
    public void thePaymentShouldBeCompletedSuccessfully() {
        GWD.wait.until(ExpectedConditions.visibilityOf(pp.paymentCompleteText));
        Assert.assertTrue(pp.paymentCompleteText.isDisplayed());
    }


}
