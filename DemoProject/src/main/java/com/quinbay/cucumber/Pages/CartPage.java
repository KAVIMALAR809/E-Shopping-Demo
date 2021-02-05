package com.quinbay.cucumber.Pages;

import io.cucumber.java.bs.A;
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

public class CartPage {



    File file=new File("src/test/resources/Data.properties");
    FileInputStream fileInput=null;

    Properties prop=new Properties();

    WebDriver driver;
    JavascriptExecutor js;
    public CartPage(WebDriver webDriver) {
        driver=webDriver;
        js=(JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//div//div//b[contains(text(),'Cart')]")
    WebElement clickcart;
    @FindBy(xpath = "(//div//a//span[contains(text(),'Proceed to checkout')])[2]")
    WebElement clickproceedtocheckout;

    //temporary
    @FindBy(xpath = "(//div//div//li//a[contains(text(),'T-shirts')])[2]")
    WebElement clicktshirt;
    @FindBy(xpath = "//div//span[contains(text(),'Add to cart')]")
    WebElement clickaddtocart;
    @FindBy(xpath = "//div//a[@class='btn btn-default button button-medium']")
    WebElement clickpopup;
    @FindBy(xpath = "//div//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement clickproceededtocheckoutinsummary;
    @FindBy(name = "processAddress")
    WebElement clickproceedaddress;
    @FindBy(name = "cgv")
    WebElement clicktermsandcondition;
    @FindBy(name = "processCarrier")
    WebElement clickproceedcarrier;
    @FindBy(xpath = "//div//a[@class='cheque']")
    WebElement clickpaymentmethod;
    @FindBy(xpath = "//div//button[@class='button btn btn-default button-medium']")
    WebElement clickconfirmorder;
    @FindBy(xpath = "//div//p[@class='alert alert-success']")
    WebElement verifyorderplacedornot;
    @FindBy(xpath = "//div//img[@class='replace-2x img-responsive']")
    WebElement clickonimage;
    @FindBy(xpath = "//div//p[@class='carrier_title']")
    WebElement verifyaddressdisplayed;

//close the tab
    @FindBy(xpath = "//div//div//span[@class='cross']")
    WebElement closepopup;

    //address
    @FindBy(xpath = "//div//p//a//span[contains(text(),'Add a new address')]")
    WebElement clickaddaddress;
    @FindBy(id="address1")
    WebElement address1;
    @FindBy(id="address2")
    WebElement address2;
    @FindBy(id="city")
    WebElement cityname;
    @FindBy(id="id_state")
    WebElement stateselectdropdown;
    @FindBy(xpath = "//*[@id=\"id_state\"]/option[2]")
    WebElement selectstate;
    @FindBy(id="postcode")
    WebElement postcode;
    @FindBy(id="phone")
    WebElement homephone;
    @FindBy(id="phone_mobile")
    WebElement phonenumber;
    @FindBy(id="alias")
    WebElement aliasaddress;
    @FindBy(name = "submitAddress")
    WebElement submitAddress;
    @FindBy(name = "id_address_delivery")
    WebElement selectaddress;
    @FindBy(xpath = "//*[@id=\"id_address_delivery\"]/option[2]")
    WebElement choosingaddressfromdropdown;


    //Assertion Webelements
    @FindBy(xpath = "(//div//span[@class='price product-price'])[2]")
    WebElement priceactualinsearch;
    @FindBy(xpath = "(//div//span[@class='price'])[3]")
    WebElement priceinthesummarytab;
    @FindBy(xpath = "(//div//span[@class='price'])[4]")
    WebElement pricefproductintotal;


    //assertion of total price
    @FindBy(id = "total_price_without_tax")
    WebElement priceinsummarypagee;
    @FindBy(id = "amount")
    WebElement priceinorderconfirmation;

    //assertion of order placed price
    @FindBy(xpath = "//div//span[@class='price']")
    WebElement lastdisplayedprice;





    public String priceinthepaymentpage;
    public String priceinthesummarypage;

    public String totalpriceinthesummarytab;
    public String totalpriceinconfirmationpage;

    public String priceattheorderplacedpage;



    public void clickCartTab() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closepopup.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickcart.click();
       priceinthesummarypage=priceinthesummarytab.getText();
        totalpriceinthesummarytab=priceinsummarypagee.getText();

    }




    public void clickProceedTocheckout() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        js.executeScript("window.scrollBy(0,2000)");
        clickproceededtocheckoutinsummary.click();



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void clickProceedAddress() {
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

        clickaddaddress.click();
        address1.sendKeys(prop.getProperty("address11"));
        address2.sendKeys(prop.getProperty("address21"));
        cityname.sendKeys(prop.getProperty("cityy"));
        stateselectdropdown.click();
        selectstate.click();
        postcode.sendKeys(prop.getProperty("zip"));
        homephone.sendKeys(prop.getProperty("homephonee"));
        phonenumber.sendKeys(prop.getProperty("mobilee"));
        aliasaddress.sendKeys(prop.getProperty("aliass"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitAddress.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectaddress.click();
        choosingaddressfromdropdown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }







        clickproceedaddress.click();

    }
    public boolean verifyShippingPageIsReached() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean status = false;
        if(verifyaddressdisplayed.isDisplayed() ){
            status = true;
        }
        return status;
    }

    public void clickTermsAndConditions() {
        clicktermsandcondition.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickproceedcarrier.click();
        priceinthepaymentpage=pricefproductintotal.getText();
    }
    public void verifyTheTotalPrice() {
        Assert.assertEquals(priceinthepaymentpage,priceinthesummarypage);

    }

    public void clickPaymentMethod() {
        js.executeScript("window.scrollBy(0,1000)");


        clickpaymentmethod.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        totalpriceinconfirmationpage=priceinorderconfirmation.getText();


    }

    public void verifyTheTotalPriceWithCarrier() {
        //Assert.assertEquals(totalpriceinconfirmationpage,totalpriceinthesummarytab);

    }

    public void clickConfirm() {

        clickconfirmorder.click();
        priceattheorderplacedpage=lastdisplayedprice.getText();


    }

    public boolean verifyOrderPlaced() {
        boolean status = false;
        if(verifyorderplacedornot.isDisplayed() ){
            status = true;
        }
        return status;

    }

    public void verifyTheOrderDetails() {

        Assert.assertEquals(priceattheorderplacedpage,totalpriceinconfirmationpage);
    }


    public void closingTheTab() {
        driver.close();
    }


}










// js.executeScript("window.scrollBy(0,2000)");
// clickproceedtocheckout.click();
// clicktshirt.click();
// js.executeScript("window.scrollBy(0,500)");


// clickonimage.click();
// clickaddtocart.click();
// clickpopup.click();
     /*   try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      */


//div//span[@class='price']     = price in the summary

//   total_price_without_tax  ==price in summary

// total_price=price in payment


//   amount   = amount in order placed pge
