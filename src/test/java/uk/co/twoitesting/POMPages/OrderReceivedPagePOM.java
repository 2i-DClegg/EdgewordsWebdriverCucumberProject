package uk.co.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.twoitesting.utilities.SharedDictionary;

public class OrderReceivedPagePOM {
    WebDriver driver;
    SharedDictionary sharedDictionary;

    public OrderReceivedPagePOM(WebDriver driver, SharedDictionary sharedDictionary) {
        this.sharedDictionary = sharedDictionary;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".order > strong")
    WebElement orderNumberElement;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    public void storeOrderNumber(){
        String orderNumber = orderNumberElement.getText();
        sharedDictionary.addValue("orderNumber", orderNumber);
    }

    public void goToAccount(){
        myAccountLink.click();
    }
}
