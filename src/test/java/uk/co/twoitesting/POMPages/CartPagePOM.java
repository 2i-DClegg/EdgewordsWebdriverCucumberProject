package uk.co.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.twoitesting.utilities.SharedDictionary;

public class CartPagePOM {

    WebDriver driver;
    private final SharedDictionary sharedDictionary;

    public CartPagePOM(WebDriver driver, SharedDictionary sharedDictionary) {
        this.sharedDictionary = sharedDictionary;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-title=Subtotal]")
    WebElement subtotal;

    @FindBy(css = "[data-title=shipping] span")
    WebElement shippingPrice;

    @FindBy(css = "#coupon_code")
    WebElement couponInput;

    @FindBy(name = "apply_coupon")
    WebElement applyCouponBtn;

    private double stringToNum(String price){
        String filteredText = price.replace("£", "");
        return Double.parseDouble(filteredText);
    }

    private double applyReductionAndShipping (){
        double oldPrice = stringToNum(subtotal.getText());
        double shipping = stringToNum(shippingPrice.getText());
        double voucherRate = 0.85;
        return (oldPrice * voucherRate) + shipping;
    }

    private void storeOldPrice(){
        sharedDictionary.addValue("expectedPrice", applyReductionAndShipping());
    }

    public void applyDiscountCode(String discountCode){
        couponInput.sendKeys(discountCode);
        applyCouponBtn.click();
    }

}
