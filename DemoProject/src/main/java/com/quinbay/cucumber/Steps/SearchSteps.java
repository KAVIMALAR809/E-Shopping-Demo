package com.quinbay.cucumber.Steps;


import com.quinbay.cucumber.Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSteps {
    static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    SearchPage search;

    @Given("user is in My Account page")
    public void userIsInAccountPage(){
        driver=LoginSteps.driver;
        search=new SearchPage(driver);
        search= PageFactory.initElements(driver,SearchPage.class);
    }

    @When("user search for a product in search tab")
    public void userSearchForAProductInSearchTab() {
        search.clickSearch();
    }

    @And("hit enter")
    public void hitEnter() {
        search.clickEnter();
    }

    @Then("the user will be able to see the search results")
    public void theUserWillBeAbleToSeeTheSearchResults() {
        assertThat("search result not found", search.verifySearchResults());
    }

    @When("the user sort the products")
    public void theUserSortTheProducts() {
        search.clickSort();
    }

    @And("the user click the Quick View tab on the selected product")
    public void theUserClickTheQuickViewTabOnTheSelectedProduct() {
        search.clickOnImage();
    }

    @Then("a pop up with product details will be displayed")
    public void aPopUpWithProductDetailsWillBeDisplayed() {
        search.verifyProductDetails();
    }

    @When("the user select the size and click Add to Cart")
    public void theUserSelectTheSizeAndClickAddToCart() {
        search.enterSize();
    }

    @Then("the product is added to the cart")
    public void theProductIsAddedToTheCart() {
        assertThat("The product is not added to the cart",search.verifyAddToCart());
        search.verifyTheQuantity();
    }
}
