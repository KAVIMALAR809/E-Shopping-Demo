package com.quinbay.cucumber.Steps;

import io.cucumber.java.en.Given;

import com.quinbay.cucumber.Pages.*;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartSteps {
    static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    CartPage cart;


    @Given("user is in home page")
    public void userIsInAccountPage(){
        driver=LoginSteps.driver;
        cart=new CartPage(driver);
        cart= PageFactory.initElements(driver,CartPage.class);
    }

    @When("the user click the cart tab")
    public void theUserClickTheCartTab() {
        cart.clickCartTab();
    }



    @And("the user click Proceed to checkout")
    public void theUserClickProceedToCheckout() {
        cart.clickProceedTocheckout();
    }

    @And("the user select the address and click proceed to checkout")
    public void theUserSelectTheAddressAndClickProceedToCheckout() {
        cart.clickProceedAddress();
    }

    @Then("the user will be in shipping page")
    public void theUserWillBeInShippingPage() {
        assertThat("Address is incorrect",cart.verifyShippingPageIsReached());
        
    }

    @When("the user agree the terms and conditions and click on Proceed to checkout")
    public void theUserAgreeTheTermsAndConditionsAndClickOnProceedToCheckout() {
        cart.clickTermsAndConditions();
    }

    @Then("the user will be on payment page")
    public void theUserWillBeOnPaymentPage() {
        cart.verifyTheTotalPrice();
        
    }

    @When("the user select the payment option")
    public void theUserSelectThePaymentOption() {
        cart.clickPaymentMethod();
    }

    @Then("the user will be order confirmation page")
    public void theUserWillBeOrderConfirmationPage() {
        cart.verifyTheTotalPriceWithCarrier();
    }

    @When("the user click on I confirm the order")
    public void theUserClickOnIConfirmTheOrder() {
        cart.clickConfirm();
    }

    @Then("the order is placed successfully")
    public void theOrderIsPlacedSuccessfully() {

        assertThat("order is not placed",cart.verifyOrderPlaced());
        cart.verifyTheOrderDetails();
        cart.closingTheTab();

    }



}
