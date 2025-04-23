package ui.qa.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {
    public WebDriver driver = DriverHelper.getDriver();

<<<<<<< HEAD
//    @Before
//    public void setup() {
//        driver.get(ConfigReader.readProperty("studymateLogin_url"));
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
=======
    @Before
    public void setup() {
        driver.get(ConfigReader.readProperty("studymateLogin_url"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
>>>>>>> a2449daa31dd99644a30ecd6ac12006d2ac9672e
}
