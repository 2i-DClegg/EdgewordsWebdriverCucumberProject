package uk.co.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
    WebDriver driver;

    public HomePagePOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Dimiss")
    WebElement dismissBtn;

    @FindBy(linkText = "My account")
    WebElement myAccount;

    private void dismissPopUp(){
        dismissBtn.click();
    }

    private void goToMyAccount(){
        myAccount.click();
    }

    public void goToLogin(){
        dismissPopUp();
        goToMyAccount();
    }
}
