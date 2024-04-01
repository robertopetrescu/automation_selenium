package Tests;

import Objects.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static Tests.BeforeAfterSteps.driver;

public class SearchSteps {

    private final SearchPage searchPage = new SearchPage(driver);

    @When("I search for {}")
    public void searchProduct(String text){
        Assert.assertTrue(searchPage.searchKeyword(text), "There was an error sending the text" );
    }

    @And("I click on search product button")
    public void clickSearchBtn(){
        Assert.assertTrue(searchPage.click(searchPage.searchBtn), "There was an error clicking on Search button");
    }

    @Then("Product list is greater than {int}")
    public void productListGreaterThan(int size){
        Assert.assertTrue(searchPage.findElements(searchPage.listingLink).size() > size, "No elements found");
    }


}
