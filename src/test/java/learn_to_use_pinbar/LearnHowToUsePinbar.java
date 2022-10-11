package learn_to_use_pinbar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;



/* US: TS26-75
As a user, I want to learn how to use the pinbar.

AC1: when users click click the “Learn how to use this space” link on the homepage, users should see:
“How To Use Pinbar” and
“Use pin icon on the right top corner of page to create fast access link in the pinbar.”

AC2: users should see an image on the page.
[in automation testing, just verify the image source.]
Expected source: https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg

Steps:
1. Users are on the homepage
2. Click the Learn how to use this space message
3. Expected Result: Users see 2 messages:
    “How To Use Pinbar”
    “Use the pin icon on the right top corner of page to create fast access link in the pinbar.”
    User views picture with source: https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg

 */
public class LearnHowToUsePinbar {

    WebDriver driver;

    //Sets up new Chrome driver for tests
    @BeforeMethod
    public void setUpBrowser(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Data bank of Truck Driver logins
    @DataProvider (name="truckDriverLogin")
    public Object[][] driverLogin() {

        return new Object[][]{
            {"user184", "UserUser123"},
            {"user190", "UserUser123"}
        } ;
    }

    @Test (dataProvider="truckDriverLogin")
    public void truckDriversLearnToUsePinbar(String username,String password){
        driver.get("https://qa1.vytrack.com/user/login");

        //Locating username and password elements to login as Truckdriver
        WebElement usernameInput=driver.findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement passwordInput=driver.findElement(By.xpath("//input[@id='prependedInput2']"));


        //Sending login and password keys
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);


        //Locating 'Learn how to use this space' button
        WebElement learnHowToUseThisSpaceBtn=driver.findElement(By.xpath("//div[@class='pin-bar-empty']//a"));
        learnHowToUseThisSpaceBtn.click();

        //Locating text in headers and creating Strings for expected text for AC1
        String header1ActTxt=driver.findElement(By.xpath("(//h3)[2]")).getText();
        String header1ExpTxt="How To Use Pinbar";

        String header2ActTxt=driver.findElement(By.xpath("(//p)[1]")).getText();
        String header2ExpTxt="Use pin icon on the right top corner of page to create fast access link in the pinbar.";

        //Verifying correct titles for both headers for AC1
        Assert.assertEquals(header1ExpTxt,header1ActTxt);
        Assert.assertEquals(header2ExpTxt,header2ActTxt);

        //Locating image source and declaring expected source for AC2
        String actSourceOfImage=driver.findElement(By.xpath("//img")).getAttribute("src");
        String expSourceOfImage="https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";

        //Verifying image source for AC2
        Assert.assertEquals(actSourceOfImage,expSourceOfImage);
    }

    @DataProvider (name="storeManagerLogin")
    public Object[][] storeManagerLogin() {

        return new Object[][]{
                {"storemanager95", "UserUser123"},
                {"storemanager98", "UserUser123"}
        } ;
    }

    @Test (dataProvider="storeManagerLogin")
    public void storeManagersLearnToUsePinbar(String username,String password){
        driver.get("https://qa1.vytrack.com/user/login");

        //Locating username and password elements to login as Store Manager
        WebElement usernameInput=driver.findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement passwordInput=driver.findElement(By.xpath("//input[@id='prependedInput2']"));

        //Sending login and password keys
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);

        //Locating 'Learn how to use this space' button
        WebElement learnHowToUseThisSpaceBtn=driver.findElement(By.xpath("//div[@class='pin-bar-empty']//a"));
        learnHowToUseThisSpaceBtn.click();

        //Locating headers for AC1
        String header1ActTxt=driver.findElement(By.xpath("(//h3)[2]")).getText();
        String header1ExpTxt="How To Use Pinbar";

        String header2ActTxt=driver.findElement(By.xpath("(//p)[1]")).getText();
        String header2ExpTxt="Use pin icon on the right top corner of page to create fast access link in the pinbar.";

        //Verifying correct titles for both headers for AC1
        Assert.assertEquals(header1ExpTxt,header1ActTxt);
        Assert.assertEquals(header2ExpTxt,header2ActTxt);

        //Locating image source and declaring expected source for AC2
        String actSourceOfImage=driver.findElement(By.xpath("//img")).getAttribute("src");
        String expSourceOfImage="https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";

        //Verifying image source for AC2
        Assert.assertEquals(actSourceOfImage,expSourceOfImage);
    }

    @DataProvider (name="salesManagerLogin")
    public Object[][] salesManagerLogin() {

        return new Object[][]{
                {"salesmanager263", "UserUser123"},
                {"salesmanager266", "UserUser123"}
        } ;
    }

    @Test (dataProvider="salesManagerLogin")
    public void salesManagersLearnToUsePinbar(String username,String password){
        driver.get("https://qa1.vytrack.com/user/login");

        //Locating username and password elements to login as Sales Manager
        WebElement usernameInput=driver.findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement passwordInput=driver.findElement(By.xpath("//input[@id='prependedInput2']"));

        //Sending login and password keys
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);

        //Locating 'Learn how to use this space' button
        WebElement learnHowToUseThisSpaceBtn=driver.findElement(By.xpath("//div[@class='pin-bar-empty']//a"));
        learnHowToUseThisSpaceBtn.click();

        //Locating headers for AC1
        String header1ActTxt=driver.findElement(By.xpath("(//h3)[2]")).getText();
        String header1ExpTxt="How To Use Pinbar";

        String header2ActTxt=driver.findElement(By.xpath("(//p)[1]")).getText();
        String header2ExpTxt="Use pin icon on the right top corner of page to create fast access link in the pinbar.";

        //Verifying correct titles for both headers for AC1
        Assert.assertEquals(header1ExpTxt,header1ActTxt);
        Assert.assertEquals(header2ExpTxt,header2ActTxt);

        //Locating image source and declaring expected source for AC2
        String actSourceOfImage=driver.findElement(By.xpath("//img")).getAttribute("src");
        String expSourceOfImage="https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";

        //Verifying image source for AC2
        Assert.assertEquals(actSourceOfImage,expSourceOfImage);
    }


    //Closing all open browsers after all tests have ran
    @AfterMethod
    public void tearDown(){
        driver.quit();
}
}
