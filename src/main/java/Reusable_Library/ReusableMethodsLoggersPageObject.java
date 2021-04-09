package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Element;
import java.io.File;
import java.io.IOException;

public class ReusableMethodsLoggersPageObject {
    public static WebDriver getDriver() throws InterruptedException, IOException {
        //kill all chrome driver instance before opening a new one
        Thread.sleep(1000);
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        //mac/windows
        //Runtime.getRuntime().exec("pgrep 'chromedriver' | xargs kill");
        //another way
        /*
        String cmds[] = {"killall","chromedriver"};
        Runtime.getRuntime().exec(cmds)
         */
        Thread.sleep(1000);
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here
        return driver;
    }//end of get driver

    //reusable method to click on any element on any websites
    public static void click(WebDriver driver, WebElement locator, ExtentTest logger, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO, "Clicking on element " + elementName);
            wait.until(ExpectedConditions.visibilityOf(locator)).click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
            logger.log(LogStatus.FAIL, "Unable to click on element " + err);
            getScreenShot(driver, logger, elementName);
        }//end of exception
    }//end of click method

    //reusable method to type on any element on any websites
    public static void sendKeys(WebDriver driver, String locator, String userValue, ExtentTest logger, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Typing on element " + elementName);
            logger.log(LogStatus.INFO, "Typing on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to type on element " + err);
            logger.log(LogStatus.FAIL, "Unable to type on element " + err);
            getScreenShot(driver, logger, elementName);
        }//end of exception
    }//end of sendkeys method

    //method to select from drop down menu
    public static void dropDownMenu(WebDriver driver, String locator, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            System.out.println("\nSelecting " + userInput + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown = new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);

        } catch (Exception err) {
            System.out.println("\nUnable to select from drop down " + err);
        }
    }//end of drop down by text method

    //reusable method to submit on any element on any websites
    public static void submit(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Submitting on element " + elementName);
            logger.log(LogStatus.INFO, "Submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        } catch (Exception err) {
            System.out.println("Unable to submit on element " + err);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + err);
            getScreenShot(driver, logger, elementName);
        }//end of exception
    }//end of submit method

    //reusable method to capture a value/text from a page
    public static String captureResult(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            System.out.println("Capturing text on element " + elementName);
            logger.log(LogStatus.INFO, "Capturing text on element " + elementName);
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
        } catch (Exception err) {
            System.out.println("Unable to capture text on element " + err + elementName);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + err);
            getScreenShot(driver, logger, elementName);
        }//end of exception
        return result;
    }//end of get result method

    public static void typeAndSubmit(WebDriver driver, String locator, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO, "Typing on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to enter on element " + e);
            getScreenShot(driver, logger, elementName);
        }
    }//end of type and submit method

    //method to click on an element
    public static void mouseHover(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            System.out.println("Mouse hovering on element " + elementName);
            logger.log(LogStatus.INFO, "Hovering on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + e);
            getScreenShot(driver, logger, elementName);
        }
    }//end of mouse hover method

    //reusable method for checking title text
    public static void checkTitle(WebDriver driver, String webAddress, String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.navigate().to(webAddress);
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title Contains " + expectedTitle);
        } else {
            System.out.println("Page title doesn't contains " + expectedTitle);
        }
    }//end of check title

    //method to click on an element
    public static void mouseClick(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            System.out.println("Mouse clicking a value on element " + elementName);
            logger.log(LogStatus.INFO, "Clicking on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + e);
            getScreenShot(driver, logger, elementName);
        }
    }//end of click method


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver wDriver, ExtentTest logger, String imageName) {
        try {
            String fileName = imageName + ".png";

            String directory = "src/main/java/HTML_Report/Screenshots/";
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots/" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of screenshot method

    //method to capture screenshot when logger fails
    public static void ScreenShot(WebDriver wDriver, ExtentTest logger, String imageName) {
        try {
            String fileName = imageName + ".png";

            String directory = "src/main/java/HTML_Report/Screenshots/";
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots/" + fileName);
            logger.log(LogStatus.INFO, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.INFO, "");
            e.printStackTrace();
        }
    }//end of screenshot method

}//end of reusable method
