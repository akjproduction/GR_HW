package Page_Object_Framework.GR_HW;

import Reusable_Library.AbstractClassGR;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends AbstractClassGR {
    ExtentTest logger;

    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public BaseClass(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }//end of constructor method

    //create static object method for page classes
    //Cars
    public static Cars cars() {
        Cars cars = new Cars(driver);
        return cars;
    }//end of Cars object
}//end of base class
