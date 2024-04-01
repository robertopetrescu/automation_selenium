package Tests;

import Objects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static Tests.BeforeAfterSteps.driver;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(driver);

    @Given("I open Etsy page")
    public void openPage(){
        driver.get("https://www.etsy.com/");
    }

    @And("I accept GDPR")
    public void acceptGDPR(){
        Assert.assertTrue(loginPage.clickAcceptGDPR(), "Could not click on Accept GDPR");
    }

    @When("I open Sign In form")
    public void signInBtn(){
        Assert.assertTrue(loginPage.clickSignIn(), "Could not click on Sign In menu");
    }

    @And("I enter {} and {} for user")
    public void iEnterCredentials(String mail, String password){
        Assert.assertTrue(loginPage.enterCredentials(mail, password), "Could not enter credentials");
    }

    @And("I click on Sign In button")
    public void clickSignIn(){
        Assert.assertTrue(loginPage.clickSignInFormBtn(), "Could not click on Sign In button");
    }

    @And("I check Welcome message")
    public void checkWelcomeMessage(){
        Assert.assertEquals(loginPage.getTextFromElement(loginPage.welcomeHeader), "Welcome to Etsy, roberto!");
    }

    @Then("I check Incorrect username message")
    public void iCheckIncorrectUsernameMessage() {
        Assert.assertTrue(loginPage.isIncorrectUsernameMessageDisplayed(), "Incorrect message not found");
    }
}
