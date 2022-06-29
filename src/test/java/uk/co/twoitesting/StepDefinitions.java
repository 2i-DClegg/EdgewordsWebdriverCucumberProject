package uk.co.twoitesting;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    @Given("I have logged in with username {string} and password {string}")
    public void i_have_logged_in_with_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I have an item in the cart")
    public void i_have_an_item_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //Scenario1
    @When("I apply the discount code {string}")
    public void i_apply_the_discount_code(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The {int}% discount should be applied to the product, and the price should be adjusted for shipping.")
    public void the_discount_should_be_applied_to_the_product_and_the_price_should_be_adjusted_for_shipping(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //Scenario2
    @When("I place the order #with the following details")
    public void i_place_the_order_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should be taken to a completed order screen which has the order number")
    public void i_should_be_taken_to_a_completed_order_screen_which_has_the_order_number() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I can see this order in my account with the same order number.")
    public void i_can_see_this_order_in_my_account_with_the_same_order_number() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
