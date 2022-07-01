package uk.co.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.twoitesting.utilities.SharedDictionary;

public class ProductPagePOM {

    WebDriver driver;

    public ProductPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "add-to-cart")
    WebElement cartBtn;

    public void addToCart(){
        cartBtn.click();

    }
}
