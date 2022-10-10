package com.vytrack.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US_06 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void us6() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        ///////////////////Login//////////////////////////////////////////////////////
        String[] usernames = {"user184", "storemanager96", "storemanager97", "storemanager98"};
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys(usernames[0]);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        ////////////////////////////Locating and Selecting Fleet dropdown///////////////////////////////////////////////////
        WebElement fleetDropdown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetDropdown.click();
        ////////////////////////Vehicles option from Fleet select/////////////////
        WebElement vehicleContracts = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleContracts.click();
///////////////////////////Move mouse over three dots to see menu//////////////////////
        for (int i = 1; i <6 ; i++) {
            WebElement threeDots = driver.findElement(By.xpath("(//td[@class='action-cell grid-cell grid-body-cell']//a[@href='javascript:void(0);'])["+i+"]"));
            Actions action = new Actions(driver);
            action.moveToElement(threeDots).pause(1000).click().perform();
            //Thread.sleep(1000);

        }
        ///////////////////Accessing each element from three dots menu//////////////////////////////
        Thread.sleep(2000);
    WebElement valueOption = driver.findElement(By.xpath("(//ul[@class='nav nav-pills icons-holder launchers-list']/li[@class='launcher-item'])[1]/a[@title='View']"));
        Thread.sleep(2000);
        WebElement editOption = driver.findElement(By.xpath("(//ul[@class='nav nav-pills icons-holder launchers-list']/li[@class='launcher-item'])[2]/a[@title='Edit']"));
        Thread.sleep(2000);
        WebElement deleteOption = driver.findElement(By.xpath("(//ul[@class='nav nav-pills icons-holder launchers-list']/li[@class='launcher-item'])[3]/a[@title='Delete']"));
        Thread.sleep(2000);
        //////////////////Creating List of options attributes value/////////////////////
        List<WebElement> options = Arrays.asList(valueOption, editOption, deleteOption);
        List<String> actualOptionsValueFromPopupMenu = new ArrayList<>();
        for (WebElement eachOption : options) {
            actualOptionsValueFromPopupMenu.add(eachOption.getAttribute("title"));
        }
        List<String> expectedOptionsValueFromPopupMenu = new ArrayList<>(Arrays.asList("View", "Edit", "Delete"));
        //////////////////////////Printing out actual and expected menu options for visual inspection/////////////
        System.out.println("actualOptionsValueFromPopupMenu = " + actualOptionsValueFromPopupMenu);
        System.out.println("expectedOptionsValueFromPopupMenu = " + expectedOptionsValueFromPopupMenu);
///////////////////Verifying options present//////////////////////////////
        Assert.assertEquals(actualOptionsValueFromPopupMenu,expectedOptionsValueFromPopupMenu,"Actual and expected doesn't match");
       driver.quit();
    }
    @Test
    public void verifyAnyCarInfoHas3Dots() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        ///////////////////Login//////////////////////////////////////////////////////
        String[] usernames = {"user184", "storemanager96", "storemanager97", "storemanager98"};
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys(usernames[0]);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        ////////////////////////////Locating and Selecting Fleet dropdown///////////////////////////////////////////////////
        WebElement fleetDropdown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetDropdown.click();
        ////////////////////////Vehicles option from Fleet select/////////////////
        WebElement vehicleContracts = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleContracts.click();
///////////////////////////Move mouse over three dots to see menu//////////////////////

        for (int i = 1; i <26 ; i++) {
            WebElement threeDots = driver.findElement(By.xpath("(//td[@class='action-cell grid-cell grid-body-cell']//a[@href='javascript:void(0);'])["+i+"]"));
            Actions action = new Actions(driver);
            action.moveToElement(threeDots).pause(1000).click().perform();
            //Thread.sleep(1000);

        }

    }
}
