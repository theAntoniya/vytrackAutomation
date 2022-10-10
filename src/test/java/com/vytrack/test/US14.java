package com.vytrack.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class US14 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void managersCanSeeDefaultFiltersOnCampaignPage() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        String[] usernames = {"storemanager95", "storemanager96", "storemanager97", "storemanager98"};
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("prependedInput"));
        Thread.sleep(2000);
        username.sendKeys(usernames[0]);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        Thread.sleep(2000);
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        /////////////////////////////Marketing dropdown/////////////////////
        WebElement marketingDropdown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[6]"));
        marketingDropdown.click();
        ////////////////////////Click the Campaigns under the Marketing///////////////////////
        WebElement campaigns = driver.findElement(By.xpath("//a[@href='/campaign/']/span[.='Campaigns']"));
        campaigns.click();
        /////////////////////////Click the Manage filters button////////////////////////
        WebElement filterButton = driver.findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filterButton.click();
        WebElement manageFilterButton = driver.findElement(By.linkText("Manage filters"));
        manageFilterButton.click();
        //////////////////Verify 5 options are checked by default/////////////////////
        WebElement checkBoxName = driver.findElement(By.xpath("//input[@value='name']"));
        WebElement checkBoxCode = driver.findElement(By.xpath("//input[@value='code']"));
        WebElement checkBoxStartDate = driver.findElement(By.xpath("//input[@value='startDate']"));
        WebElement checkBoxEndDate = driver.findElement(By.xpath("//input[@value='endDate']"));
        WebElement checkBoxBudget = driver.findElement(By.xpath("//input[@value='budget']"));

        System.out.println("checkBoxName.isSelected() = " + checkBoxName.isSelected());
        System.out.println("checkBoxCode.isSelected() = " + checkBoxCode.isSelected());
        System.out.println("checkBoxStartDate.isSelected() = " + checkBoxStartDate.isSelected());
        System.out.println("checkBoxEndDate.isSelected() = " + checkBoxEndDate.isSelected());
        System.out.println("checkBoxBudget.isSelected() = " + checkBoxBudget.isSelected());
        driver.quit();

    }

    @Test
    public void managersCanUnceckAnyFilterOptions() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        String[] usernames = {"storemanager95", "storemanager96", "storemanager97", "storemanager98"};

        WebElement username = driver.findElement(By.id("prependedInput"));

        username.sendKeys(usernames[0]);
        WebElement password = driver.findElement(By.id("prependedInput2"));

        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        /////////////////////////////Marketing dropdown/////////////////////
        WebElement marketingDropdown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[6]"));
        marketingDropdown.click();
        ////////////////////////Click the Campaigns under the Marketing///////////////////////
        WebElement campaigns = driver.findElement(By.xpath("//a[@href='/campaign/']/span[.='Campaigns']"));
        campaigns.click();
        /////////////////////////Click the Manage filters button////////////////////////
        WebElement filterButton = driver.findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filterButton.click();
        WebElement manageFilterButton = driver.findElement(By.linkText("Manage filters"));
        manageFilterButton.click();


        //////////////Uncheck one or more options and verify isSelected/////////////

        WebElement checkBoxName = driver.findElement(By.xpath("//input[@value='name']"));
        checkBoxName.click();
        checkBoxName = driver.findElement(By.xpath("//input[@value='name']"));
        System.out.println("Name checked? -- " + checkBoxName.isSelected());

        WebElement checkBoxCode = driver.findElement(By.xpath("//input[@value='code']"));
        checkBoxCode.click();
        checkBoxCode = driver.findElement(By.xpath("//input[@value='code']"));
        System.out.println("Code checked? -- " + checkBoxCode.isSelected());

       WebElement checkBoxStartDate = driver.findElement(By.xpath("//input[@value='startDate']"));
        checkBoxStartDate.click();
        checkBoxStartDate = driver.findElement(By.xpath("//input[@value='startDate']"));
        System.out.println("Start date checked? -- " + checkBoxStartDate.isSelected());
        driver.quit();


    }
}
