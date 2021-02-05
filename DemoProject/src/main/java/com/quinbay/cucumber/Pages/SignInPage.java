package com.quinbay.cucumber.Pages;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class SignInPage {
    File file=new File("src/test/resources/Data.properties");
    FileInputStream fileInput=null;

    Properties prop=new Properties();


    WebDriver driver;
    JavascriptExecutor js;
    public SignInPage(WebDriver webDriver) throws IOException {
        driver=webDriver;
        js=(JavascriptExecutor) driver;
    }

    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
    WebElement signintab;
    @FindBy(id="email")
    WebElement enteremail;
    @FindBy(id="passwd")
    WebElement enterpassword;
    @FindBy(id="SubmitLogin")
    WebElement submitbutton;
    @FindBy(xpath = "//div//a[@class='account']")
    WebElement verifyLogin;

    //div[@class='header_user_info']




    public void userClickSignIn() throws InterruptedException {

        Thread.sleep(1000);
        signintab.click();
    }

    public void userEnterCredentials() {
        try{
            fileInput=new FileInputStream(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();

        }

        try{
            prop.load(fileInput);
        }catch(IOException e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enteremail.sendKeys(prop.getProperty("email"));
        enterpassword.sendKeys(prop.getProperty("password"));
    }

    public void clickOnSubmit() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitbutton.click();
    }

    public boolean verifyLogin() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean status = false;
        if(verifyLogin.isDisplayed() ){
            status = true;
        }
        return status;
    }
}
