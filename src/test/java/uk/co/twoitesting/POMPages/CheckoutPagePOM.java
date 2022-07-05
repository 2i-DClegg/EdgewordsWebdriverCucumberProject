package uk.co.twoitesting.POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static uk.co.twoitesting.utilities.UtilityFuncs.waitForElementToBeClickable;

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

    @FindBy(css = ".wc_payment_method payment_method_cheque")
    WebElement chequePaymentBtn;

    public void fillInBillingForm(List<Map<String, String>> tableData) {
        String fName = tableData.get(0).get("FirstName");
        String lName = tableData.get(0).get("LastName");
        String houseNumStreetName = tableData.get(0).get("HouseNumberStreetName");
        String town = tableData.get(0).get("Town");
        String postcode = tableData.get(0).get("Postcode");
        String email = tableData.get(0).get("Email");
        String phone = tableData.get(0).get("Phone");

        //Clear any persistent input
        firstNameInput.clear();
        lastNameInput.clear();
        addressFirstLineInput.clear();
        townCityInput.clear();
        postcodeInput.clear();
        emailInput.clear();
        phoneInput.clear();

        firstNameInput.sendKeys(fName);
        lastNameInput.sendKeys(lName);
        addressFirstLineInput.sendKeys(houseNumStreetName);
        townCityInput.sendKeys(town);
        postcodeInput.sendKeys(postcode);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);

//        waitForElementToBeClickable(driver, By.cssSelector(".wc_payment_method payment_method_cheque"), 3 );
//        chequePaymentBtn.click();
    }

    public void completeOrder(){
        //if we declare earlier we get a stale element exception

        WebElement placeOrderBtn = driver.findElement(By.id("place_order"));
        //placeOrderBtn.click();
        System.out.println("Have we hit an error?");
        System.out.println(placeOrderBtn);

    }

}
