package ui.qa.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {
    public WebDriver driver = DriverHelper.getDriver();

//    @Before
//    public void setup() {
//        driver.get(ConfigReader.readProperty("studymateLogin_url"));
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
