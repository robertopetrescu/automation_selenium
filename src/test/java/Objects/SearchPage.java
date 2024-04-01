package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Utils.getSelectorFromFile;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver){
        super(driver);
    }
    public By searchTxt = getSelectorFromFile("searchTxt");
    public By searchBtn = getSelectorFromFile("searchBtn");
    public By listingLink = getSelectorFromFile("listingLink");

    public boolean searchKeyword(String text){
        return sendText(searchTxt, text);
    }

}
