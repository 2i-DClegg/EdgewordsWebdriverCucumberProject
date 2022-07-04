package uk.co.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPagePOM {
    WebDriver driver;

    public CheckoutPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "billing_first_name")
    WebElement firstNameInput;

    @FindBy(id= "billing_last_name")
    WebElement lastNameInput;

    @FindBy(id = "select2-billing_country-container")
    WebElement countrySelect;

    @FindBy(id = "billing_address_1")
    WebElement addressFirstLineInput;

    @FindBy(id = "billing_city")
    WebElement townCityInput;

    @FindBy(id = "billing_postcode")
    WebElement postcodeInput;

    @FindBy(id = "billing_phone")
    WebElement phoneInput;

    @FindBy(id = "billing_email")
    WebElement emailInput;

    @FindBy(id = "payment_method_cheque")
    WebElement chequePayment;

    @FindBy(id="place_order")
    WebElement placeOrderButton;

    public void fillInBillingFrom() {

    }
}
