package uk.co.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.twoitesting.utilities.SharedDictionary;

public class LoginPagePOM {

    private WebDriver driver;

    public LoginPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "button[name='login']")
    WebElement loginButton;

    private void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    private void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void enterLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        loginButton.click();
    }
}
