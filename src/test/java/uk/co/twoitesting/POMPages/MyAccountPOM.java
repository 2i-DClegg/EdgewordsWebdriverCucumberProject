package uk.co.twoitesting.POMPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.twoitesting.utilities.SharedDictionary;

public class MyAccountPOM {
    WebDriver driver;

    public MyAccountPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "woocommerce-product-search-field-0")
    WebElement searchBox;

    public void searchProduct(String product){
        searchBox.sendKeys(product + Keys.ENTER);
    }

}
