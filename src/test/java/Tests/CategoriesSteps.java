package Tests;

import Objects.CategoriesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static Tests.BeforeAfterSteps.driver;

public class CategoriesSteps {
    private final CategoriesPage categoriesPage = new CategoriesPage(driver);

    @When("I click on Categories menu")
    public void clickCategoryMenu(){
        Assert.assertTrue(categoriesPage.clickCategoriesMenu(), "Could not click on Categories menu");
    }

    @And("I select {} category from menu")
    public void selectCategory(String category){
        Assert.assertTrue(categoriesPage.clickCategory(category), String.format("Could not click on category %s", category));
    }

    @And("I check category header for {}")
    public void checkCategoryHeader(String category){
        Assert.assertEquals(categoriesPage.getTextFromElement(categoriesPage.categoryHeader), category, "Category header is not correct");
    }
}
