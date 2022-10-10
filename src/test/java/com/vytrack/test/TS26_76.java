package com.vytrack.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TS26_76 {
    WebDriver driver;
    int index= 0;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    /*
    AC1: Store managers and Sales managers access the Vehicle contracts page.
    Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
    Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System
     */

    public void storeManagerAccessVehicleContractPage() throws InterruptedException {
 ////////////////////////////////////////Login//////////////////////////
        driver.get("https://qa2.vytrack.com/user/login");
        String[] usernames = {"storemanager95", "storemanager96", "storemanager97", "storemanager98"};
        Thread.sleep(2000);
            WebElement username = driver.findElement(By.id("prependedInput"));
            Thread.sleep(2000);
            username.sendKeys(usernames[index]);
            WebElement password = driver.findElement(By.id("prependedInput2"));
            Thread.sleep(2000);
            password.sendKeys("UserUser123");
            WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            loginBtn.click();
////////////////////////////Locating and Selecting Fleet dropdown///////////////////////////////////////////////////
            WebElement fleetDropdown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
            fleetDropdown.click();
            WebElement vehicleContracts = driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
            vehicleContracts.click();
            Thread.sleep(3000);
            String actualTitle = driver.getTitle();
////////////////////Verifying URL////////////////////////////////////////////
            String acctualURL = driver.getCurrentUrl();
            String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
            Assert.assertEquals(acctualURL, expectedURL, "URL is not matching");
/////////////////////////////Verifying title///////////////////////////////////
            String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
            Assert.assertEquals(actualTitle, expectedTitle, "Title is not matching");

// Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void salesManagerAccessVehicleContractPage() throws InterruptedException{
        ////////////////////////////////////////Login//////////////////////////
        driver.get("https://qa2.vytrack.com/user/login");
        String[] usernames = {"salesmanager263", "salesmanager264", "salesmanager265", "salesmanager266"};
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("prependedInput"));
        Thread.sleep(2000);
        username.sendKeys(usernames[3]);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        Thread.sleep(2000);
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
////////////////////////////Locating and Selecting dropdown///////////////////////////////////////////////////
        WebElement fleetDropdown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetDropdown.click();
        WebElement vehicleContracts = driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContracts.click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
////////////////////Verifying URL////////////////////////////////////////////
        String acctualURL = driver.getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        Assert.assertEquals(acctualURL, expectedURL, "URL is not matching");
/////////////////////////////Verifying title///////////////////////////////////
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not matching");

// Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void driverAccessVehicleContractPage() throws InterruptedException {
        ////////////////////////////////////////Login//////////////////////////
        driver.get("https://qa2.vytrack.com/user/login");
        String[] usernames = {"user184", "user185", "user186", "user187","user188", "user189", "user190"};
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("prependedInput"));
        Thread.sleep(2000);
        //driver username "user189" account is locked
        username.sendKeys(usernames[6]);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        Thread.sleep(2000);
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        ////////////////////////////Locating and Selecting dropdown///////////////////////////////////////////////////
        WebElement fleetDropdown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetDropdown.click();
        Thread.sleep(2000);
        WebElement vehicleContracts = driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContracts.click();
        String actualAlertText =driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).getText();
        String expectedAlertText = "You do not have permission to perform this action.";
        Assert.assertEquals(actualAlertText,expectedAlertText,"Alert text not matching");
        driver.quit();
    }
}
