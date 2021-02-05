package com.quinbay.cucumber.Steps;


import com.quinbay.cucumber.Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
public class LoginSteps {
    static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    SignInPage signin;

    @Given("user login with valid credentials")
    public void userLoginToWebsite() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, SECONDS);
        driver.get("http://automationpractice.com/index.php");
        signin=new SignInPage(driver);
        signin= PageFactory.initElements(driver,SignInPage.class);
    }

    @When("user click sign in tab")
    public void userClickSignInTab() throws InterruptedException {
        signin.userClickSignIn();
    }
    @When("the user enter the email address and password")
    public void the_user_enter_the_email_address_and_password() {
        signin.userEnterCredentials();

    }

    @When("the user click Sign in")
    public void the_user_click_sign_in() {
        signin.clickOnSubmit();

    }

    @Then("the user lands on My Account page")
    public void the_user_lands_on_my_account_page() {

        assertThat("Login unsuccessful", signin.verifyLogin());
    }

}
