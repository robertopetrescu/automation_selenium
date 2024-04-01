package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Utils.getSelectorFromFile;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public By acceptGDPR = getSelectorFromFile("acceptGDPR");
    public By signInBtn = getSelectorFromFile("signInBtn");
    public By usernameTxt = getSelectorFromFile("usernameTxt");
    public By passwordTxt = getSelectorFromFile("passwordTxt");
    public By signInFormBtn = getSelectorFromFile("signInFormBtn");
    public By welcomeHeader = getSelectorFromFile("welcomeHeader");
    public By incorrectUsername = getSelectorFromFile("incorrectUsername");

    public boolean isIncorrectUsernameMessageDisplayed(){
        waitForSpinnerToDisappear();
        return findElement(incorrectUsername).getText().contains("Username is invalid.");
}

    public boolean clickSignInFormBtn() {
        click(signInFormBtn);
        return waitForSpinnerToAppear().isDisplayed();
    }

    public boolean enterCredentials(String mail, String password) {
        return sendText(usernameTxt, mail) && sendText(passwordTxt, password);
    }

    public boolean clickSignIn() {
        return click(signInBtn);
    }

    public boolean clickAcceptGDPR() {
        return click(acceptGDPR);
    }
}
