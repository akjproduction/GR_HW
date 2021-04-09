package PageObjectTestCase;

import Page_Object_Framework.GR_HW.BaseClass;
import Reusable_Library.AbstractClassGR;
import org.testng.annotations.Test;

public class TC_GR_Cars extends AbstractClassGR {

    @Test
    public void Cars() throws InterruptedException {
        driver.navigate().to("https://www.cars.com/");
        Thread.sleep(2000);//2 sec delay
        BaseClass.cars().Cars();
        Thread.sleep(2000);//2 sec delay
    }//end of Test
}
