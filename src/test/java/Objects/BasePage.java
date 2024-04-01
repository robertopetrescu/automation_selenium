package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.Utils.getSelectorFromFile;

public class BasePage {

    private final WebDriver driver;

    public By spinnerSelector = getSelectorFromFile("spinnerSelector");
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public boolean click(By locator){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(locator)).click();
            return true;
        } catch(Exception e){
            return false;
        }

    }

    public boolean sendText(By locator, String textToSend){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            findElement(locator).sendKeys(textToSend);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public String getTextFromElement(By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    public List<WebElement> findElements(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public void waitForSpinnerToDisappear(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(spinnerSelector));

    }

    public WebElement waitForSpinnerToAppear() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(spinnerSelector));
    }
}
