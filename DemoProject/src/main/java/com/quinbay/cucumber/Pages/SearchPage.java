package com.quinbay.cucumber.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SearchPage {

    File file=new File("src/test/resources/Data.properties");
    FileInputStream fileInput=null;

    Properties prop=new Properties();

    WebDriver driver;
    JavascriptExecutor js;
    public SearchPage(WebDriver webDriver) {
        driver=webDriver;
        js=(JavascriptExecutor) driver;
    }

    @FindBy(id="search_query_top")
    WebElement clicksearchtab;
    @FindBy(name="submit_search")
    WebElement clicksearchsubmit;
    @FindBy(xpath = "//div//h1[@class='page-heading  product-listing']")
    WebElement verifysearchresult;
    @FindBy(id = "selectProductSort")
    WebElement clicksort;
    @FindBy(xpath = "//*[@id=\"selectProductSort\"]/option[2]")
    WebElement selectsort;
    @FindBy(xpath = "(//div//img[@class='replace-2x img-responsive'])[9]")
    WebElement clickonimage;
    @FindBy(xpath = "//div//div//label[contains(text(),'Quantity')]")
    WebElement verifyproduct;
    @FindBy(id= "group_1")
    WebElement entersizedetail;
    @FindBy(xpath = "//div//span[contains(text(),'Add to cart')]")
    WebElement clickaddtocart;
    @FindBy(xpath = "//div//div//i[@class='icon-ok']")
    WebElement verifyproductaddedtocart;

    //assertion
    @FindBy(xpath = "(//div//a[@class='product-name'])[9]")
     WebElement productname1;
    @FindBy(xpath = "//div//h1")
    WebElement productnameinthetab;
    @FindBy(xpath = "(//div//span[@class='price product-price'])[2]")
    public WebElement priceactualinsearch;
    @FindBy(id = "our_price_display")
    WebElement priceexpectedinthetab;
    @FindBy(id="quantity_wanted")
    WebElement quantityoftheproduct;
    @FindBy(id="layer_cart_product_quantity")
    WebElement quantitydisplayedinthepopup;


    public String productactuall;
    public String productexpectedd;

    public String priceactual;
    public String priceexpected;

    public String quantityGiven;
    public String quantitydisplayed;


    //public String productName=driver.findElement(By.xpath("(//div//a[@class='product-name'])[11]")).getText();

   // public String actualname=productname1.getText();
   // public String expectedproductname=productnameinthetab.getText();

    //   (//div//a[@class='product-name'])[11] = product name
    //   //div//h1  = product name inside

    //    (//div//span[@class='price product-price'])[2]   = price
    //    id= "our_price_display"  = price displayed

    public void clickSearch() {
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
        clicksearchtab.sendKeys(prop.getProperty("product"));

    }

    public void clickEnter() {
        clicksearchsubmit.click();
    }

    public boolean verifySearchResults() {
        boolean status = false;
        if(verifysearchresult.isDisplayed() ){
            status = true;
        }
        return status;
    }

    public void clickSort() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clicksort.click();
        selectsort.click();

    }

    public void clickOnImage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productactuall = productname1.getText();
        priceactual=priceactualinsearch.getText();
        clickonimage.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productexpectedd = productnameinthetab.getText();
        priceexpected=priceexpectedinthetab.getText();

    }

    public void verifyProductDetails() {

       Assert.assertEquals(productactuall,productexpectedd);
       Assert.assertEquals(priceactual,priceexpected);

    }

    public void enterSize() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        entersizedetail.click();
        entersizedetail.sendKeys(prop.getProperty("Size"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quantityGiven=quantityoftheproduct.getText();


        clickaddtocart.click();

        quantitydisplayed=quantitydisplayedinthepopup.getText();


    }

    public boolean verifyAddToCart() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean status = false;
        if(verifyproductaddedtocart.isDisplayed() ){
            status = true;
        }
        return status;

    }

    public void verifyTheQuantity() {
        Assert.assertEquals(quantitydisplayed,quantityGiven);

    }
}
