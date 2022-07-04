package uk.co.twoitesting.POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.twoitesting.utilities.SharedDictionary;

public class CartPagePOM {
    WebDriver driver;
    SharedDictionary sharedDictionary;

    public CartPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "coupon_code")
    WebElement couponInput;

    @FindBy(name = "apply_coupon")
    WebElement couponButton;

    @FindBy(css="[data-title=Subtotal] span.woocommerce-Price-amount")
    WebElement subTotal;

    @FindBy(css="[data-title=Shipping] span.woocommerce-Price-amount")
    WebElement shippingCost;

    @FindBy(css="[data-title=Total] > Strong > span.woocommerce-Price-amount  ")
    WebElement totalCost;


    public void applyCoupon(String couponCode){
        couponInput.sendKeys(couponCode);
        couponButton.click();
    }

    private double priceToNum(String textPrice){
        String filteredText = textPrice.replace("£", "");
        return Double.parseDouble(filteredText);
    }

    public double manualDiscountCalcAndStore(int discountRate){


        double shippingRate = priceToNum(shippingCost.getText());
        double subTotalNum = priceToNum(subTotal.getText());
        return (subTotalNum * (100 - discountRate)/100) + shippingRate;
    }

    public double getCurrentTotal(){
        return priceToNum(totalCost.getText());
    }



}
