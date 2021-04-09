package Page_Object_Framework.GR_HW;

import Reusable_Library.AbstractClassGR;
import Reusable_Library.ReusableMethodsLoggersPageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Cars extends AbstractClassGR {
    ExtentTest logger;

    public Cars(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = AbstractClassGR.logger;
    }//end of constructor method

    //used Cars
    @FindBy(xpath = "//*[@id='ae-main-content']/section[2]/div/form/div/div[1]/div/select/option[3]")
    WebElement usedCars;

    //make Honda
    @FindBy(xpath = "//*[@id='ae-main-content']/section[2]/div/form/div/div[2]/div/select/option[26]")
    WebElement Make;

    //model Pilot
    @FindBy(xpath = "//*[@id='ae-main-content']/section[2]/div/form/div/div[3]/div/select/option[26]")
    WebElement Model;

    //price 50000
    @FindBy(xpath = "//*[@id='ae-main-content']/section[2]/div/form/div/div[4]/div/select/option[13]")
    WebElement Price;

    //distance 100 miles
    @FindBy(xpath = "//*[@id='ae-main-content']/section[2]/div/form/div/div[5]/div[1]/div/select/option[7]")
    WebElement Distance;

    //zipcode 60008
    @FindBy(xpath = "//*[@id='ae-main-content']/section[2]/div/form/div/div[5]/div[2]/div/input")
    WebElement ZipCode;

    //search
    @FindBy(xpath = "//*[@id='ae-main-content']/section[2]/div/form/div/div[6]/input")
    WebElement Search;

    //validating filters
    @FindBy(xpath = "//*[@id='ae-main-content']/div[4]/cars-filters/div[1]/div[1]/header")
    WebElement Validate;


    public void Cars() throws InterruptedException {
        ReusableMethodsLoggersPageObject.click(driver, usedCars, logger, "Stock Type");//clicking on stock type
        Thread.sleep(1000);//delay 1 sec
        ReusableMethodsLoggersPageObject.click(driver, Make, logger, "Make");//clicking on make
        Thread.sleep(1000);//delay 1 sec
        ReusableMethodsLoggersPageObject.click(driver, Model, logger, "Model");//clicking on model
        Thread.sleep(1000);//delay 1 sec
        ReusableMethodsLoggersPageObject.click(driver, Price, logger, "Price");//clicking on price
        Thread.sleep(1000);//delay 1 sec
        ReusableMethodsLoggersPageObject.click(driver, Distance, logger, "Distance");//clicking on distance
        Thread.sleep(1000);//delay 1 sec
        ReusableMethodsLoggersPageObject.typeAndSubmit(driver, "//*[@id='ae-main-content']/section[2]/div/form/div/div[5]/div[2]/div/input", "60008", logger, "ZipCode");//entering on zipcode

    }//end of cars page
}//end of cars class
