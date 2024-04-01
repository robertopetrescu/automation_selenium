package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Utils.getSelectorFromFile;

public class CategoriesPage extends BasePage{
    public CategoriesPage(WebDriver driver){
        super(driver);
    }
    public By categories = getSelectorFromFile("categories");
    public By categoryHeader = getSelectorFromFile("categoryHeader");

    public boolean clickCategoriesMenu() {
        return click(categories);
    }

    public boolean clickCategory(String category) {
        return click(By.xpath(String.format("//a[contains(text(),'%s')]", category)));
    }
}
