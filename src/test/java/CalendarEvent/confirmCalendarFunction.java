package CalendarEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.VyTrack_Utilities;
import utilities.WebDriverFactory;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class confirmCalendarFunction {
    WebDriver driver;
   public static List<String>userNames=
           new ArrayList<>(Arrays.asList("user184","user190","storemanager95","storemanager98","salesmanager263","salesmanager266"));
    public static String password="UserUser123";

   public static String expectedDefaultValue = "1";
   public static String expectedErrorMassage ="This value should not be blank.";


    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://qa1.vytrack.com/user/login
        driver.get("https://qa1.vytrack.com/user/login");
    }

    @Test
    public void testDefaultValue_AC1() throws InterruptedException {


        for (String userName : userNames) {
            VerifyDefaultValue(driver,userName,expectedDefaultValue);
            logOutVyTrack(driver);
            Thread.sleep(1000);

        }
    }

    @Test
    public void testErrorMassage_AC2() throws InterruptedException {

        for (String userName : userNames) {
            VerifyErrorMassage(driver,userName,expectedErrorMassage);
            logOutVyTrack(driver);
            Thread.sleep(1000);

        }



    }


    public static void VerifyDefaultValue(WebDriver driver,String userName,String expectedValue) throws InterruptedException {

        // log in with utility
        VyTrack_Utilities.logInVyTrack(driver,userName,password);

        // locate activities dropdown
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));

        //use action function to mouse move to activities dropdown
       Actions action = new Actions(driver);
       action.moveToElement(activitiesElement).perform();
       // locate the calendar event
       WebElement calendarEvent = driver.findElement(By.linkText("Calendar Events"));

        calendarEvent.click(); // click it to go create go calendar event page

        //locating create calendar event button
        WebElement createCalenderEventBtn = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));

        Thread.sleep(3000);// need time to run to page
        createCalenderEventBtn.click();// clicking it to go create calendar event page

        //locate repeat selection
        Thread.sleep(2000);
        WebElement repeatSelection  = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatSelection.click(); // select it
        //locate repeat every day(s) box
        WebElement repeatEveryDays=driver.findElement(By.xpath("(//label/input[@class='recurrence-subview-control__number'])[1]"));
        // get actual value from repeat every day box
        String actualValue = repeatEveryDays.getAttribute("value");

        // verify the default value
        Assert.assertEquals(actualValue,expectedValue);

    }

    public static void VerifyErrorMassage(WebDriver driver,String userName,String expectedErrorMassage) throws InterruptedException {
        // log in with utility
        VyTrack_Utilities.logInVyTrack(driver,userName,password);

        // locate activities dropdown
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));

        //use action function to mouse move to activities dropdown
        Actions action = new Actions(driver);
        action.moveToElement(activitiesElement).perform();
        // locate the calendar event
        WebElement calendarEvent = driver.findElement(By.linkText("Calendar Events"));

        calendarEvent.click(); // click it to go create go calendar event page

        //locating create calendar event button
        WebElement createCalenderEventBtn = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));

        Thread.sleep(3000);// need time to run to page
        createCalenderEventBtn.click();// clicking it to go create calendar event page

        //locate repeat selection
        Thread.sleep(2000);
        WebElement repeatSelection  = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatSelection.click(); // select it
        //locate repeat every day(s) box
        WebElement repeatEveryDays= driver.findElement(By.xpath("(//label/input[@class='recurrence-subview-control__number'])[1]"));
        repeatEveryDays.clear(); // clear the box
        // locate error massage
        WebElement errorMassage = driver.findElement(By.xpath("//span//span//span[.='This value should not be blank.']"));
        String actualErrorMassageText =errorMassage.getText();//get massage text
        // verify actual massage
        Assert.assertEquals(actualErrorMassageText,expectedErrorMassage);


    }

    public static void logOutVyTrack(WebDriver driver){
        WebElement userDropdown = driver.findElement(By.xpath("//i[@class='fa-caret-down']"));
        userDropdown.click();
        WebElement logOutSelection = driver.findElement(By.xpath("//a[.='Logout']"));
        logOutSelection.click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

    }

    @AfterMethod
    public void tearDownMethod(){
      driver.quit();
    }

}


/*
Test cases #1
Description:  users see the default repeat day as 1
Environment: https://qa1.vytrack.com/user/login
Steps:
Users are on the homepage
Click the “Calendar Events” under the Activities
Click the “Create Calendar Event” button
Check the Repeat checkbox
Verify the repeat number is 1

Test cases #2
Description:  users clear the repat day and see an error message
Environment: https://qa1.vytrack.com/user/login
Steps:
Users are on the homepage
Click the “Calendar Events” under the Activities
Click the “Create Calendar Event” button
Check the Repeat checkbox
Clear(delete) the number 1
Verify the app displays “This value should not be blank.”


 */