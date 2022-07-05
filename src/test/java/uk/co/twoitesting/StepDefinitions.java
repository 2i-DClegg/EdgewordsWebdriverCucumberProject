package uk.co.twoitesting;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.co.twoitesting.POMPages.*;
import uk.co.twoitesting.utilities.SharedDictionary;
import java.util.List;
import java.util.Map;


import static org.hamcrest.Matchers.*;

public class StepDefinitions {

    private final SharedDictionary sharedDictionary;
    private WebDriver driver;

    public StepDefinitions(SharedDictionary sharedDictionary){
        this.sharedDictionary = sharedDictionary;
        this.driver = (WebDriver) sharedDictionary.getValue("driver");
    }

    @Given("I have logged in with username {string} and password {string}")
    public void i_have_logged_in_with_username_and_password(String username, String password) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.edgewordstraining.co.uk/demo-site/");
        HomePagePOM homepage = new HomePagePOM(driver);
        homepage.goToLogin();
        Thread.sleep(2000);

        LoginPagePOM loginPage = new LoginPagePOM(driver);
        loginPage.enterLogin(username, password);
        Thread.sleep(2000);
    }

    @Given("I have an {string} in the cart")
    public void i_have_an_in_the_cart(String product) {
        MyAccountPOM accountPage = new MyAccountPOM(driver);
        accountPage.searchProduct(product);

        ProductPagePOM productPage = new ProductPagePOM(driver);
        productPage.addToCart();

    }
    //Scenario1
    @When("I apply the discount code {string}")
    public void i_apply_the_discount_code(String discountCode) {
        CartPagePOM cartPage = new CartPagePOM(driver);
        cartPage.applyCoupon(discountCode);

    }
    @Then("The {int}% discount should be applied to the product, and the price should be adjusted for shipping.")
    public void the_discount_should_be_applied_to_the_product_and_the_price_should_be_adjusted_for_shipping(Integer discount) {
        CartPagePOM cartPage = new CartPagePOM(driver);
        MatcherAssert.assertThat(cartPage.getCurrentTotal(), equalTo(cartPage.manualDiscountCalcAndStore(discount)));
    }

    //Scenario2
    @When("I place the order #with the following details")
    public void i_place_the_order_with_the_following_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //TUrn table into a map
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        CartPagePOM cartPage = new CartPagePOM(driver);
        cartPage.goToCheckout();

        CheckoutPagePOM checkoutPage = new CheckoutPagePOM(driver);
        checkoutPage.fillInBillingForm(data);
        Thread.sleep(3000);
        checkoutPage.completeOrder();
        Thread.sleep(3000);

    }
    @Then("I should be taken to a completed order screen which has the order number")
    public void i_should_be_taken_to_a_completed_order_screen_which_has_the_order_number() {
        OrderReceivedPagePOM orderReceivedPage = new OrderReceivedPagePOM(driver, sharedDictionary);
        String orderNumber = orderReceivedPage.storeOrderNumber();
        String orderText = orderReceivedPage.orderConfirmation();

        MatcherAssert.assertThat(orderNumber, is(notNullValue()));
        MatcherAssert.assertThat(orderText, equalTo("Thank you. Your order has been received."));
        orderReceivedPage.goToAccount();
    }
    @Then("I can see this order in my account with the same order number.")
    public void i_can_see_this_order_in_my_account_with_the_same_order_number() {
        // Write code here that turns the phrase above into concrete actions
        MyAccountPOM accountPage = new MyAccountPOM(driver);
        accountPage.goToOrders();

        String storedOrderNum = (String) sharedDictionary.getValue("orderNumber");
        //check that the order number exists by checking the number of elements returned is more than 0
        int numberOfElements = driver.findElements(By.partialLinkText(storedOrderNum)).size();
        MatcherAssert.assertThat(numberOfElements, greaterThan(0));

    }

}
