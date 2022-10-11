package com.vytrack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TS26_82 {

    WebDriver driver;
int index =0;
    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }


    @Test
    public void verify_Error_Message_For_Managers() throws InterruptedException {
/*
AC1: Store and Sales managers should see an error message “You do not have permission to perform this action.”
when they click the “Vehicle Odometer” module.

 */

String [] userNames = {"storemanager95","storemanager98","salesmanager263","salesmanager266"};

//----> Log in with managers credentials ----
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBox.sendKeys(userNames[index]);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");
        Thread.sleep(2000);
        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();

//----> locating and clicking the “Vehicle Odometers” under the Fleet button
        WebElement selectFleetBtn = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        selectFleetBtn.click();
        Thread.sleep(2000);
        WebElement dropDownOptionBtn = driver.findElement(By.xpath("//div[@style='max-height: 272px;']//li[4]"));
        dropDownOptionBtn.click();

//----> Verifying the managers see error message: “You do not have permission to perform this action.”
        String expectedErrorTxt = "You do not have permission to perform this action.";
        String actualErrorTxt = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).getText();
        Assert.assertEquals(actualErrorTxt, expectedErrorTxt, "Error massage is not matching or Doesn't showing up");



    }



    @Test
    public void verify_Drivers_On_Page1() throws InterruptedException {
        /*
        AC2: Drivers should see the default page as 1.
         */
        String[] drivesUserNames = {"user184","user190"};
 //---> Log in with drivers credentials
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBox.sendKeys(drivesUserNames[index]);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");
        Thread.sleep(2000);
        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();
//---->From home page, clicking “Vehicle Odometers” button under the Fleet
        WebElement selectFleetBtn = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        selectFleetBtn.click();
        Thread.sleep(2000);
        WebElement dropDownOptionBtn = driver.findElement(By.xpath("//div[@style='max-height: 272px;']//li[4]"));
        dropDownOptionBtn.click();

//---->Verifying Drivers default page number is 1
        WebElement page1 = driver.findElement(By.xpath("//input[@value='1']"));

        Assert.assertEquals(page1.getAttribute("value"), "1", "Value is Not matching");

    }


    @Test
    public void verify_Drivers_see_25per_page() throws InterruptedException {
/*
AC3: Divers should see the View Per Page is 25 by default.
 */
 //---> Log in with drivers credentials
        String[] driversUserNames = {"user184","user190"};
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBox.sendKeys(driversUserNames[index]);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");
        Thread.sleep(2000);
        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();

//---->From home page, clicking “Vehicle Odometers” button under the Fleet
        WebElement selectFleetBtn = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        selectFleetBtn.click();
        WebElement dropDownOptionBtn = driver.findElement(By.xpath("//div[@style='max-height: 272px;']//li[4]"));
        Thread.sleep(2000);
        dropDownOptionBtn.click();
//--> Verifying driver's default view per page is 25
        WebElement perPage25 = driver.findElement(By.xpath("//button[@data-toggle='dropdown']"));
        Assert.assertEquals(perPage25.getText(), "25", "Value is not matching");

    }
    @AfterTest
    public void teardownMethod(){
        driver.quit();
    }
}